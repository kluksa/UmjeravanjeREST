/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto;

import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 *
 * @author kraljevic
 *
 *
 *
 *
 * <brojObrasca>string</brojObrasca>
 * <revizija>string</revizija>
 * <postaja>string</postaja>
 *
 *
 */
@XmlRootElement
@XmlType(propOrder = {"oznaka_izvjesca", "datum", "uredjaj", "postaja", "rezultati", "dilucija", "crm", "cisti_zrak", "mjeritelj", "okolisni_uvjeti", "napomena"})

public class Umjeravanje {

    Integer id;
    Uredjaj uredjaj;
    Metoda rezultati;
    Dilucijska dilucija;
    Boca crm;
    CistiZrak cisti_zrak;
    Mjeritelj mjeritelj;
    String oznaka_izvjesca;
    String postaja;
    Date datum;
    OkolisniUvjeti okolisni_uvjeti;
    String napomena;

    public Umjeravanje(Integer id, Uredjaj uredjaj, Metoda metoda, Dilucijska dilucija, Boca boca, CistiZrak cisti_zrak, Mjeritelj mjeritelj,
            String oznaka_izvjesca, String postaja, Date datum, OkolisniUvjeti okolisni_uvjeti, String napomena) {
        this.id = id;
        this.uredjaj = uredjaj;
        this.rezultati = metoda;
        this.dilucija = dilucija;
        this.crm = boca;
        this.cisti_zrak = cisti_zrak;
        this.mjeritelj = mjeritelj;
        this.oznaka_izvjesca = oznaka_izvjesca;
        this.postaja = postaja;
        this.datum = datum;
        this.okolisni_uvjeti = okolisni_uvjeti;
        this.napomena = napomena;
    }

    public Umjeravanje() {
    }

    @XmlAttribute
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Uredjaj getUredjaj() {
        return uredjaj;
    }

    public void setUredjaj(Uredjaj uredjaj) {
        this.uredjaj = uredjaj;
    }

    public Metoda getRezultati() {
        return rezultati;
    }

    public void setRezultati(Metoda rezultati) {
        this.rezultati = rezultati;
    }

    public Dilucijska getDilucija() {
        return dilucija;
    }

    public void setDilucija(Dilucijska dilucija) {
        this.dilucija = dilucija;
    }

    public Boca getCrm() {
        return crm;
    }

    public void setCrm(Boca crm) {
        this.crm = crm;
    }

    public CistiZrak getCisti_zrak() {
        return cisti_zrak;
    }

    public void setCisti_zrak(CistiZrak cisti_zrak) {
        this.cisti_zrak = cisti_zrak;
    }

    public Mjeritelj getMjeritelj() {
        return mjeritelj;
    }

    public void setMjeritelj(Mjeritelj mjeritelj) {
        this.mjeritelj = mjeritelj;
    }

    public String getOznaka_izvjesca() {
        return oznaka_izvjesca;
    }

    public void setOznaka_izvjesca(String oznaka_izvjesca) {
        this.oznaka_izvjesca = oznaka_izvjesca;
    }

    public String getPostaja() {
        return postaja;
    }

    public void setPostaja(String postaja) {
        this.postaja = postaja;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public OkolisniUvjeti getOkolisni_uvjeti() {
        return okolisni_uvjeti;
    }

    public void setOkolisni_uvjeti(OkolisniUvjeti okolisni_uvjeti) {
        this.okolisni_uvjeti = okolisni_uvjeti;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public static class Builder {

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

        public Builder() {
        }

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setUredjaj(Uredjaj uredjaj) {
            this.uredjaj = uredjaj;
            return this;
        }

        public Builder setMetoda_id(Metoda metoda_id) {
            this.metoda_id = metoda_id;
            return this;
        }

        public Builder setDilucija_id(Dilucijska dilucija_id) {
            this.dilucija_id = dilucija_id;
            return this;
        }

        public Builder setBoca_id(Boca boca_id) {
            this.boca_id = boca_id;
            return this;
        }

        public Builder setCisti_zrak_id(CistiZrak cisti_zrak_id) {
            this.cisti_zrak_id = cisti_zrak_id;
            return this;
        }

        public Builder setMjeritelj_id(Mjeritelj mjeritelj_id) {
            this.mjeritelj_id = mjeritelj_id;
            return this;
        }

        public Builder setOznaka_izvjesca(String oznaka_izvjesca) {
            this.oznaka_izvjesca = oznaka_izvjesca;
            return this;
        }

        public Builder setPostaja(String postaja) {
            this.postaja = postaja;
            return this;
        }

        public Builder setDatum(Date datum) {
            this.datum = datum;
            return this;
        }

        public Builder setOkolisni_uvjeti(OkolisniUvjeti okolisni_uvjeti) {
            this.okolisni_uvjeti = okolisni_uvjeti;
            return this;
        }

        public Builder setNapomena(String napomena) {
            this.napomena = napomena;
            return this;
        }

        public Umjeravanje build() {
            return new Umjeravanje(id, uredjaj, metoda_id, dilucija_id, boca_id, cisti_zrak_id, mjeritelj_id, oznaka_izvjesca, postaja, datum, okolisni_uvjeti, napomena);
        }
    }

}
