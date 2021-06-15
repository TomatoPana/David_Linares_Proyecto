package com.example.pfinal.database;

public class Sucursales {
    private int id;
    private String rfc;
    private String calle;
    private String numero;
    private String colonia;
    private String telefono;

    public Sucursales() {
        this.id = 0;
        this.rfc = "";
        this.calle = "";
        this.numero = "";
        this.colonia = "";
        this.telefono = "";
    }

    public Sucursales(int id, String rfc, String calle, String numero, String colonia, String telefono) {
        this.id = id;
        this.rfc = rfc;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
