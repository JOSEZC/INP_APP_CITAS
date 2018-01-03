package com.example.josezc.inp_cm;

import android.content.Context;

import com.example.josezc.inp_cm.Entidades.Cita;

public class Cargar_Citas_Presenter  implements  Cargar_Citas_Interfaces.Presenter {

    private Cargar_Citas_Interfaces.View view;
    private Cargar_Citas_Interfaces.Iterator iterator;

    public Cargar_Citas_Presenter(Cargar_Citas_Interfaces.View view){
        this.view = view;
        iterator = new Cargar_Citas_Iterator(this);

    }

    @Override
    public void mostrarDetalle(Cita cita) {
        if(view!=null)
            view.mostrarDetalle(cita);
    }



    @Override
    public String[] cargar_mis_citas(Context context,int id_user) {
        if(view!=null)
            return iterator.cargar_mis_citas(context,id_user);
        return null;
    }
}
