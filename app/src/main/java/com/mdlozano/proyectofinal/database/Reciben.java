package com.mdlozano.proyectofinal.database;

public class Reciben {
    private int Sucursales_id;
    private int Articulos_id;


    public Reciben (){
        this.Sucursales_id = 0;
        this.Articulos_id = 0;

    }

    public Reciben (
            int Sucursales_id,
            int Articulos_id

    ) {
        this.Sucursales_id = Sucursales_id;
        this.Articulos_id = Articulos_id;

    }

    public int getSucursales_id() {
        return Sucursales_id;
    }

    public void setSucursales_id(int Sucursales_id) {
        this.Sucursales_id = Sucursales_id;
    }

    public int getArticulos_id() {
        return Articulos_id;
    }

    public void setArticulos_id(int Articulos_id) {
        this.Articulos_id = Articulos_id;
    }
}
