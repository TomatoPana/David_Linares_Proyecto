package com.example.pfinal.adapters;

import com.example.pfinal.fragments.ArticulosFragment;
import com.example.pfinal.fragments.ClientesFragment;
import com.example.pfinal.fragments.EmpleadosFragment;
import com.example.pfinal.fragments.PedidosFragment;
import com.example.pfinal.fragments.ProveedoresFragment;
import com.example.pfinal.fragments.SucursalesFragment;

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
