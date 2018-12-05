/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liquidacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author juan.muro
 */
public class OrdenDao {
    
    private Connection connection;
    
    public OrdenDao(){
        
        this.connection = new liquidacion.ConnectionFactory().getConnection();        
    }
    
        public void añadir (Orden orden){
        
        String sql = "insert into orden (contrapartida, bic_contrapartida, sentido, importe, divisa, fecha_valor, corresponsal_propio, cuenta_corresponsal_propio, corresponsal_ajeno, cuenta_corresponsal_ajeno, tipo_mensaje) values (?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            
            //prepared statement para inserir la conexion
            
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            //setear los valores
            stmt.setString(1, orden.getContrapartida());            
            stmt.setString(2, orden.getBICContrapartida());
            stmt.setString(3, orden.getSentido());
            stmt.setDouble(4, orden.getImporte());
            stmt.setString(5, orden.getDivisa());
            stmt.setDate(6, orden.getFechaValor());
            stmt.setString(7, orden.getCorresponsalPropio());
            stmt.setString(8, orden.getCuentaCorresponsalPropio());
            stmt.setString(9, orden.getCorresponsalAjeno());
            stmt.setString(10, orden.getCuentaCorresponsalAjeno());
            stmt.setString(11, orden.getTipoMensaje());
            
            
  
            
            
            //executar
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e){
            throw new RuntimeException (e);
            
        }
        
    }    
    
    
}
