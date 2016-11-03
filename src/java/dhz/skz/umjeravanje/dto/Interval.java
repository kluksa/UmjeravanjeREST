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
public class Interval {
    Double min;
    Double max;
    String jedinica;

    public Interval() {
    }
    
    

    public Interval(Double min, Double max, String jedinica) {
        this.min = min;
        this.max = max;
        this.jedinica = jedinica;
    }
    

    
    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    @XmlAttribute
    public String getJedinica() {
        return jedinica;
    }

    public void setJedinica(String jedinica) {
        this.jedinica = jedinica;
    }
    
    
}
