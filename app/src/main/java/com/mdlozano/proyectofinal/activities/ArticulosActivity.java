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
import com.mdlozano.proyectofinal.database.Articulos;
import com.mdlozano.proyectofinal.database.IArticulos;

public class ArticulosActivity extends AppCompatActivity {

    TextView articulosAction;
    EditText Clave_producto;
    EditText Nombre;
    EditText Precio;
    EditText Descipcion;
    EditText Proveedores_id;
    Button Anadir;
    Button Eliminar;
    Button Editar;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulos);

        articulosAction = findViewById(R.id.articulos_accion);
        Clave_producto = findViewById(R.id.clave_producto);
        Nombre = findViewById(R.id.nombre);
        Precio = findViewById(R.id.precio);
        Descipcion = findViewById(R.id.descripcion);
        Proveedores_id = findViewById(R.id.proveedores_id);
        Anadir = findViewById(R.id.btnAnadirArticulos);
        Eliminar = findViewById(R.id.btnEliminarArticulos);
        Editar = findViewById(R.id.btnEditarArticulos);

        Intent intent = getIntent();
        id = intent.getIntExtra("ID", 0);
        if(intent.getBooleanExtra("Edicion", false)){
            cargarArticulo(id);
        };

    }

    public void cargarArticulo(int id) {
        Articulos info = IArticulos.getArticulos(id);

        articulosAction.setText("Mostrando información de los articulos: " + info.getId());
        Clave_producto.setText(String.valueOf(info.getClave_producto()));
        Nombre.setText(info.getNombre());
        Precio.setText(info.getPrecio());
        Descipcion.setText(info.getDescripcion());
        Proveedores_id.setText(String.valueOf(info.getProveedores_id()));

        Anadir.setVisibility(View.INVISIBLE);
        Eliminar.setVisibility(View.VISIBLE);
        Editar.setVisibility(View.VISIBLE);


    }

    public void guardarArticulos(View view) {
        boolean hasProblem = false;
        if(Clave_producto.getText().length() == 0) {
            Toast.makeText(this, "El campo no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Nombre.getText().length() == 0) {
            Toast.makeText(this, "El campo no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Precio.getText().length() == 0) {
            Toast.makeText(this, "El campo no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Descipcion.getText().length() == 0) {
            Toast.makeText(this, "El campo no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Proveedores_id.getText().length() == 0) {
            Toast.makeText(this, "El campo no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }


        if(!hasProblem) {
            Articulos dato = new Articulos();
            dato.setNombre(Clave_producto.getText().toString());
            dato.setNombre(Nombre.getText().toString());
            dato.setPrecio(Precio.getText().toString());
            dato.setDescripcion(Descipcion.getText().toString());
            dato.setProveedores_id(Integer.parseInt(Proveedores_id.getText().toString()));

            if(IArticulos.insertArticulos(dato)) {
                Toast.makeText(this, "Dato insertado correctamente", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(this, "No se insertó correctamente", Toast.LENGTH_LONG).show();
            }

        }

    }

    public void eliminarArticulos(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Estás seguro de continuar?")

                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        IArticulos.deleteArticulos(ArticulosActivity.this.id);

                        Toast.makeText(ArticulosActivity.this, "Elemento eliminado correctamente", Toast.LENGTH_LONG).show();
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

    public void editarArticulos(View view) {
        Articulos dato = new Articulos();
        dato.setId(this.id);
        dato.setClave_producto(Clave_producto.getText().toString());
        dato.setNombre(Nombre.getText().toString());
        dato.setPrecio(Precio.getText().toString());
        dato.setDescripcion(Descipcion.getText().toString());
        dato.setProveedores_id(Integer.parseInt(Proveedores_id.getText().toString()));

        IArticulos.updateArticulos(dato);

        Toast.makeText(this, "Elemento editado correctamente", Toast.LENGTH_LONG).show();

        finish();

    }

}