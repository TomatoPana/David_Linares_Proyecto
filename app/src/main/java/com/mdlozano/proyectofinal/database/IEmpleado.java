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

public interface IEmpleado {
    static Empleados getEmpleado(int id) {
        final AtomicReference<Empleados> resultado = new AtomicReference<>();

        Runnable task = () -> {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Empleados WHERE id = " + String.valueOf(id));

                if (resultSet.next()) {
                    resultado.set(new Empleados(
                            resultSet.getInt("id"),
                            resultSet.getInt("numero_empleado"),
                            resultSet.getString("nombre"),
                            resultSet.getString("calle"),
                            resultSet.getString("colonia"),
                            resultSet.getString("numero_casa"),
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

    static ArrayList<Empleados> getEmpleados() {
        ArrayList<Empleados> resultado = new ArrayList<>();
        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Empleados");
                Empleados elemento;
                while (resultSet.next()) {
                    elemento = new Empleados(
                            resultSet.getInt("id"),
                            resultSet.getInt("numero_empleado"),
                            resultSet.getString("nombre"),
                            resultSet.getString("calle"),
                            resultSet.getString("colonia"),
                            resultSet.getString("numero_casa"),
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

    static boolean deleteEmpleado(int id) {
        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {
            try {

                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://ao9moanwus0rjiex.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");

                String SQL = "DELETE FROM Empleados WHERE id = ?";

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

    static boolean insertEmpleado(Empleados elemento) {
        AtomicBoolean result = new AtomicBoolean(false);

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");

                String SQL = "INSERT INTO Empleados (numero_empleado, nombre, calle, colonia, numero_casa, telefono) VALUES (?,?,?,?,?,?)";

                PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                preparedStatement.setInt(1, elemento.getNumero_empleado());
                preparedStatement.setString(2, elemento.getNombre());
                preparedStatement.setString(3, elemento.getCalle());
                preparedStatement.setString(4, elemento.getColonia());
                preparedStatement.setString(5, elemento.getNumero_casa());
                preparedStatement.setString(6, elemento.getTelefono());

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

    static boolean updateEmpleado(Empleados elemento) {

        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {
            try {

                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://ao9moanwus0rjiex.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");

                String SQL = "UPDATE Empleados SET numero_empleado = ?, nombre = ?, calle = ?, colonia = ?, numero_casa = ?, telefono = ? WHERE id = ?";

                PreparedStatement statement = connection.prepareStatement(SQL);

                statement.setInt(1, elemento.getNumero_empleado());
                statement.setString(2, elemento.getNombre());
                statement.setString(3, elemento.getCalle());
                statement.setString(4, elemento.getColonia());
                statement.setString(5, elemento.getNumero_casa());
                statement.setString(6, elemento.getTelefono());
                statement.setInt(7, elemento.getId());

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