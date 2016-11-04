/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author kraljevic
 */
@XmlType(propOrder={"oznaka","naziv", "proizvodjac"})
public class Oprema {
    String oznaka;
    String naziv;
    String proizvodjac;

    public Oprema() {
    }

    public Oprema(String oznaka, String naziv, String proizvodjac) {
        this.oznaka = oznaka;
        this.naziv = naziv;
        this.proizvodjac = proizvodjac;
    }
    
    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }
    
    public static Oprema create(dhz.skz.aqdb.entity.Uredjaj u){
        Oprema o = new Oprema();
        o.setOznaka(u.getSerijskaOznaka());
        o.setNaziv(u.getModelUredjajaId().getOznakaModela());
        o.setProizvodjac(u.getModelUredjajaId().getProizvodjacId().getNaziv());
        return o;
    }
}
