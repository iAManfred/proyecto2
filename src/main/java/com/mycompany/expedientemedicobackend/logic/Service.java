package com.mycompany.expedientemedicobackend.logic;

import com.mycompany.expedientemedicobackend.DAO.DoctorDAO;
import com.mycompany.expedientemedicobackend.DAO.PersonaDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Service {
    HashMap<String,Persona> personas;
    PersonaDAO perDAO;
    DoctorDAO docDAO;
    
    private static Service uniqueInstance;
    
    public static Service instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Service();
        }
        return uniqueInstance;
    }
    
    private Service(){
        perDAO = new PersonaDAO();
        docDAO = new DoctorDAO();
    }
    
    
    
    //-----------------------------------------------------------------//
    //Persona
    //-----------------------------------------------------------------//
    
    public Persona personasCREATE(Persona per,String idDoc)throws Exception {
        if (perDAO.read(per.getCedula())!=null){
            throw new Exception ("406-persona ya existe");
        }
        else{
            perDAO.create(per, idDoc);
            return per;
        }
    }
    
    public List<Persona> personasREAD(String idDoc) {
        return perDAO.read(idDoc);
    } 
    
    public Persona personasREAD(int id)throws Exception {
        Persona per = perDAO.read(id);
        if (per!=null){
            return per;
        }
        else{
            throw new Exception ("404-persona no existe");
        }
    }
    
    public Persona personasREAD(String cedula,String idDoc)throws Exception {
        Persona per = perDAO.read(cedula, idDoc);
        if (per!=null){
            return per;
        }
        else{
            throw new Exception ("404-persona no existe");
        }
    }

    public void personasUPDATE(Persona per)throws Exception {
        
        if (perDAO.read(per.getCedula())==null){
            throw new Exception ("404-persona no existe");
        }
        else{
            perDAO.update(per);
        }
    }
    
    public void personasDELETE(int id)throws Exception {
        if (perDAO.read(id)==null){
            throw new Exception ("404-persona no existe");
        }
        else{
            perDAO.delete(id);
        }
    }
    
    
    
    //-----------------------------------------------------------------//
    //Doctor
    //-----------------------------------------------------------------//
    
    public Doctor doctoresCREATE(Doctor doc)throws Exception {
        if (docDAO.read(doc.getCedula())!=null){
            throw new Exception ("406-persona ya existe");
        }
        else{
            docDAO.create(doc);
            return doc;
        }
    }
    
    public Doctor doctoresREAD(String cedula)throws Exception {
        Doctor doc = docDAO.read(cedula);
        if (doc!=null){
            return doc;
        }
        else{
            throw new Exception ("404-persona no existe");
        }
    }
    
    public boolean doctoresVALIDATE(String cedula, String contrasena)throws Exception {
        return docDAO.validate(cedula, contrasena);
    }
    
}
