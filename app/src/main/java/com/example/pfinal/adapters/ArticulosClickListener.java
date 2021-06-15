package com.example.pfinal.adapters;

import android.view.View;

import com.example.pfinal.database.Articulos;

import java.util.ArrayList;

public interface ArticulosClickListener {
    public void ArticulosListClicked(View v, int position, ArrayList<Articulos> dataSet);
}
