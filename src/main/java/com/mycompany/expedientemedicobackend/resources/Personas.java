package com.mycompany.expedientemedicobackend.resources;

import com.mycompany.expedientemedicobackend.logic.Persona;
import com.mycompany.expedientemedicobackend.logic.Service;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.DELETE;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.POST;


@Path("/personas")
public class Personas {
    
    @POST
    @Path("{idDoc}")
    @Consumes(MediaType.APPLICATION_JSON) 
    public void create(Persona p,@PathParam("idDoc") String idDoc) {  
        try {
            Service.instance().personasCREATE(p,idDoc);
        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
    
    @GET
    @Path("{idDoc}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> read(@PathParam("idDoc") String idDoc) { 
        return Service.instance().personasREAD(idDoc);
    }     
    
    @GET
    @Path("{idDoc}/{cedula}")
    @Produces({MediaType.APPLICATION_JSON})
    public Persona read(@PathParam("cedula") String cedula,@PathParam("idDoc") String idDoc ) {
        try {
            return Service.instance().personasREAD(cedula,idDoc);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") int id, Persona p) {  
        try {
            Service.instance().personasUPDATE(p);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") int id) {
        try {
            Service.instance().personasDELETE(id);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
}
