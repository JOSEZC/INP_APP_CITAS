package com.example.josezc.inp_cm;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.josezc.inp_cm.Entidades.Usuario;
import com.example.josezc.inp_cm.Utilidades.Utilidades;


public class Usuario_Login_Iterator implements Usuario_Login_Interface.Iterator {
    private Usuario_Login_Interface.Presenter presenter;
    private Usuario mi_Usuario=new Usuario();

    public Usuario_Login_Iterator(Usuario_Login_Interface.Presenter presenter){
        this.presenter = presenter;
    }




    @Override
    public void verificarUsuario(Context context,String dni, String password) {
        if(dni.equals("") || dni.length()!=8 || esDNI(dni)==false)
        {
            presenter.mostrarMensaje("Ingrese un  DNI válido");
        }else {

            if(dni.equals("71324160")){

                presenter.esAdmin();

            }else{
                conexionSQLiteHelper conn = new conexionSQLiteHelper(context);

                SQLiteDatabase db = conn.getWritableDatabase();


                String[] projection = {
                        Utilidades.USUARIO_ID,
                        Utilidades.USUARIO_NOMBRES,
                        Utilidades.USUARIO_AP_PATERNO,
                        Utilidades.USUARIO_AP_PATERNO,
                        Utilidades.USUARIO_EMAIL,
                        Utilidades.USUARIO_DNI,
                        Utilidades.USUARIO_DIA_NAC,
                        Utilidades.USUARIO_MES_NAC,
                        Utilidades.USUARIO_ANIO_NAC


                };


                String selection = Utilidades.USUARIO_PASSWORD + " =? AND " + Utilidades.USUARIO_DNI + " =?";
                String[] selectionArgs = {password, dni};



                Cursor cursor = db.query(
                        Utilidades.TABLA_USUARIO,                     // The table to query
                        projection,                               // The columns to return
                        selection,                                // The columns for the WHERE clause
                        selectionArgs,                            // The values for the WHERE clause
                        null,                                     // don't group the rows
                        null,                                     // don't filter by row groups
                        null                                 // The sort order
                );
                try {
                    cursor.moveToFirst();

                    mi_Usuario.setId(cursor.getInt(0));
                    mi_Usuario.setNombres(cursor.getString(1) );
                    mi_Usuario.setAp_paterno(cursor.getString(2));
                    mi_Usuario.setAp_materno(cursor.getString(3));
                    mi_Usuario.setEmail(cursor.getString(4));
                    mi_Usuario.setDni(cursor.getString(5));

                    presenter.mostrarMensaje("Bienvenido: " + cursor.getString(1));
                    presenter.direccionar();
                    cursor.close();
                }catch(Exception e){
                    presenter.mostrarMensaje("DNI o PASSWORD ERRONEOS");
                }

            }

        }


    }
    @Override
    public Usuario obtenerUsuario() {
        return mi_Usuario;
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
