/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje;

import dhz.skz.aqdb.facades.UredjajFacade;
import dhz.skz.umjeravanje.dto.Boca;
import dhz.skz.umjeravanje.dto.builders.BocaBuilder;
import java.util.NoSuchElementException;
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
public class BocaResource {
    UredjajFacade uredjajFacade = lookupUredjajFacadeBean();
    
    private String id;

    /**
     * Creates a new instance of BocaResource
     */
    private BocaResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the BocaResource
     */
    public static BocaResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of BocaResource class.
        return new BocaResource(id);
    }

    /**
     * Retrieves representation of an instance of
     * dhz.skz.umjeravanje.BocaResource
     *
     * @return an instance of dhz.skz.umjeravanje.dto.Boca
     */
    @GET
    @Produces("application/xml")
    public Boca getXml() {
        try {
            return new BocaBuilder().build(uredjajFacade.find(Integer.parseInt(id)));
        } catch (NoSuchElementException ex) {
            Logger.getLogger(BocaResource.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    /**
     * PUT method for updating or creating an instance of BocaResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(Boca content) {
        throw new WebApplicationException(Response.Status.FORBIDDEN);
    }

    /**
     * DELETE method for resource BocaResource
     */
    @DELETE
    public void delete() {
        throw new WebApplicationException(Response.Status.FORBIDDEN);
    }

    private UredjajFacade lookupUredjajFacadeBean() {
        try {
            Context c = new InitialContext();
            return (UredjajFacade) c.lookup("java:global/SKZ/SKZ-ejb/UredjajFacade!dhz.skz.aqdb.facades.UredjajFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
