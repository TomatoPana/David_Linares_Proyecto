package com.mdlozano.proyectofinal;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new EmpleadosFragment();
            case 1:
                return new SucursalesFragment();
            case 2:
                return new ArticulosFragment();
            case 3:
                return new ProveedoresFragment();
            case 4:
                return new PedidosFragment();
            case 5:
                return new ClientesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
