package com.mycompany.expedientemedicobackend.logic;


public class Examen {
    private int id;
    private int idPersona;
    private String nombre;
    private String direccion;

    public Examen(int id, int idPersona, String nombre, String direccion) {
        this.id = id;
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Examen() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
