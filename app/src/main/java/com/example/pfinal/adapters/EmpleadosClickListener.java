package com.example.pfinal.adapters;

import android.view.View;

import com.example.pfinal.database.Empleados;

import java.util.ArrayList;

public interface EmpleadosClickListener {
    public void EmpleadosListClicked(View v, int position, ArrayList<Empleados> dataSet);
}
