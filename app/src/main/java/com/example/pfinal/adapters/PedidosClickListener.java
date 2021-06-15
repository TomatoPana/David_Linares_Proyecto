package com.example.pfinal.adapters;

import android.view.View;

import com.example.pfinal.database.Pedidos;

import java.util.ArrayList;

public interface PedidosClickListener {
    public void PedidosListClicked(View v, int position, ArrayList<Pedidos> dataSet);
}
