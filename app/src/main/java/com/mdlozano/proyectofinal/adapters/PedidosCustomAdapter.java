package com.mdlozano.proyectofinal.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mdlozano.proyectofinal.R;
import com.mdlozano.proyectofinal.database.Pedidos;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PedidosCustomAdapter extends RecyclerView.Adapter<PedidosCustomAdapter.ViewHolder> {

    private ArrayList<Pedidos> dataSet = new ArrayList<>();

    public PedidosCustomAdapter(ArrayList<Pedidos> data) {
        this.dataSet = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PedidosCustomAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


        }


    }

}
