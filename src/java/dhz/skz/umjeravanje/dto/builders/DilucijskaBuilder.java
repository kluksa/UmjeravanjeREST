/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto.builders;

import dhz.skz.aqdb.entity.EtalonDilucijska;
import dhz.skz.umjeravanje.dto.Dilucijska;
import dhz.skz.umjeravanje.dto.Oprema;
import dhz.skz.umjeravanje.dto.SljedivaVelicina;
import dhz.skz.umjeravanje.dto.Velicina;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class DilucijskaBuilder {

    private Integer id;
    private Oprema opciPodaci;
    private SljedivaVelicina mfc1;
    private SljedivaVelicina mfc2;
    private SljedivaVelicina ozon = null;

    public DilucijskaBuilder() {
    }

    public DilucijskaBuilder setMfc1(Double iznos, String jedinica, String sljedivost) {
        this.mfc1 = new SljedivaVelicina(new Velicina(iznos, jedinica), sljedivost);
        return this;
    }

    public DilucijskaBuilder setMfc2(Double iznos, String jedinica, String sljedivost) {
        this.mfc2 = new SljedivaVelicina(new Velicina(iznos, jedinica), sljedivost);
        return this;
    }

    public DilucijskaBuilder setOzon(Double iznos, String jedinica, String sljedivost) {
        this.ozon = new SljedivaVelicina(new Velicina(iznos, jedinica), sljedivost);
        return this;
    }

    public DilucijskaBuilder setOpciPodaci(Oprema opciPodaci) {
        this.opciPodaci = opciPodaci;
        return this;
    }

    public DilucijskaBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public Dilucijska build() {
        return new Dilucijska(id, opciPodaci, mfc1, mfc2, ozon);
    }

    public Dilucijska build(dhz.skz.aqdb.entity.Uredjaj u) {
        if ( u == null || u.getEtalonDilucijskaCollection() == null || u.getEtalonDilucijskaCollection().isEmpty()) throw new NoSuchElementException();

        this.id = u.getId();
        this.opciPodaci = new Oprema(u.getSerijskaOznaka(),
                u.getModelUredjajaId().getOznakaModela(), u.getModelUredjajaId().getProizvodjacId().getNaziv());

        Comparator<EtalonDilucijska> cmp = (EtalonDilucijska ed1, EtalonDilucijska ed2) -> ed1.getEtalonDilucijskaPK().getPrimjenaOd().compareTo(ed2.getEtalonDilucijskaPK().getPrimjenaOd());
        EtalonDilucijska max = Collections.max(u.getEtalonDilucijskaCollection(), cmp);

        this.mfc1 = new SljedivaVelicina(new Velicina(1.75, "%"), max.getMfczSljedivost());
        this.mfc2 = new SljedivaVelicina(new Velicina(1.75, "%"), max.getMfcsSljedivost());
        this.ozon = null;
        return DilucijskaBuilder.this.build();
    }

}
