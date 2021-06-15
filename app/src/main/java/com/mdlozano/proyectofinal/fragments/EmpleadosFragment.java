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
import com.mdlozano.proyectofinal.activities.EmpleadosActivity;
import com.mdlozano.proyectofinal.adapters.EmpleadosClickListener;
import com.mdlozano.proyectofinal.adapters.EmpleadosCustomAdapter;
import com.mdlozano.proyectofinal.database.Empleados;
import com.mdlozano.proyectofinal.database.IEmpleado;

import java.util.ArrayList;

public class EmpleadosFragment extends Fragment implements EmpleadosClickListener {

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
            Intent newActivity = new Intent(getActivity(), EmpleadosActivity.class);
            newActivity.putExtra("Edicion", false);
            startActivity(newActivity);
        });

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        ArrayList<Empleados> mDataset;
        mDataset = IEmpleado.getEmpleados();


        recyclerView.setAdapter(new EmpleadosCustomAdapter(mDataset, this));
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        ArrayList<Empleados> mDataset;
        mDataset = IEmpleado.getEmpleados();


        recyclerView.setAdapter(new EmpleadosCustomAdapter(mDataset, this));
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void EmpleadosListClicked(View v, int position, ArrayList<Empleados> dataSet) {
        Intent newActivity = new Intent(getActivity(), EmpleadosActivity.class);
        newActivity.putExtra("Edicion", true);
        newActivity.putExtra("ID", dataSet.get(position).getId());
        startActivity(newActivity);
    }
}