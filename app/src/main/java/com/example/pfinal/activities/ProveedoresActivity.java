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
import com.example.pfinal.database.Proveedores;
import com.example.pfinal.database.IProveedores;

public class ProveedoresActivity extends AppCompatActivity {

    TextView proveedoresAction;
    EditText Nombre;
    EditText Telefono;
    Button Anadir;
    Button Eliminar;
    Button Editar;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proveedores);

        proveedoresAction = findViewById(R.id.proveedores_action);
        Nombre = findViewById(R.id.nombre);
        Telefono = findViewById(R.id.telefono);
        Anadir = findViewById(R.id.btnAnadirProveedores);
        Eliminar = findViewById(R.id.btnEliminarProveedores);
        Editar = findViewById(R.id.btnEditarProveedores);

        Intent intent = getIntent();
        id = intent.getIntExtra("ID", 0);
        if(intent.getBooleanExtra("Edicion", false)){
            cargarProveedores(id);
        };

    }

    public void cargarProveedores(int id) {
        Proveedores info = IProveedores.getProveedores(id);

        proveedoresAction.setText("Mostrando información de proveedores: " + info.getId());
        Nombre.setText(info.getNombre());
        Telefono.setText(info.getTelefono());
        Anadir.setVisibility(View.INVISIBLE);
        Eliminar.setVisibility(View.VISIBLE);
        Editar.setVisibility(View.VISIBLE);


    }

    public void guardarProveedores(View view) {
        boolean hasProblem = false;

        if(Nombre.getText().length() == 0) {
            Toast.makeText(this, "Campo no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Telefono.getText().length() == 0) {
            Toast.makeText(this, "Campo no puede ser vacio", Toast.LENGTH_LONG).show();
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

    public void eliminarProveedores(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Estás seguro de continuar?")

                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        IProveedores.deleteProveedores(ProveedoresActivity.this.id);

                        Toast.makeText(ProveedoresActivity.this, "Elemento eliminado correctamente", Toast.LENGTH_LONG).show();
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

    public void editarProveedores(View view) {
        Proveedores dato = new Proveedores();

        dato.setId(this.id);
        dato.setNombre(Nombre.getText().toString());
        dato.setTelefono(Telefono.getText().toString());

        IProveedores.updateProveedores(dato);

        Toast.makeText(this, "Elemento editado correctamente", Toast.LENGTH_LONG).show();

        finish();

    }

}