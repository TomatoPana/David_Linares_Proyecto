package com.example.pfinal.adapters;

import android.view.View;

import com.example.pfinal.database.Sucursales;

import java.util.ArrayList;

public interface SucursalesClickListener {
    public void SucursalesListClicked(View v, int position, ArrayList<Sucursales> dataSet);
}
