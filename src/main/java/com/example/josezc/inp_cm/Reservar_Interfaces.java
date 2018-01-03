package com.example.josezc.inp_cm;

import android.content.Context;

import com.example.josezc.inp_cm.Entidades.Cita;


public interface Reservar_Interfaces {
    interface View{
        void mostrar(String mensaje);
        int getID_Especialidad(int i);
    }
    interface Presenter{
        void mostrar(String mensaje);
        int getID_Especialidad(int i);

        int buscarClaveEspecialidad(int i);
        String[]listarEspecialidades(Context context);

        String[]listarMedicos(Context context,int id_especialidad);

        Cita prepararCita(int id_usuario,String nombre_user, int position_medico,int position_especialidad,Context context);


    }
    interface Iterator{

        int buscarClaveEspecialidad(int i);
        String[]  listarEspecialidades(Context context);
        String[]listarMedicos(Context context,int id_especialidad);
        Cita prepararCita(int id_usuario,String nombre_user, int position_medico,int position_especialidad,Context context);

    }
}
