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
import com.example.pfinal.database.Pedidos;
import com.example.pfinal.database.IPedidos;

public class PedidosActivity extends AppCompatActivity {

    TextView pedidosAction;
    EditText Fecha_compra;
    EditText Precio;
    EditText Fecha_entrega;
    EditText Clientes_id;
    Button Anadir;
    Button Eliminar;
    Button Editar;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        pedidosAction = findViewById(R.id.pedidos_action);
        Fecha_compra = findViewById(R.id.fecha_compra);
        Precio = findViewById(R.id.precio);
        Fecha_entrega = findViewById(R.id.fecha_entrega);
        Clientes_id = findViewById(R.id.clientes_id);
        Anadir = findViewById(R.id.btnAnadirPedidos);
        Eliminar = findViewById(R.id.btnEliminarPedidos);
        Editar = findViewById(R.id.btnEditarPedidos);

        Intent intent = getIntent();
        id = intent.getIntExtra("ID", 0);
        if (intent.getBooleanExtra("Edicion", false)) {
            cargarPedidos(id);
        }
        ;

    }

    public void cargarPedidos(int id) {
        Pedidos info = IPedidos.getPedidos(id);

        pedidosAction.setText("Mostrando información de pedidos: " + info.getId());
        Fecha_compra.setText(String.valueOf(info.getFecha_compra()));
        Precio.setText(String.valueOf(info.getPrecio()));
        Fecha_entrega.setText(String.valueOf(info.getFecha_entrega()));
        Clientes_id.setText(String.valueOf(info.getClientes_id()));

        Anadir.setVisibility(View.INVISIBLE);
        Eliminar.setVisibility(View.VISIBLE);
        Editar.setVisibility(View.VISIBLE);


    }

    public void guardarPedidos(View view) {
        boolean hasProblem = false;
        if (Fecha_compra.getText().length() == 0) {
            Toast.makeText(this, "Numero de empleado no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }
        if (Precio.getText().length() == 0) {
            Toast.makeText(this, "Calle no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if (Fecha_entrega.getText().length() == 0) {
            Toast.makeText(this, "Nombre no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if (Clientes_id.getText().length() == 0) {
            Toast.makeText(this, "Colonia no puede ser vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }


        if (!hasProblem) {
            Pedidos dato = new Pedidos();
            dato.setFecha_compra(Fecha_compra.getText().toString());
            dato.setPrecio(Integer.parseInt(Precio.getText().toString()));
            dato.setFecha_entrega(Fecha_entrega.getText().toString());
            dato.setClientes_id(Integer.parseInt(Clientes_id.getText().toString()));

            if (IPedidos.insertPedidos(dato)) {
                Toast.makeText(this, "Dato insertado correctamente", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(this, "No se insertó correctamente", Toast.LENGTH_LONG).show();
            }

        }

    }

    public void eliminarPedidos(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Estás seguro de continuar?")

                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        IPedidos.deletePedidos(PedidosActivity.this.id);

                        Toast.makeText(PedidosActivity.this, "Elemento eliminado correctamente", Toast.LENGTH_LONG).show();
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

    public void editarPedidos(View view) {
        Pedidos dato = new Pedidos();
        dato.setId(this.id);
        dato.setFecha_compra(Fecha_compra.getText().toString());
        dato.setPrecio(Float.parseFloat(Precio.getText().toString()));
        dato.setFecha_entrega(Fecha_entrega.getText().toString());
        dato.setClientes_id(Integer.parseInt(Clientes_id.getText().toString()));

        IPedidos.updatePedidos(dato);

        Toast.makeText(this, "Elemento editado correctamente", Toast.LENGTH_LONG).show();

        finish();

    }
}