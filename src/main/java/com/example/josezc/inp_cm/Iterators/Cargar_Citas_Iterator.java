package com.example.josezc.inp_cm.Iterators;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.josezc.inp_cm.Interfaces.Cargar_Citas_Interfaces;
import com.example.josezc.inp_cm.Entidades.Cita;
import com.example.josezc.inp_cm.Utilidades.Utilidades;
import com.example.josezc.inp_cm.conexionSQLiteHelper;

import java.util.ArrayList;

public class Cargar_Citas_Iterator implements Cargar_Citas_Interfaces.Iterator {

    private Cargar_Citas_Interfaces.Presenter presenter;

    conexionSQLiteHelper helper;
    ArrayList<String> listaCitas;


    String[]error = {""};

    ArrayList<Cita> citasLista;


    public Cargar_Citas_Iterator(Cargar_Citas_Interfaces.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public String[] cargar_mis_citas(Context context,int id_user) {

        if(id_user == 0)
        {
            return error;
        }else {

            String id_usr= Integer.toString(id_user);

            helper = new conexionSQLiteHelper(context);
            SQLiteDatabase db = helper.getReadableDatabase();


            String[] projection = {
                    Utilidades.CITA_ESPECIALIDAD_NOMBRE,
                    Utilidades.CITA_DOCTOR_NOMBRE,
                    Utilidades.CITA_PACIENTE_NOMBRE,
                    Utilidades.CITA_HORARIO,
                    Utilidades.CITA_FECHA
            };

            Cita cita = null;
            citasLista = new ArrayList<Cita>();

            String selection = Utilidades.CITA_ID_USUARIO + " =? " ;
            String[] selectionArgs = {id_usr};



            Cursor cursor = db.query(
                    Utilidades.TABLA_CITA,                     // The table to query
                    projection,                               // The columns to return
                    selection,                                // The columns for the WHERE clause
                    selectionArgs,                            // The values for the WHERE clause
                    null,                                     // don't group the rows
                    null,                                     // don't filter by row groups
                    null                                 // The sort order
            );

            while(cursor.moveToNext()){
                cita = new Cita();
                cita.setEspecialidad_nombre(cursor.getString(0));
                cita.setDoctor_nombre(cursor.getString(1));
                cita.setPaciente_nombre(cursor.getString(2));
                cita.setHorario(cursor.getString(3));
                cita.setFecha(cursor.getString(4));

                citasLista.add(cita);

            }
            int resultados = citasLista.size();
            if(resultados ==0){


                return  error;
            }else{
                obtenerListaCitas();

                String [] values = listaCitas.toArray(new String[listaCitas.size()]);


                return values;
            }





        }




    }
    private void obtenerListaCitas() {
        listaCitas= new ArrayList<String>();


        for (int i = 0;i<citasLista.size();i++){
            listaCitas.add(citasLista.get(i).getEspecialidad_nombre()+"  FECHA: "+citasLista.get(i).getFecha()+" HORARIO:"+citasLista.get(i).getHorario());
        }
    }
}
