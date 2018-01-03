package com.example.josezc.inp_cm;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;


public interface Medico_Registro_Interfaces {

    interface View{
        void mostrar(String mensaje);
        int getID_Especialidad(int i);
    }
    interface Presenter{
        void mostrar(String mensaje);
        int getID_Especialidad(int i);

        int buscarClave(int i);
        String[]listarEspecialidades(Context context);

        void registrarMedico(Context context,String nombre,String ap_paterno,String ap_materno,String dni,String telefono,String hora_inicio,String hora_fin,int id_especialidad);
    }
    interface Iterator{
        int buscarClave(int i);
        String[]  listarEspecialidades(Context context);

        void registrarMedico(Context context,String nombre,String ap_paterno,String ap_materno,String dni,String telefono,String hora_inicio,String hora_fin,int id_especialidad);
    }
}
