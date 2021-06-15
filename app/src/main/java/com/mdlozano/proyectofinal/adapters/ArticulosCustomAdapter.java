package com.mdlozano.proyectofinal.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mdlozano.proyectofinal.R;
import com.mdlozano.proyectofinal.database.Articulos;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticulosCustomAdapter extends RecyclerView.Adapter<ArticulosCustomAdapter.ViewHolder> {

    private ArrayList<Articulos> dataSet = new ArrayList<>();

    public ArticulosCustomAdapter(ArrayList<Articulos> data) {
        this.dataSet = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticulosCustomAdapter.ViewHolder holder, int position) {

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