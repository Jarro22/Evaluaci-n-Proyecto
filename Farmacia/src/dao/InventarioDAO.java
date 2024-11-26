package dao;

import models.Inventario;
import config.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAO {
    public void agregarInventario(Inventario inventario) {
        String query = "INSERT INTO Inventario (producto_id, cantidad, fecha_actualizacion) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, inventario.getProductoId());
            preparedStatement.setInt(2, inventario.getCantidad());
            preparedStatement.setDate(3, Date.valueOf(inventario.getFechaActualizacion()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Inventario> obtenerTodoElInventario() {
        List<Inventario> inventarioList = new ArrayList<>();
        String query = "SELECT * FROM Inventario";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Inventario inventario = new Inventario(
                        resultSet.getInt("inventario_id"),
                        resultSet.getInt("producto_id"),
                        resultSet.getInt("cantidad"),
                        resultSet.getDate("fecha_actualizacion").toLocalDate()
                );
                inventarioList.add(inventario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inventarioList;
    }

    public void actualizarInventario(Inventario inventario) {
        String query = "UPDATE Inventario SET producto_id = ?, cantidad = ?, fecha_actualizacion = ? WHERE inventario_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, inventario.getProductoId());
            preparedStatement.setInt(2, inventario.getCantidad());
            preparedStatement.setDate(3, Date.valueOf(inventario.getFechaActualizacion()));
            preparedStatement.setInt(4, inventario.getInventarioId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarInventario(int inventarioId) {
        String query = "DELETE FROM Inventario WHERE inventario_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, inventarioId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
