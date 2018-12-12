/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liquidacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author juan.muro
 */
public class MensajeDao {
    
    
    private Connection connection;
    
    public MensajeDao(){
        this.connection = new liquidacion.ConnectionFactory().getConnection();
        
    }
    
    public ArrayList<OrdenMensaje> listarMensajes(Filtro filtro){ //Hecho por alguien que no es Ale 
        ArrayList<OrdenMensaje> ordenmensajes = new ArrayList<>();
        String sql = "select m.*, o.* " +
                    "from mensaje as m"+
                    "inner join orden as o"+
                    "on o.id = m.idorden"+
                    "where o.tipo_mensaje like '%"+filtro.getTipoMensaje()+"%' " +
                    "and o.corresponsal_propio like '%"+filtro.getCorresponsalPropio()+"%' "+
                    "and m.trn like '%"+filtro.getTRNMensaje()+"%' ";                    

        if(filtro.getImporte() != 0)
            sql += " and importe >= " + filtro.getImporte();
        if(filtro.getImporteMax() != 0)
            sql += " and importe <= " + filtro.getImporteMax();
        if(filtro.getFechaValor()!= null)
            sql += " and fecha_valor >= '" + filtro.getFechaValor() + "'";
        if(filtro.getFechaValorMax()!= null)
            sql += " and fecha_valor <= '" + filtro.getFechaValorMax() + "'";
 

        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);       
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
                Orden orden = new Orden ();
                orden.setTipoMensaje(rs.getString("tipo_mensaje"));
                orden.setRefOrden(rs.getString("ref_orden"));
                orden.setContrapartida(rs.getString("contrapartida"));
                orden.setImporte(rs.getDouble("importe"));
                orden.setDivisa(rs.getString("divisa"));
                orden.setFechaValor(rs.getDate("fecha_valor"));
                orden.setCorresponsalPropio(rs.getString("corresponsal_propio"));
                
                Mensaje mensaje = new Mensaje();
                mensaje.setTRN(rs.getString("trn"));
                mensaje.setCruce(rs.getString("cruce"));
                mensaje.setSwift(rs.getString("swift"));
                mensaje.setId(rs.getInt("idmensaje"));
                
                OrdenMensaje om = new OrdenMensaje(orden, mensaje);
 
                ordenmensajes.add(om);
            }
            rs.close();
            stmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ordenmensajes;
    }    
    
    public String generarTrn(Orden orden) {
        
        long idOrden = orden.getId();
        String refOrden = orden.getRefOrden();
   
        String sql = "select count(trn) as numtrn from mensaje where idorden = " + idOrden ;
        
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);       
            ResultSet rs = stmt.executeQuery(); 
            long num = 0;
            
            while(rs.next()){   
                
                num = rs.getLong("numtrn");
            }
                        
            rs.close();
            stmt.close();  
             String trn = refOrden + "." + num+1;            
             return trn; 
             
        }catch(SQLException e) {                
                 throw new RuntimeException(e);
                }
       
    }
    
    public String generarSwift (Orden orden, Mensaje mensaje){
        
        String tipoMensaje = orden.getTipoMensaje();
        String swift = "";
        
        switch (tipoMensaje){
            
            case "MT202" : 
                //Campo fijo de inicio
                swift = "{1:F01" + orden.getBICEntidad()+"0000000000}{2:I202"+orden.getCorresponsalPropio()+"N}{3:{113:NNES}{108:PMC0743000002271}}{4:";
                //TRN
                String trn202 = mensaje.getTRN();
                swift += ":20A:" + trn202;
                //Tipo de mensaje (siempre sera NONREF)
                swift += ":21:NONREF";
                //Fecha valor, divisa e importe
                String fechav = new SimpleDateFormat("ddMMMyyyy").format(orden.getFechaValor());
                String divisa = orden.getDivisa();
                String importe = orden.getImporte()+"";
                swift += ":32A:"+fechav+divisa+importe;
                //BIC empresa de la orden
                swift += ":52A:BSCHESM0XXX";
                //Cuenta corresp propio y BIC corresp propio
                String correspPropio = orden.getCorresponsalPropio();
                String cuentaCorrespPropio = orden.getCuentaCorresponsalPropio();
                swift +=":53A:/"+ cuentaCorrespPropio + correspPropio + "ZYAYESM0XXX";
                //Cuenta corresp ajeno y BIC corresp ajeno
                String correspAjeno = orden.getCorresponsalAjeno();
                String cuentaCorrespAjeno = orden.getCuentaCorresponsalAjeno();
                swift += ":57A:/"+cuentaCorrespAjeno + correspAjeno + "MGTCBEBEXXX";
                //BIC de la contrapartida 
                String BICContrap = orden.getBICContrapartida();
                swift += ":58A:/" + BICContrap+ "-}";
                break;
                
            case "MT103":
                //Campo fijo de inicio
                swift = "{1:F01"+orden.getBICEntidad()+"0000000000}{2:I103"+orden.getCorresponsalPropio()+"N2020}{3:{108:GTAA000000996111}{119:STP}}{4:";
                //TRN
                String trn103 = mensaje.getTRN();
                swift += ":20A:" + trn103;
                //Valor fijo
                swift += ":23B:CRED";
                //Valor fijo
                swift += ":23E:SDVA";
                //Fecha valor, divisa e importe
                String fechavalor = new SimpleDateFormat("ddMMMyyyy").format(orden.getFechaValor());
                String div = orden.getDivisa();
                String imp = orden.getImporte()+"";
                swift += ":32A:"+fechavalor+div+imp;
                //BIC empresa de la orden
                swift += ":50A:/BSCHESM0XXX";    
                //Cuenta y BIC corresp propio
                String cuentcorprop = orden.getCuentaCorresponsalPropio();
                String corprop = orden.getCorresponsalPropio();
                swift += ":53A:/"+ cuentcorprop + corprop;
                //Cuenta y Bic corresp ajeno
                String cuentcoraje = orden.getCuentaCorresponsalAjeno();
                String coraje = orden.getCorresponsalAjeno();
                swift += ":57A:/"+ cuentcoraje + coraje;
                //Cuenta y BIC contrapartida
                String contrapart = orden.getContrapartida();
                swift += ":59A:/" + contrapart;
                //Campo fijo
                swift += ":71A:/OUR-}";
                break;   
                
            case "MT900" :
                swift = "{1:F01"+orden.getBICEntidad()+"4720546658}{2:O9001324180412"+orden.getCorresponsalPropio()+"71606974711804121324N}{3:{108:180412RG1L8Q0101}}{4:";
                //TRN mensaje recibidi
                //TRN mensaje asociado
                //Cuenta corresp propio
                String ccp = orden.getCuentaCorresponsalPropio();
                swift += ":25:"+ccp;
                //Fecha valor divisa importe
                String fv = new SimpleDateFormat("ddMMMyyyy").format(orden.getFechaValor());
                String di = orden.getDivisa();
                String im = orden.getImporte()+"";
                swift += ":32A:"+fv+di+im;    
                //Corresp propio
                String cp = orden.getCorresponsalPropio();
                swift += cp;
                //Campo fijo
                swift += "-}{5:{CHK:39F735B5D1AD}}";
                break;
                
            case "MT910" :
                swift = "{1:F01"+orden.getBICEntidad()+"4720546658}{2:O9001324180412"+orden.getCorresponsalPropio()+"71606974711804121324N}{3:{108:180412RG1L8Q0101}}{4:";
                //TRN mensaje recibidi
                //TRN mensaje asociado
                //Cuenta corresp propio
                String ccp910 = orden.getCuentaCorresponsalPropio();
                swift += ":25:"+ccp910;
                //Fecha valor divisa importe
                String fv910 = new SimpleDateFormat("ddMMMyyyy").format(orden.getFechaValor());
                String di910 = orden.getDivisa();
                String im910 = orden.getImporte()+"";
                swift += ":32A:"+fv910+di910+im910;    
                //Corresp propio
                String cp910 = orden.getCorresponsalPropio();
                swift += cp910;
                //Campo fijo
                swift += "-}{5:{CHK:BE1AF6A16912}}";
                break;                
        }        
        return swift;
    }
    
    
    
    public void closeConnetion(){
        try{
            if(!connection.isClosed())
                connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
    
    
}
