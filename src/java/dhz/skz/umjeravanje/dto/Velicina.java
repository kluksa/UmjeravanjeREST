/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author kraljevic
 */
//@XmlType(propOrder={"vrijednost"})
public class Velicina {
    Double vrijednost;
//    @XmlAttribute(name="jedinica")
    String jedinica;

    public Velicina() {
    }

    public Velicina(Double v, String jedinica ) {
        this.vrijednost = v;
        this.jedinica = jedinica;
    }

    @XmlValue
    public Double getVrijednost() {
        return vrijednost;
    }

    public void setVrijednost(Double v) {
        this.vrijednost = v;
    }

    @XmlAttribute(name="mjerna_jedinica")
    public String getJedinica() {
        return jedinica;
    }

    public void setJedinica(String jedinica) {
        this.jedinica = jedinica;
    }
        
}
