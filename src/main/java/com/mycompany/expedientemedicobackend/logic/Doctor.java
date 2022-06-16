package com.mycompany.expedientemedicobackend.logic;

import java.util.List;


public class Doctor {
    
    private String cedula;
    private String nombre;
    private String especialidad;
    private String correo;
    private String locacion;
    private String contrasena;
    private int precio;
    private int tiempo;
    private List<Slot> horario;

    public Doctor(String cedula, String nombre, String especialidad, String correo, String locacion, String contrasena, int precio, int tiempo, List<Slot> horario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.correo = correo;
        this.locacion = locacion;
        this.contrasena = contrasena;
        this.precio = precio;
        this.tiempo = tiempo;
        this.horario = horario;
    }

    public Doctor() {
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getLocacion() {
        return locacion;
    }

    public void setLocacion(String locacion) {
        this.locacion = locacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public List<Slot> getHorario() {
        return horario;
    }

    public void setHorario(List<Slot> horario) {
        this.horario = horario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
}
