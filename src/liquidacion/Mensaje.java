/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liquidacion;

import java.text.SimpleDateFormat;
import utiles.RandomString;

/**
 *
 * @author juan.muro
 */
public class Mensaje {
        
    private Orden orden;
    private long id;
    private String TRN;
    private String swift;
    private String cruce;
    private String tipoMensaje;
    private String TRNrecibido;

    public Mensaje() {
    }
    
    public Mensaje(Orden orden, String TRN){
        this.orden = orden;
        this.TRN = TRN;
        swift = generarSwift();
    }
    
    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }     

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTRN() {
        return TRN;
    }

    public void setTRN(String TRN) {
        this.TRN = TRN;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getCruce() {
        return cruce;
    }

    public void setCruce(String cruce) {
        this.cruce = cruce;
    }

    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public String getTRNrecibido() {
        return TRNrecibido;
    }

    public void setTRNrecibido(String TRNrecibido) {
        this.TRNrecibido = TRNrecibido;
    }
    
    public String generarSwift() {
        String tipoMensaje = orden.getTipoMensaje();
        String MUR = new RandomString(16).nextString();
        String swift = "";
        
        switch (tipoMensaje) {

            case "MT202":
                //Campo fijo de inicio
                swift = "{1:F01" + orden.getBICEntidad() + "0000000000}{2:I202" + orden.getCorresponsalPropio() + "N}{3:{113:NNES}{108:"+MUR+"}}{4:";
                //TRN
                swift += ":20A:" + TRN;
                //Tipo de mensaje (siempre sera NONREF)
                swift += ":21:NONREF";
                //Fecha valor, divisa e importe
                String fechav = new SimpleDateFormat("yyMMdd").format(orden.getFechaValor());
                String divisa = orden.getDivisa();
                String importe = orden.getImporte() + "";
                swift += ":32A:" + fechav + divisa + importe;
                //BIC empresa de la orden
                swift += ":52A:BSCHESM0XXX";
                //Cuenta corresp propio y BIC corresp propio
                String correspPropio = orden.getCorresponsalPropio();
                String cuentaCorrespPropio = orden.getCuentaCorresponsalPropio();
                swift += ":53A:/" + cuentaCorrespPropio + correspPropio;
                //Cuenta corresp ajeno y BIC corresp ajeno
                String correspAjeno = orden.getCorresponsalAjeno();
                String cuentaCorrespAjeno = orden.getCuentaCorresponsalAjeno();
                swift += ":57A:/" + cuentaCorrespAjeno + correspAjeno;
                //BIC de la contrapartida 
                String BICContrap = orden.getBICContrapartida();
                swift += ":58A:/" + BICContrap + "-}";
                break;

            case "MT103":
                //Campo fijo de inicio
                swift = "{1:F01" + orden.getBICEntidad() + "0000000000}{2:I103" + orden.getCorresponsalPropio() + "N2020}{3:{108:"+MUR+"}{119:STP}}{4:";
                //TRN
                swift += ":20A:" + TRN;
                //Valor fijo
                swift += ":23B:CRED";
                //Valor fijo
                swift += ":23E:SDVA";
                //Fecha valor, divisa e importe
                String fechavalor = new SimpleDateFormat("yyMMdd").format(orden.getFechaValor());
                String div = orden.getDivisa();
                String imp = orden.getImporte() + "";
                swift += ":32A:" + fechavalor + div + imp;
                //BIC empresa de la orden
                swift += ":50A:/BSCHESM0XXX";
                //Cuenta y BIC corresp propio
                String cuentcorprop = orden.getCuentaCorresponsalPropio();
                String corprop = orden.getCorresponsalPropio();
                swift += ":53A:/" + cuentcorprop + corprop;
                //Cuenta y Bic corresp ajeno
                String cuentcoraje = orden.getCuentaCorresponsalAjeno();
                String coraje = orden.getCorresponsalAjeno();
                swift += ":57A:/" + cuentcoraje + coraje;
                //Cuenta y BIC contrapartida
                String contrapart = orden.getContrapartida();
                swift += ":59A:/" + contrapart;
                //Campo fijo
                swift += ":71A:/OUR-}";
                break;
        }
        return swift;
    }
    
    public String responderSwift(){
        String MUR = new RandomString(16).nextString();
        String swift = "";
        
        switch (tipoMensaje) {
            case "MT900":
                swift = "{1:F01" + orden.getBICEntidad() + "}{2:O900" + orden.getCorresponsalPropio() + "}{3:{108:"+MUR+"}}{4:";
                //TRN mensaje recibidi
                swift +=":20:"+TRNrecibido;
                //TRN mensaje asociado
                swift +=":21:"+TRN;
                //Cuenta corresp propio
                String ccp = orden.getCuentaCorresponsalPropio();
                swift += ":25:" + ccp;
                //Fecha valor divisa importe
                String fv = new SimpleDateFormat("yyMMdd").format(orden.getFechaValor());
                String di = orden.getDivisa();
                String im = orden.getImporte() + "";
                swift += ":32A:" + fv + di + im;
                //Corresp propio
                String cp = orden.getCorresponsalPropio();
                swift += cp;
                //Campo fijo
                swift += "-}{5:{CHK:39F735B5D1AD}}";
                break;

            case "MT910":
                swift = "{1:F01" + orden.getBICEntidad() + "}{2:O910" + orden.getCorresponsalPropio() +"}{3:{108:"+MUR+"}}{4:";
                //TRN mensaje recibidi
                swift +=":20:"+TRNrecibido;
                //TRN mensaje asociado
                swift +=":21:"+TRN;
                //Cuenta corresp propio
                String ccp910 = orden.getCuentaCorresponsalPropio();
                swift += ":25:" + ccp910;
                //Fecha valor divisa importe
                String fv910 = new SimpleDateFormat("yyMMdd").format(orden.getFechaValor());
                String di910 = orden.getDivisa();
                String im910 = orden.getImporte() + "";
                swift += ":32A:" + fv910 + di910 + im910;
                //Corresp propio
                String cp910 = orden.getCorresponsalPropio();
                swift += cp910;
                //Campo fijo
                swift += "-}{5:{CHK:BE1AF6A16912}}";
                break;
            case "ACK":
                swift = "{1:F21"+orden.getBICEntidad()+"}{4:{177:1310311338}{451:1}{405:Y01}{108:"+MUR+"}}";
                break;
            case "NACK":
                swift = "{1:F21"+orden.getBICEntidad()+"}{4:{177:1311221640}{451:0}{108:"+MUR+"}}";
                break;
        }
        return swift;
    } 
   
}
