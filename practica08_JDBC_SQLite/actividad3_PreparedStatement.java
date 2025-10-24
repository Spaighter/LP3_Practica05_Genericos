package practica08_JDBC_SQLite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * En esta clase muestro cómo usar PreparedStatement para evitar inyecciones SQL
 * y mejorar el rendimiento de las consultas.
 */
public class actividad3_PreparedStatement {

    public static void main(String[] args) {
        try (Connection conexion = actividad1_Conexion.conectar()) {

            // Inserto un nuevo producto usando PreparedStatement
            String insertar = "INSERT INTO productos (nombre, precio) VALUES (?, ?)";
            PreparedStatement psInsert = conexion.prepareStatement(insertar);
            psInsert.setString(1, "Monitor");
            psInsert.setDouble(2, 899.90);
            psInsert.executeUpdate();

            // Recupero los productos
            String seleccionar = "SELECT * FROM productos WHERE precio > ?";
            PreparedStatement psSelect = conexion.prepareStatement(seleccionar);
            psSelect.setDouble(1, 100);
            ResultSet rs = psSelect.executeQuery();

            System.out.println("\n  PRODUCTOS CON PRECIO > 100  ");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("nombre") + " | " +
                                   rs.getDouble("precio"));
            }

        } catch (SQLException e) {
            System.out.println("Error en el uso de PreparedStatement: " + e.getMessage());
        }
    }
}
