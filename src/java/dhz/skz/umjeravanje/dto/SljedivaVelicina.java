/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto;

import javax.xml.bind.annotation.XmlType;


/**
 *
 * @author kraljevic
 */
@XmlType(propOrder={"iznos","mjerna_nesigurnost", "sljedivost"})
public class SljedivaVelicina {
    Velicina iznos;
    Velicina mjerna_nesigurnost;
    String sljedivost;

    public SljedivaVelicina(Velicina mjerna_nesigurnost, String sljedivost) {
        this.mjerna_nesigurnost = mjerna_nesigurnost;
        this.sljedivost = sljedivost;
    }
    public Velicina getMjerna_nesigurnost() {
        return mjerna_nesigurnost;
    }

    public void setMjerna_nesigurnost(Velicina mjerna_nesigurnost) {
        this.mjerna_nesigurnost = mjerna_nesigurnost;
    }

    public String getSljedivost() {
        return sljedivost;
    }

    public void setSljedivost(String sljedivost) {
        this.sljedivost = sljedivost;
    }

    public Velicina getIznos() {
        return iznos;
    }

    public void setIznos(Velicina iznost) {
        this.iznos = iznost;
    }
    
}
