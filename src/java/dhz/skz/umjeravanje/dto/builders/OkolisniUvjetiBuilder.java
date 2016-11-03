/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto.builders;

import dhz.skz.umjeravanje.dto.OkolisniUvjeti;
import dhz.skz.umjeravanje.dto.Velicina;


public class OkolisniUvjetiBuilder {
    private Velicina temperatura;
    private Velicina tlak;
    private Velicina relativna_vlaga;

    public OkolisniUvjetiBuilder() {
    }

    public OkolisniUvjetiBuilder setTemperatura(Velicina temperatura) {
        this.temperatura = temperatura;
        return this;
    }

    public OkolisniUvjetiBuilder setTlak(Velicina tlak) {
        this.tlak = tlak;
        return this;
    }

    public OkolisniUvjetiBuilder setRelativna_vlaga(Velicina relativna_vlaga) {
        this.relativna_vlaga = relativna_vlaga;
        return this;
    }

    public OkolisniUvjeti build() {
        return new OkolisniUvjeti(temperatura, tlak, relativna_vlaga);
    }
    
}
