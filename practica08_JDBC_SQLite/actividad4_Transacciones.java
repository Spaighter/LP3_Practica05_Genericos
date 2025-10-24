package practica08_JDBC_SQLite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * En esta clase demuestro el manejo de transacciones con JDBC.
 * Si ocurre un error, hago un rollback para mantener la integridad de los datos.
 */
public class actividad4_Transacciones {

    public static void main(String[] args) {
        try (Connection conexion = actividad1_Conexion.conectar()) {
            conexion.setAutoCommit(false); // Desactivo el autocommit

            String insertar = "INSERT INTO productos (nombre, precio) VALUES (?, ?)";
            PreparedStatement ps = conexion.prepareStatement(insertar);

            ps.setString(1, "Tablet");
            ps.setDouble(2, 1500.0);
            ps.executeUpdate();

            ps.setString(1, "Auriculares");
            ps.setDouble(2, 400.0);
            ps.executeUpdate();

            // Simulo un error para probar rollback
            if (true) throw new SQLException("Error simulado en la transacción.");

            conexion.commit();
            System.out.println("Transacción completada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error en la transacción: " + e.getMessage());
            try (Connection conexion = actividad1_Conexion.conectar()) {
                conexion.rollback();
                System.out.println("Se realizó rollback correctamente.");
            } catch (SQLException ex) {
                System.out.println("Error al hacer rollback: " + ex.getMessage());
            }
        }
    }
}
