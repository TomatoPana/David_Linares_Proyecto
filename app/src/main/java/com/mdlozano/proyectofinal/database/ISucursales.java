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

public interface ISucursales {
    static Sucursales getSucursales(int id) {
        final AtomicReference<Sucursales> resultado = new AtomicReference<>();

        Runnable task = () -> {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Sucursales WHERE id = " + String.valueOf(id));

                if (resultSet.next()) {
                    resultado.set(new Sucursales(
                            resultSet.getInt("id"),
                            resultSet.getString("rfc"),
                            resultSet.getString("calle"),
                            resultSet.getString("numero"),
                            resultSet.getString("colonia"),
                            resultSet.getString("telefono")));
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

    static ArrayList<Sucursales> getSucursales() {
        ArrayList<Sucursales> resultado = new ArrayList<>();
        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Sucursales");
                Sucursales elemento;
                while (resultSet.next()) {
                    elemento = new Sucursales(
                            resultSet.getInt("id"),
                            resultSet.getString("rfc"),
                            resultSet.getString("calle"),
                            resultSet.getString("numero"),
                            resultSet.getString("colonia"),
                            resultSet.getString("telefono"));
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

    static boolean deleteSucursales(int id) {
        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {
            try {

                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://ao9moanwus0rjiex.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");

                String SQL = "DELETE FROM Sucursales WHERE id = ?";

                PreparedStatement statement = connection.prepareStatement(SQL);

                statement.setInt(1, id);

                statement.execute();

                resultado.set(true);

                connection.close();

            } catch (Exception exception){
                exception.printStackTrace();
                resultado.set(false);
            }
        };

        Thread thread = new Thread(task);
        thread.start();

        while(thread.isAlive()){};

        return resultado.get();
    }

    static boolean insertSucursales(Sucursales elemento) {
        AtomicBoolean result = new AtomicBoolean(false);

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");

                String SQL = "INSERT INTO Sucursales (rfc, calle, numero, colonia, telefono) VALUES (?,?,?,?,?,?)";

                PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                preparedStatement.setString(1, elemento.getRfc());
                preparedStatement.setString(2, elemento.getCalle());
                preparedStatement.setString(3, elemento.getNumero());
                preparedStatement.setString(4, elemento.getColonia());
                preparedStatement.setString(5, elemento.getTelefono());


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

    static boolean updateSucursales(Sucursales elemento) {

        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {
            try {

                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://ao9moanwus0rjiex.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");

                String SQL = "UPDATE Sucursales SET rfc = ?, calle = ?, numero = ?, colonia = ?, telefono = ? WHERE id = ?";

                PreparedStatement statement = connection.prepareStatement(SQL);

                statement.setString(1, elemento.getRfc());
                statement.setString(2, elemento.getCalle());
                statement.setString(3, elemento.getNumero());
                statement.setString(4, elemento.getColonia());
                statement.setString(5, elemento.getTelefono());
                statement.setInt(6, elemento.getId());

                statement.execute();

                resultado.set(true);

                connection.close();

            } catch (Exception exception){
                exception.printStackTrace();
                resultado.set(false);
            }
        };

        Thread thread = new Thread(task);
        thread.start();

        while(thread.isAlive()){};

        return resultado.get();
    }
}
