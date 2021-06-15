package com.example.pfinal.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pfinal.R;
import com.example.pfinal.database.Sucursales;
import com.example.pfinal.database.ISucursales;

public class SucursalesActivity extends AppCompatActivity {

    TextView sucursalesAction;
    EditText Rfc;
    EditText Calle;
    EditText Numero;
    EditText Colonia;
    EditText Telefono;
    Button Anadir;
    Button Eliminar;
    Button Editar;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucursales);

        sucursalesAction = findViewById(R.id.sucursales_action);
        Rfc = findViewById(R.id.rfc);
        Calle = findViewById(R.id.calle);
        Numero = findViewById(R.id.numero);
        Colonia = findViewById(R.id.colonia);
        Telefono = findViewById(R.id.telefono);
        Anadir = findViewById(R.id.btnAnadirSucursales);
        Eliminar = findViewById(R.id.btnEliminarSucursales);
        Editar = findViewById(R.id.btnEditarSucursales);

        Intent intent = getIntent();
        id = intent.getIntExtra("ID", 0);
        if (intent.getBooleanExtra("Edicion", false)) {
            cargarSucursales(id);
        }

    }

    public void cargarSucursales(int id) {
        Sucursales info = ISucursales.getSucursales(id);

        sucursalesAction.setText("Mostrando información de sucursales: " + info.getId());
        Rfc.setText(String.valueOf(info.getRfc()));
        Calle.setText(info.getCalle());
        Numero.setText(info.getNumero());
        Colonia.setText(info.getColonia());
        Telefono.setText(info.getTelefono());
        Anadir.setVisibility(View.INVISIBLE);
        Eliminar.setVisibility(View.VISIBLE);
        Editar.setVisibility(View.VISIBLE);


    }

    public void guardarSucursal(View view) {
        boolean hasProblem = false;
        if (Rfc.getText().length() == 0) {
            Toast.makeText(this, "RFC no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if (Calle.getText().length() == 0) {
            Toast.makeText(this, "Calle no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if (Numero.getText().length() == 0) {
            Toast.makeText(this, "Numero no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if (Colonia.getText().length() == 0) {
            Toast.makeText(this, "Colonia no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }


        if (Telefono.getText().length() == 0) {
            Toast.makeText(this, "Telefono no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if (!hasProblem) {
            Sucursales dato = new Sucursales();
            dato.setRfc(Rfc.getText().toString());
            dato.setCalle(Calle.getText().toString());
            dato.setNumero(Numero.getText().toString());
            dato.setColonia(Colonia.getText().toString());
            dato.setTelefono(Telefono.getText().toString());

            if (ISucursales.insertSucursales(dato)) {
                Toast.makeText(this, "Dato insertado correctamente", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(this, "No se insertó correctamente", Toast.LENGTH_LONG).show();
            }

        }

    }

    public void eliminarSucursal(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Estás seguro de continuar?")

                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        ISucursales.deleteSucursales(SucursalesActivity.this.id);

                        Toast.makeText(SucursalesActivity.this, "Elemento eliminado correctamente", Toast.LENGTH_LONG).show();
                        finish();
                    }
                })

                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });

        AlertDialog dialog = builder.create();

        dialog.show();
    }

    public void editarSucursal(View view) {
        Sucursales dato = new Sucursales();
        dato.setId(this.id);
        dato.setRfc(Rfc.getText().toString());
        dato.setCalle(Calle.getText().toString());
        dato.setNumero(Numero.getText().toString());
        dato.setColonia(Colonia.getText().toString());
        dato.setTelefono(Telefono.getText().toString());

        ISucursales.updateSucursales(dato);

        Toast.makeText(this, "Elemento editado correctamente", Toast.LENGTH_LONG).show();

        finish();

    }
}