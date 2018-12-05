/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liquidacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juan.muro
 */
public class ConnectionFactory {
    
     public Connection getConnection(){
        
        try{
            
            //jdbc es el protocolo (usando driver)
            //mysql, subprotocolo
            //localhost servidor (IP o nombre)
            //3306 es el puerto (creado por defecto)
            //agenda es el nombre de la BBDD
            //?createDatebaseIfNOtExist = true
            
            String url = "jdbc:mysql://localhost:3306/mensajeria";
            String usuario = "root";
            String password = "root";
        
            return DriverManager.getConnection(url, usuario, password);
            
         }catch(SQLException e){
    
               throw new RuntimeException (e);
    
            
                
                }    
        
    }    
    
}
