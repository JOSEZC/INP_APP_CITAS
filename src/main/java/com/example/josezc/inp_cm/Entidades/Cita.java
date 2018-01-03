package com.example.josezc.inp_cm.Entidades;

import java.io.Serializable;

/**
 * Created by JOSEZC on 2/01/2018.
 */

public class Cita implements Serializable {
    private Integer id;
    private String fecha;
    private String paciente_nombre;
    private String doctor_nombre;
    private String especialidad_nombre;
    private String horario;

    private Integer Id_especialidad;
    private Integer Id_paciente;
    private Integer Id_medico;

    public Cita(){}

    public Cita(Integer id, String fecha, String paciente_nombre, String doctor_nombre, String especialidad_nombre, String horario, Integer id_especialidad, Integer id_paciente, Integer id_medico) {
        this.id = id;
        this.fecha = fecha;
        this.paciente_nombre = paciente_nombre;
        this.doctor_nombre = doctor_nombre;
        this.especialidad_nombre = especialidad_nombre;
        this.horario = horario;
        Id_especialidad = id_especialidad;
        Id_paciente = id_paciente;
        Id_medico = id_medico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPaciente_nombre() {
        return paciente_nombre;
    }

    public void setPaciente_nombre(String paciente_nombre) {
        this.paciente_nombre = paciente_nombre;
    }

    public String getDoctor_nombre() {
        return doctor_nombre;
    }

    public void setDoctor_nombre(String doctor_nombre) {
        this.doctor_nombre = doctor_nombre;
    }

    public String getEspecialidad_nombre() {
        return especialidad_nombre;
    }

    public void setEspecialidad_nombre(String especialidad_nombre) {
        this.especialidad_nombre = especialidad_nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Integer getId_especialidad() {
        return Id_especialidad;
    }

    public void setId_especialidad(Integer id_especialidad) {
        Id_especialidad = id_especialidad;
    }

    public Integer getId_paciente() {
        return Id_paciente;
    }

    public void setId_paciente(Integer id_paciente) {
        Id_paciente = id_paciente;
    }

    public Integer getId_medico() {
        return Id_medico;
    }

    public void setId_medico(Integer id_medico) {
        Id_medico = id_medico;
    }
}

