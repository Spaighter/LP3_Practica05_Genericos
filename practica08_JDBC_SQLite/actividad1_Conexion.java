package practica08_JDBC_SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * En esta clase establezco la conexión con la base de datos SQLite.
 * Si el archivo no existe, se crea automáticamente en la carpeta del proyecto.
 */
public class actividad1_Conexion {

    private static final String URL = "jdbc:sqlite:basedatos.db";

    public static Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL);
            System.out.println("Conexión establecida con la base de datos SQLite.");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
        return conexion;
    }
}
