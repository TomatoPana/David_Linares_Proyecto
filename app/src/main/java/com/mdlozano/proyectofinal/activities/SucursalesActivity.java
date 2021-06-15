package com.mdlozano.proyectofinal.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.mdlozano.proyectofinal.database.Sucursales;
import com.mdlozano.proyectofinal.R;
import com.mdlozano.proyectofinal.database.ISucursales;

public class SucursalesActivity extends AppCompatActivity {
    TextView sucursalesAction;
    EditText Rfc;
    EditText Calle;
    EditText Numero;
    EditText Colonia;
    EditText Telefono;
    Button Anadir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleados);

        sucursalesAction = findViewById(R.id.sucursales_action);
        Rfc = findViewById(R.id.rfc);
        Calle = findViewById(R.id.calle);
        Numero = findViewById(R.id.numero);
        Colonia = findViewById(R.id.colonia);
        Telefono = findViewById(R.id.telefono);
        Anadir = findViewById(R.id.btnAnadirSucursal);

        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", 0);
        if(intent.getBooleanExtra("Edicion", false)){
            cargarSucursales(id);
        };

    }

    public void cargarSucursales(int id) {
        Sucursales info = ISucursales.getSucursales(id);

        sucursalesAction.setText("Mostrando información de las sucursales ID: " + info.getId());
        Rfc.setText(String.valueOf(info.getRfc()));
        Calle.setText(info.getCalle());
        Numero.setText(info.getNumero());
        Colonia.setText(info.getColonia());
        Telefono.setText(info.getTelefono());


        Anadir.setVisibility(View.INVISIBLE);

    }

    public void guardarSucursal(View view) {
        boolean hasProblem = false;
        if(Rfc.getText().length() == 0) {
            Toast.makeText(this, "El RFC de la sucursal no puede estar vacia", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Calle.getText().length() == 0) {
            Toast.makeText(this, "La calle no puede ser vacia", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Numero.getText().length() == 0) {
            Toast.makeText(this, "El numero no puede quedar vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Colonia.getText().length() == 0) {
            Toast.makeText(this, "Colonia no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Telefono.getText().length() == 0) {
            Toast.makeText(this, "El telefono no puede estar vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }


        if(!hasProblem) {
            Sucursales dato = new Sucursales();
            dato.setRfc(Rfc.getText().toString());
            dato.setCalle(Calle.getText().toString());
            dato.setColonia(Colonia.getText().toString());
            dato.setTelefono(Telefono.getText().toString());

            if(ISucursales.insertSucursales(dato)) {
                Toast.makeText(this, "Dato insertado correctamente", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(this, "No se insertó correctamente", Toast.LENGTH_LONG).show();
            }

        }

    }
}