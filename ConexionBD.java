package giorgio;

import java.sql.*;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/logistica";
    private static final String USER = "root";  
    private static final String PASSWORD = "";  

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void cerrarConexion(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
