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
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
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
@Path("/metoda")
public class MetodasResource {
    @EJB
    AnalitickeMetodeFacade analitickeMetodeFacade = lookupAnalitickeMetodeFacadeBean();

    @Context
    private UriInfo context;
    

    /**
     * Creates a new instance of MetodasResource
     */
    public MetodasResource() {
    }

    /**
     * Retrieves representation of an instance of dhz.skz.umjeravanje.MetodasResource
     * @return an instance of java.util.List<dhz.skz.umjeravanje.dto.Metoda>
     */
    @GET
    @Produces("application/xml")
    public java.util.List<dhz.skz.umjeravanje.dto.Metoda> getXml() {
        return analitickeMetodeFacade.findAll().stream().map(am->new MetodaBuilder().build(am)).collect(Collectors.toList());
    }

    /**
     * POST method for creating an instance of MetodaResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response postXml(Metoda content) {
        //TODO
        throw new WebApplicationException(Response.Status.FORBIDDEN);
//        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public MetodaResource getMetodaResource(@PathParam("id") String id) {
        return MetodaResource.getInstance(id);
    }

    private AnalitickeMetodeFacade lookupAnalitickeMetodeFacadeBean() {
        try {
            javax.naming.Context c = new InitialContext();
            return (AnalitickeMetodeFacade) c.lookup("java:global/SKZ/SKZ-ejb/AnalitickeMetodeFacade!dhz.skz.aqdb.facades.AnalitickeMetodeFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
