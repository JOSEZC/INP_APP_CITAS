package com.example.josezc.inp_cm.Presenters;

import android.content.Context;

import com.example.josezc.inp_cm.Interfaces.Registro_Cita_Interfaces;
import com.example.josezc.inp_cm.Iterators.Registro_Cita_Iterator;

/**
 * Created by JOSEZC on 3/01/2018.
 */

public class Registro_Cita_Presenter implements  Registro_Cita_Interfaces.Presenter{

    private  Registro_Cita_Interfaces.View view;
    private  Registro_Cita_Interfaces.Iterator iterator;

    public Registro_Cita_Presenter(Registro_Cita_Interfaces.View view){
        this.view = view;
        iterator = new Registro_Cita_Iterator(this);

    }

    @Override
    public void mostrarMensaje(String msn) {
        if(view!=null)
            view.mostrarMensaje(msn);
    }

    @Override
    public void registrarCita(Context context, String nombre_paciente, String nombre_medico, String nombre_especialidad, String horario, String fecha, int id_paciente, int id_medico, int id_especialidad) {
        if(view!=null)
            iterator.registrarCita(context, nombre_paciente, nombre_medico, nombre_especialidad, horario, fecha, id_paciente, id_medico, id_especialidad);
    }
}
