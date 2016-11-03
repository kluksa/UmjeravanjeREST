/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kraljevic
 */
@XmlRootElement
public class Uredjaj {
    Integer id;
    Oprema opci_podaci;
    Velicina vrijeme_odziva;
    List<String> mjerene_komponente;
    Integer metoda_id;

    public Uredjaj() {
    }

    public Uredjaj(Integer id) {
        this.id = id;
    }

    public Uredjaj(Integer id, Oprema opci_podaci, Velicina vrijeme_odziva, List<String> mjerene_komponente, Integer metoda_id) {
        this.id = id;
        this.opci_podaci = opci_podaci;
        this.vrijeme_odziva = vrijeme_odziva;
        this.mjerene_komponente = mjerene_komponente;
        this.metoda_id = metoda_id;
    }
    
    public Oprema getOpci_podaci() {
        return opci_podaci;
    }

    public void setOpci_podaci(Oprema opci_podaci) {
        this.opci_podaci = opci_podaci;
    }

    public Velicina getVrijeme_odziva() {
        return vrijeme_odziva;
    }

    public void setVrijeme_odziva(Velicina vrijeme_odziva) {
        this.vrijeme_odziva = vrijeme_odziva;
    }

    public List<String> getMjerene_komponente() {
        return mjerene_komponente;
    }

    public void setMjerene_komponente(List<String> mjerene_komponente) {
        this.mjerene_komponente = mjerene_komponente;
    }

    public Integer getMetoda_id() {
        return metoda_id;
    }

    public void setMetoda_id(Integer metoda_id) {
        this.metoda_id = metoda_id;
    }
    
    
    @XmlAttribute
    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
}
