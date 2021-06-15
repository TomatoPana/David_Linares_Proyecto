package com.mdlozano.proyectofinal.adapters;

import android.view.View;

import com.mdlozano.proyectofinal.database.Empleados;

import java.util.ArrayList;

public interface EmpleadosClickListener {
    public void EmpleadosListClicked(View v, int position, ArrayList<Empleados> dataSet);
}
