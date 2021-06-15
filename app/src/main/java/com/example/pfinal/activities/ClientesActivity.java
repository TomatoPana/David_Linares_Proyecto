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
import com.example.pfinal.database.Clientes;
import com.example.pfinal.database.IClientes;


public class ClientesActivity extends AppCompatActivity {

    TextView clientesAction;
    EditText Fecha_nacimiento;
    EditText Telefono;
    EditText Nombre;
    EditText Calle;
    EditText Colonia;
    EditText Numero_casa;
    Button Anadir;
    Button Eliminar;
    Button Editar;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        clientesAction = findViewById(R.id.clientes_action);
        Fecha_nacimiento = findViewById(R.id.fecha_nacimiento);
        Telefono = findViewById(R.id.telefono);
        Nombre = findViewById(R.id.nombre);
        Calle = findViewById(R.id.calle);
        Colonia = findViewById(R.id.colonia);
        Numero_casa = findViewById(R.id.numero_casa);
        Anadir = findViewById(R.id.btnAnadirClientes);
        Eliminar = findViewById(R.id.btnEliminarClientes);
        Editar = findViewById(R.id.btnEditarClientes);

        Intent intent = getIntent();
        id = intent.getIntExtra("ID", 0);
        if(intent.getBooleanExtra("Edicion", false)){
            cargarClientes(id);
        };

    }

    public void cargarClientes(int id) {
        Clientes info = IClientes.getClientes(id);

        clientesAction.setText("Mostrando información del cliente: " + info.getId());
        Fecha_nacimiento.setText(String.valueOf(info.getFecha_nacimiento()));
        Telefono.setText(info.getTelefono());
        Nombre.setText(info.getNombre());
        Calle.setText(info.getCalle());
        Colonia.setText(info.getColonia());
        Numero_casa.setText(info.getNumero_casa());

        Anadir.setVisibility(View.INVISIBLE);
        Eliminar.setVisibility(View.VISIBLE);
        Editar.setVisibility(View.VISIBLE);


    }

    public void guardarCliente(View view) {

        Clientes dato = new Clientes();
        dato.setFecha_nacimiento(Fecha_nacimiento.getText().toString());
        dato.setTelefono(Telefono.getText().toString());
        dato.setNombre(Nombre.getText().toString());
        dato.setCalle(Calle.getText().toString());
        dato.setColonia(Colonia.getText().toString());
        dato.setNumero_casa(Numero_casa.getText().toString());

        if(IClientes.insertClientes(dato)) {
            Toast.makeText(this, "Dato insertado correctamente", Toast.LENGTH_LONG).show();
            finish();
        } else {
            Toast.makeText(this, "No se insertó correctamente", Toast.LENGTH_LONG).show();
        }

    }

    public void eliminarCliente(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Estás seguro de continuar?")

                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        IClientes.deleteClientes(ClientesActivity.this.id);

                        Toast.makeText(ClientesActivity.this, "Elemento eliminado correctamente", Toast.LENGTH_LONG).show();
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

    public void editarCliente(View view) {
        Clientes dato = new Clientes();
        dato.setId(this.id);
        dato.setFecha_nacimiento(Fecha_nacimiento.getText().toString());
        dato.setTelefono(Telefono.getText().toString());
        dato.setNombre(Nombre.getText().toString());
        dato.setCalle(Calle.getText().toString());
        dato.setColonia(Colonia.getText().toString());
        dato.setNumero_casa(Numero_casa.getText().toString());

        IClientes.updateClientes(dato);

        Toast.makeText(this, "Elemento editado correctamente", Toast.LENGTH_LONG).show();

        finish();

    }

}