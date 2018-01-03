package com.example.josezc.inp_cm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;

import com.example.josezc.inp_cm.Utilidades.Utilidades;

/**
 * Created by JOSEZC on 3/01/2018.
 */

public class Registro_Cita_Iterator implements Registro_Cita_Interfaces.Iterator{
    private Registro_Cita_Interfaces.Presenter presenter;

    public  Registro_Cita_Iterator(Registro_Cita_Interfaces.Presenter presenter){
        this.presenter = presenter;

    }
    @Override
    public void registrarCita(Context context, String nombre_paciente, String nombre_medico, String nombre_especialidad, String horario, String fecha, int id_paciente, int id_medico, int id_especialidad) {


            conexionSQLiteHelper conn = new conexionSQLiteHelper(context);

            SQLiteDatabase db = conn.getWritableDatabase();


            ContentValues values = new ContentValues();
            values.put(Utilidades.CITA_PACIENTE_NOMBRE, nombre_paciente);
            values.put(Utilidades.CITA_DOCTOR_NOMBRE, nombre_medico);
            values.put(Utilidades.CITA_ESPECIALIDAD_NOMBRE, nombre_especialidad);
            values.put(Utilidades.CITA_FECHA, fecha);
            values.put(Utilidades.CITA_HORARIO, horario);
            values.put(Utilidades.CITA_ID_USUARIO, id_paciente);
            values.put(Utilidades.CITA_ID_MEDICO, id_medico);
            values.put(Utilidades.CITA_ID_ESPECIALIDAD, id_especialidad);


            long newRowId = db.insert(Utilidades.TABLA_CITA, null, values);


            if(newRowId == -1){
                presenter.mostrarMensaje("El USUARIO(DNI) YA ESTA EN USO");
            }
            else{
                presenter.mostrarMensaje("REGISTRADO con clave:"+newRowId);


            }


    }
}
