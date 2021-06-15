package com.mdlozano.proyectofinal.database;

public class Pedidos {

    private int id;
    private int fecha_compra;
    private float precio;
    private int fecha_entrega;
    private int Clientes_id;

    public Pedidos(){
        this.id = 0;
        this.fecha_compra = 0;
        this.precio = 0;
        this.fecha_entrega = 0;
        this.Clientes_id = 0;

    }

    public Pedidos(
            int id,
            int fecha_compra,
            float precio,
            int fecha_entrega,
            int Clientes_id
    ) {
        this.id = id;
        this.fecha_compra = fecha_compra;
        this.precio = precio;
        this.fecha_entrega = fecha_entrega;
        this.Clientes_id = Clientes_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(int fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(int fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public int getClientes_id() {
        return Clientes_id;
    }

    public void setClientes_id(int Clientes_id) {
        this.Clientes_id = Clientes_id;
    }

}
