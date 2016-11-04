/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto;

import dhz.skz.aqdb.entity.AnalitickeMetode;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kraljevic
 */
@XmlRootElement
public class Metoda {

    Integer id;
    String naziv;
    String oznaka_norme;
    List<IspitnaVelicina> ispitne_velicine;
    List<TockeUmjeravanja> tocke_umjeravanja;

    public Metoda() {
    }

    public Metoda(Integer id, String naziv, String oznaka_norme, List<IspitnaVelicina> ispitne_velicine, List<TockeUmjeravanja> predlozene_tocke) {
        this.id = id;
        this.naziv = naziv;
        this.oznaka_norme = oznaka_norme;
        this.ispitne_velicine = ispitne_velicine;
        this.tocke_umjeravanja = predlozene_tocke;
    }

    @XmlAttribute
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOznaka_norme() {
        return oznaka_norme;
    }

    public void setOznaka_norme(String oznaka_norme) {
        this.oznaka_norme = oznaka_norme;
    }

    public List<IspitnaVelicina> getIspitne_velicine() {
        return ispitne_velicine;
    }

    public void setIspitne_velicine(List<IspitnaVelicina> ispitne_velicine) {
        this.ispitne_velicine = ispitne_velicine;
    }

    public List<TockeUmjeravanja> getTocke_umjeravanja() {
        return tocke_umjeravanja;
    }

    public void setTocke_umjeravanja(List<TockeUmjeravanja> tocke_umjeravanja) {
        this.tocke_umjeravanja = tocke_umjeravanja;
    }

    public static Metoda create(AnalitickeMetode am) {
        Metoda m = new Metoda();
        m.setId(am.getId());
        m.setNaziv(am.getNaziv());
        m.setOznaka_norme(am.getNorma());
        m.setTocke_umjeravanja(am.getMetodaUmjerneTockeCollection().stream()
                .map(TockeUmjeravanja::create)
                .collect(Collectors.toList()));
        m.setIspitne_velicine(am.getDozvoljeneGraniceCollection().stream()
                .map(IspitnaVelicina::create)
                .collect(Collectors.toList()));
        return m;

    }

    public static class Builder {

        private Integer id;
        private String naziv;
        private String oznaka_norme;
        private List<IspitnaVelicina> ispitne_velicine;
        private List<TockeUmjeravanja> tocke_umjeravanja;

        public Builder() {
        }

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setNaziv(String naziv) {
            this.naziv = naziv;
            return this;
        }

        public Builder setOznaka_norme(String oznaka_norme) {
            this.oznaka_norme = oznaka_norme;
            return this;
        }

        public Builder setKomponente(List<IspitnaVelicina> ispitne_velicine) {
            this.ispitne_velicine = ispitne_velicine;
            return this;
        }

        public Builder setPredlozene_tocke(List<TockeUmjeravanja> tocke_umjeravanja) {
            this.tocke_umjeravanja = tocke_umjeravanja;
            return this;
        }

        public Metoda build() {
            return new Metoda(id, naziv, oznaka_norme, ispitne_velicine, tocke_umjeravanja);
        }
    }

}
