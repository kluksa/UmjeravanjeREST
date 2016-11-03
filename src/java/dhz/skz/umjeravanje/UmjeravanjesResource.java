/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje;

import dhz.skz.umjeravanje.dto.Umjeravanje;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author kraljevic
 */
@Path("/umjeravanje")
public class UmjeravanjesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UmjeravanjesResource
     */
    public UmjeravanjesResource() {
    }

    /**
     * Retrieves representation of an instance of dhz.skz.umjeravanje.UmjeravanjesResource
     * @return an instance of java.util.List<dhz.skz.umjeravanje.dto.Umjeravanje>
     */
    @GET
    @Produces("application/xml")
    public java.util.List<dhz.skz.umjeravanje.dto.Umjeravanje> getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * POST method for creating an instance of UmjeravanjeResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response postXml(Umjeravanje content) {
        //TODO
        content = new Umjeravanje();
        content.setId(546);
        content.setOznaka_izvjesca("OZNAKA_1");
        return Response.created(context.getAbsolutePath()).entity(content).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public UmjeravanjeResource getUmjeravanjeResource(@PathParam("id") String id) {
        return UmjeravanjeResource.getInstance(id);
    }
}
