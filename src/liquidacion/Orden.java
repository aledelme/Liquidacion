/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liquidacion;

import java.sql.Date;





/**
 *
 * @author alejandro.delmedico
 */
public class Orden {
   
    
    private String BICEntidad = "BSCHESMMXXX";
    
    private String refOrden;
    
    private String contrapartida;
    
    private String BICContrapartida;
    
    private String sentido;
    
    private double importe;
    
    private Date fechaValor;
       
    private String divisa;
    
    private String corresponsalPropio;
    
    private String cuentaCorresponsalPropio;
    
    private String corresponsalAjeno;
    
    private String cuentaCorresponsalAjeno;
    
    private String tipoMensaje;
    
 
    

   
    
    public Orden (String BICEntidad,String refOrden, String contrapartida, String BICContrapartida, String sentido, double importe, Date fechaValor, String divisa, String corresponsalPropio, String cuentaCorresponsalPropio, String corresponsalAjeno, String cuentaCorrespAjeno, String tipoMensaje){
        
        this.BICEntidad = BICEntidad;
        this.refOrden = refOrden;
        this.contrapartida = contrapartida;
        this.BICContrapartida = BICContrapartida;
        this.sentido = sentido;
        this.importe = importe;
        this.fechaValor = fechaValor;
        this.divisa = divisa;
        this.corresponsalPropio = corresponsalAjeno;
        this.cuentaCorresponsalPropio = cuentaCorresponsalPropio;
        this.corresponsalAjeno = corresponsalAjeno;
        this.cuentaCorresponsalAjeno = cuentaCorresponsalAjeno;
        this.tipoMensaje = tipoMensaje;
        
        
    }
    
    public Orden (String BICEntidad, String contrapartida, String BICContrapartida, String sentido, double importe, String divisa, String corresponsalPropio, String cuentaCorresponsalPropio, String corresponsalAjeno, String cuentaCorrespAjeno, String tipoMensaje){
        
        this.BICEntidad = BICEntidad;
        this.contrapartida = contrapartida;
        this.BICContrapartida = BICContrapartida;
        this.sentido = sentido;
        this.importe = importe;
        this.divisa = divisa;
        this.corresponsalPropio = corresponsalAjeno;
        this.cuentaCorresponsalPropio = cuentaCorresponsalPropio;
        this.corresponsalAjeno = corresponsalAjeno;
        this.cuentaCorresponsalAjeno = cuentaCorresponsalAjeno;
        this.tipoMensaje = tipoMensaje;
        
        
    }    
    
    
    
    

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }
    
    

    public String getBICEntidad() {
        return BICEntidad;
    }

    public void setBICEntidad(String BICEntidad) {
        this.BICEntidad = BICEntidad;
    }

    public String getRefOrden() {
        return refOrden;
    }

    public void setRefOrden(String refOrden) {
        this.refOrden = refOrden;
    }

    public String getContrapartida() {
        return contrapartida;
    }

    public void setContrapartida(String contrapartida) {
        this.contrapartida = contrapartida;
    }

    public String getBICContrapartida() {
        return BICContrapartida;
    }

    public void setBICContrapartida(String BICContrapartida) {
        this.BICContrapartida = BICContrapartida;
    }

    public String getSentido() {
        return sentido;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getCorresponsalPropio() {
        return corresponsalPropio;
    }

    public void setCorresponsalPropio(String corresponsalPropio) {
        this.corresponsalPropio = corresponsalPropio;
    }

    public String getCuentaCorresponsalPropio() {
        return cuentaCorresponsalPropio;
    }

    public void setCuentaCorresponsalPropio(String cuentaCorresponsalPropio) {
        this.cuentaCorresponsalPropio = cuentaCorresponsalPropio;
    }

    public String getCorresponsalAjeno() {
        return corresponsalAjeno;
    }

    public void setCorresponsalAjeno(String corresponsalAjeno) {
        this.corresponsalAjeno = corresponsalAjeno;
    }

    public String getCuentaCorresponsalAjeno() {
        return cuentaCorresponsalAjeno;
    }

    public void setCuentaCorresponsalAjeno(String cuentaCorresponsalAjeno) {
        this.cuentaCorresponsalAjeno = cuentaCorresponsalAjeno;
    }

    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public Date getFechaValor() {
        return fechaValor;
    }

    public void setFechaValor(Date fechaValor) {
        this.fechaValor = fechaValor;
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hola Muro");
    }
    
}
