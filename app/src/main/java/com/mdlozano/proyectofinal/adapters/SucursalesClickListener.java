package com.mdlozano.proyectofinal.adapters;

import android.view.View;

import com.mdlozano.proyectofinal.database.Sucursales;

import java.util.ArrayList;

public interface SucursalesClickListener {
    public void SucursalesListClicked(View v, int position, ArrayList<Sucursales> dataSet);
}
