/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje;

import dhz.skz.aqdb.facades.UredjajFacade;
import dhz.skz.umjeravanje.dto.Dilucijska;
import dhz.skz.umjeravanje.dto.Oprema;
import dhz.skz.umjeravanje.dto.builders.DilucijskaBuilder;
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
public class DilucijskaResource {
    UredjajFacade uredjajFacade = lookupUredjajFacadeBean();

    private String id;

    /**
     * Creates a new instance of DilucijskaResource
     */
    private DilucijskaResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the DilucijskaResource
     */
    public static DilucijskaResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of DilucijskaResource class.
        return new DilucijskaResource(id);
    }

    /**
     * Retrieves representation of an instance of
     * dhz.skz.umjeravanje.DilucijskaResource
     *
     * @return an instance of dhz.skz.umjeravanje.dto.Dilucijska
     */
    @GET
    @Produces("application/xml")
    public Dilucijska getXml() {
        try {
            return new DilucijskaBuilder().build(uredjajFacade.find(Integer.parseInt(id)));
        } catch (NoSuchElementException ex) {
            Logger.getLogger(BocaResource.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
//        return new DilucijskaBuilder()
//                .setId(838)
//                .setOpciPodaci(new Oprema("Dilucijska 1", "D1", "DP1"))
//                .setMfc1(17., "%", "SLJ1")
//                .setMfc2(12., "%", "SLJ2")
//                .setOzon(1234., "nmol/mol", "SLJO3")
//                .build();
    }

    /**
     * PUT method for updating or creating an instance of DilucijskaResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(Dilucijska content) {
        throw new WebApplicationException(Response.Status.FORBIDDEN);
    }

    /**
     * DELETE method for resource DilucijskaResource
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
