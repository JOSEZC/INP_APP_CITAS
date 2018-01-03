package com.example.josezc.inp_cm;

import android.content.Context;

import com.example.josezc.inp_cm.Entidades.Usuario;



public class Usuario_Login_Presenter implements Usuario_Login_Interface.Presenter {
    private Usuario_Login_Interface.View view;
    private Usuario_Login_Interface.Iterator iterator;

    public Usuario_Login_Presenter(Usuario_Login_Interface.View view){
        this.view = view;
        iterator =new Usuario_Login_Iterator(this);
    }


    @Override
    public void mostrarMensaje(String mensaje) {
        if(view!=null)
            view.mostrarMensaje(mensaje);
    }


    @Override
    public void direccionar() {

        view.direccionar();
    }

    @Override
    public void esAdmin() {
        view.esAdmin();
    }

    @Override
    public Usuario obtenerUsuario() {
        if(view!=null){
             return iterator.obtenerUsuario();
        }
        return null;
    }


    @Override
    public void verificarUsuario(Context context,String dni, String password) {
        if(view!=null)
            iterator.verificarUsuario(context,dni,password);
    }
}
