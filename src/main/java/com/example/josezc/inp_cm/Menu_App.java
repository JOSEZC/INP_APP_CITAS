package com.example.josezc.inp_cm;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.josezc.inp_cm.Entidades.Usuario;

public class Menu_App extends AppCompatActivity



        implements NavigationView.OnNavigationItemSelectedListener {
    Spinner spinn;


    TextView nombre_usuario,email_usuario;

    Usuario user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__app);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();





        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_desplegable);
        navigationView.setNavigationItemSelectedListener(this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contenedor,new Inicio_View()).commit();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu__app, menu);


        final Bundle usuario_enviado = getIntent().getExtras();


        if(usuario_enviado != null)
            user = (Usuario) usuario_enviado.getSerializable("usuario");


        nombre_usuario = (TextView)findViewById(R.id.nombre_usuario);
        email_usuario = (TextView)findViewById(R.id.correo_usuario);

        nombre_usuario.setText(user.getNombres());
        email_usuario.setText(user.getEmail());







        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.nav_inicio) {


            fragmentManager.beginTransaction().replace(R.id.contenedor,new Inicio_View()).commit();

        } else if (id == R.id.nav_reservar) {

            Bundle args = new Bundle();

            args.putString("id_user", Integer.toString(user.getId()));
            args.putString("nombre_user",user.getNombres()+" "+user.getAp_paterno()+" "+user.getAp_materno());


            Reservar_View fragment = new Reservar_View();
            fragment.setArguments(args);

            fragmentManager.beginTransaction().replace(R.id.contenedor,fragment).commit();

        } else if (id == R.id.nav_mis_citas) {

            Bundle args1 = new Bundle();

            args1.putString("id_user_reg", Integer.toString(user.getId()));


            Cargar_Citas_View fragment1 = new Cargar_Citas_View();
            fragment1.setArguments(args1);


            fragmentManager.beginTransaction().replace(R.id.contenedor,fragment1).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
