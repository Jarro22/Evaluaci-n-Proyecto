package dao;

import models.Proveedor;
import config.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    public void agregarProveedor(Proveedor proveedor) {
        String query = "INSERT INTO Proveedores (nombre, contacto, telefono, direccion) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, proveedor.getNombre());
            preparedStatement.setString(2, proveedor.getContacto());
            preparedStatement.setString(3, proveedor.getTelefono());
            preparedStatement.setString(4, proveedor.getDireccion());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Proveedor> obtenerTodosLosProveedores() {
        List<Proveedor> proveedores = new ArrayList<>();
        String query = "SELECT * FROM Proveedores";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Proveedor proveedor = new Proveedor(
                        resultSet.getInt("proveedor_id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("contacto"),
                        resultSet.getString("telefono"),
                        resultSet.getString("direccion")
                );
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return proveedores;
    }

    public void actualizarProveedor(Proveedor proveedor) {
        String query = "UPDATE Proveedores SET nombre = ?, contacto = ?, telefono = ?, direccion = ? WHERE proveedor_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, proveedor.getNombre());
            preparedStatement.setString(2, proveedor.getContacto());
            preparedStatement.setString(3, proveedor.getTelefono());
            preparedStatement.setString(4, proveedor.getDireccion());
            preparedStatement.setInt(5, proveedor.getProveedorId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProveedor(int proveedorId) {
        String query = "DELETE FROM Proveedores WHERE proveedor_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, proveedorId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
