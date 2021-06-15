package com.example.pfinal.database;

public class Dependen {

    private int Empleados_id;
    private int Sucursales_id;

    public Dependen (){
        this.Empleados_id = 0;
        this.Sucursales_id = 0;

    }

    public Dependen (
            int Empleados_id,
            int Sucursales_id
    ) {

        this.Empleados_id = Empleados_id;
        this.Sucursales_id = Sucursales_id;
    }

    public int getEmpleados_id() {
        return Empleados_id;
    }

    public void setEmpleados_id(int Empleados_id) {
        this.Empleados_id = Empleados_id;
    }

    public int getSucursales_id() {
        return Sucursales_id;
    }

    public void setSucursales_id(int Sucursales_id) {
        this.Sucursales_id = Sucursales_id;
    }
}
