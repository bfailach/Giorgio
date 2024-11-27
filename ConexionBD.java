package giorgio;

import java.sql.*;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/logistica";
    private static final String USER = "root";  // Cambia si tienes un usuario diferente
    private static final String PASSWORD = "";  // Cambia la contraseña si es necesario

    // Establecer conexión con la base de datos
    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Cerrar la conexión con la base de datos
    public static void cerrarConexion(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
