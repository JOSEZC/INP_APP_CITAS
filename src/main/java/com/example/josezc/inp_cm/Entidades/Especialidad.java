package com.example.josezc.inp_cm.Entidades;

import java.io.Serializable;

/**
 * Created by JOSEZC on 2/01/2018.
 */

public class Especialidad implements Serializable{
    private Integer id;
    private String nombre;
    private String costo;

    public Especialidad(){

    }

    public Especialidad(Integer id, String nombre, String costo) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }
}
