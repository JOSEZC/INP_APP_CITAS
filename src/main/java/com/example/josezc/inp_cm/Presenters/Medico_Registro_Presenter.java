package com.example.josezc.inp_cm.Presenters;

import android.content.Context;

import com.example.josezc.inp_cm.Interfaces.Medico_Registro_Interfaces;
import com.example.josezc.inp_cm.Iterators.Medico_Registro_Iterator;

/**
 * Created by JOSEZC on 2/01/2018.
 */

public class Medico_Registro_Presenter implements Medico_Registro_Interfaces.Presenter {

    private Medico_Registro_Interfaces.View  view;
    private Medico_Registro_Interfaces.Iterator iterator;

    public Medico_Registro_Interfaces.View getView() {
        return view;
    }



    public Medico_Registro_Presenter(Medico_Registro_Interfaces.View view){
        this.view = view;
        iterator = new Medico_Registro_Iterator(this);
    }


    @Override
    public void mostrar(String mensaje) {
        if(view!=null){
            view.mostrar(mensaje);
        }
    }

    @Override
    public int getID_Especialidad(int i) {
        if(view!=null)
            return view.getID_Especialidad(i);

        return -1;
    }

    @Override
    public int buscarClave(int i) {
        if(view!=null)
            return iterator.buscarClave(i);

        return -1;
    }

    @Override
    public String[] listarEspecialidades(Context context) {

        return iterator.listarEspecialidades(context);
    }

    @Override
    public void registrarMedico(Context context,String nombre, String ap_paterno, String ap_materno, String dni, String telefono, String hora_inicio, String hora_fin,int id_especialidad) {
        if(view!=null)
            iterator.registrarMedico(context, nombre, ap_paterno, ap_materno, dni, telefono, hora_inicio, hora_fin,id_especialidad);
    }
}
