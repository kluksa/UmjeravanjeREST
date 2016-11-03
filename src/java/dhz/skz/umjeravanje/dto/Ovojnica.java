/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kraljevic
 */
@XmlRootElement
public class Ovojnica {
    Boca boca;
    CistiZrak cistiZrak;
    Dilucijska dilucijska;
    Metoda metoda;
    Uredjaj uredjaj;
    Integer id;
    
    public Ovojnica() {
        
    }

    public Ovojnica(Boca boca, CistiZrak cistiZrak, Dilucijska dilucijska, Metoda metoda, Uredjaj uredjaj) {
        this.boca = boca;
        this.cistiZrak = cistiZrak;
        this.dilucijska = dilucijska;
        this.metoda = metoda;
        this.uredjaj = uredjaj;
    }
    
    
    
    public Boca getBoca() {
        return boca;
    }

    public void setBoca(Boca boca) {
        this.boca = boca;
    }

    public CistiZrak getCistiZrak() {
        return cistiZrak;
    }

    public void setCistiZrak(CistiZrak cistiZrak) {
        this.cistiZrak = cistiZrak;
    }

    public Dilucijska getDilucijska() {
        return dilucijska;
    }

    public void setDilucijska(Dilucijska dilucijska) {
        this.dilucijska = dilucijska;
    }

    public Metoda getMetoda() {
        return metoda;
    }

    public void setMetoda(Metoda metoda) {
        this.metoda = metoda;
    }

    public Uredjaj getUredjaj() {
        return uredjaj;
    }

    public void setUredjaj(Uredjaj uredjaj) {
        this.uredjaj = uredjaj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
