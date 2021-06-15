package com.mdlozano.proyectofinal.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mdlozano.proyectofinal.R;
import com.mdlozano.proyectofinal.database.Empleados;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmpleadosCustomAdapter extends RecyclerView.Adapter<EmpleadosCustomAdapter.ViewHolder> {

    private static ArrayList<Empleados> localDataset;
    private static EmpleadosClickListener itemListener;


    public EmpleadosCustomAdapter(ArrayList<Empleados> dataSet, EmpleadosClickListener itemListener) {
        localDataset = dataSet;
        EmpleadosCustomAdapter.itemListener = itemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_row_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpleadosCustomAdapter.ViewHolder holder, int position) {
        Empleados dato = localDataset.get(position);

        TextView[] views = holder.getTextView();

        views[0].setText("Nombre: " + dato.getNombre());
        views[1].setText("No. Empleado: " + dato.getNumero_empleado());
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
            itemListener.EmpleadosListClicked(v, this.getLayoutPosition(), localDataset);
        }

        public TextView[] getTextView() {
            return textView;
        }

    }

}