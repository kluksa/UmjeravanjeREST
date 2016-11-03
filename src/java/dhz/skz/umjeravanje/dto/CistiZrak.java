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
@XmlType(propOrder={"opci_podaci", "maksimalni_udjeli"})
public class CistiZrak {
    Integer id;
    List<Koncentracija> maksimalni_udjeli;
    Oprema opci_podaci;
            
    public CistiZrak() {
    }

    public CistiZrak(Integer id) {
        this.id = id;
    }

    public CistiZrak(Integer id, Oprema opciPodaci, List<Koncentracija> maksimalni_udjeli) {
        this.id = id;
        this.opci_podaci = opciPodaci;
        this.maksimalni_udjeli = maksimalni_udjeli;
    }
    
    public List<Koncentracija> getMaksimalni_udjeli() {
        return maksimalni_udjeli;
    }

    public void setMaksimalni_udjeli(List<Koncentracija> maksimalni_udjeli) {
        this.maksimalni_udjeli = maksimalni_udjeli;
    }

    public Oprema getOpci_podaci() {
        return opci_podaci;
    }

    public void setOpci_podaci(Oprema opciPodaci) {
        this.opci_podaci = opciPodaci;
    }
    
    @XmlAttribute
    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
}
