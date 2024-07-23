package udb.farmacia.service;



import udb.farmacia.model.InsumoMedico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsumoMedicoService {
    public List<InsumoMedico> getAll() throws SQLException {
        List<InsumoMedico> insumos = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM InsumosMedicos";
        ResultSet rs = connection.createStatement().executeQuery(query);
        while (rs.next()) {
            InsumoMedico insumo = new InsumoMedico();
            insumo.setId(rs.getInt("ID"));
            insumo.setNombre(rs.getString("Nombre"));
            insumo.setCantidad(rs.getInt("Cantidad"));
            insumo.setPrecio(rs.getDouble("Precio"));
            insumos.add(insumo);
        }
        return insumos;
    }

    public void addInsumoMedico(InsumoMedico insumo) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO InsumosMedicos (ID, Nombre, Cantidad, Precio) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, insumo.getId());
        ps.setString(2, insumo.getNombre());
        ps.setInt(3, insumo.getCantidad());
        ps.setDouble(4, insumo.getPrecio());
        ps.executeUpdate();
    }

    public void updateInsumoMedico(InsumoMedico insumo) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "UPDATE InsumosMedicos SET Nombre = ?, Cantidad = ?, Precio = ? WHERE ID = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, insumo.getNombre());
        ps.setInt(2, insumo.getCantidad());
        ps.setDouble(3, insumo.getPrecio());
        ps.setInt(4, insumo.getId());
        ps.executeUpdate();
    }

    public void deleteInsumoMedico(int id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "DELETE FROM InsumosMedicos WHERE ID = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}