/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje;

import dhz.skz.aqdb.facades.UredjajFacade;
import dhz.skz.umjeravanje.dto.CistiZrak;
import dhz.skz.umjeravanje.dto.builders.CistiZrakBuilder;
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
@Path("/cisti_zrak")
public class CistiZraksResource {
    UredjajFacade uredjajFacade = lookupUredjajFacadeBean();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CistiZraksResource
     */
    public CistiZraksResource() {
    }

    /**
     * Retrieves representation of an instance of dhz.skz.umjeravanje.CistiZraksResource
     * @return an instance of java.util.List<dhz.skz.umjeravanje.dto.CistiZrak>
     */
    @GET
    @Produces("application/xml")
    public java.util.List<dhz.skz.umjeravanje.dto.CistiZrak> getXml() {
        return uredjajFacade.findAll().stream()
                .filter(e->true
                        && Objects.nonNull(e)
                        && Objects.nonNull(e.getEtalonCistiZrakKvalitetaCollection())
                        && !e.getEtalonCistiZrakKvalitetaCollection().isEmpty()
                )
                .map(new CistiZrakBuilder()::build)
                .collect(Collectors.toList());
    }

    /**
     * POST method for creating an instance of CistiZrakResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response postXml(CistiZrak content) {
        throw new WebApplicationException(Response.Status.FORBIDDEN);
        //TODO
//        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public CistiZrakResource getCistiZrakResource(@PathParam("id") String id) {
        return CistiZrakResource.getInstance(id);
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
