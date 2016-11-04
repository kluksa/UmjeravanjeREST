/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto;

import dhz.skz.aqdb.entity.AnalitickeMetode;
import dhz.skz.aqdb.entity.MetodaUmjerneTocke;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author kraljevic
 */
@XmlType(propOrder = {"c_ref", "c", "u"})
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

    public static TockeUmjeravanja create(MetodaUmjerneTocke ut) {
        TockeUmjeravanja t = new TockeUmjeravanja();
        t.setKomponenta(ut.getKomponentaId().getFormula());
        t.setC_ref(1. * ut.getPostotakOpsega());
        t.setMjerne_jedinice("%");
        return t;
    }

    public static  class Builder {

        private String komponenta;
        private Double c_ref;
        private Double c;
        private Double u;
        private String mjerne_jedinice;

        public Builder() {
        }

        public Builder setKomponenta(String komponenta) {
            this.komponenta = komponenta;
            return this;
        }

        public Builder setC_ref(Double c_ref) {
            this.c_ref = c_ref;
            return this;
        }

        public Builder setC(Double c) {
            this.c = c;
            return this;
        }

        public Builder setU(Double u) {
            this.u = u;
            return this;
        }

        public Builder setMjerne_jedinice(String mjerne_jedinice) {
            this.mjerne_jedinice = mjerne_jedinice;
            return this;
        }

        public TockeUmjeravanja build() {
            return new TockeUmjeravanja(komponenta, c_ref, c, u, mjerne_jedinice);
        }
    }

}
