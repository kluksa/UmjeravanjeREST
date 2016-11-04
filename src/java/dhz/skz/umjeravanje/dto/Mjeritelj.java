/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto;

import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author kraljevic
 */
public class Mjeritelj {
    private Integer id;
    private String username;
    private String ime;
    private String prezime;

    public Mjeritelj() {
    }

    public Mjeritelj(Integer id) {
        this.id = id;
    }

    @XmlAttribute
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
}
