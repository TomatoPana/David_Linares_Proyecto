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

public interface IPedidos {
    static Pedidos getPedidos(int id) {
        final AtomicReference<Pedidos> resultado = new AtomicReference<>();

        Runnable task = () -> {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Pedidos WHERE id = " + String.valueOf(id));

                if (resultSet.next()) {
                    resultado.set(new Pedidos(
                            resultSet.getInt("id"),
                            resultSet.getString("fecha_compra"),
                            resultSet.getFloat("precio"),
                            resultSet.getString("fecha_entrega"),
                            resultSet.getInt("Clientes_id")));
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

    static ArrayList<Pedidos> getPedidos() {
        ArrayList<Pedidos> resultado = new ArrayList<>();
        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Pedidos");
                Pedidos elemento;
                while (resultSet.next()) {
                    elemento = new Pedidos(
                            resultSet.getInt("id"),
                            resultSet.getString("fecha_compra"),
                            resultSet.getFloat("precio"),
                            resultSet.getString("fecha_entrega"),
                            resultSet.getInt("Clientes_id"));
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

    static boolean deletePedidos(int id) {
        AtomicBoolean result = new AtomicBoolean(false);

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");

                String SQL = "DELETE FROM Pedidos WHERE id = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                preparedStatement.setInt(1, id);

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

    static boolean insertPedidos(Pedidos elemento) {
        AtomicBoolean result = new AtomicBoolean(false);

        Runnable task = () -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://23.21.99.28/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");

                String SQL = "INSERT INTO Pedidos (fecha_compra, precio, fecha_entrega, Clientes_id) VALUES (?,?,?,?,?,?)";

                PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                preparedStatement.setString(1, elemento.getFecha_compra());
                preparedStatement.setFloat(2, elemento.getPrecio());
                preparedStatement.setString(3, elemento.getFecha_entrega());
                preparedStatement.setInt(4, elemento.getClientes_id());

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

    static boolean updatePedidos(Pedidos elemento) {
        AtomicBoolean resultado = new AtomicBoolean(false);

        Runnable task = () -> {
            try {

                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://ao9moanwus0rjiex.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/o1nn5loiir4ca32c",
                        "bn0yd5x7ks7qs247",
                        "gdguphkqkfajaq3n");

                String SQL = "UPDATE Pedidos SET fecha_compra = ?, precio = ?, fecha_entrega = ?, Clientes_id = ? WHERE id = ?";

                PreparedStatement statement = connection.prepareStatement(SQL);

                statement.setString(1, elemento.getFecha_compra());
                statement.setFloat(2, elemento.getPrecio());
                statement.setString(3, elemento.getFecha_entrega());
                statement.setInt(4, elemento.getClientes_id());
                statement.setInt(5, elemento.getId());

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
