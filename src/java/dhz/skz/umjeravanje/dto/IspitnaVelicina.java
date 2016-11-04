/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto;

import dhz.skz.aqdb.entity.DozvoljeneGranice;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author kraljevic
 */
@XmlType(propOrder = {"naziv", "tocka_norme", "oznaka", "dozvoljene_granice", "vrijednost"})
public class IspitnaVelicina {

    @NotNull
    Integer id;
    @NotNull
    String komponenta;
    String naziv;
    String tocka_norme;
    String oznaka;
    Interval dozvoljene_granice;
    Velicina vrijednost;

    public IspitnaVelicina() {
    }

    public IspitnaVelicina(Integer id, String komponenta, String naziv, String tocka_norme, String oznaka, Interval dozvoljene_granice, Velicina vrijednost) {
        this.id = id;
        this.komponenta = komponenta;
        this.naziv = naziv;
        this.tocka_norme = tocka_norme;
        this.oznaka = oznaka;
        this.dozvoljene_granice = dozvoljene_granice;
        this.vrijednost = vrijednost;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTocka_norme() {
        return tocka_norme;
    }

    public void setTocka_norme(String tocka_norme) {
        this.tocka_norme = tocka_norme;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public Interval getDozvoljene_granice() {
        return dozvoljene_granice;
    }

    public void setDozvoljene_granice(Interval dozvoljene_granice) {
        this.dozvoljene_granice = dozvoljene_granice;
    }

    @XmlAttribute
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Velicina getVrijednost() {
        return vrijednost;
    }

    public void setVrijednost(Velicina vrijednost) {
        this.vrijednost = vrijednost;
    }

    @XmlAttribute
    public String getKomponenta() {
        return komponenta;
    }

    public void setKomponenta(String komponenta) {
        this.komponenta = komponenta;
    }

    public static IspitnaVelicina create(DozvoljeneGranice dg) {
        IspitnaVelicina i = new IspitnaVelicina();
        i.setId(dg.getDozvoljeneGranicePK().getIspitneVelicineId());
        i.setKomponenta(dg.getKomponentaId().getFormula());
        i.setNaziv(dg.getIspitneVelicine().getNaziv());
        i.setTocka_norme("nema tocke norme");
        i.setOznaka(dg.getIspitneVelicine().getOznaka());
        i.setDozvoljene_granice(new Interval(dg.getMin(), dg.getMax(), dg.getMjerneJediniceId().getOznaka()));
        i.setVrijednost(null);
        return i;
    }

    public static class Builder {

        private Integer id;
        private String komponenta;
        private String naziv;
        private String tocka_norme;
        private String oznaka;
        private Interval dozvoljene_granice;
        private Velicina vrijednost;

        public Builder() {
        }

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setKomponenta(String komponenta) {
            this.komponenta = komponenta;
            return this;
        }

        public Builder setNaziv(String naziv) {
            this.naziv = naziv;
            return this;
        }

        public Builder setTocka_norme(String tocka_norme) {
            this.tocka_norme = tocka_norme;
            return this;
        }

        public Builder setOznaka(String oznaka) {
            this.oznaka = oznaka;
            return this;
        }

        public Builder setDozvoljene_granice(Interval dozvoljene_granice) {
            this.dozvoljene_granice = dozvoljene_granice;
            return this;
        }

        public Builder setVrijednost(Velicina vrijednost) {
            this.vrijednost = vrijednost;
            return this;
        }

        public IspitnaVelicina build() {
            return new IspitnaVelicina(id, komponenta, naziv, tocka_norme, oznaka, dozvoljene_granice, vrijednost);
        }
    }

}
