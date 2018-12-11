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
    
    
    
    public void closeConnetion(){
        try{
            if(!connection.isClosed())
                connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
    
    
}
