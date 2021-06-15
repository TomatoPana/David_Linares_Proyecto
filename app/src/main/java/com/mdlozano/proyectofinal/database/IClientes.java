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

public interface IClientes {
    static Clientes getClientes(int id) {
        final AtomicReference<Clientes> resultado = new AtomicReference<>();

        Runnable task = () -> {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Clientes WHERE id = " + String.valueOf(id));

                if (resultSet.next()) {
                    resultado.set(new Clientes(
                            resultSet.getInt("id"),
                            resultSet.getInt("fecha_nacimiento"),
                            resultSet.getString("telefono"),
                            resultSet.getString("nombre"),
                            resultSet.getString("calle"),
                            resultSet.getString("colonia"),
                            resultSet.getString("numero_casa")));
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

    static ArrayList<Clientes> getClientes() {
        ArrayList<Clientes> resultado = new ArrayList<>();
        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Clientes");
                Clientes elemento;
                while (resultSet.next()) {
                    elemento = new Clientes(
                            resultSet.getInt("id"),
                            resultSet.getInt("fecha_nacimiento"),
                            resultSet.getString("telefono"),
                            resultSet.getString("nombre"),
                            resultSet.getString("calle"),
                            resultSet.getString("colonia"),
                            resultSet.getString("numero_casa"));
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

    static boolean deleteClientes(int id) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://ao9moanwus0rjiex.cbetxkdyhwsb.us-east-1.rds.amazonaws.com",
                "bn0yd5x7ks7qs247",
                "gdguphkqkfajaq3n");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("DELETE FROM Clientes WHERE id = " + String.valueOf(id));

        resultSet.deleteRow();
        return resultSet.rowDeleted();
    }

    static boolean insertClientes(Clientes elemento) {
        AtomicBoolean result = new AtomicBoolean(false);

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");

                String SQL = "INSERT INTO Clientes (fecha_nacimiento, telefono, nombre, calle, colonia, numero_caso) VALUES (?,?,?,?,?,?)";

                PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                preparedStatement.setInt(1, elemento.getFecha_nacimiento());
                preparedStatement.setString(2, elemento.getTelefono());
                preparedStatement.setString(3, elemento.getNombre());
                preparedStatement.setString(4, elemento.getCalle());
                preparedStatement.setString(5, elemento.getColonia());
                preparedStatement.setString(6, elemento.getNumero_casa());

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

    static boolean updateClientes(Clientes elemento) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://ao9moanwus0rjiex.cbetxkdyhwsb.us-east-1.rds.amazonaws.com",
                "bn0yd5x7ks7qs247",
                "gdguphkqkfajaq3n");
        Statement statement = connection.createStatement();
        String SQL = "UPDATE Clientes SET "
                + "fecha_nacimiento = " + elemento.getFecha_nacimiento()
                + "telefono = " + elemento.getTelefono()
                + "nombre = " + elemento.getNombre()
                + "calle = " + elemento.getCalle()
                + "colonia = " + elemento.getColonia()
                + "numero_casa = " + elemento.getNumero_casa()
                + "WHERE id = " + elemento.getId();

        ResultSet resultSet = statement.executeQuery(SQL);

        resultSet.updateRow();

        return resultSet.rowUpdated();
    }
}
