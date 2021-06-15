package com.mdlozano.proyectofinal.database;

public class Articulos {
    private int id;
    private String clave_producto;
    private String nombre;
    private String precio;
    private String descripcion;
    private int Proveedores_id;

    public Articulos(){
        this.id = 0;
        this.clave_producto = "";
        this.nombre = "";
        this.precio = "";
        this.descripcion = "";
        this.Proveedores_id = 0;
}
    public Articulos(
            int id,
            String clave_producto,
            String nombre,
            String precio,
            String descripcion,
            int Provedoores_id
    ) {
        this.id = id;
        this.clave_producto = clave_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.Proveedores_id = Provedoores_id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClave_producto() {
        return clave_producto;
    }

    public void setClave_producto(String clave_producto) {
        this.clave_producto = clave_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {this.precio = precio;}

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getProveedores_id() {
        return Proveedores_id;
    }

    public void setProveedores_id(int Proveedores_id) {
        this.Proveedores_id = Proveedores_id;
    }

    }

