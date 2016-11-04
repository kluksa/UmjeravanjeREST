/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje;

import dhz.skz.aqdb.facades.UredjajFacade;
import dhz.skz.umjeravanje.dto.Uredjaj;
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
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author kraljevic
 */
@Path("/uredjaji")
public class UredjajResource {

    UredjajFacade uredjajFacade = lookupUredjajFacadeBean();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UredjajsResource
     */
    public UredjajResource() {
    }

    /**
     * Retrieves representation of an instance of
 dhz.skz.umjeravanje.UredjajResource
     *
     * @return an instance of java.util.List<dhz.skz.umjeravanje.dto.Uredjaj>
     */
    @GET
    @Produces("application/xml")
    public java.util.List<Uredjaj> getElementList() {
        return uredjajFacade.findAll().stream()
                .filter(e -> Objects.nonNull(e)
                        && Objects.nonNull(e.getModelUredjajaId())
                        && Objects.nonNull(e.getModelUredjajaId().getAnalitickeMetodeId())
                        && e.getEtalonBocaCollection().isEmpty()
                        && e.getEtalonCistiZrakKvalitetaCollection().isEmpty()
                        && e.getEtalonDilucijskaCollection().isEmpty()
                )
                .map(Uredjaj::create)
                .collect(Collectors.toList());
    }

    @GET
    @Path("{id}")
    @Produces("application/xml")
    public Uredjaj getElement(@PathParam("id") Integer id) {
        try {
            return Uredjaj.create(uredjajFacade.find(id));
        } catch (NoSuchElementException ex) {
            Logger.getLogger(UredjajResource.class.getName()).log(Level.SEVERE, null, ex);
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
