package com.example.pfinal.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pfinal.R;
import com.example.pfinal.database.Pedidos;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PedidosCustomAdapter extends RecyclerView.Adapter<PedidosCustomAdapter.ViewHolder> {

    private static ArrayList<Pedidos> localDataset;
    private static PedidosClickListener itemListener;


    public PedidosCustomAdapter(ArrayList<Pedidos> dataSet, PedidosClickListener itemListener) {
        localDataset = dataSet;
        PedidosCustomAdapter.itemListener = itemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_row_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PedidosCustomAdapter.ViewHolder holder, int position) {
        Pedidos dato = localDataset.get(position);

        TextView[] views = holder.getTextView();

        views[0].setText("Fecha de la Compra: " + dato.getFecha_compra());
        views[1].setText("Precio del pedido: " + dato.getPrecio());
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
            itemListener.PedidosListClicked(v, this.getLayoutPosition(), localDataset);
        }

        public TextView[] getTextView() {
            return textView;
        }

    }

}