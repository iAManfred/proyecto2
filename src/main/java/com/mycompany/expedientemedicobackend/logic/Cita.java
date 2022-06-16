package com.mycompany.expedientemedicobackend.logic;

import java.time.LocalDate;
import java.time.LocalTime;


public class Cita {
    
    private int id;
    private String doc;
    private Persona per;
    private String texto;
    private LocalDate dia;
    private LocalTime from;
    private LocalTime to;

    public Cita(int id, String doc, Persona per, String texto, LocalDate dia, LocalTime from, LocalTime to) {
        this.id = id;
        this.doc = doc;
        this.per = per;
        this.texto = texto;
        this.dia = dia;
        this.from = from;
        this.to = to;
    }


    public Cita() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public Persona getPer() {
        return per;
    }

    public void setPer(Persona per) {
        this.per = per;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getFrom() {
        return from;
    }

    public void setFrom(LocalTime from) {
        this.from = from;
    }

    public LocalTime getTo() {
        return to;
    }

    public void setTo(LocalTime to) {
        this.to = to;
    }
    
    
}
