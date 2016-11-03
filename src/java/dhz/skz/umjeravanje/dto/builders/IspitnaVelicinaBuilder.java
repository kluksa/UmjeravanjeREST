/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto.builders;

import dhz.skz.aqdb.entity.DozvoljeneGranice;
import dhz.skz.umjeravanje.dto.Interval;
import dhz.skz.umjeravanje.dto.IspitnaVelicina;
import dhz.skz.umjeravanje.dto.Velicina;


public class IspitnaVelicinaBuilder {
    private Integer id;
    private String komponenta;
    private String naziv;
    private String tocka_norme;
    private String oznaka;
    private Interval dozvoljene_granice;
    private Velicina vrijednost;

    public IspitnaVelicinaBuilder() {
    }

    public IspitnaVelicinaBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public IspitnaVelicinaBuilder setKomponenta(String komponenta) {
        this.komponenta = komponenta;
        return this;
    }

    public IspitnaVelicinaBuilder setNaziv(String naziv) {
        this.naziv = naziv;
        return this;
    }

    public IspitnaVelicinaBuilder setTocka_norme(String tocka_norme) {
        this.tocka_norme = tocka_norme;
        return this;
    }

    public IspitnaVelicinaBuilder setOznaka(String oznaka) {
        this.oznaka = oznaka;
        return this;
    }

    public IspitnaVelicinaBuilder setDozvoljene_granice(Interval dozvoljene_granice) {
        this.dozvoljene_granice = dozvoljene_granice;
        return this;
    }

    public IspitnaVelicinaBuilder setVrijednost(Velicina vrijednost) {
        this.vrijednost = vrijednost;
        return this;
    }

    public IspitnaVelicina build() {
        return new IspitnaVelicina(id, komponenta, naziv, tocka_norme, oznaka, dozvoljene_granice, vrijednost);
    }
    
    public IspitnaVelicina build(DozvoljeneGranice dg) {
        this.id = dg.getDozvoljeneGranicePK().getIspitneVelicineId();
        this.komponenta = dg.getKomponentaId().getFormula();
        this.naziv = dg.getIspitneVelicine().getNaziv();
        this.tocka_norme = "nema tocke norme";
        this.oznaka = dg.getIspitneVelicine().getOznaka();
        this.dozvoljene_granice = new Interval(dg.getMin(), dg.getMax(), dg.getMjerneJediniceId().getOznaka());
        this.vrijednost = null;
        return IspitnaVelicinaBuilder.this.build();
    }
    
}
