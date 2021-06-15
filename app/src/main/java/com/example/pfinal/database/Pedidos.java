package com.example.pfinal.database;

public class Pedidos {

    private int id;
    private String fecha_compra;
    private float precio;
    private String fecha_entrega;
    private int Clientes_id;

    public Pedidos(){
        this.id = 0;
        this.fecha_compra = "";
        this.precio = 0;
        this.fecha_entrega = "";
        this.Clientes_id = 0;

    }

    public Pedidos(
            int id,
            String fecha_compra,
            float precio,
            String fecha_entrega,
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

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public int getClientes_id() {
        return Clientes_id;
    }

    public void setClientes_id(int Clientes_id) {
        this.Clientes_id = Clientes_id;
    }

}
