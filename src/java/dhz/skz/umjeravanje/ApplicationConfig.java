/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author kraljevic
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(dhz.skz.umjeravanje.BocaResource.class);
        resources.add(dhz.skz.umjeravanje.BocasResource.class);
        resources.add(dhz.skz.umjeravanje.CistiZraksResource.class);
        resources.add(dhz.skz.umjeravanje.DilucijskasResource.class);
        resources.add(dhz.skz.umjeravanje.MetodaResource.class);
        resources.add(dhz.skz.umjeravanje.MetodasResource.class);
        resources.add(dhz.skz.umjeravanje.UmjeravanjesResource.class);
        resources.add(dhz.skz.umjeravanje.UredjajResource.class);
        resources.add(dhz.skz.umjeravanje.UredjajsResource.class);
    }
    
}
