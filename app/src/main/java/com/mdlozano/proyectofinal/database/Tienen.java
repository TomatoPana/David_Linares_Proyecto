package com.mdlozano.proyectofinal.database;

public class Tienen {
    private int Articulos_id;
    private int Pedidos_id;

    public Tienen (){
        this.Articulos_id = 0;
        this.Pedidos_id = 0;

    }

    public Tienen (
            int Articulos_id,
            int Pedidos_id
    ) {
        this.Articulos_id = Articulos_id;
        this.Pedidos_id = Pedidos_id;
    }

    public int getArticulos_id() { return Articulos_id; }

    public void setArticulos_id(int Articulos_id) {
        this.Articulos_id = Articulos_id;
    }

    public int getPedidos_id() {
        return getPedidos_id();
    }

    public void setPedidos_id(int Pedidos_id) {
        this.Pedidos_id = Pedidos_id;
    }
}
