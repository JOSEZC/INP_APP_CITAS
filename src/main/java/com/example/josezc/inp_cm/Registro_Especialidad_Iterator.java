package com.example.josezc.inp_cm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;

import com.example.josezc.inp_cm.Utilidades.Utilidades;

/**
 * Created by JOSEZC on 2/01/2018.
 */

public class Registro_Especialidad_Iterator implements Especialidad_Registro_Interfaces.Iterator{

    private Especialidad_Registro_Interfaces.Presenter presenter;


    public Registro_Especialidad_Iterator(Especialidad_Registro_Interfaces.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void registrarEspecialidad(Context context, String nombre, String costo) {
        if(nombre.equals("")|| costo.equals("")){
            presenter.mostrarResultado("Complete todos los Campos");
        }else{
            conexionSQLiteHelper conn = new conexionSQLiteHelper(context);

            SQLiteDatabase db = conn.getWritableDatabase();


            ContentValues values = new ContentValues();
            values.put(Utilidades.ESPECIALIDAD_NOMBRE, nombre.toUpperCase());
            values.put(Utilidades.ESPECIALIDAD_COSTO, costo);


            long newRowId = db.insert(Utilidades.TABLA_ESPECIALIDAD, Utilidades.ESPECIALIDAD_ID, values);


            if(newRowId == -1){
                presenter.mostrarResultado("YA EXISTE");
            }
            else{
                presenter.mostrarResultado("REGISTRADO con clave:"+newRowId);


            }

        }
    }
}
