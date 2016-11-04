/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author kraljevic
 */
@XmlRootElement
@XmlType(propOrder = {"opci_podaci", "sljedivost", "komponente"})
public class Boca {

    Integer id;
    Oprema opci_podaci;
    String sljedivost;
    List<Koncentracija> komponente;

    public Boca() {
    }

    public Boca(Integer id) {
        this.id = id;
    }

    public Boca(Integer id, Oprema opciPodaci, String sljedivost, List<Koncentracija> komponente) {
        this.id = id;
        this.opci_podaci = opciPodaci;
        this.sljedivost = sljedivost;
        this.komponente = komponente;
    }

    public List<Koncentracija> getKomponente() {
        return komponente;
    }

    public void setKomponente(List<Koncentracija> komponente) {
        this.komponente = komponente;
    }

    public String getSljedivost() {
        return sljedivost;
    }

    public void setSljedivost(String sljedivost) {
        this.sljedivost = sljedivost;
    }

    public Oprema getOpci_podaci() {
        return opci_podaci;
    }

    public void setOpci_podaci(Oprema opci_podaci) {
        this.opci_podaci = opci_podaci;
    }

    @XmlAttribute
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Boca create(dhz.skz.aqdb.entity.Uredjaj u) {
        if (u == null || u.getEtalonBocaCollection() == null || u.getEtalonBocaCollection().isEmpty()) {
            throw new NoSuchElementException();
        }
        Boca b = new Boca();
        b.setId(u.getId());
        b.setSljedivost(null);
        b.setOpci_podaci(Oprema.create(u));
        b.setKomponente(u.getEtalonBocaCollection().stream().map(eb -> new Koncentracija.Builder()
                .setC(new Velicina(eb.getKoncentracija(), eb.getMjerneJediniceId().getOznaka()))
                .setU(new Velicina(eb.getNesigurnost(), eb.getMjerneJediniceId().getOznaka()))
                .setKomponenta(eb.getKomponenta().getFormula())
                .build()).collect(Collectors.toList()));
        return b;
    }

    public static class Builder {

        private Oprema opciPodaci;
        private String sljedivost;
        private Integer id;
        private List<Koncentracija> komponente;

        public Builder() {
        }

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setSljedivost(String sljedivost) {
            this.sljedivost = sljedivost;
            return this;
        }

        public Builder setKomponente(List<Koncentracija> komponente) {
            this.komponente = komponente;
            return this;
        }

        public Builder setOpciPodaci(Oprema opciPodaci) {
            this.opciPodaci = opciPodaci;
            return this;
        }

        public Boca build() {
            return new Boca(id, opciPodaci, sljedivost, komponente);
        }
    }

}
