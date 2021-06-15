package com.example.pfinal.database;

public class Clientes {
    private int id;
    private String fecha_nacimiento;
    private String telefono;
    private String nombre;
    private String calle;
    private String colonia;
    private String numero_casa;

    public Clientes(){
        this.id = 0;
        this.fecha_nacimiento = "";
        this.telefono = "";
        this.nombre = "";
        this.calle = "";
        this.colonia = "";
        this.numero_casa = "";

    }

    public Clientes(
            int id,
            String fecha_nacimiento,
            String telefono,
            String nombre,
            String calle,
            String colonia,
            String numero_casa
    ) {
        this.id = id;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.nombre = nombre;
        this.calle = calle;
        this.colonia = colonia;
        this.numero_casa = numero_casa;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) { this.fecha_nacimiento = fecha_nacimiento; }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumero_casa() {
        return numero_casa;
    }

    public void setNumero_casa(String numero_casa) {
        this.numero_casa = numero_casa;
    }

}
