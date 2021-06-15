package com.example.pfinal.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public interface ITienen {
    static Tienen getTienen(int id) {
        final AtomicReference<Tienen> resultado = new AtomicReference<>();

        Runnable task = () -> {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Tienen WHERE id = " + String.valueOf(id));

                if (resultSet.next()) {
                    resultado.set(new Tienen(
                            resultSet.getInt("Articulos_id"),
                            resultSet.getInt("Pedidos_id")));
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

    static ArrayList<Tienen> getTienen() {
        ArrayList<Tienen> resultado = new ArrayList<>();
        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Tienen");
                Tienen elemento;
                while (resultSet.next()) {
                    elemento = new Tienen(
                            resultSet.getInt("Articulos_id"),
                            resultSet.getInt("Pedidos_id"));
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

    static boolean deleteTienen(int id) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://ao9moanwus0rjiex.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/o1nn5loiir4ca32c",
                "bn0yd5x7ks7qs247",
                "gdguphkqkfajaq3n");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("DELETE FROM Tienen WHERE id = " + String.valueOf(id));

        resultSet.deleteRow();
        return resultSet.rowDeleted();
    }

    static boolean insertTienen(Tienen elemento) {
        AtomicBoolean result = new AtomicBoolean(false);

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");

                String SQL = "INSERT INTO Tienen (Articulos_id, Pedidos_id) VALUES (?,?,?,?,?,?)";

                PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                preparedStatement.setInt(1, elemento.getArticulos_id());
                preparedStatement.setInt(2, elemento.getPedidos_id());

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

    static boolean updateTienen(Tienen elemento) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://ao9moanwus0rjiex.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/o1nn5loiir4ca32c",
                "bn0yd5x7ks7qs247",
                "gdguphkqkfajaq3n");
        Statement statement = connection.createStatement();
        String SQL = "UPDATE Tienen SET "
                + "Articulos_id = " + elemento.getArticulos_id()
                + "Pedidos_id = " + elemento.getPedidos_id();

        ResultSet resultSet = statement.executeQuery(SQL);

        resultSet.updateRow();

        return resultSet.rowUpdated();
    }
}
