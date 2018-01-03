package com.example.josezc.inp_cm.Iterators;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;

import com.example.josezc.inp_cm.Interfaces.Usuario_Registro_Interface;
import com.example.josezc.inp_cm.Utilidades.Utilidades;
import com.example.josezc.inp_cm.conexionSQLiteHelper;


public class Usuario_Registro_Iterator implements Usuario_Registro_Interface.Iterator{

    private Usuario_Registro_Interface.Presenter presenter;


    public Usuario_Registro_Iterator(Usuario_Registro_Interface.Presenter presenter){

        this.presenter = presenter;
    }
    @Override
    public void registrarUsuario(final Context context, String nombres, String dni, String ap_paterno, String ap_materno, String email, String dia_nac, String mes_nac, String anio_nac, String password) {

        if(dni.equals("") || dni.length()!=8 || esDNI(dni)==false)
        {
            presenter.mostrarError("Ingrese un Nro: DNI válido");

        }else{

            conexionSQLiteHelper conn = new conexionSQLiteHelper(context);

            SQLiteDatabase db = conn.getWritableDatabase();


            ContentValues values = new ContentValues();
            values.put(Utilidades.USUARIO_ID, dni);
            values.put(Utilidades.USUARIO_NOMBRES, nombres);
            values.put(Utilidades.USUARIO_AP_PATERNO, ap_paterno);
            values.put(Utilidades.USUARIO_AP_MATERNO, ap_materno);
            values.put(Utilidades.USUARIO_DNI, dni);
            values.put(Utilidades.USUARIO_EMAIL, email);
            values.put(Utilidades.USUARIO_DIA_NAC, dia_nac);
            values.put(Utilidades.USUARIO_MES_NAC, mes_nac);
            values.put(Utilidades.USUARIO_ANIO_NAC, anio_nac);
            values.put(Utilidades.USUARIO_PASSWORD, password);

            long newRowId = db.insert(Utilidades.TABLA_USUARIO, null, values);

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
                presenter.mostrarError("El USUARIO(DNI) YA ESTA EN USO");
            }
            else{
                presenter.mostrarResultado("REGISTRADO con clave:"+newRowId);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        presenter.reDirigir();

                    }
                }, 2000);

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
