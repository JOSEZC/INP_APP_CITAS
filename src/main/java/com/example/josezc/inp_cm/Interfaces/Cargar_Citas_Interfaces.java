package com.example.josezc.inp_cm.Interfaces;

import android.content.Context;

import com.example.josezc.inp_cm.Entidades.Cita;

/**
 * Created by JOSEZC on 3/01/2018.
 */

public interface Cargar_Citas_Interfaces {

    interface View{
        void mostrarDetalle(Cita cita);

    }
    public interface Presenter{
        void mostrarDetalle(Cita cita);
        String[] cargar_mis_citas(Context context,int id_user);

    }
    public interface Iterator{
        String[] cargar_mis_citas(Context context, int id_user);

    }
}
