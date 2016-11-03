/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto.builders;

import dhz.skz.aqdb.entity.AnalitickeMetode;
import dhz.skz.umjeravanje.dto.IspitnaVelicina;
import dhz.skz.umjeravanje.dto.Metoda;
import dhz.skz.umjeravanje.dto.TockeUmjeravanja;
import java.util.List;
import java.util.stream.Collectors;


public class MetodaBuilder {
    private Integer id;
    private String naziv;
    private String oznaka_norme;
    private List<IspitnaVelicina> ispitne_velicine;
    private List<TockeUmjeravanja> tocke_umjeravanja;

    public MetodaBuilder() {
    }

    public MetodaBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public MetodaBuilder setNaziv(String naziv) {
        this.naziv = naziv;
        return this;
    }

    public MetodaBuilder setOznaka_norme(String oznaka_norme) {
        this.oznaka_norme = oznaka_norme;
        return this;
    }

    public MetodaBuilder setKomponente(List<IspitnaVelicina> ispitne_velicine) {
        this.ispitne_velicine = ispitne_velicine;
        return this;
    }

    public MetodaBuilder setPredlozene_tocke(List<TockeUmjeravanja> tocke_umjeravanja) {
        this.tocke_umjeravanja = tocke_umjeravanja;
        return this;
    }

    public Metoda build() {
        return new Metoda(id, naziv, oznaka_norme, ispitne_velicine, tocke_umjeravanja);
    }
    
    public Metoda build(AnalitickeMetode am) {
        this.id = am.getId();
        this.naziv = am.getNaziv();
        this.oznaka_norme = am.getNorma();
        this.tocke_umjeravanja = am.getMetodaUmjerneTockeCollection().stream().map(ut->new TockeUmjeravanjaBuilder().createTockeUmjeravanja(ut)).collect(Collectors.toList());
        this.ispitne_velicine = am.getDozvoljeneGraniceCollection().stream()
                .map(dg->new IspitnaVelicinaBuilder().build(dg))
                .collect(Collectors.toList());
        return MetodaBuilder.this.build();
        
    }
}
