/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto;

import dhz.skz.aqdb.entity.EtalonDilucijska;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author kraljevic
 */
@XmlRootElement
@XmlType(propOrder = {"opci_podaci", "mfc_kal_plin", "mfc_dilutent", "ozon"})
public class Dilucijska {

    Integer id;
    Oprema opci_podaci;
    SljedivaVelicina mfc_kal_plin;
    SljedivaVelicina mfc_dilutent;
    SljedivaVelicina ozon;

    public Dilucijska() {
    }

    public Dilucijska(Integer id) {
        this.id = id;
    }

    public Dilucijska(Integer id, Oprema opci_podaci, SljedivaVelicina mfc1, SljedivaVelicina mfc2,
            SljedivaVelicina ozon) {
        this.id = id;
        this.opci_podaci = opci_podaci;
        this.mfc_kal_plin = mfc1;
        this.mfc_dilutent = mfc2;
        this.ozon = ozon;
    }

    public SljedivaVelicina getMfc_kal_plin() {
        return mfc_kal_plin;
    }

    public void setMfc_kal_plin(SljedivaVelicina mfc_kal_plin) {
        this.mfc_kal_plin = mfc_kal_plin;
    }

    public SljedivaVelicina getMfc_dilutent() {
        return mfc_dilutent;
    }

    public void setMfc_dilutent(SljedivaVelicina mfc_dilutent) {
        this.mfc_dilutent = mfc_dilutent;
    }

    public SljedivaVelicina getOzon() {
        return ozon;
    }

    public void setOzon(SljedivaVelicina ozon) {
        this.ozon = ozon;
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

    public static Dilucijska create(dhz.skz.aqdb.entity.Uredjaj u) {
        if (u == null || u.getEtalonDilucijskaCollection() == null || u.getEtalonDilucijskaCollection().isEmpty()) {
            throw new NoSuchElementException();
        }

        Dilucijska d = new Dilucijska();
        d.setId(u.getId());
        d.setOpci_podaci(Oprema.create(u));

        Comparator<EtalonDilucijska> cmp = (EtalonDilucijska ed1, EtalonDilucijska ed2) -> ed1.getEtalonDilucijskaPK().getPrimjenaOd().compareTo(ed2.getEtalonDilucijskaPK().getPrimjenaOd());
        EtalonDilucijska max = Collections.max(u.getEtalonDilucijskaCollection(), cmp);

        d.setMfc_dilutent(new SljedivaVelicina(new Velicina(1.75, "%"), max.getMfczSljedivost()));
        d.setMfc_kal_plin(new SljedivaVelicina(new Velicina(1.75, "%"), max.getMfcsSljedivost()));
        d.setOzon(null);
        return d;
    }

    public static class Builder {

        private Integer id;
        private Oprema opciPodaci;
        private SljedivaVelicina mfc1;
        private SljedivaVelicina mfc2;
        private SljedivaVelicina ozon = null;

        public Builder() {
        }

        public Builder setMfc1(Double iznos, String jedinica, String sljedivost) {
            this.mfc1 = new SljedivaVelicina(new Velicina(iznos, jedinica), sljedivost);
            return this;
        }

        public Builder setMfc2(Double iznos, String jedinica, String sljedivost) {
            this.mfc2 = new SljedivaVelicina(new Velicina(iznos, jedinica), sljedivost);
            return this;
        }

        public Builder setOzon(Double iznos, String jedinica, String sljedivost) {
            this.ozon = new SljedivaVelicina(new Velicina(iznos, jedinica), sljedivost);
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

        public Dilucijska build() {
            return new Dilucijska(id, opciPodaci, mfc1, mfc2, ozon);
        }
    }

}
