/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje;

import dhz.skz.aqdb.facades.UredjajFacade;
import dhz.skz.umjeravanje.dto.Dilucijska;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author kraljevic
 */
@Path("/dilucijska")
public class DilucijskaResource {

    UredjajFacade uredjajFacade = lookupUredjajFacadeBean();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DilucijskasResource
     */
    public DilucijskaResource() {
    }

    /**
     * Retrieves representation of an instance of
 dhz.skz.umjeravanje.DilucijskaResource
     *
     * @return an instance of java.util.List<dhz.skz.umjeravanje.dto.Dilucijska>
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public java.util.List<dhz.skz.umjeravanje.dto.Dilucijska> getElementList() {
        return uredjajFacade.findAll().stream()
                .filter(e -> true
                        && Objects.nonNull(e)
                        && Objects.nonNull(e.getEtalonDilucijskaCollection())
                        && !e.getEtalonDilucijskaCollection().isEmpty()
                )
                .map(Dilucijska::create)
                .collect(Collectors.toList());
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Dilucijska getElement(@PathParam("id") Integer id) {
        try {
            return Dilucijska.create(uredjajFacade.find(id));
        } catch (NoSuchElementException ex) {
            Logger.getLogger(DilucijskaResource.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    private UredjajFacade lookupUredjajFacadeBean() {
        try {
            javax.naming.Context c = new InitialContext();
            return (UredjajFacade) c.lookup("java:global/SKZ/SKZ-ejb/UredjajFacade!dhz.skz.aqdb.facades.UredjajFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
