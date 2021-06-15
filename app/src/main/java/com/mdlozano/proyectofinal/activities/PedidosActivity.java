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
import com.mdlozano.proyectofinal.database.Pedidos;
import com.mdlozano.proyectofinal.database.IPedidos;

public class PedidosActivity extends AppCompatActivity {

    TextView pedidosAction;
    EditText Fecha_compra;
    EditText Precio;
    EditText Fecha_entrega;
    EditText Clientes_id;
    Button Anadir;

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

        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", 0);
        if(intent.getBooleanExtra("Edicion", false)){
            cargarPedidos(id);
        };

    }

    public void cargarPedidos(int id) {
        Pedidos info = IPedidos.getPedidos(id);

        pedidosAction.setText("Mostrando información Pedidos ID: " + info.getId());
        Fecha_compra.setText(String.valueOf(info.getFecha_compra()));
        Precio.setText(String.valueOf(info.getPrecio()));
        Fecha_entrega.setText(info.getFecha_entrega());
        Clientes_id.setText(info.getClientes_id());

        Anadir.setVisibility(View.INVISIBLE);

    }

    public void guardarPedidos(View view) {
        boolean hasProblem = false;
        if(Fecha_compra.getText().length() == 0) {
            Toast.makeText(this, "La fecha de compra no debe estar vacia", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Precio.getText().length() == 0) {
            Toast.makeText(this, "El precio no debe estar vacio", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Fecha_entrega.getText().length() == 0) {
            Toast.makeText(this, "La fecha de entrega no puede estar vacia", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(Clientes_id.getText().length() == 0) {
            Toast.makeText(this, "El ID del cliente que  hizo la compra no puede estar vacia", Toast.LENGTH_LONG).show();
            hasProblem = true;
        }

        if(!hasProblem) {
            Pedidos dato = new Pedidos();
            dato.setFecha_compra(Integer.parseInt(Fecha_compra.getText().toString()));
            dato.setPrecio(Integer.parseInt(Precio.getText().toString()));
            dato.setFecha_compra(Integer.parseInt(Fecha_compra.getText().toString()));
            dato.setClientes_id(Integer.parseInt(Clientes_id.getText().toString()));

            if(IPedidos.insertPedidos(dato)) {
                Toast.makeText(this, "Dato insertado correctamente", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(this, "No se insertó correctamente", Toast.LENGTH_LONG).show();
            }

        }

    }
}