/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhz.skz.umjeravanje;

import dhz.skz.umjeravanje.dto.Boca;
import dhz.skz.umjeravanje.dto.CistiZrak;
import dhz.skz.umjeravanje.dto.Dilucijska;
import dhz.skz.umjeravanje.dto.IspitnaVelicina;
import dhz.skz.umjeravanje.dto.Metoda;
import dhz.skz.umjeravanje.dto.Mjeritelj;
import dhz.skz.umjeravanje.dto.OkolisniUvjeti;
import dhz.skz.umjeravanje.dto.TockeUmjeravanja;
import dhz.skz.umjeravanje.dto.Umjeravanje;
import dhz.skz.umjeravanje.dto.Uredjaj;
import dhz.skz.umjeravanje.dto.Velicina;
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
    public Umjeravanje getElement() {
        return new Umjeravanje.Builder()
                .setBoca_id(new Boca.Builder()
                        .setId(36)
                        .build())
                .setCisti_zrak_id(new CistiZrak.Builder()
                        .setId(36)
                        .build())
                .setDatum(new Date())
                .setDilucija_id(new Dilucijska.Builder()
                        .setId(37)
                        .build())
                .setMetoda_id(new Metoda.Builder()
                        .setId(38)
                        .setKomponente(new ArrayList<IspitnaVelicina>() {
                            {
                                add(new IspitnaVelicina.Builder()
                                        .setId(123)
                                        .setKomponenta("NOl")
                                        .setVrijednost(new Velicina(11., "nmol/mol"))
                                        .build());
                                add(new IspitnaVelicina.Builder()
                                        .setId(13)
                                        .setKomponenta("xNOl")
                                        .setVrijednost(new Velicina(101., "nmol/mol"))
                                        .build());

                            }
                        })
                        .setPredlozene_tocke(new ArrayList<TockeUmjeravanja>() {
                            {
                                add(new TockeUmjeravanja.Builder()
                                        .setC_ref(123.)
                                        .setC(123.4)
                                        .setKomponenta("SO7")
                                        .setMjerne_jedinice("nmol/mol")
                                        .setU(11.2)
                                        .build());
                                add(new TockeUmjeravanja.Builder()
                                        .setC_ref(3.)
                                        .setC(3.4)
                                        .setKomponenta("SO7")
                                        .setMjerne_jedinice("nmol/mol")
                                        .setU(0.2)
                                        .build());
                                add(new TockeUmjeravanja.Builder()
                                        .setC_ref(123.)
                                        .setC(123.4)
                                        .setKomponenta("SO9")
                                        .setMjerne_jedinice("nmol/mol")
                                        .setU(11.2)
                                        .build());
                                add(new TockeUmjeravanja.Builder()
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
                .setOkolisni_uvjeti(new OkolisniUvjeti.Builder()
                        .setRelativna_vlaga(new Velicina(90., "%"))
                        .setTemperatura(new Velicina(10., "C"))
                        .setTlak(new Velicina(1000., "hPa"))
                        .build())
                .setPostaja("Postaja")
                .setUredjaj(new Uredjaj.Builder()
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
