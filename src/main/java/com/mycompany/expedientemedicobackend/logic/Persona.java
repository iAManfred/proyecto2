package com.mycompany.expedientemedicobackend.logic;

import java.util.List;


public class Persona {
    
    private int id;
    private String cedula;
    private String nombre;
    private String sexo;
    private String correo;
    List<Enfermedad> enfermedades;

    public Persona(int id, String cedula, String nombre, String sexo, String correo, List<Enfermedad> enfermedades) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.sexo = sexo;
        this.correo = correo;
        this.enfermedades = enfermedades;
    }

    
    public Persona() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String Sexo) {
        this.sexo = Sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Enfermedad> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(List<Enfermedad> enfermedades) {
        this.enfermedades = enfermedades;
    }
    
}
