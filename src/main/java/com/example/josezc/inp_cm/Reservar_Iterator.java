package com.example.josezc.inp_cm;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.josezc.inp_cm.Entidades.Cita;
import com.example.josezc.inp_cm.Entidades.Especialidad;
import com.example.josezc.inp_cm.Entidades.Medico;
import com.example.josezc.inp_cm.Utilidades.Utilidades;

import java.util.ArrayList;

/**
 * Created by JOSEZC on 2/01/2018.
 */

public class Reservar_Iterator implements Reservar_Interfaces.Iterator {
    private Reservar_Interfaces.Presenter presenter;

    conexionSQLiteHelper helper;
    ArrayList<String> listaEspecialidades;
    ArrayList<String> listaMedicos;

    String[]error = {""};

    ArrayList<Especialidad> especialidadesLista;
    ArrayList<Medico> medicosLista;

    public Reservar_Iterator(Reservar_Interfaces.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public int buscarClaveEspecialidad(int i) {
        return presenter.getID_Especialidad(especialidadesLista.get(i-1).getId());
    }

    @Override
    public String[] listarEspecialidades(Context context) {
        // String [] values = listaEspecialidades.toArray(new String[listaEspecialidades.size()]);

        helper = new conexionSQLiteHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Especialidad especialidad = null;
        especialidadesLista  = new ArrayList<Especialidad>();

        Cursor cursor = db.rawQuery("SELECT *FROM "+ Utilidades.TABLA_ESPECIALIDAD,null);
        while (cursor.moveToNext()){
            especialidad = new Especialidad();
            especialidad.setId(cursor.getInt(0));
            especialidad.setNombre(cursor.getString(1));
            especialidad.setCosto(cursor.getString(2));

            especialidadesLista.add(especialidad);
        }
        obtenerLista();



        //String [] values =
        //     {"Time at Residence","Under 6 months","6-12 months","1-2 years","2-4 years","4-8 years","8-15 years","Over 15 years",};



        // adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        String [] values = listaEspecialidades.toArray(new String[listaEspecialidades.size()]);
        return values ;

    }

    @Override
    public String[] listarMedicos(Context context, int id_especialidad) {


        if(id_especialidad == 0)
        {
            presenter.mostrar("Seleccione Especialidad");
        }else {

            String id_esp= Integer.toString(id_especialidad);
            helper = new conexionSQLiteHelper(context);
            SQLiteDatabase db = helper.getReadableDatabase();


                String[] projection = {
                        Utilidades.MEDICO_ID,
                        Utilidades.MEDICO_NOMBRES,
                        Utilidades.MEDICO_AP_PATERNO,
                        Utilidades.MEDICO_AP_MATERNO,
                        Utilidades.MEDICO_DNI,
                        Utilidades.MEDICO_HORA_INICIO,
                        Utilidades.MEDICO_HORA_FIN
                };

                Medico medico = null;
                medicosLista = new ArrayList<Medico>();
                String selection = Utilidades.MEDICO_ID_ESPECIALIDAD + " =? " ;
                String[] selectionArgs = {id_esp};



                Cursor cursor = db.query(
                        Utilidades.TABLA_MEDICO,                     // The table to query
                        projection,                               // The columns to return
                        selection,                                // The columns for the WHERE clause
                        selectionArgs,                            // The values for the WHERE clause
                        null,                                     // don't group the rows
                        null,                                     // don't filter by row groups
                        null                                 // The sort order
                );

                while(cursor.moveToNext()){
                    medico = new Medico();
                    medico.setIdMedico(cursor.getInt(0));
                    medico.setNombres(cursor.getString(1));
                    medico.setAp_paterno(cursor.getString(2));
                    medico.setAp_materno(cursor.getString(3));
                    medico.setDni(cursor.getString(4));
                    medico.setHoraInicio(cursor.getString(5));
                    medico.setHoraFin(cursor.getString(6));

                    medicosLista.add(medico);

                }
                int resultados = medicosLista.size();
                if(resultados ==0){
                    presenter.mostrar("No hay Médicos Disponibles");

                    return  error;
                }else{
                    obtenerListamedicos();

                    String [] values = listaMedicos.toArray(new String[listaMedicos.size()]);

                    presenter.mostrar(resultados+" Médico(s) Disponibles");
                    return values;
                }





        }


        String [] values2 = {""};

        return values2;

    }

    @Override
    public Cita prepararCita(int id_usuario, String nombre_user, int position_medico, int position_cita,Context context) {
        Cita mi_cita = new Cita();

        Medico aux_med = medicosLista.get(position_medico);

        Especialidad  aux_esp = especialidadesLista.get(position_cita-1);

        mi_cita.setPaciente_nombre(nombre_user);
        mi_cita.setDoctor_nombre(aux_med.getNombres()+" "+aux_med.getAp_paterno());
        mi_cita.setHorario("DE: "+aux_med.getHoraInicio()+" A "+aux_med.getHoraFin());
        mi_cita.setEspecialidad_nombre(aux_esp.getNombre());

        mi_cita.setId_especialidad(aux_esp.getId());
        mi_cita.setId_medico(aux_med.getIdMedico());
        mi_cita.setId_paciente(id_usuario);


        return mi_cita;

    }

    private void obtenerListamedicos() {
        listaMedicos= new ArrayList<String>();
        //listaMedicos.add("Seleccione");

        for (int i = 0;i<medicosLista.size();i++){
            listaMedicos.add(medicosLista.get(i).getNombres()+" "+medicosLista.get(i).getAp_paterno()+" Horario De:"+medicosLista.get(i).getHoraInicio()+"  A "+medicosLista.get(i).getHoraFin());
        }
    }



    private void obtenerLista() {
        listaEspecialidades = new ArrayList<String>();
        listaEspecialidades.add("Seleccione");

        for (int i = 0;i<especialidadesLista.size();i++){
            listaEspecialidades.add(especialidadesLista.get(i).getNombre());
        }

    }
}
