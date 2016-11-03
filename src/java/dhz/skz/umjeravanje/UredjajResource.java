/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje;

import dhz.skz.aqdb.facades.UredjajFacade;
import dhz.skz.umjeravanje.dto.Uredjaj;
import dhz.skz.umjeravanje.dto.builders.UredjajBuilder;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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
public class UredjajResource {
    UredjajFacade uredjajFacade = lookupUredjajFacadeBean();
    
    private String id;

    /**
     * Creates a new instance of UredjajResource
     */
    private UredjajResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the UredjajResource
     */
    public static UredjajResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of UredjajResource class.
        return new UredjajResource(id);
    }

    /**
     * Retrieves representation of an instance of
     * dhz.skz.umjeravanje.UredjajResource
     *
     * @return an instance of dhz.skz.umjeravanje.dto.Uredjaj
     */
    @GET
    @Produces("application/xml")
    public Uredjaj getXml() {
        try {
            return new UredjajBuilder().build(uredjajFacade.find(Integer.parseInt(id)));
        } catch (NoSuchElementException ex) {
            Logger.getLogger(BocaResource.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
//        return new UredjajBuilder()
//                .setId(45321)
//                .setOpci_podaci(new Oprema("Uredjaj 1", "U1", "UP1"))
//                .setVrijeme_odziva(new Velicina(123., "s"))
//                .setMjerene_komponente(new ArrayList<String>() {
//                    {
//                        add("K1");
//                        add("K2");
//                    }
//                })
//                .setAnaliticka_metoda_id(123)
//                .build();
    }

    /**
     * PUT method for updating or creating an instance of UredjajResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(Uredjaj content) {
        throw new WebApplicationException(Response.Status.FORBIDDEN);
    }

    /**
     * DELETE method for resource UredjajResource
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
