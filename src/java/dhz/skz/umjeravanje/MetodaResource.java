/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje;

import dhz.skz.aqdb.facades.AnalitickeMetodeFacade;
import dhz.skz.umjeravanje.dto.Metoda;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * REST Web Service
 *
 * @author kraljevic
 */
@Path("/metoda")
public class MetodaResource {

    @EJB
    AnalitickeMetodeFacade analitickeMetodeFacade = lookupAnalitickeMetodeFacadeBean();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MetodasResource
     */
    public MetodaResource() {
    }

    /**
     * Retrieves representation of an instance of
 dhz.skz.umjeravanje.MetodaResource
     *
     * @return an instance of java.util.List<dhz.skz.umjeravanje.dto.Metoda>
     */
    @GET
    @Produces("application/xml")
    public java.util.List<dhz.skz.umjeravanje.dto.Metoda> getElementList() {
        return analitickeMetodeFacade.findAll().stream()
                .map(Metoda::create)
                .collect(Collectors.toList());
    }

    @GET
    @Path("{id}")
    @Produces("application/xml")
    public Metoda getElement(@PathParam("id") Integer id) {
        return Metoda.create(analitickeMetodeFacade.find(id));
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
