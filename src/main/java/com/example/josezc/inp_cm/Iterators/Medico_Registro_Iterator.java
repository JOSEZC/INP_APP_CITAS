package com.example.josezc.inp_cm.Iterators;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.josezc.inp_cm.Entidades.Especialidad;
import com.example.josezc.inp_cm.Interfaces.Medico_Registro_Interfaces;
import com.example.josezc.inp_cm.Utilidades.Utilidades;
import com.example.josezc.inp_cm.conexionSQLiteHelper;

import java.util.ArrayList;


public class Medico_Registro_Iterator  implements  Medico_Registro_Interfaces.Iterator{

    private Medico_Registro_Interfaces.Presenter presenter;
    conexionSQLiteHelper helper;
    ArrayList<String> listaEspecialidades;
    ArrayList<Especialidad> especialidadesLista;


    public Medico_Registro_Iterator( Medico_Registro_Interfaces.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public int buscarClave(int i) {
        return presenter.getID_Especialidad(especialidadesLista.get(i-1).getId());
    }

    @Override
    public String[]  listarEspecialidades(Context context) {



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



    private void obtenerLista() {
        listaEspecialidades = new ArrayList<String>();
        listaEspecialidades.add("Seleccione");

        for (int i = 0;i<especialidadesLista.size();i++){
            listaEspecialidades.add(especialidadesLista.get(i).getNombre());
        }

    }
    @Override
    public void registrarMedico(Context context, String nombre, String ap_paterno, String ap_materno, String dni, String telefono, String hora_inicio, String hora_fin, int id_especialidad) {
        if(dni.equals("") || dni.length()!=8 || esDNI(dni)==false)
        {
            presenter.mostrar("Ingrese un Nro: DNI válido");

        }else{

            if(id_especialidad ==0){
                presenter.mostrar("Seleccione Especialidad");

            }
            else{
                conexionSQLiteHelper conn = new conexionSQLiteHelper(context);

                SQLiteDatabase db = conn.getWritableDatabase();


                ContentValues values = new ContentValues();

                values.put(Utilidades.MEDICO_NOMBRES, nombre);
                values.put(Utilidades.MEDICO_AP_PATERNO, ap_paterno);
                values.put(Utilidades.MEDICO_AP_MATERNO, ap_materno);
                values.put(Utilidades.MEDICO_DNI, dni);
                values.put(Utilidades.MEDICO_TELEFONO, telefono);
                values.put(Utilidades.MEDICO_HORA_INICIO, hora_inicio);
                values.put(Utilidades.MEDICO_HORA_FIN, hora_fin);
                values.put(Utilidades.MEDICO_ID_ESPECIALIDAD, id_especialidad);



                long newRowId = db.insert(Utilidades.TABLA_MEDICO, null, values);

            /*final Paciente_Helper helper = new Paciente_Helper(context);

            SQLiteDatabase db = helper.getWritableDatabase();


            ContentValues values = new ContentValues();
            values.put(Paciente.ID, dni);
            values.put(Paciente.NOMBRES, nombres);
            values.put(Paciente.AP_PATERNO, ap_paterno);
            values.put(Paciente.AP_MATERNO, ap_materno);
            values.put(Paciente.DNI, dni);
            values.put(Paciente.EMAIL, email);
            values.put(Paciente.DIA_NAC, dia_nac);
            values.put(Paciente.MES_NAC, mes_nac);
            values.put(Paciente.ANIO_NAC, anio_nac);
            values.put(Paciente.PASSWORD, password);


            long newRowId = db.insert(Paciente.TABLE_NAME, null, values);*/
                if(newRowId == -1){
                    presenter.mostrar("El USUARIO(DNI) YA ESTA EN USO");
                }
                else{
                    presenter.mostrar("REGISTRADO con clave:"+newRowId);


                }

            }
        }




    }
    boolean esDNI(String dni){
        try{
            int dniReal = Integer.parseInt(dni);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

}
