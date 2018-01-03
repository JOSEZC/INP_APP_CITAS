package com.example.josezc.inp_cm;

import android.content.Context;

/**
 * Created by JOSEZC on 2/01/2018.
 */

public class Registro_Especialidad_Presenter  implements  Especialidad_Registro_Interfaces.Presenter{

    private Especialidad_Registro_Interfaces.View view;
    private Especialidad_Registro_Interfaces.Iterator  iterator;


    public Registro_Especialidad_Presenter(Especialidad_Registro_Interfaces.View view){
        this.view = view;
        iterator =new Registro_Especialidad_Iterator(this);


    }

    @Override
    public void mostrarResultado(String resultado) {
        if(view!=null)
            view.mostrarResultado(resultado);
    }

    @Override
    public void registrarEspecialidad(Context context, String nombre, String costo) {
        if(view!=null)
            iterator.registrarEspecialidad(context,nombre,costo);
    }
}
