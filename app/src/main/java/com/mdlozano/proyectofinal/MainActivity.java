package com.mdlozano.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        viewPager.setAdapter(new FragmentAdapter(this));

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("Empleados");
                    break;
                case 1:
                    tab.setText("Sucursales");
                    break;
                case 2:
                    tab.setText("Articulos");
                    break;
                case 3:
                    tab.setText("Proveedores");
                    break;
                case 4:
                    tab.setText("Pedidos");
                    break;
                case 5:
                    tab.setText("Clientes");
                    break;
            }
        });

        tabLayoutMediator.attach();

    }
}