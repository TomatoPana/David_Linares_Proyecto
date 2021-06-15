package com.mdlozano.proyectofinal.adapters;

import android.view.View;
import android.view.ViewGroup;

import com.mdlozano.proyectofinal.database.Sucursales;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SucursalesCustomAdapter extends RecyclerView.Adapter<SucursalesCustomAdapter.ViewHolder> {

    private ArrayList<Sucursales> dataSet = new ArrayList<>();

    public void Sucursales(ArrayList<Sucursales> data) {
        this.dataSet = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SucursalesCustomAdapter.ViewHolder holder, int position) {

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