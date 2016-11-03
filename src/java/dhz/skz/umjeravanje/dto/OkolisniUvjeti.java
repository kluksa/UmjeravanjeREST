/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto;

/**
 *
 * @author kraljevic
 */
public class OkolisniUvjeti {
    Velicina temperatura;
    Velicina tlak;
    Velicina relativna_vlaga;

    public OkolisniUvjeti() {
    }

    public OkolisniUvjeti(Velicina temperatura, Velicina tlak, Velicina relativna_vlaga) {
        this.temperatura = temperatura;
        this.tlak = tlak;
        this.relativna_vlaga = relativna_vlaga;
    }

    public Velicina getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Velicina temperatura) {
        this.temperatura = temperatura;
    }

    public Velicina getTlak() {
        return tlak;
    }

    public void setTlak(Velicina tlak) {
        this.tlak = tlak;
    }

    public Velicina getRelativna_vlaga() {
        return relativna_vlaga;
    }

    public void setRelativna_vlaga(Velicina relativna_vlaga) {
        this.relativna_vlaga = relativna_vlaga;
    }
}
