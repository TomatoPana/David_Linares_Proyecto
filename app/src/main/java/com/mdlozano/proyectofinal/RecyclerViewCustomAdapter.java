package com.mdlozano.proyectofinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewCustomAdapter extends RecyclerView.Adapter<RecyclerViewCustomAdapter.ViewHolder> {

    private final String[] localDataset;

    public RecyclerViewCustomAdapter(String[] dataSet) {
        localDataset = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_row_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewCustomAdapter.ViewHolder holder, int position) {
        TextView[] views = holder.getTextView();

        for (TextView view : views) {
            view.setText(localDataset[position]);
        }
    }

    @Override
    public int getItemCount() {
        return localDataset.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView[] textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(v -> {
                Toast.makeText(itemView.getContext(), "Hola", Toast.LENGTH_LONG).show();
            });

            textView = new TextView[] { itemView.findViewById(R.id.textView), itemView.findViewById(R.id.textView2) };

        }

        public TextView[] getTextView() {
            return textView;
        }

    }

}
