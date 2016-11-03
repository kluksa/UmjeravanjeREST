/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje;

import dhz.skz.umjeravanje.dto.IspitnaVelicina;
import dhz.skz.umjeravanje.dto.Mjeritelj;
import dhz.skz.umjeravanje.dto.TockeUmjeravanja;
import dhz.skz.umjeravanje.dto.Umjeravanje;
import dhz.skz.umjeravanje.dto.Velicina;
import dhz.skz.umjeravanje.dto.builders.BocaBuilder;
import dhz.skz.umjeravanje.dto.builders.CistiZrakBuilder;
import dhz.skz.umjeravanje.dto.builders.DilucijskaBuilder;
import dhz.skz.umjeravanje.dto.builders.IspitnaVelicinaBuilder;
import dhz.skz.umjeravanje.dto.builders.MetodaBuilder;
import dhz.skz.umjeravanje.dto.builders.OkolisniUvjetiBuilder;
import dhz.skz.umjeravanje.dto.builders.TockeUmjeravanjaBuilder;
import dhz.skz.umjeravanje.dto.builders.UmjeravanjeBuilder;
import dhz.skz.umjeravanje.dto.builders.UredjajBuilder;
import java.util.ArrayList;
import java.util.Date;
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
public class UmjeravanjeResource {

    private String id;

    /**
     * Creates a new instance of UmjeravanjeResource
     */
    private UmjeravanjeResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the UmjeravanjeResource
     */
    public static UmjeravanjeResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of UmjeravanjeResource class.
        return new UmjeravanjeResource(id);
    }

    /**
     * Retrieves representation of an instance of
     * dhz.skz.umjeravanje.UmjeravanjeResource
     *
     * @return an instance of dhz.skz.umjeravanje.dto.Umjeravanje
     */
    @GET
    @Produces("application/xml")
    public Umjeravanje getXml() {
        return new UmjeravanjeBuilder()
                .setBoca_id(new BocaBuilder()
                        .setId(36)
                        .build())
                .setCisti_zrak_id(new CistiZrakBuilder()
                        .setId(36)
                        .build())
                .setDatum(new Date())
                .setDilucija_id(new DilucijskaBuilder()
                        .setId(37)
                        .build())
                .setMetoda_id(new MetodaBuilder()
                        .setId(38)
                        .setKomponente(new ArrayList<IspitnaVelicina>() {
                            {
                                add(new IspitnaVelicinaBuilder()
                                        .setId(123)
                                        .setKomponenta("NOl")
                                        .setVrijednost(new Velicina(11., "nmol/mol"))
                                        .build());
                                add(new IspitnaVelicinaBuilder()
                                        .setId(13)
                                        .setKomponenta("xNOl")
                                        .setVrijednost(new Velicina(101., "nmol/mol"))
                                        .build());

                            }
                        })
                        .setPredlozene_tocke(new ArrayList<TockeUmjeravanja>() {
                            {
                                add(new TockeUmjeravanjaBuilder()
                                        .setC_ref(123.)
                                        .setC(123.4)
                                        .setKomponenta("SO7")
                                        .setMjerne_jedinice("nmol/mol")
                                        .setU(11.2)
                                        .build());
                                add(new TockeUmjeravanjaBuilder()
                                        .setC_ref(3.)
                                        .setC(3.4)
                                        .setKomponenta("SO7")
                                        .setMjerne_jedinice("nmol/mol")
                                        .setU(0.2)
                                        .build());
                                add(new TockeUmjeravanjaBuilder()
                                        .setC_ref(123.)
                                        .setC(123.4)
                                        .setKomponenta("SO9")
                                        .setMjerne_jedinice("nmol/mol")
                                        .setU(11.2)
                                        .build());
                                add(new TockeUmjeravanjaBuilder()
                                        .setC_ref(3.)
                                        .setC(3.4)
                                        .setKomponenta("SO9")
                                        .setMjerne_jedinice("nmol/mol")
                                        .setU(0.2)
                                        .build());
                            }
                        })
                        .build())
                .setMjeritelj_id(new Mjeritelj(12345))
                .setNapomena("Napomena")
                .setOkolisni_uvjeti(new OkolisniUvjetiBuilder()
                        .setRelativna_vlaga(new Velicina(90., "%"))
                        .setTemperatura(new Velicina(10., "C"))
                        .setTlak(new Velicina(1000., "hPa"))
                        .build())
                .setPostaja("Postaja")
                .setUredjaj(new UredjajBuilder()
                        .setId(123)
                        .createUredjaj())
                .build();
    }

    /**
     * PUT method for updating or creating an instance of UmjeravanjeResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(Umjeravanje content) {
        throw new WebApplicationException(Response.Status.EXPECTATION_FAILED);
    }

    /**
     * DELETE method for resource UmjeravanjeResource
     */
    @DELETE
    public void delete() {
        throw new WebApplicationException(Response.Status.FORBIDDEN);
    }
}
