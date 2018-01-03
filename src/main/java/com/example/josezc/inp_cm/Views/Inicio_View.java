package com.example.josezc.inp_cm.Views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.josezc.inp_cm.Entidades.Cita;
import com.example.josezc.inp_cm.Entidades.Usuario;
import com.example.josezc.inp_cm.R;


public class Inicio_View extends Fragment  {

    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         v = inflater.inflate(R.layout.fragment_inicio, container, false);




        return v;



    }



}
