package practica08_JDBC_SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * En esta actividad uso la interfaz PreparedStatement para realizar consultas seguras
 * con parámetros en una base de datos SQLite. 
 * Me aseguro de evitar inyecciones SQL y optimizar las consultas.
 */
public class actividad2_PreparedStatement {

    public static void main(String[] args) {
        // Ruta de la base de datos (usamos la misma que en el ejercicio anterior)
        String url = "jdbc:sqlite:basedatos.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Conexión establecida con la base de datos.\n");

                // Inserto un nuevo producto con PreparedStatement
                insertarProducto(conn, "Monitor", 899.99);

                // Consulto productos con precio mayor a un valor ingresado
                double precioMinimo = 100.0;
                mostrarProductosPorPrecio(conn, precioMinimo);

                // Actualizo un producto con parámetros
                actualizarPrecio(conn, "Mouse", 95.50);

                // Elimino un producto usando parámetro
                eliminarProducto(conn, "Teclado");
            }

        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
    }

    // Inserto un producto usando parámetros
    private static void insertarProducto(Connection conn, String nombre, double precio) {
        String sql = "INSERT INTO productos(nombre, precio) VALUES(?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setDouble(2, precio);
            pstmt.executeUpdate();
            System.out.println("Producto insertado: " + nombre);
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    // Muestro los productos con precio mayor a cierto valor
    private static void mostrarProductosPorPrecio(Connection conn, double precioMinimo) {
        String sql = "SELECT * FROM productos WHERE precio > ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, precioMinimo);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n=== PRODUCTOS CON PRECIO MAYOR A " + precioMinimo + " ===");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("nombre") + " | " + rs.getDouble("precio"));
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }

    // Actualizo el precio de un producto
    private static void actualizarPrecio(Connection conn, String nombre, double nuevoPrecio) {
        String sql = "UPDATE productos SET precio = ? WHERE nombre = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, nuevoPrecio);
            pstmt.setString(2, nombre);
            int filas = pstmt.executeUpdate();

            if (filas > 0) {
                System.out.println("\nPrecio actualizado para: " + nombre);
            } else {
                System.out.println("\nNo se encontró el producto: " + nombre);
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    // Elimino un producto por nombre
    private static void eliminarProducto(Connection conn, String nombre) {
        String sql = "DELETE FROM productos WHERE nombre = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            int filas = pstmt.executeUpdate();

            if (filas > 0) {
                System.out.println("\nProducto eliminado: " + nombre);
            } else {
                System.out.println("\nNo se encontró el producto para eliminar: " + nombre);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
