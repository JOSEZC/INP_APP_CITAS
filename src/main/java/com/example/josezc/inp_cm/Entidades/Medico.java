package com.example.josezc.inp_cm.Entidades;

import com.example.josezc.inp_cm.Menu_App;

import java.io.Serializable;

/**
 * Created by JOSEZC on 2/01/2018.
 */

public class Medico implements Serializable {

    private Integer IdMedico;
    private Integer IdEspecialidad;
    private String nombres;
    private String ap_paterno;
    private String ap_materno;
    private String dni;
    private String telefono;
    private String horaInicio;
    private String horaFin;


    public Medico(){}

    public Medico(Integer idMedico, Integer idEspecialidad, String nombres, String ap_paterno, String ap_materno, String dni, String telefono, String horaInicio, String horaFin) {
        IdMedico = idMedico;
        IdEspecialidad = idEspecialidad;
        this.nombres = nombres;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.dni = dni;
        this.telefono = telefono;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Integer getIdMedico() {
        return IdMedico;
    }

    public void setIdMedico(Integer idMedico) {
        IdMedico = idMedico;
    }

    public Integer getIdEspecialidad() {
        return IdEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        IdEspecialidad = idEspecialidad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String ap_dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
}
