package com.mdlozano.proyectofinal.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mdlozano.proyectofinal.R;
import com.mdlozano.proyectofinal.database.Clientes;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClientesCustomAdapter extends RecyclerView.Adapter<ClientesCustomAdapter.ViewHolder> {

    private ArrayList<Clientes> dataSet = new ArrayList<>();

    public ClientesCustomAdapter(ArrayList<Clientes> data) {
        this.dataSet = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ClientesCustomAdapter.ViewHolder holder, int position) {

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