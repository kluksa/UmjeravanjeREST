/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto.builders;

import dhz.skz.aqdb.facades.EtalonCistiZrakKvalitetaFacade;
import dhz.skz.umjeravanje.dto.CistiZrak;
import dhz.skz.umjeravanje.dto.Koncentracija;
import dhz.skz.umjeravanje.dto.Oprema;
import dhz.skz.umjeravanje.dto.Velicina;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class CistiZrakBuilder {
    EtalonCistiZrakKvalitetaFacade etalonCistiZrakKvalitetaFacade = lookupEtalonCistiZrakKvalitetaFacadeBean();
    private Integer id;
    private Oprema opciPodaci;
    private List<Koncentracija> maksimalni_udjeli;

    public CistiZrakBuilder() {
    }

    public CistiZrakBuilder setMaksimalni_udjeli(List<Koncentracija> maksimalni_udjeli) {
        this.maksimalni_udjeli = maksimalni_udjeli;
        return this;
    }
    
    public CistiZrakBuilder setOpciPodaci(Oprema opciPodaci) {
        this.opciPodaci = opciPodaci;
        return this;
    }
    
    public CistiZrakBuilder setId(Integer id) {
        this.id = id;
        return this;
    }
    
    public CistiZrak build() {
        return new CistiZrak(id, opciPodaci, maksimalni_udjeli);
    }

    public CistiZrak build(dhz.skz.aqdb.entity.Uredjaj u) {
        if ( u == null || u.getEtalonCistiZrakKvalitetaCollection() == null || u.getEtalonCistiZrakKvalitetaCollection().isEmpty()) throw new NoSuchElementException();
        this.id = u.getId();
        this.opciPodaci = new Oprema(u.getSerijskaOznaka(), 
                u.getModelUredjajaId().getOznakaModela(), u.getModelUredjajaId().getProizvodjacId().getNaziv());
        this.maksimalni_udjeli = u.getEtalonCistiZrakKvalitetaCollection().stream()
                .map(mu->new Koncentracija(mu.getKomponenta().getFormula(),new Velicina(mu.getMaxUdio(),mu.getMjerneJediniceId().getOznaka()),null, null))
                .collect(Collectors.toList());
        return CistiZrakBuilder.this.build();
    }


    private EtalonCistiZrakKvalitetaFacade lookupEtalonCistiZrakKvalitetaFacadeBean() {
        try {
            Context c = new InitialContext();
            return (EtalonCistiZrakKvalitetaFacade) c.lookup("java:global/SKZ/SKZ-ejb/EtalonCistiZrakKvalitetaFacade!dhz.skz.aqdb.facades.EtalonCistiZrakKvalitetaFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
