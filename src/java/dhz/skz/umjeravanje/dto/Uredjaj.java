/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto;

import dhz.skz.aqdb.entity.Komponenta;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
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
    
    public static Uredjaj create(dhz.skz.aqdb.entity.Uredjaj u) {
        if ( u == null || u.getModelUredjajaId() == null ) throw new NoSuchElementException();
        Uredjaj uu = new Uredjaj();
        uu.setId(u.getId());
        uu.setOpci_podaci(Oprema.create(u));
        uu.setVrijeme_odziva(new Velicina(180.,"s"));
        uu.setMjerene_komponente(u.getModelUredjajaId().getKomponentaCollection().stream().map(Komponenta::getFormula).collect(Collectors.toList()));
        uu.setMetoda_id(u.getModelUredjajaId().getAnalitickeMetodeId().getId());
        return uu;
    }
    
    public static class Builder {
    private Integer id;
    private Oprema opci_podaci;
    private Velicina vrijeme_odziva;
    private List<String> mjerene_komponente;
    private Integer metodaId;

    public Builder() {
    }

    public Builder setOpci_podaci(Oprema opci_podaci) {
        this.opci_podaci = opci_podaci;
        return this;
    }

    public Builder setVrijeme_odziva(Velicina vrijeme_odziva) {
        this.vrijeme_odziva = vrijeme_odziva;
        return this;
    }

    public Builder setMjerene_komponente(List<String> mjerene_komponente) {
        this.mjerene_komponente = mjerene_komponente;
        return this;
    }
    
    public Builder setAnaliticka_metoda_id(Integer metodaId) {
        this.metodaId = metodaId;
        return this;
    }
    
    public Builder setId(Integer id) {
        this.id = id;
        return this;
    }

    public Uredjaj createUredjaj() {
        return new Uredjaj(id, opci_podaci, vrijeme_odziva, mjerene_komponente, metodaId);
    }
    }

}
