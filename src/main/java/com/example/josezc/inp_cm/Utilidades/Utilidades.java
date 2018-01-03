package com.example.josezc.inp_cm.Utilidades;

/**
 * Created by JOSEZC on 1/01/2018.
 */

public class Utilidades {
    //USUARIO
    public final static String TABLA_USUARIO = "usuario";

    public final static String USUARIO_ID = "id";
    public final static String USUARIO_NOMBRES = "nombres";
    public final static String USUARIO_AP_PATERNO = "ap_paterno";
    public final static String USUARIO_AP_MATERNO = "ap_materno";
    public final static String USUARIO_DNI = "dni";
    public final static String USUARIO_PASSWORD = "password";
    public final static String USUARIO_DIA_NAC = "dia_nac";
    public final static String USUARIO_MES_NAC = "mes_nac";
    public final static String USUARIO_ANIO_NAC = "anio_nac";
    public final static String USUARIO_EMAIL= "email";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+TABLA_USUARIO+" ("+USUARIO_ID+" INTEGER, "+USUARIO_NOMBRES+" TEXT, "+USUARIO_AP_PATERNO+" TEXT, "+USUARIO_AP_MATERNO+" TEXT, "+USUARIO_DNI+" TEXT, "+USUARIO_EMAIL+" TEXT, "+USUARIO_DIA_NAC+" TEXT, "+USUARIO_MES_NAC+" TEXT, "+USUARIO_ANIO_NAC+" TEXT, "+USUARIO_PASSWORD+" TEXT)";

    //ESPECIALIDAD
    public final static String TABLA_ESPECIALIDAD = "especialidad";

    public final static String ESPECIALIDAD_ID  = "id";
    public final static String ESPECIALIDAD_NOMBRE  = "nombre";
    public final static String ESPECIALIDAD_COSTO  = "costo";

    public static final String CREAR_TABLA_ESPECIALIDAD =  "CREATE TABLE "+TABLA_ESPECIALIDAD+" ("+ESPECIALIDAD_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ESPECIALIDAD_NOMBRE+" TEXT, "+ESPECIALIDAD_COSTO+" TEXT)";

    //MEDICO
    public final static String TABLA_MEDICO = "medico";

    public final static String MEDICO_ID  = "id";
    public final static String MEDICO_NOMBRES  = "nombres";
    public final static String MEDICO_AP_PATERNO  = "ap_paterno";
    public final static String MEDICO_AP_MATERNO  = "ap_materno";
    public final static String MEDICO_DNI  = "dni";
    public final static String MEDICO_TELEFONO  = "telefono";
    public final static String MEDICO_HORA_INICIO  = "hora_inicio";
    public final static String MEDICO_HORA_FIN  = "hora_fin";
    public final static String MEDICO_ID_ESPECIALIDAD  = "id_especialidad";

    public static final String CREAR_TABLA_MEDICO =  "CREATE TABLE "+TABLA_MEDICO+" ("+MEDICO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+MEDICO_NOMBRES+" TEXT, "+MEDICO_AP_PATERNO+" TEXT,"+MEDICO_AP_MATERNO+" TEXT,"+MEDICO_DNI+" TEXT,"+MEDICO_TELEFONO+" TEXT,"+MEDICO_HORA_INICIO+" TEXT,"+MEDICO_HORA_FIN+" TEXT,"+MEDICO_ID_ESPECIALIDAD+" INTEGER)";



    //CITA
    public final static String TABLA_CITA = "cita";

    public final static String CITA_ID  = "id";
    public final static String CITA_FECHA  = "fecha";
    public final static String CITA_PACIENTE_NOMBRE  = "paciente_nombre";
    public final static String CITA_DOCTOR_NOMBRE  = "doctor_nombre";
    public final static String CITA_ESPECIALIDAD_NOMBRE  = "especialidad_nombre";
    public final static String CITA_HORARIO  = "horario";

    public final static String CITA_ID_ESPECIALIDAD  = "id_especialidad";
    public final static String CITA_ID_MEDICO  = "id_medico";
    public final static String CITA_ID_USUARIO  = "id_usuario";


    public static final String CREAR_TABLA_CITA =  "CREATE TABLE "+TABLA_CITA+" ("+CITA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CITA_FECHA+" TEXT, "+CITA_PACIENTE_NOMBRE+" TEXT, "+CITA_DOCTOR_NOMBRE+" TEXT, "+CITA_ESPECIALIDAD_NOMBRE+" TEXT, "+CITA_HORARIO+" TEXT, "+CITA_ID_ESPECIALIDAD+" INTEGER,"+CITA_ID_MEDICO+" INTEGER,"+CITA_ID_USUARIO+" INTEGER)";



}
