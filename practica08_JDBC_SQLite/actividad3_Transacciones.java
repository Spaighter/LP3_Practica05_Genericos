package practica08_JDBC_SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * En esta actividad muestro cómo manejar transacciones en JDBC.
 * Aquí realizo varias operaciones (INSERT, UPDATE y DELETE) dentro de una transacción.
 * Si ocurre un error, hago rollback para revertir los cambios.
 */
public class actividad3_Transacciones {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:basedatos.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Conexión establecida con la base de datos.");

                // Desactivo el autocommit para controlar la transacción manualmente
                conn.setAutoCommit(false);

                try {
                    // Inserto nuevos productos
                    insertarProducto(conn, "Tablet", 600.0);
                    insertarProducto(conn, "Cámara", 1200.0);

                    // Actualizo el precio de un producto existente
                    actualizarPrecio(conn, "Laptop", 2400.0);

                    // Borro un producto
                    eliminarProducto(conn, "Mouse");

                    // Si todo salió bien, confirmo la transacción
                    conn.commit();
                    System.out.println("\nTransacción completada correctamente.");
                } catch (SQLException e) {
                    // Si ocurre un error, revierto los cambios
                    System.out.println("\nError durante la transacción: " + e.getMessage());
                    conn.rollback();
                    System.out.println("Se revirtieron los cambios (rollback).");
                } finally {
                    // Reactivo el autocommit
                    conn.setAutoCommit(true);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }

    // Inserta un producto en la base de datos
    private static void insertarProducto(Connection conn, String nombre, double precio) throws SQLException {
        String sql = "INSERT INTO productos(nombre, precio) VALUES(?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setDouble(2, precio);
            pstmt.executeUpdate();
            System.out.println("Insertado: " + nombre);
        }
    }

    // Actualiza el precio de un producto existente
    private static void actualizarPrecio(Connection conn, String nombre, double nuevoPrecio) throws SQLException {
        String sql = "UPDATE productos SET precio = ? WHERE nombre = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, nuevoPrecio);
            pstmt.setString(2, nombre);
            int filas = pstmt.executeUpdate();

            if (filas > 0)
                System.out.println("Precio actualizado para: " + nombre);
            else
                System.out.println("No se encontró el producto: " + nombre);
        }
    }

    // Elimina un producto por nombre
    private static void eliminarProducto(Connection conn, String nombre) throws SQLException {
        String sql = "DELETE FROM productos WHERE nombre = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            int filas = pstmt.executeUpdate();

            if (filas > 0)
                System.out.println("Producto eliminado: " + nombre);
            else
                System.out.println("No se encontró el producto para eliminar: " + nombre);
        }
    }
}
