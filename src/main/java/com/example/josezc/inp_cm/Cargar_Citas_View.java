package com.example.josezc.inp_cm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.josezc.inp_cm.Entidades.Cita;
import com.example.josezc.inp_cm.Entidades.Usuario;


public class Cargar_Citas_View extends Fragment  implements Cargar_Citas_Interfaces.View{


    View v;
    ListView lista_mis_citas;
    Cargar_Citas_Interfaces.Presenter presenter;

    String id_user_reg;
    Usuario user_this;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_mi_informacion, container, false);
        lista_mis_citas =(ListView)v.findViewById(R.id.list_mis_citas_l);



       id_user_reg  = getArguments().getString("id_user_reg");




        presenter = new Cargar_Citas_Presenter(this);

        String[] values =presenter.cargar_mis_citas(this.getActivity(),Integer.parseInt(id_user_reg));

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),
                android.R.layout.simple_list_item_1, values);
        lista_mis_citas.setAdapter(arrayAdapter);



        lista_mis_citas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });





        return v;


    }

    @Override
    public void mostrarDetalle(Cita cita) {

        String s= "Especialidad: "+cita.getEspecialidad_nombre()+"";

        Toast.makeText(this.getActivity(),s,Toast.LENGTH_SHORT).show();
    }
}
