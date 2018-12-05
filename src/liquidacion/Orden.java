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
    
    private String BICEntidad;
    
    private long refOrden;
    
    private String contrapartida;
    
    private String BICContrapartida;
    
    private String sentido;
    
    private double importe;   
    
    private String corresponsalPropio;
    
    private String cuentaCorresponsalPropio;
    
    private String corresponsalAjeno;
    
    private String cuentaCorresponsalAjeno;
    
    private String tipoMensaje;
    
    private Date fechaValor;
    
    private String divisa;
   
    
    
    
    
    

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

    public long getRefOrden() {
        return refOrden;
    }

    public void setRefOrden(long refOrden) {
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
