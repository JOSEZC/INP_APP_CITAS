package com.example.josezc.inp_cm.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.josezc.inp_cm.Entidades.Cita;
import com.example.josezc.inp_cm.Interfaces.Reservar_Interfaces;
import com.example.josezc.inp_cm.Presenters.Reservar_Presenter;
import com.example.josezc.inp_cm.R;


public class Reservar_View extends Fragment implements Reservar_Interfaces.View {

    View vista;
    Spinner spinner;
    ListView lista_medicos_esp;
    private Reservar_Interfaces.Presenter presenter;

    int position_click_especialidad =0;
    int position_click_medico =0;
    String id_user,nombre_user;

    int id_e =0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=  inflater.inflate(R.layout.fragment_reservar, container, false);

        id_user = getArguments().getString("id_user");
        nombre_user = getArguments().getString("nombre_user");


        spinner = (Spinner) vista.findViewById(R.id.spinner_especialialidades_reservar);
        lista_medicos_esp = (ListView)vista.findViewById(R.id.listView_medicos_esp);


        presenter = new Reservar_Presenter(this);

        String[] values =presenter.listarEspecialidades(this.getActivity());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,values);
        spinner.setAdapter(adapter);







        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //prepara_CIta
                position_click_especialidad=position;

                id_e=presenter.getID_Especialidad(position);

                String [] medicos_esp = presenter.listarMedicos(getActivity(),id_e);

                ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),
                        android.R.layout.simple_list_item_1, medicos_esp);
                lista_medicos_esp.setAdapter(arrayAdapter);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        lista_medicos_esp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {



                Cita aux = presenter.prepararCita(Integer.parseInt(id_user),nombre_user,position,position_click_especialidad,getActivity());

                Intent intent = new Intent(getActivity(),Registro_Cita_View.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("cita",aux);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });




        return vista;
    }

    @Override
    public void mostrar(String mensaje) {
        Toast.makeText(this.getActivity(),mensaje,Toast.LENGTH_SHORT).show();

    }

    @Override
    public int getID_Especialidad(int i) {
        return i;
    }
}
