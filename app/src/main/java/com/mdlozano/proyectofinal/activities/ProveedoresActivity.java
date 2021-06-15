package com.mdlozano.proyectofinal.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.mdlozano.proyectofinal.database.Proveedores;
import com.mdlozano.proyectofinal.database.IProveedores;
import com.mdlozano.proyectofinal.R;

public class ProveedoresActivity extends AppCompatActivity {
    TextView proveedoresAction;
    EditText Nombre;
    EditText Telefono;
    Button Anadir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proveedores);

        proveedoresAction = findViewById(R.id.proveedores_action);
        Nombre = findViewById(R.id.nombre);
        Telefono = findViewById(R.id.telefono);
        Anadir = findViewById(R.id.btnAnadirProvedoores);

        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", 0);
        if(intent.getBooleanExtra("Edicion", false)){
            cargarProveedores(id);
        };

    }

    public void cargarProveedores(int id) {
        Proveedores info = IProveedores.getProveedores(id);

        proveedoresAction.setText("Mostrando información de los Proveedores: " + info.getId());
        Nombre.setText(String.valueOf(info.getNombre()));
        Telefono.setText(info.getTelefono());

        Anadir.setVisibility(View.INVISIBLE);

    }

    public void guardarSucursal(View view) {
        boolean hasProblem = false;
        if(Nombre.getText().length() == 0) {
            Toast.makeText(this, "El nombre del proveedor no puede estar vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Telefono.getText().length() == 0) {
            Toast.makeText(this, "El telefono no puede estar vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }


        if(!hasProblem) {
            Proveedores dato = new Proveedores();
            dato.setNombre(Nombre.getText().toString());
            dato.setTelefono(Telefono.getText().toString());

            if(IProveedores.insertProveedores(dato)) {
                Toast.makeText(this, "Dato insertado correctamente", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(this, "No se insertó correctamente", Toast.LENGTH_LONG).show();
            }

        }

    }
}