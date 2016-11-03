/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje;

import dhz.skz.aqdb.facades.UredjajFacade;
import dhz.skz.umjeravanje.dto.Uredjaj;
import dhz.skz.umjeravanje.dto.builders.UredjajBuilder;
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
public class UredjajsResource {
    UredjajFacade uredjajFacade = lookupUredjajFacadeBean();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UredjajsResource
     */
    public UredjajsResource() {
    }

    /**
     * Retrieves representation of an instance of dhz.skz.umjeravanje.UredjajsResource
     * @return an instance of java.util.List<dhz.skz.umjeravanje.dto.Uredjaj>
     */
    @GET
    @Produces("application/xml")
    public java.util.List<dhz.skz.umjeravanje.dto.Uredjaj> getXml() {
        return uredjajFacade.findAll().stream()
                .filter(e-> Objects.nonNull(e)  
                        && Objects.nonNull(e.getModelUredjajaId())
                        && Objects.nonNull(e.getModelUredjajaId().getAnalitickeMetodeId())
                        && e.getEtalonBocaCollection().isEmpty()
                        && e.getEtalonCistiZrakKvalitetaCollection().isEmpty()
                        && e.getEtalonDilucijskaCollection().isEmpty()
                )
                .map(new UredjajBuilder()::build)
                .collect(Collectors.toList());
    }

    /**
     * POST method for creating an instance of UredjajResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response postXml(Uredjaj content) {
        //TODO
        throw new WebApplicationException(Response.Status.FORBIDDEN);
//        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public UredjajResource getUredjajResource(@PathParam("id") String id) {
        return UredjajResource.getInstance(id);
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
