package com.example.pfinal.adapters;

import android.view.View;

import com.example.pfinal.database.Proveedores;

import java.util.ArrayList;

public interface ProveedoresClickListener {
    public void ProveedoresListClicked(View v, int position, ArrayList<Proveedores> dataSet);
}
