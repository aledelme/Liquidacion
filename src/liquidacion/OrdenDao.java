/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liquidacion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author juan.muro
 */
public class OrdenDao {
    
    private Connection connection;
    
    public OrdenDao(){
        
        this.connection = new liquidacion.ConnectionFactory().getConnection();        
    }
    
        public String refOrden (){
            
            String sql = "select max(ref_orden) as max from orden";
            String resultado = "ORDEN";
            
            try{
                
            
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                
                String valor = rs.getString("max");
                
                if (valor==null){
                    
                    resultado = "ORDEN00000001";
                            
                    
                }else{
                    
                    Long secuencia = Long.parseLong(valor.replaceAll("\\D+", ""))+1;
                    resultado = resultado + StringUtils.leftPad(secuencia.toString(), 8, "0");
                    
                    
                }
                
            }
            
            
            }catch(SQLException e){
                
                e.printStackTrace();
                
            }
            
            return resultado;
        }
    
        public void añadir (Orden orden){
        
        String sql = "insert into orden (bic_entidad, ref_orden, contrapartida, bic_contrapartida, sentido, importe, divisa, fecha_valor, corresponsal_propio, cuenta_corresponsal_propio, corresponsal_ajeno, cuenta_corresponsal_ajeno, tipo_mensaje, estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            
            //prepared statement para inserir la conexion
            
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            //setear los valores
            stmt.setString(1, orden.getBICEntidad());
            stmt.setString(2, orden.getRefOrden());
            stmt.setString(3, orden.getContrapartida());            
            stmt.setString(4, orden.getBICContrapartida());
            stmt.setString(5, orden.getSentido());
            stmt.setDouble(6, orden.getImporte());
            stmt.setString(7, orden.getDivisa());
            stmt.setDate(8, orden.getFechaValor());
            stmt.setString(9, orden.getCorresponsalPropio());
            stmt.setString(10, orden.getCuentaCorresponsalPropio());
            stmt.setString(11, orden.getCorresponsalAjeno());
            stmt.setString(12, orden.getCuentaCorresponsalAjeno());
            stmt.setString(13, orden.getTipoMensaje());
            stmt.setString(14, "No Liberado");
            
  
            
            
            //executar
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e){
            throw new RuntimeException (e);
            
        }
        
    }    
    
    
}
