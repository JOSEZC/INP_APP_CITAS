package com.example.josezc.inp_cm.Interfaces;

import android.content.Context;

/**
 * Created by JOSEZC on 31/12/2017.
 */

public interface Usuario_Registro_Interface {
    interface View{
        void mostrarResultado(String resultado);
        void mostrarError(String error);
        void reDirigir();

    }
    interface Presenter{
        void mostrarResultado(String resultado);
        void mostrarError(String error);
        void reDirigir();

        void registrarUsuario(Context context, String nombres, String dni, String ap_paterno,
                              String ap_materno, String email, String dia_nac,
                              String mes_nac, String anio_nac, String password);
    }
    interface Iterator{
        void registrarUsuario(Context context, String nombres,String dni,String ap_paterno,
                              String ap_materno,String email,String dia_nac,
                              String mes_nac,String anio_nac,String password);
    }
}
