/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto.builders;

import dhz.skz.aqdb.entity.AnalitickeMetode;
import dhz.skz.aqdb.entity.MetodaUmjerneTocke;
import dhz.skz.umjeravanje.dto.TockeUmjeravanja;
import java.util.stream.Stream;


public class TockeUmjeravanjaBuilder {
    private String komponenta;
    private Double c_ref;
    private Double c;
    private Double u;
    private String mjerne_jedinice;

    public TockeUmjeravanjaBuilder() {
    }

    public TockeUmjeravanjaBuilder setKomponenta(String komponenta) {
        this.komponenta = komponenta;
        return this;
    }

    public TockeUmjeravanjaBuilder setC_ref(Double c_ref) {
        this.c_ref = c_ref;
        return this;
    }

    public TockeUmjeravanjaBuilder setC(Double c) {
        this.c = c;
        return this;
    }

    public TockeUmjeravanjaBuilder setU(Double u) {
        this.u = u;
        return this;
    }

    public TockeUmjeravanjaBuilder setMjerne_jedinice(String mjerne_jedinice) {
        this.mjerne_jedinice = mjerne_jedinice;
        return this;
    }

    public TockeUmjeravanja build() {
        return new TockeUmjeravanja(komponenta, c_ref, c, u, mjerne_jedinice);
    }

    public TockeUmjeravanja createTockeUmjeravanja(MetodaUmjerneTocke ut) {
        AnalitickeMetode am = ut.getAnalitickeMetode();
        this.komponenta = ut.getKomponentaId().getFormula();
        this.c_ref = ut.getPostotakOpsega()*1.;
        this.mjerne_jedinice = "%";
        return build();
    }
    
}
