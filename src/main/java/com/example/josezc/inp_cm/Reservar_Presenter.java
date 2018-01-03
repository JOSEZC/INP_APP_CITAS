package com.example.josezc.inp_cm;

import android.content.Context;

import com.example.josezc.inp_cm.Entidades.Cita;

/**
 * Created by JOSEZC on 2/01/2018.
 */

public class Reservar_Presenter implements Reservar_Interfaces.Presenter {

    private Reservar_Interfaces.View view;
    private Reservar_Interfaces.Iterator iterator;

    public Reservar_Presenter(Reservar_Interfaces.View view){
        this.view = view;
        iterator = new Reservar_Iterator(this);
    }
    @Override
    public void mostrar(String mensaje) {
        view.mostrar(mensaje);
    }

    @Override
    public int getID_Especialidad(int i) {

        if(view!=null)
            return view.getID_Especialidad(i);

        return -1;
    }

    @Override
    public int buscarClaveEspecialidad(int i) {

        if(view!=null)
            return iterator.buscarClaveEspecialidad(i);

        return -1;
    }

    @Override
    public String[] listarEspecialidades(Context context) {
        return iterator.listarEspecialidades(context);
    }

    @Override
    public String[] listarMedicos(Context context, int id_especialidad) {
        return iterator.listarMedicos(context,id_especialidad);
    }

    @Override
    public Cita prepararCita(int id_usuario, String nombre_user, int position_medico, int position_especialidad,Context context) {
        return iterator.prepararCita(id_usuario, nombre_user, position_medico, position_especialidad,context);
    }


}
