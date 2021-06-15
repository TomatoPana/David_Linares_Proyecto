package com.example.pfinal.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.pfinal.R;
import com.example.pfinal.activities.ProveedoresActivity;
import com.example.pfinal.adapters.ProveedoresClickListener;
import com.example.pfinal.adapters.ProveedoresCustomAdapter;
import com.example.pfinal.database.Proveedores;
import com.example.pfinal.database.IProveedores;

import java.util.ArrayList;

public class ProveedoresFragment extends Fragment implements ProveedoresClickListener {

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
            Intent newActivity = new Intent(getActivity(), ProveedoresActivity.class);
            newActivity.putExtra("Edicion", false);
            startActivity(newActivity);
        });

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        ArrayList<Proveedores> mDataset;
        mDataset = IProveedores.getProveedores();


        recyclerView.setAdapter(new ProveedoresCustomAdapter(mDataset, this));
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        ArrayList<Proveedores> mDataset;
        mDataset = IProveedores.getProveedores();


        recyclerView.setAdapter(new ProveedoresCustomAdapter(mDataset, this));
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void ProveedoresListClicked(View v, int position, ArrayList<Proveedores> dataSet) {
        Intent newActivity = new Intent(getActivity(), ProveedoresActivity.class);
        newActivity.putExtra("Edicion", true);
        newActivity.putExtra("ID", dataSet.get(position).getId());
        startActivity(newActivity);
    }
}