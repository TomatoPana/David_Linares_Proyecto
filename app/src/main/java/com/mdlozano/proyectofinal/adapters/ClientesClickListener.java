package com.mdlozano.proyectofinal.adapters;

import android.view.View;

import com.mdlozano.proyectofinal.database.Clientes;

import java.util.ArrayList;

public interface ClientesClickListener {
    public void ClientesListClicked(View v, int position, ArrayList<Clientes> dataSet);
}
