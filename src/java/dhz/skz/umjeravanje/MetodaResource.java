/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje;

import dhz.skz.aqdb.facades.AnalitickeMetodeFacade;
import dhz.skz.umjeravanje.dto.Metoda;
import dhz.skz.umjeravanje.dto.builders.MetodaBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author kraljevic
 */
public class MetodaResource {
    AnalitickeMetodeFacade analitickeMetodeFacade = lookupAnalitickeMetodeFacadeBean();

    private String id;
    

    /**
     * Creates a new instance of MetodaResource
     */
    private MetodaResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the MetodaResource
     * @param id
     * @return 
     */
    public static MetodaResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of MetodaResource class.
        return new MetodaResource(id);
    }

    /**
     * Retrieves representation of an instance of
     * dhz.skz.umjeravanje.MetodaResource
     *
     * @return an instance of dhz.skz.umjeravanje.dto.Metoda
     */
    @GET
    @Produces("application/xml")
    public Metoda getXml() {
        return new MetodaBuilder().build(analitickeMetodeFacade.find(Integer.parseInt(id)));
    }

    /**
     * PUT method for updating or creating an instance of MetodaResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(Metoda content) {
        throw new WebApplicationException(Response.Status.FORBIDDEN);
    }

    /**
     * DELETE method for resource MetodaResource
     */
    @DELETE
    public void delete() {
        throw new WebApplicationException(Response.Status.FORBIDDEN);
    }

    private AnalitickeMetodeFacade lookupAnalitickeMetodeFacadeBean() {
        try {
            Context c = new InitialContext();
            return (AnalitickeMetodeFacade) c.lookup("java:global/SKZ/SKZ-ejb/AnalitickeMetodeFacade!dhz.skz.aqdb.facades.AnalitickeMetodeFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
