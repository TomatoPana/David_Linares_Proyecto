package com.mdlozano.proyectofinal.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mdlozano.proyectofinal.R;
import com.mdlozano.proyectofinal.database.Articulos;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticulosCustomAdapter extends RecyclerView.Adapter<ArticulosCustomAdapter.ViewHolder> {

    private static ArrayList<Articulos> localDataset;
    private static ArticulosClickListener itemListener;


    public ArticulosCustomAdapter(ArrayList<Articulos> dataSet, ArticulosClickListener itemListener) {
        localDataset = dataSet;
        ArticulosCustomAdapter.itemListener = itemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_row_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticulosCustomAdapter.ViewHolder holder, int position) {
        Articulos dato = localDataset.get(position);

        TextView[] views = holder.getTextView();

        views[0].setText("Clave del producto: " + dato.getClave_producto());
        views[1].setText("Nombre del articulo: " + dato.getNombre());
    }

    @Override
    public int getItemCount() {
        return localDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView[] textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            textView = new TextView[] { itemView.findViewById(R.id.textView), itemView.findViewById(R.id.textView2) };

        }

        @Override
        public void onClick(View v) {
            itemListener.ArticulosListClicked(v, this.getLayoutPosition(), localDataset);
        }

        public TextView[] getTextView() {
            return textView;
        }

    }

}