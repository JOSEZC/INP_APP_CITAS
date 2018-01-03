package com.example.josezc.inp_cm;

import android.content.Context;

/**
 * Created by JOSEZC on 31/12/2017.
 */

public class Usuario_Registro_Presenter implements Usuario_Registro_Interface.Presenter{

    private Usuario_Registro_Interface.View view;
    private Usuario_Registro_Interface.Iterator iterator;

    public Usuario_Registro_Presenter(Usuario_Registro_Interface.View view){
        this.view = view;
        iterator =new Usuario_Registro_Iterator(this);

    }

    @Override
    public void mostrarResultado(String resultado) {
        if(view!=null)
            view.mostrarResultado(resultado);
    }

    @Override
    public void mostrarError(String error) {
        if(view!=null)
            view.mostrarResultado(error);
    }

    @Override
    public void reDirigir() {
        if(view!=null)
            view.reDirigir();
    }

    @Override
    public void registrarUsuario(Context context,String nombres, String dni, String ap_paterno, String ap_materno, String email, String dia_nac, String mes_nac, String anio_nac, String password) {
        if(view!=null)
            iterator.registrarUsuario(context,nombres,dni,ap_paterno,ap_materno,email,dia_nac,mes_nac,anio_nac,password);
    }
}
