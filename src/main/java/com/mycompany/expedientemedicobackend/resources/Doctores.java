package com.mycompany.expedientemedicobackend.resources;

import com.mycompany.expedientemedicobackend.logic.Doctor;
import com.mycompany.expedientemedicobackend.logic.Service;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.POST;

@Path("/doctores")
public class Doctores {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    public void create(Doctor d) {  
        try {
            Service.instance().doctoresCREATE(d);
        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Doctor read(@PathParam("id") String id) {
        try {
            return Service.instance().doctoresREAD(id);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
    @GET
    @Path("{id}/{contrasena}")
    @Produces({MediaType.APPLICATION_JSON})
    public boolean validate(@PathParam("id") String id,@PathParam("contrasena") String contrasena) {
        try {
            return Service.instance().doctoresVALIDATE(id, contrasena);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
}
