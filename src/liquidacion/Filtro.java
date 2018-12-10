/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liquidacion;
import java.util.Date;
/**
 *
 * @author alejandro.delmedico
 */
public class Filtro extends Orden{
    private double importeMax;
    private Date  fechaLiberacionMax;
    private Date fechaValorMax;
    private Date fechaLiquidacionMax;

    public double getImporteMax() {
        return importeMax;
    }

    public void setImporteMax(double importeMax) {
        this.importeMax = importeMax;
    }

    public Date getFechaLiberacionMax() {
        return fechaLiberacionMax;
    }

    public void setFechaLiberacionMax(Date fechaLiberacionMax) {
        this.fechaLiberacionMax = fechaLiberacionMax;
    }

    public Date getFechaValorMax() {
        return fechaValorMax;
    }

    public void setFechaValorMax(Date fechaValorMax) {
        this.fechaValorMax = fechaValorMax;
    }

    public Date getFechaLiquidacionMax() {
        return fechaLiquidacionMax;
    }

    public void setFechaLiquidacionMax(Date fechaLiquidacionMax) {
        this.fechaLiquidacionMax = fechaLiquidacionMax;
    }
}
