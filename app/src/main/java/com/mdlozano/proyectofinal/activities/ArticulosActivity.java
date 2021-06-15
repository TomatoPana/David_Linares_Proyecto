package com.mdlozano.proyectofinal.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.mdlozano.proyectofinal.database.Articulos;
import com.mdlozano.proyectofinal.R;
import com.mdlozano.proyectofinal.database.IArticulos;


public class ArticulosActivity extends AppCompatActivity {

    TextView articulosAction;
    EditText Clave_producto;
    EditText Nombre;
    EditText Precio;
    EditText Descripcion;
    EditText Provedoores_id;
    Button Anadir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulos);

        articulosAction = findViewById(R.id.articulos_action);
        Clave_producto = findViewById(R.id.clave_producto);
        Nombre = findViewById(R.id.nombre);
        Precio = findViewById(R.id.precio);
        Descripcion = findViewById(R.id.descripcion);
        Provedoores_id = findViewById(R.id.provedoores_id);
        Anadir = findViewById(R.id.btnAnadirArticulos);

        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", 0);
        if(intent.getBooleanExtra("Edicion", false)){
            cargarArticulos(id);
        };

    }

    public void cargarArticulos(int id) {
        Articulos info = IArticulos.getArticulos(id);

        articulosAction.setText("Mostrando información de Sucursales: " + info.getId());
        Clave_producto.setText(info.getClave_producto());
        Nombre.setText(info.getNombre());
        Precio.setText(info.getPrecio());
        Descripcion.setText(info.getDescripcion());
        Provedoores_id.setText(info.getProveedores_id());

        Anadir.setVisibility(View.INVISIBLE);

    }

    public void guardarArticulos(View view) {
        boolean hasProblem = false;
        if(Clave_producto.getText().length() == 0) {
            Toast.makeText(this, "La clave del articulo no puede ser vacia", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Nombre.getText().length() == 0) {
            Toast.makeText(this, "Nombre no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Precio.getText().length() == 0) {
            Toast.makeText(this, "el Precio no puede quedar vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Descripcion.getText().length() == 0) {
            Toast.makeText(this, "La descripcion no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Provedoores_id.getText().length() == 0) {
            Toast.makeText(this, "Provedoor no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(!hasProblem) {
            Articulos dato = new Articulos();
            dato.setClave_producto(Clave_producto.getText().toString());
            dato.setNombre(Nombre.getText().toString());
            dato.setPrecio(Precio.getText().toString());
            dato.setDescripcion(Descripcion.getText().toString());
            dato.setProveedores_id(Integer.parseInt(Provedoores_id.getText().toString()));

            if(IArticulos.insertArticulos(dato)) {
                Toast.makeText(this, "Dato insertado correctamente", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(this, "No se insertó correctamente", Toast.LENGTH_LONG).show();
            }

        }

    }
}