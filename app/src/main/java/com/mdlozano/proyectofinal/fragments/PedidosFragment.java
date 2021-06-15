package com.mdlozano.proyectofinal.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mdlozano.proyectofinal.R;
import com.mdlozano.proyectofinal.activities.PedidosActivity;
import com.mdlozano.proyectofinal.adapters.PedidosClickListener;
import com.mdlozano.proyectofinal.adapters.PedidosCustomAdapter;
import com.mdlozano.proyectofinal.database.Pedidos;
import com.mdlozano.proyectofinal.database.IPedidos;

import java.util.ArrayList;

public class PedidosFragment extends Fragment implements PedidosClickListener {

    RecyclerView recyclerView;
    FloatingActionButton FAB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_empleados, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        FAB = view.findViewById(R.id.floating_action_button);

        FAB.setOnClickListener(v -> {
            Intent newActivity = new Intent(getActivity(), PedidosActivity.class);
            newActivity.putExtra("Edicion", false);
            startActivity(newActivity);
        });

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        ArrayList<Pedidos> mDataset;
        mDataset = IPedidos.getPedidos();


        recyclerView.setAdapter(new PedidosCustomAdapter(mDataset, this));
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        ArrayList<Pedidos> mDataset;
        mDataset = IPedidos.getPedidos();


        recyclerView.setAdapter(new PedidosCustomAdapter(mDataset, this));
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void PedidosListClicked(View v, int position, ArrayList<Pedidos> dataSet) {
        Intent newActivity = new Intent(getActivity(), PedidosActivity.class);
        newActivity.putExtra("Edicion", true);
        newActivity.putExtra("ID", dataSet.get(position).getId());
        startActivity(newActivity);
    }
}