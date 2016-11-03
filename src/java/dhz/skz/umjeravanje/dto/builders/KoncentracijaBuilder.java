/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto.builders;

import dhz.skz.umjeravanje.dto.Koncentracija;
import dhz.skz.umjeravanje.dto.Velicina;


public class KoncentracijaBuilder {
    private String komponenta;
    private String sljedivost;
    private Velicina c;
    private Velicina u = null;

    public KoncentracijaBuilder() {
    }

    public KoncentracijaBuilder setKomponenta(String komponenta) {
        this.komponenta = komponenta;
        return this;
    }
    
    public KoncentracijaBuilder setSljedivost(String sljedivost) {
        this.sljedivost = sljedivost;
        return this;
    }

    public KoncentracijaBuilder setC(Velicina c) {
        this.c = c;
        return this;
    }

    public KoncentracijaBuilder setU(Velicina u) {
        this.u = u;
        return this;
    }

    public Koncentracija build() {
        return new Koncentracija(komponenta, c, u, sljedivost);
    }
    
}
