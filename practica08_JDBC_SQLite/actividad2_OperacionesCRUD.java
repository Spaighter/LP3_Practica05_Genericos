package practica08_JDBC_SQLite;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * En esta clase realizo las operaciones básicas sobre la tabla productos:
 * Crear, Insertar, Leer, Actualizar y Eliminar registros.
 */
public class actividad2_OperacionesCRUD {

    public static void main(String[] args) {
        try (Connection conexion = actividad1_Conexion.conectar();
             Statement stmt = conexion.createStatement()) {

            // 1. Creo la tabla si no existe
            String crearTabla = "CREATE TABLE IF NOT EXISTS productos (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nombre TEXT NOT NULL, " +
                    "precio REAL NOT NULL)";
            stmt.execute(crearTabla);

            // 2. Inserto registros
            stmt.executeUpdate("INSERT INTO productos (nombre, precio) VALUES ('Laptop', 2500.50)");
            stmt.executeUpdate("INSERT INTO productos (nombre, precio) VALUES ('Mouse', 80.99)");
            stmt.executeUpdate("INSERT INTO productos (nombre, precio) VALUES ('Teclado', 120.75)");

            // 3. Leo los registros
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos");
            System.out.println("\n  LISTA DE PRODUCTOS  ");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("nombre") + " | " +
                                   rs.getDouble("precio"));
            }

            // 4. Actualizo un registro
            stmt.executeUpdate("UPDATE productos SET precio = 99.99 WHERE nombre = 'Mouse'");

            // 5. Borro un registro
            stmt.executeUpdate("DELETE FROM productos WHERE nombre = 'Teclado'");

            System.out.println("\nOperaciones CRUD completadas correctamente.");

        } catch (SQLException e) {
            System.out.println("Error en las operaciones CRUD: " + e.getMessage());
        }
    }
}
