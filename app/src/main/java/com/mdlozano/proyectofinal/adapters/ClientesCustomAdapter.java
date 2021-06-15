package com.mdlozano.proyectofinal.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mdlozano.proyectofinal.R;
import com.mdlozano.proyectofinal.database.Clientes;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClientesCustomAdapter extends RecyclerView.Adapter<ClientesCustomAdapter.ViewHolder> {

    private static ArrayList<Clientes> localDataset;
    private static ClientesClickListener itemListener;


    public ClientesCustomAdapter(ArrayList<Clientes> dataSet, ClientesClickListener itemListener) {
        localDataset = dataSet;
        ClientesCustomAdapter.itemListener = itemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_row_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientesCustomAdapter.ViewHolder holder, int position) {
        Clientes dato = localDataset.get(position);

        TextView[] views = holder.getTextView();

        views[0].setText("Nombre del Cliente: " + dato.getNombre());
        views[1].setText("Telefono del cliente: " + dato.getTelefono());

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
            itemListener.ClientesListClicked(v, this.getLayoutPosition(), localDataset);
        }

        public TextView[] getTextView() {
            return textView;
        }

    }

}