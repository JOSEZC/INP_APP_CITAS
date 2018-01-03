package com.example.josezc.inp_cm;

import android.content.Context;

import com.example.josezc.inp_cm.Entidades.Usuario;


public interface Usuario_Login_Interface {

    interface View{
        void mostrarMensaje(String mensaje);
        void direccionar();
        void esAdmin();

    }
    interface Presenter{

        void mostrarMensaje(String mensaje);
        Usuario obtenerUsuario();

        void direccionar();
        void esAdmin();
        void verificarUsuario(Context context,String dni, String password);


    }
    interface Iterator{

        Usuario obtenerUsuario();
        void verificarUsuario(Context context,String dni,String password);

    }
}
