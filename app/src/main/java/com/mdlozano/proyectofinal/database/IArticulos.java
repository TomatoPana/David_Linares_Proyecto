package com.mdlozano.proyectofinal.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public interface IArticulos {
    static Articulos getArticulos(int id) {
        final AtomicReference<Articulos> resultado = new AtomicReference<>();

        Runnable task = () -> {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Articulos WHERE id = " + String.valueOf(id));

                if (resultSet.next()) {
                    resultado.set(new Articulos(
                            resultSet.getInt("id"),
                            resultSet.getString("clave_producto"),
                            resultSet.getString("nombre"),
                            resultSet.getString("precio"),
                            resultSet.getString("descripcion"),
                            resultSet.getInt("Proveedores_id")));
                } else {
                    resultado.set(null);
                }
                connection.close();
            } catch (Exception exception) {
                resultado.set(null);
                exception.printStackTrace();
            }

        };

        Thread thread = new Thread(task);
        thread.start();

        while(thread.isAlive()){};

        return resultado.get();
    }
    static ArrayList<Articulos> getArticulos() {
        ArrayList<Articulos> resultado = new ArrayList<>();
        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Articulos");
                Articulos elemento;
                while (resultSet.next()) {
                    elemento = new Articulos(
                            resultSet.getInt("id"),
                            resultSet.getString("clave_producto"),
                            resultSet.getString("nombre"),
                            resultSet.getString("precio"),
                            resultSet.getString("descripcion"),
                            resultSet.getInt("Proveedores_id"));
                    resultado.add(elemento);
                }
                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        };

        Thread thread = new Thread(task);
        thread.start();

        while(thread.isAlive()){};

        return resultado;

    };

    static boolean deleteArticulos(int id) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://ao9moanwus0rjiex.cbetxkdyhwsb.us-east-1.rds.amazonaws.com",
                "bn0yd5x7ks7qs247",
                "gdguphkqkfajaq3n");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("DELETE FROM Articulos WHERE id = " + String.valueOf(id));

        resultSet.deleteRow();
        return resultSet.rowDeleted();
    }

    static boolean insertArticulos(Articulos elemento) {
        AtomicBoolean result = new AtomicBoolean(false);

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");

                String SQL = "INSERT INTO Articulos (clave_producto, nombre, precio, descripcion, Provedoores_id) VALUES (?,?,?,?,?,?)";

                PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                preparedStatement.setString(1, elemento.getClave_producto());
                preparedStatement.setString(2, elemento.getNombre());
                preparedStatement.setString(3, elemento.getPrecio());
                preparedStatement.setString(4, elemento.getDescripcion());
                preparedStatement.setInt(5, elemento.getProveedores_id());

                preparedStatement.execute();



                result.set(true);

                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
                result.set(false);
            }
        };

        Thread thread = new Thread(task);
        thread.start();

        while(thread.isAlive()){};

        return result.get();

    }

    static boolean updateArticulos(Articulos elemento) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://ao9moanwus0rjiex.cbetxkdyhwsb.us-east-1.rds.amazonaws.com",
                "bn0yd5x7ks7qs247",
                "gdguphkqkfajaq3n");
        Statement statement = connection.createStatement();
        String SQL = "UPDATE Articulos SET "
                + "clave_producto = " + elemento.getClave_producto()
                + "nombre = " + elemento.getNombre()
                + "precio = " + elemento.getPrecio()
                + "descripcion = " + elemento.getDescripcion()
                + "Provedoores = " + elemento.getProveedores_id()
                + "WHERE id = " + elemento.getId();

        ResultSet resultSet = statement.executeQuery(SQL);

        resultSet.updateRow();

        return resultSet.rowUpdated();
    }
}
