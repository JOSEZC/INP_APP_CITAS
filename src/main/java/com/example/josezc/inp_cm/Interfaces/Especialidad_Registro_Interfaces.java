package com.example.josezc.inp_cm.Interfaces;

import android.content.Context;



public interface Especialidad_Registro_Interfaces {

    interface View{
        void mostrarResultado(String resultado);
        //void mostrarError(String error);
        //void reDirigir();

    }
    interface Presenter{
        void mostrarResultado(String resultado);
       // void mostrarError(String error);
       // void reDirigir();

        void registrarEspecialidad(Context context, String nombre, String costo);
    }
    interface Iterator{

        void registrarEspecialidad(Context context, String nombre, String costo);
    }
}
