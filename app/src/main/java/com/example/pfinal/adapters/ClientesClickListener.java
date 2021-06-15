package com.example.pfinal.adapters;

import android.view.View;

import com.example.pfinal.database.Clientes;

import java.util.ArrayList;

public interface ClientesClickListener {
    public void ClientesListClicked(View v, int position, ArrayList<Clientes> dataSet);
}
