package com.example.pfinal.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pfinal.adapters.SucursalesClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.pfinal.R;
import com.example.pfinal.activities.SucursalesActivity;
import com.example.pfinal.adapters.SucursalesCustomAdapter;
import com.example.pfinal.database.Sucursales;
import com.example.pfinal.database.ISucursales;

import java.util.ArrayList;

public class SucursalesFragment extends Fragment implements SucursalesClickListener {

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
            Intent newActivity = new Intent(getActivity(), SucursalesActivity.class);
            newActivity.putExtra("Edicion", false);
            startActivity(newActivity);
        });

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        ArrayList<Sucursales> mDataset;
        mDataset = ISucursales.getSucursales();


        recyclerView.setAdapter(new SucursalesCustomAdapter(mDataset, this));
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        ArrayList<Sucursales> mDataset;
        mDataset = ISucursales.getSucursales();


        recyclerView.setAdapter(new SucursalesCustomAdapter(mDataset, this));
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void SucursalesListClicked(View v, int position, ArrayList<Sucursales> dataSet) {
        Intent newActivity = new Intent(getActivity(), SucursalesActivity.class);
        newActivity.putExtra("Edicion", true);
        newActivity.putExtra("ID", dataSet.get(position).getId());
        startActivity(newActivity);
    }
}