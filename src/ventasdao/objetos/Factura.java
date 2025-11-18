/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.objetos;

import java.util.Date;
import java.util.List;

/**
 *
 * @author hchanampe
 */
public class Factura {
    
    
    private Integer id;
    
    private Date date;
    
    private List<LineaFactura> lineaFactura;
    
    private TipoDePagoDeFactura typeOfPayment;

    public Factura(Integer id, Date date, List<LineaFactura> lineaFactura, TipoDePagoDeFactura typeOfPayment) {
        this.id = id;
        this.date = date;
        this.lineaFactura = lineaFactura;
        this.typeOfPayment = typeOfPayment;
    }

    public TipoDePagoDeFactura getTypeOfPayment() {
        return typeOfPayment;
    }

    public void setTypeOfPayment(TipoDePagoDeFactura typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<LineaFactura> getLineaFactura() {
        return lineaFactura;
    }

    public void setLineaFactura(List<LineaFactura> lineaFactura) {
        this.lineaFactura = lineaFactura;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", date=" + date +
                ", lineaFactura=" + lineaFactura +
                '}';
    }
}
