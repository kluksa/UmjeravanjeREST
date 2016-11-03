/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto.builders;

import dhz.skz.umjeravanje.exceptions.NoEntityException;
import dhz.skz.umjeravanje.dto.Boca;
import dhz.skz.umjeravanje.dto.Koncentracija;
import dhz.skz.umjeravanje.dto.Oprema;
import dhz.skz.umjeravanje.dto.Velicina;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


public class BocaBuilder {
    private Oprema opciPodaci;
    private String sljedivost;
    private Integer id;
    private List<Koncentracija> komponente;

    public BocaBuilder() {
    }

    public BocaBuilder setId(Integer id) {
        this.id = id;
        return this;
    }
    public BocaBuilder setSljedivost(String sljedivost) {
        this.sljedivost = sljedivost;
        return this;
    }

    public BocaBuilder setKomponente(List<Koncentracija> komponente) {
        this.komponente = komponente;
        return this;
    }

    public BocaBuilder setOpciPodaci(Oprema opciPodaci) {
        this.opciPodaci = opciPodaci;
        return this;
    }
    
    public Boca build() {
        return new Boca(id, opciPodaci, sljedivost, komponente);
    }
    
    public Boca build(dhz.skz.aqdb.entity.Uredjaj u)  {
        if ( u == null || u.getEtalonBocaCollection() == null || u.getEtalonBocaCollection().isEmpty()) throw new NoSuchElementException();
        this.id = u.getId();
        this.sljedivost = null;
        this.opciPodaci = new Oprema(u.getSerijskaOznaka(), 
                u.getModelUredjajaId().getOznakaModela(), 
                u.getModelUredjajaId().getProizvodjacId().getNaziv());
        
        
        this.komponente = u.getEtalonBocaCollection().stream().map(eb->new KoncentracijaBuilder()
                .setC(new Velicina(eb.getKoncentracija(),eb.getMjerneJediniceId().getOznaka()))
                .setU(new Velicina(eb.getNesigurnost(), eb.getMjerneJediniceId().getOznaka()))
                .setKomponenta(eb.getKomponenta().getFormula())
                .build()).collect(Collectors.toList());
        return BocaBuilder.this.build();
        
    }
}
