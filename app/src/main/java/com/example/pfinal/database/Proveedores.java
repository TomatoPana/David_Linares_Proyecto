package com.example.pfinal.database;



public class Proveedores {
    private int id;
    private String nombre;
    private String telefono;

    public Proveedores (){
        this.id = 0;
        this.nombre = "";
        this.telefono = "";

    }

    public Proveedores (
            int id,
            String nombre,
            String telefono
    ) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
