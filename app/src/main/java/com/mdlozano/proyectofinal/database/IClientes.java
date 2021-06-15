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
                            resultSet.getString("fecha_nacimiento"),
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
                            resultSet.getString("fecha_nacimiento"),
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

    static boolean deleteClientes(int id) {
        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {
            try {

                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://ao9moanwus0rjiex.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");

                String SQL = "DELETE FROM Clientes WHERE id = ?";

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

    static boolean insertClientes(Clientes elemento) {
        AtomicBoolean result = new AtomicBoolean(false);

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");

                String SQL = "INSERT INTO Clientes (fecha_nacimiento, telefono, nombre, calle, colonia, numero_casa) VALUES (?,?,?,?,?,?)";

                PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                preparedStatement.setString(1, elemento.getFecha_nacimiento());
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

    static boolean updateClientes(Clientes elemento) {

        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {
            try {

                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://ao9moanwus0rjiex.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");

                String SQL = "UPDATE Clientes SET fecha_nacimiento = ?, telefono = ?, nombre = ?, calle = ?, colonia = ?, numero_casa = ? WHERE id = ?";

                PreparedStatement statement = connection.prepareStatement(SQL);

                statement.setString(1, elemento.getFecha_nacimiento());
                statement.setString(3, elemento.getTelefono());
                statement.setString(2, elemento.getNombre());
                statement.setString(4, elemento.getCalle());
                statement.setString(5, elemento.getColonia());
                statement.setString(6, elemento.getNumero_casa());
                statement.setInt(7, elemento.getId());

                statement.execute();

                resultado.set(true);

                connection.close();

            } catch (Exception exception) {
                exception.printStackTrace();
                resultado.set(false);
            }
        };

        Thread thread = new Thread(task);
        thread.start();

        while (thread.isAlive()) {
        }
        ;

        return resultado.get();

    }
}