/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liquidacion;

/**
 *
 * @author juan.muro
 */
public class OrdenMensaje {
    
    private Orden orden;
    private Mensaje mensaje;
    
    public OrdenMensaje (Orden orden, Mensaje mensaje){
        
        this.orden = orden;
        this.mensaje = mensaje;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
}
