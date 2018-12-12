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
public class Mensaje {
    
    private long id;
    private String TRN;
    private String swift;
    private String cruce;

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
   
}
