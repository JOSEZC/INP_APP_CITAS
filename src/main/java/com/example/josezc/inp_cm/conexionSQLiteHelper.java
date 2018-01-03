package com.example.josezc.inp_cm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.josezc.inp_cm.Utilidades.Utilidades;



public class conexionSQLiteHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "citas.db";






    public conexionSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
        db.execSQL(Utilidades.CREAR_TABLA_ESPECIALIDAD);
        db.execSQL(Utilidades.CREAR_TABLA_MEDICO);
        db.execSQL(Utilidades.CREAR_TABLA_CITA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ESPECIALIDAD);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_MEDICO);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CITA);
        onCreate(db);
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
