package com.mdlozano.proyectofinal.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mdlozano.proyectofinal.R;
import com.mdlozano.proyectofinal.database.Clientes;
import com.mdlozano.proyectofinal.database.IClientes;

public class ClientesActivity extends AppCompatActivity {

    TextView clientesAction;
    EditText Fecha_nacimiento;
    EditText Nombre;
    EditText Telefono;
    EditText Calle;
    EditText Colonia;
    EditText Numero_casa;
    Button Anadir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        clientesAction = findViewById(R.id.clientes_action);
        Fecha_nacimiento = findViewById(R.id.fecha_nacimiento);
        Nombre = findViewById(R.id.nombre);
        Telefono = findViewById(R.id.telefono);
        Calle = findViewById(R.id.calle);
        Colonia = findViewById(R.id.colonia);
        Numero_casa = findViewById(R.id.numero_casa);
        Anadir = findViewById(R.id.btnAnadirClientes);

        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", 0);
        if(intent.getBooleanExtra("Edicion", false)){
            cargarEmpleado(id);
        };

    }

    public void cargarEmpleado(int id) {
        Clientes info = IClientes.getClientes(id);

        clientesAction.setText("Mostrando información Cliente ID: " + info.getId());
        Fecha_nacimiento.setText(String.valueOf(info.getFecha_nacimiento()));
        Telefono.setText(info.getTelefono());
        Nombre.setText(info.getNombre());
        Calle.setText(info.getCalle());
        Colonia.setText(info.getColonia());
        Numero_casa.setText(info.getNumero_casa());
        

        Anadir.setVisibility(View.INVISIBLE);

    }

    public void guardarClientes(View view) {
        boolean hasProblem = false;
        if(Fecha_nacimiento.getText().length() == 0) {
            Toast.makeText(this, "Fecha de nacimiento no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }
        
        if(Telefono.getText().length() == 0) {
            Toast.makeText(this, "Telefono no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Nombre.getText().length() == 0) {
            Toast.makeText(this, "Nombre no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Calle.getText().length() == 0) {
            Toast.makeText(this, "Calle no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Colonia.getText().length() == 0) {
            Toast.makeText(this, "Colonia no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Numero_casa.getText().length() == 0) {
            Toast.makeText(this, "Numero de casa no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        
        if(!hasProblem) {
            Clientes dato = new Clientes();
            dato.setFecha_nacimiento(Integer.parseInt(Fecha_nacimiento.getText().toString()));
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

    }
}