package com.mdlozano.proyectofinal.activities;

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

import com.mdlozano.proyectofinal.R;
import com.mdlozano.proyectofinal.database.Empleados;
import com.mdlozano.proyectofinal.database.IEmpleado;

public class EmpleadosActivity extends AppCompatActivity {

    TextView empleadosAction;
    EditText numeroEmpleado;
    EditText Nombre;
    EditText Calle;
    EditText Colonia;
    EditText NumeroCasa;
    EditText Telefono;
    Button Anadir;
    Button Eliminar;
    Button Editar;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleados);

        empleadosAction = findViewById(R.id.empleados_action);
        numeroEmpleado = findViewById(R.id.numero_empleado);
        Nombre = findViewById(R.id.nombre);
        Calle = findViewById(R.id.calle);
        Colonia = findViewById(R.id.colonia);
        NumeroCasa = findViewById(R.id.numero_casa);
        Telefono = findViewById(R.id.telefono);
        Anadir = findViewById(R.id.btnAnadirEmpleado);
        Eliminar = findViewById(R.id.btnEliminarEmpleados);
        Editar = findViewById(R.id.btnEditarEmpleados);

        Intent intent = getIntent();
        id = intent.getIntExtra("ID", 0);
        if(intent.getBooleanExtra("Edicion", false)){
            cargarEmpleado(id);
        };

    }

    public void cargarEmpleado(int id) {
        Empleados info = IEmpleado.getEmpleado(id);

        empleadosAction.setText("Mostrando información Empleado ID: " + info.getId());
        numeroEmpleado.setText(String.valueOf(info.getNumero_empleado()));
        Nombre.setText(info.getNombre());
        Calle.setText(info.getCalle());
        Colonia.setText(info.getColonia());
        NumeroCasa.setText(info.getNumero_casa());
        Telefono.setText(info.getTelefono());

        Anadir.setVisibility(View.INVISIBLE);
        Eliminar.setVisibility(View.VISIBLE);
        Editar.setVisibility(View.VISIBLE);

        
    }

    public void guardarEmpleado(View view) {
        boolean hasProblem = false;
        if(numeroEmpleado.getText().length() == 0) {
            Toast.makeText(this, "Numero de empleado no puede ser vacio", Toast.LENGTH_LONG).show();
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

        if(NumeroCasa.getText().length() == 0) {
            Toast.makeText(this, "Numero de casa no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Telefono.getText().length() == 0) {
            Toast.makeText(this, "Telefono no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(!hasProblem) {
            Empleados dato = new Empleados();
            dato.setNumero_empleado(Integer.parseInt(numeroEmpleado.getText().toString()));
            dato.setNombre(Nombre.getText().toString());
            dato.setCalle(Calle.getText().toString());
            dato.setColonia(Colonia.getText().toString());
            dato.setNumero_casa(NumeroCasa.getText().toString());
            dato.setTelefono(Telefono.getText().toString());

            if(IEmpleado.insertEmpleado(dato)) {
                Toast.makeText(this, "Dato insertado correctamente", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(this, "No se insertó correctamente", Toast.LENGTH_LONG).show();
            }

        }

    }

    public void eliminarEmpleado(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Estás seguro de continuar?")

                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        IEmpleado.deleteEmpleado(EmpleadosActivity.this.id);

                        Toast.makeText(EmpleadosActivity.this, "Elemento eliminado correctamente", Toast.LENGTH_LONG).show();
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

    public void editarEmpleado(View view) {
        Empleados dato = new Empleados();
        dato.setId(this.id);
        dato.setNumero_empleado(Integer.parseInt(numeroEmpleado.getText().toString()));
        dato.setNombre(Nombre.getText().toString());
        dato.setCalle(Calle.getText().toString());
        dato.setColonia(Colonia.getText().toString());
        dato.setNumero_casa(NumeroCasa.getText().toString());
        dato.setTelefono(Telefono.getText().toString());

        IEmpleado.updateEmpleado(dato);

        Toast.makeText(this, "Elemento editado correctamente", Toast.LENGTH_LONG).show();

        finish();

    }

}