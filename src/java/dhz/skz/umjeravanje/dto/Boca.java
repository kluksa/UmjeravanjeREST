/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author kraljevic
 */
@XmlRootElement
@XmlType(propOrder={"opci_podaci", "sljedivost", "komponente"})
public class Boca {
    Integer id;
    Oprema opci_podaci;
    String sljedivost;
    List<Koncentracija> komponente;

    public Boca() {
    }

    public Boca(Integer id) {
        this.id = id;
    }
    
    public Boca(Integer id, Oprema opciPodaci, String sljedivost, List<Koncentracija> komponente) {
        this.id = id;
        this.opci_podaci = opciPodaci;
        this.sljedivost = sljedivost;
        this.komponente = komponente;
    }

    public List<Koncentracija> getKomponente() {
        return komponente;
    }

    public void setKomponente(List<Koncentracija> komponente) {
        this.komponente = komponente;
    }

    public String getSljedivost() {
        return sljedivost;
    }

    public void setSljedivost(String sljedivost) {
        this.sljedivost = sljedivost;
    }

    public Oprema getOpci_podaci() {
        return opci_podaci;
    }

    public void setOpci_podaci(Oprema opci_podaci) {
        this.opci_podaci = opci_podaci;
    }
    
    @XmlAttribute
    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
}
