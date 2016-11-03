/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author kraljevic
 */
@XmlType(propOrder={"koncentracija", "prosirena_nesigurnost"})
public class Koncentracija {
    String komponenta;
    Velicina koncentracija;
    Velicina prosirena_nesigurnost;
    String sljedivost;

    public Koncentracija(String komponenta, Velicina vrijednost, Velicina prosirena_nesigurnost, String sljedivost) {
        this.komponenta = komponenta;
        this.koncentracija = vrijednost;
        this.prosirena_nesigurnost = prosirena_nesigurnost;
        this.sljedivost = sljedivost;
    }
    
    
    @XmlAttribute
    public String getKomponenta() {
        return komponenta;
    }

    public void setKomponenta(String komponenta) {
        this.komponenta = komponenta;
    }

    public Velicina getKoncentracija() {
        return koncentracija;
    }

    public void setKoncentracija(Velicina koncentracija) {
        this.koncentracija = koncentracija;
    }

    public Velicina getProsirena_nesigurnost() {
        return prosirena_nesigurnost;
    }

    public void setProsirena_nesigurnost(Velicina u) {
        this.prosirena_nesigurnost = u;
    }
    
    @XmlAttribute
    public String getSljedivost() {
        return sljedivost;
    }

    public void setSljedivost(String sljedivost) {
        this.sljedivost = sljedivost;
    }

    
}
