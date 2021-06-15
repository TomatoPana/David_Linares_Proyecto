package com.example.pfinal.database;

import java.sql.*;
import java.util.ArrayList;

public class Empleados {

    private int id;
    private int numero_empleado;
    private String nombre;
    private String calle;
    private String colonia;
    private String numero_casa;
    private String telefono;

    public Empleados(){
        this.id = 0;
        this.numero_empleado = 0;
        this.nombre = "";
        this.calle = "";
        this.colonia = "";
        this.numero_casa = "";
        this.telefono = "";
    }

    public Empleados(
            int id,
            int numero_empleado,
            String nombre,
            String calle,
            String colonia,
            String numero_casa,
            String telefono
    ) {
        this.id = id;
        this.numero_empleado = numero_empleado;
        this.nombre = nombre;
        this.calle = calle;
        this.colonia = colonia;
        this.numero_casa = numero_casa;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero_empleado() {
        return numero_empleado;
    }

    public void setNumero_empleado(int numero_empleado) {
        this.numero_empleado = numero_empleado;
    }

    public String getNombre() {
        return nombre;
    }

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
