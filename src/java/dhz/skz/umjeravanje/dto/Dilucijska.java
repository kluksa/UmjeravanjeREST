/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author kraljevic
 */
@XmlRootElement
@XmlType(propOrder={"opci_podaci", "mfc_kal_plin","mfc_dilutent", "ozon"})
public class Dilucijska {
    Integer id;
    Oprema opci_podaci;
    SljedivaVelicina mfc_kal_plin;
    SljedivaVelicina mfc_dilutent;
    SljedivaVelicina ozon;
    
    
    public Dilucijska(){}

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
    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
}
