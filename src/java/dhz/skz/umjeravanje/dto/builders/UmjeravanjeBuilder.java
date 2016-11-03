/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto.builders;

import dhz.skz.umjeravanje.dto.Boca;
import dhz.skz.umjeravanje.dto.CistiZrak;
import dhz.skz.umjeravanje.dto.Dilucijska;
import dhz.skz.umjeravanje.dto.IspitnaVelicina;
import dhz.skz.umjeravanje.dto.Metoda;
import dhz.skz.umjeravanje.dto.Mjeritelj;
import dhz.skz.umjeravanje.dto.OkolisniUvjeti;
import dhz.skz.umjeravanje.dto.TockeUmjeravanja;
import dhz.skz.umjeravanje.dto.Umjeravanje;
import dhz.skz.umjeravanje.dto.Uredjaj;
import java.util.Date;
import java.util.List;


public class UmjeravanjeBuilder {
    private Integer id;
    private Uredjaj uredjaj;
    private Metoda metoda_id;
    private Dilucijska dilucija_id;
    private Boca boca_id;
    private CistiZrak cisti_zrak_id;
    private Mjeritelj mjeritelj_id;
    private String oznaka_izvjesca;
    private String postaja;
    private Date datum;
    private OkolisniUvjeti okolisni_uvjeti;
    private String napomena;

    public UmjeravanjeBuilder() {
    }

    public UmjeravanjeBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public UmjeravanjeBuilder setUredjaj(Uredjaj uredjaj) {
        this.uredjaj = uredjaj;
        return this;
    }

    public UmjeravanjeBuilder setMetoda_id(Metoda metoda_id) {
        this.metoda_id = metoda_id;
        return this;
    }

    public UmjeravanjeBuilder setDilucija_id(Dilucijska dilucija_id) {
        this.dilucija_id = dilucija_id;
        return this;
    }

    public UmjeravanjeBuilder setBoca_id(Boca boca_id) {
        this.boca_id = boca_id;
        return this;
    }

    public UmjeravanjeBuilder setCisti_zrak_id(CistiZrak cisti_zrak_id) {
        this.cisti_zrak_id = cisti_zrak_id;
        return this;
    }

    public UmjeravanjeBuilder setMjeritelj_id(Mjeritelj mjeritelj_id) {
        this.mjeritelj_id = mjeritelj_id;
        return this;
    }

    public UmjeravanjeBuilder setOznaka_izvjesca(String oznaka_izvjesca) {
        this.oznaka_izvjesca = oznaka_izvjesca;
        return this;
    }

    public UmjeravanjeBuilder setPostaja(String postaja) {
        this.postaja = postaja;
        return this;
    }

    public UmjeravanjeBuilder setDatum(Date datum) {
        this.datum = datum;
        return this;
    }

    public UmjeravanjeBuilder setOkolisni_uvjeti(OkolisniUvjeti okolisni_uvjeti) {
        this.okolisni_uvjeti = okolisni_uvjeti;
        return this;
    }

    public UmjeravanjeBuilder setNapomena(String napomena) {
        this.napomena = napomena;
        return this;
    }

    public Umjeravanje build() {
        return new Umjeravanje(id, uredjaj, metoda_id, dilucija_id, boca_id, cisti_zrak_id, mjeritelj_id, oznaka_izvjesca, postaja, datum, okolisni_uvjeti, napomena);
    }
    
    
}
