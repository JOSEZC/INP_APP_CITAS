package com.example.josezc.inp_cm.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.josezc.inp_cm.Interfaces.Medico_Registro_Interfaces;
import com.example.josezc.inp_cm.Presenters.Medico_Registro_Presenter;
import com.example.josezc.inp_cm.R;

public class Medico_Registro_View extends AppCompatActivity  implements  Medico_Registro_Interfaces.View{

    EditText nombres,ap_paterno,ap_materno,dni,telefono,hora_inicio,hora_fin;
    Button btn_registro_medico;
    Spinner spinner_especialidades;
    private Medico_Registro_Interfaces.Presenter presenter;
    int Id_Especialidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_medicos);

        nombres = (EditText)findViewById(R.id.input_nombre_medico_reg);
        ap_paterno = (EditText)findViewById(R.id.input_ap_paterno_medico_reg);
        ap_materno = (EditText)findViewById(R.id.input_ap_materno_medico_reg);
        dni = (EditText)findViewById(R.id.input_dni_medico_reg);
        telefono = (EditText)findViewById(R.id.input_telefono_medico_reg);
        hora_inicio = (EditText)findViewById(R.id.input_inicio_medico_reg);
        hora_fin = (EditText)findViewById(R.id.input_fin_medico_reg);


        btn_registro_medico =(Button)findViewById(R.id.btn_reg_medico);

        spinner_especialidades = (Spinner) findViewById(R.id.spinner_lista_especialidades);


        presenter = new Medico_Registro_Presenter(this);


       //lista las especialidades en combo
        String[] values =presenter.listarEspecialidades(getApplicationContext());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,values);
        spinner_especialidades.setAdapter(adapter);


        btn_registro_medico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.registrarMedico(getApplicationContext(),
                        nombres.getText().toString(),ap_paterno.getText().toString(),
                        ap_materno.getText().toString(),dni.getText().toString(),
                        telefono.getText().toString(),hora_inicio.getText().toString(),
                        hora_fin.getText().toString(),Id_Especialidad
                );
            }
        });


        spinner_especialidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Id_Especialidad=presenter.getID_Especialidad(position);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });






    }


    @Override
    public void mostrar(String mensaje) {
        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getID_Especialidad(int i) {
        return i;
    }
}
