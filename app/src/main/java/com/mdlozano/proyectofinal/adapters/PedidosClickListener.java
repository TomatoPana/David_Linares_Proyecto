package com.mdlozano.proyectofinal.adapters;

import android.view.View;

import com.mdlozano.proyectofinal.database.Pedidos;

import java.util.ArrayList;

public interface PedidosClickListener {
    public void PedidosListClicked(View v, int position, ArrayList<Pedidos> dataSet);
}
