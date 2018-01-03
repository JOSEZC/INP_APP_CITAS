package com.example.josezc.inp_cm.Entidades;

import java.io.Serializable;

/**
 * Created by JOSEZC on 1/01/2018.
 */

public class Usuario implements Serializable{

    private int id ;
    private String nombres;
    private String ap_materno;
    private String ap_paterno;
    private String dni;
    private String email;
    private String password;
    private String dia_nac;
    private String mes_nac;
    private String anio_nac;

    public  Usuario(){}

    public Usuario(int id, String nombres, String ap_materno, String ap_paterno,
                   String dni, String email, String password,
                   String dia_nac, String mes_nac, String anio_nac) {
        this.id = id;
        this.nombres = nombres;
        this.ap_materno = ap_materno;
        this.ap_paterno = ap_paterno;
        this.dni = dni;
        this.email = email;
        this.password = password;
        this.dia_nac = dia_nac;
        this.mes_nac = mes_nac;
        this.anio_nac = anio_nac;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDia_nac() {
        return dia_nac;
    }

    public void setDia_nac(String dia_nac) {
        this.dia_nac = dia_nac;
    }

    public String getMes_nac() {
        return mes_nac;
    }

    public void setMes_nac(String mes_nac) {
        this.mes_nac = mes_nac;
    }

    public String getAnio_nac() {
        return anio_nac;
    }

    public void setAnio_nac(String anio_nac) {
        this.anio_nac = anio_nac;
    }
}
