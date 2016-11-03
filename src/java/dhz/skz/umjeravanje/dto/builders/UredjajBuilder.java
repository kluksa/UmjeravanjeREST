/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto.builders;

import dhz.skz.aqdb.entity.Komponenta;
import dhz.skz.umjeravanje.dto.Oprema;
import dhz.skz.umjeravanje.dto.Uredjaj;
import dhz.skz.umjeravanje.dto.Velicina;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


public class UredjajBuilder {
    private Integer id;
    private Oprema opci_podaci;
    private Velicina vrijeme_odziva;
    private List<String> mjerene_komponente;
    private Integer metodaId;

    public UredjajBuilder() {
    }

    public UredjajBuilder setOpci_podaci(Oprema opci_podaci) {
        this.opci_podaci = opci_podaci;
        return this;
    }

    public UredjajBuilder setVrijeme_odziva(Velicina vrijeme_odziva) {
        this.vrijeme_odziva = vrijeme_odziva;
        return this;
    }

    public UredjajBuilder setMjerene_komponente(List<String> mjerene_komponente) {
        this.mjerene_komponente = mjerene_komponente;
        return this;
    }
    
    public UredjajBuilder setAnaliticka_metoda_id(Integer metodaId) {
        this.metodaId = metodaId;
        return this;
    }
    
    public UredjajBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public Uredjaj createUredjaj() {
        return new Uredjaj(id, opci_podaci, vrijeme_odziva, mjerene_komponente, metodaId);
    }

    public Uredjaj build(dhz.skz.aqdb.entity.Uredjaj u) {
        if ( u == null || u.getModelUredjajaId() == null ) throw new NoSuchElementException();
        this.id = u.getId();
        this.opci_podaci = new Oprema(u.getSerijskaOznaka(), 
                u.getModelUredjajaId().getOznakaModela(), 
                u.getModelUredjajaId().getProizvodjacId().getNaziv());
        this.vrijeme_odziva = new Velicina(180.,"s");
        this.mjerene_komponente = u.getModelUredjajaId().getKomponentaCollection().stream().map(Komponenta::getFormula).collect(Collectors.toList());
        this.metodaId = u.getModelUredjajaId().getAnalitickeMetodeId().getId();
        return createUredjaj();
        
    }
    
}
