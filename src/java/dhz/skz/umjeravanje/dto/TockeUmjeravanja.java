/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author kraljevic
 */
@XmlType(propOrder={"c_ref","c", "u"})
public class TockeUmjeravanja {
    String komponenta;
    Double c_ref;
    Double c;
    Double u;
    String mjerne_jedinice;
    //Vrsta Z,S,L

    public TockeUmjeravanja() {
    }

    public TockeUmjeravanja(String komponenta, Double c_ref, Double c, Double u, String mjerne_jedinice) {
        this.komponenta = komponenta;
        this.c_ref = c_ref;
        this.c = c;
        this.u = u;
        this.mjerne_jedinice = mjerne_jedinice;
    }

    @XmlAttribute
    public String getKomponenta() {
        return komponenta;
    }

    public void setKomponenta(String komponenta) {
        this.komponenta = komponenta;
    }

    public Double getC_ref() {
        return c_ref;
    }

    public void setC_ref(Double c_ref) {
        this.c_ref = c_ref;
    }

    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    public Double getU() {
        return u;
    }

    public void setU(Double u) {
        this.u = u;
    }

    @XmlAttribute
    public String getMjerne_jedinice() {
        return mjerne_jedinice;
    }

    public void setMjerne_jedinice(String mjerne_jedinice) {
        this.mjerne_jedinice = mjerne_jedinice;
    }

    
    
}
