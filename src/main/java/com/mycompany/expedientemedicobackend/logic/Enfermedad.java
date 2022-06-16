package com.mycompany.expedientemedicobackend.logic;


public class Enfermedad {
    
    private int id;
    private String nombre;

    public Enfermedad(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Enfermedad() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
