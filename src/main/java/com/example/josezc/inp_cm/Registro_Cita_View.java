package com.example.josezc.inp_cm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.josezc.inp_cm.Entidades.Cita;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Registro_Cita_View extends AppCompatActivity implements Registro_Cita_Interfaces.View{

    TextView prueba;
    DatePicker fecha;
    Button btn_reg_cita;
    String final_fecha;
    private Registro_Cita_Interfaces.Presenter presenter;
    Cita cita_preparada = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle__cita);


        fecha = (DatePicker)findViewById(R.id.data_prueba);
        btn_reg_cita = (Button) findViewById(R.id.btn_reg_cita);

        final Bundle cita_enviada = getIntent().getExtras();


        if(cita_enviada != null)
            cita_preparada = (Cita) cita_enviada.getSerializable("cita");

        int day = fecha.getDayOfMonth();
        int month = fecha.getMonth() + 1;
        int year = fecha.getYear()-1900;


        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM-dd-yyyy");
        Date d = new Date(year, month, day);
        String strDate = dateFormatter.format(d);

        final_fecha= strDate;

        presenter = new Registro_Cita_Presenter(this);

        btn_reg_cita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.registrarCita(getApplicationContext(),
                        cita_preparada.getPaciente_nombre(),
                        cita_preparada.getDoctor_nombre(),
                        cita_preparada.getEspecialidad_nombre(),
                        cita_preparada.getHorario(),
                        final_fecha,
                        cita_preparada.getId_paciente(),
                        cita_preparada.getId_medico(),
                        cita_preparada.getId_especialidad()


                        );
            }
        });



    }

    @Override
    public void mostrarMensaje(String msn) {
        Toast.makeText(getApplicationContext(),msn,Toast.LENGTH_SHORT).show();
    }
}
