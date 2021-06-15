package com.mdlozano.proyectofinal.adapters;

import android.view.View;

import com.mdlozano.proyectofinal.database.Articulos;

import java.util.ArrayList;

public interface ArticulosClickListener {
    public void ArticulosListClicked(View v, int position, ArrayList<Articulos> dataSet);
}
