package com.example.josezc.inp_cm.Interfaces;

import android.content.Context;

/**
 * Created by JOSEZC on 3/01/2018.
 */

public interface Registro_Cita_Interfaces {

    interface View{
        void mostrarMensaje(String msn);

    }
    interface Presenter{
        void mostrarMensaje(String msn);
        void registrarCita(Context context,String nombre_paciente,String nombre_medico,String nombre_especialidad,String horario,String fecha, int id_paciente,int id_medico,int id_especialidad);

    }
    interface Iterator{
        void registrarCita(Context context,String nombre_paciente,String nombre_medico,String nombre_especialidad,String horario,String fecha, int id_paciente,int id_medico,int id_especialidad);


    }
}
