package com.example.josezc.inp_cm.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.josezc.inp_cm.Entidades.Usuario;
import com.example.josezc.inp_cm.Interfaces.Usuario_Login_Interface;
import com.example.josezc.inp_cm.Menu_App;
import com.example.josezc.inp_cm.Presenters.Usuario_Login_Presenter;
import com.example.josezc.inp_cm.R;

public class Usuario_Login_View extends AppCompatActivity implements Usuario_Login_Interface.View  {


    EditText dni;
    EditText password;
    TextView link_registro;
    Button btn_ingresar;

    private Usuario_Login_Interface.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dni = (EditText)findViewById(R.id.input_dni_login);
        password = (EditText)findViewById(R.id.input_password_login);

        link_registro = (TextView)findViewById(R.id.link_registro);
        btn_ingresar = (Button)findViewById(R.id.btn_ingresar_login);

        presenter = new Usuario_Login_Presenter(this);



        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null)
        {
            dni.setText(bundle.getString("DNI"));
            password.setText(bundle.getString("PASSWORD"));
        }


        btn_ingresar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                presenter.verificarUsuario(getApplicationContext(),
                        dni.getText().toString(),
                        password.getText().toString());
            }
        });



        link_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(Usuario_Login_View.this,Usuario_Registro_View.class);
               startActivity(intent);
            }
        });


    }



    @Override
    public void mostrarMensaje(String mensaje) {
        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void direccionar() {

        Usuario usuario = presenter.obtenerUsuario();


        Intent intent = new Intent(Usuario_Login_View.this,Menu_App.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("usuario",usuario);
        intent.putExtras(bundle);
        startActivity(intent);



    }

    @Override
    public void esAdmin() {
        Intent intent = new Intent(Usuario_Login_View.this,Registro_Especialidad_View.class);
        startActivity(intent);
    }

}
