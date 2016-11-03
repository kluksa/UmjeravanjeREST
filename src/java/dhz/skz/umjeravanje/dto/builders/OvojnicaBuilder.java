/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto.builders;

import dhz.skz.umjeravanje.dto.Boca;
import dhz.skz.umjeravanje.dto.CistiZrak;
import dhz.skz.umjeravanje.dto.Dilucijska;
import dhz.skz.umjeravanje.dto.Metoda;
import dhz.skz.umjeravanje.dto.Ovojnica;
import dhz.skz.umjeravanje.dto.Uredjaj;


public class OvojnicaBuilder {
    private Boca boca;
    private CistiZrak cistiZrak;
    private Dilucijska dilucijska;
    private Metoda metoda;
    private Uredjaj uredjaj;

    public OvojnicaBuilder() {
    }

    public OvojnicaBuilder setBoca(Boca boca) {
        this.boca = boca;
        return this;
    }

    public OvojnicaBuilder setCistiZrak(CistiZrak cistiZrak) {
        this.cistiZrak = cistiZrak;
        return this;
    }

    public OvojnicaBuilder setDilucijska(Dilucijska dilucijska) {
        this.dilucijska = dilucijska;
        return this;
    }

    public OvojnicaBuilder setMetoda(Metoda metoda) {
        this.metoda = metoda;
        return this;
    }
    
    public OvojnicaBuilder setUredjaj(Uredjaj uredjaj) {
        this.uredjaj = uredjaj;
        return this;
    }

    public Ovojnica createOvojnica() {
        return new Ovojnica(boca, cistiZrak, dilucijska, metoda, uredjaj);
    }
    
}
