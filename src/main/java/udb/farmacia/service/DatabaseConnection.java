package udb.farmacia.service;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3000/insumos";
    private static final String USER = "root";
    private static final String PASSWORD = "root1";

    static {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS InsumosMedicos ("
                    + "ID INT PRIMARY KEY AUTO_INCREMENT,"
                    + "Nombre VARCHAR(255),"
                    + "Cantidad INT,"
                    + "Precio DECIMAL(10, 2)"
                    + ")";
            connection.createStatement().execute(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
