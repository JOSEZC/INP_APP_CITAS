package com.example.josezc.inp_cm.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.josezc.inp_cm.Interfaces.Usuario_Registro_Interface;
import com.example.josezc.inp_cm.Presenters.Usuario_Registro_Presenter;
import com.example.josezc.inp_cm.R;

public class Usuario_Registro_View extends AppCompatActivity implements Usuario_Registro_Interface.View{


    Button registrar;
    EditText nombre,ap_paterno,ap_materno,email,dni,dia_nac,mes_nac,anio_nac,password;
    private Usuario_Registro_Interface.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registrar = (Button)findViewById(R.id.btn_registrar);

        nombre = (EditText)findViewById(R.id.input_nombres);
        ap_paterno = (EditText)findViewById(R.id.input_apellido_paterno);
        ap_materno = (EditText)findViewById(R.id.input_apellido_materno);
        email = (EditText)findViewById(R.id.input_correo);
        dni = (EditText)findViewById(R.id.input_dni);
        dia_nac = (EditText)findViewById(R.id.input_dia);
        mes_nac = (EditText)findViewById(R.id.input_mes);
        anio_nac = (EditText)findViewById(R.id.input_anio);
        password = (EditText)findViewById(R.id.input_password);


        presenter = new Usuario_Registro_Presenter(this);

       // final Paciente_Helper helper = new Paciente_Helper(this);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.registrarUsuario(getApplicationContext(),
                        nombre.getText().toString(),
                        dni.getText().toString(),
                        ap_paterno.getText().toString(),
                        ap_materno.getText().toString(),
                        email.getText().toString(),
                        dia_nac.getText().toString(),
                        mes_nac.getText().toString(),
                        anio_nac.getText().toString(),
                        password.getText().toString());
            }
        });

    }

    @Override
    public void mostrarResultado(String resultado) {
        Toast.makeText(getApplicationContext(),resultado,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarError(String error) {
        Toast.makeText(getApplicationContext(),error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void reDirigir() {

        String dni_in = dni.getText().toString();
        String password_in = password.getText().toString();

        Intent intent = new Intent(Usuario_Registro_View.this,Usuario_Login_View.class);
        intent.putExtra("DNI",dni_in);
        intent.putExtra("PASSWORD",password_in);

        startActivity(intent);



    }

}
