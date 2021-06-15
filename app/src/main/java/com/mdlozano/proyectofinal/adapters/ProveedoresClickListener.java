package com.mdlozano.proyectofinal.adapters;

import android.view.View;

import com.mdlozano.proyectofinal.database.Proveedores;

import java.util.ArrayList;

public interface ProveedoresClickListener {
    public void ProveedoresListClicked(View v, int position, ArrayList<Proveedores> dataSet);
}
