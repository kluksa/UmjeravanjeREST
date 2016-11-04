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
@XmlType(propOrder = {"opci_podaci", "maksimalni_udjeli"})
public class CistiZrak {

    Integer id;
    List<Koncentracija> maksimalni_udjeli;
    Oprema opci_podaci;

    public CistiZrak() {
    }

    public CistiZrak(Integer id) {
        this.id = id;
    }

    public CistiZrak(Integer id, Oprema opciPodaci, List<Koncentracija> maksimalni_udjeli) {
        this.id = id;
        this.opci_podaci = opciPodaci;
        this.maksimalni_udjeli = maksimalni_udjeli;
    }

    public List<Koncentracija> getMaksimalni_udjeli() {
        return maksimalni_udjeli;
    }

    public void setMaksimalni_udjeli(List<Koncentracija> maksimalni_udjeli) {
        this.maksimalni_udjeli = maksimalni_udjeli;
    }

    public Oprema getOpci_podaci() {
        return opci_podaci;
    }

    public void setOpci_podaci(Oprema opciPodaci) {
        this.opci_podaci = opciPodaci;
    }

    @XmlAttribute
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static CistiZrak create(dhz.skz.aqdb.entity.Uredjaj u) {
        if (u == null || u.getEtalonCistiZrakKvalitetaCollection() == null || u.getEtalonCistiZrakKvalitetaCollection().isEmpty()) {
            throw new NoSuchElementException();
        }
        CistiZrak cz = new CistiZrak();
        cz.setId(u.getId());
        cz.setOpci_podaci(Oprema.create(u));
        cz.setMaksimalni_udjeli(u.getEtalonCistiZrakKvalitetaCollection().stream()
                .map(mu -> new Koncentracija(mu.getKomponenta().getFormula(), new Velicina(mu.getMaxUdio(), mu.getMjerneJediniceId().getOznaka()), null, null))
                .collect(Collectors.toList()));
        return cz;
    }

    public static class Builder {

        private Integer id;
        private Oprema opciPodaci;
        private List<Koncentracija> maksimalni_udjeli;

        public Builder() {
        }

        public Builder setMaksimalni_udjeli(List<Koncentracija> maksimalni_udjeli) {
            this.maksimalni_udjeli = maksimalni_udjeli;
            return this;
        }

        public Builder setOpciPodaci(Oprema opciPodaci) {
            this.opciPodaci = opciPodaci;
            return this;
        }

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public CistiZrak build() {
            return new CistiZrak(id, opciPodaci, maksimalni_udjeli);
        }
    }

}
