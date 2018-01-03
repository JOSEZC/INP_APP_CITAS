package com.example.josezc.inp_cm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro_Especialidad_View extends AppCompatActivity implements Especialidad_Registro_Interfaces.View{

    private Especialidad_Registro_Interfaces.Presenter presenter;

    EditText nombre,costo;
    Button registro,link_reg_medico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_especialidad);
        nombre = (EditText)findViewById(R.id.input_nombre_especialidad_reg);
        costo = (EditText)findViewById(R.id.input_costo_especialidad_reg);

        registro = (Button)findViewById(R.id.btn_registro_especialidad);
        link_reg_medico = (Button)findViewById(R.id.btn_link_reg_medico);

        presenter = new Registro_Especialidad_Presenter(this);


        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.registrarEspecialidad(getApplicationContext(),
                        nombre.getText().toString(),
                        costo.getText().toString()
                        );
            }
        });

        link_reg_medico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registro_Especialidad_View.this,Medico_Registro_View.class);
                startActivity(intent);
            }
        });





    }

    @Override
    public void mostrarResultado(String resultado) {
        Toast.makeText(getApplicationContext(),resultado,Toast.LENGTH_SHORT).show();
    }
}
