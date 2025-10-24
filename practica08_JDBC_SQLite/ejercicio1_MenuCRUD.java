package practica08_JDBC_SQLite;

import java.sql.*;
import java.util.Scanner;

/*
 * En este programa implemento un menú CRUD para gestionar los registros de una tabla
 * en una base de datos SQLite. 
 * Permito insertar, mostrar, actualizar y eliminar empleados desde la consola,
 * y antes de aplicar cualquier cambio, solicito una clave de confirmación.
 */
public class ejercicio1_MenuCRUD {

    // Dirección del archivo de base de datos SQLite
    private static final String URL = "jdbc:sqlite:basedatos_ejercicio.db";

    // Clave de confirmación para operaciones que modifican datos
    private static final String CLAVE_ADMIN = "1234";

    // Objeto para manejar la conexión con la base de datos
    private static Connection conn;

    // Scanner para leer la entrada del usuario
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // Aquí establezco la conexión con la base de datos
            conn = DriverManager.getConnection(URL);
            // Llamo al método que crea la tabla si no existe
            crearTabla();
            // Ingreso al menú principal
            menuPrincipal();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    // En este método creo un menú que permite elegir las operaciones CRUD
    private static void menuPrincipal() throws SQLException {
        int opcion;
        do {
            System.out.println("\n   MENÚ CRUD   ");
            System.out.println("1. Insertar registro");
            System.out.println("2. Mostrar registros");
            System.out.println("3. Actualizar registro");
            System.out.println("4. Eliminar registro");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpio el buffer

            switch (opcion) {
                case 1 -> insertar();
                case 2 -> mostrar();
                case 3 -> actualizar();
                case 4 -> eliminar();
                case 5 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida, intente nuevamente.");
            }
        } while (opcion != 5);
    }

    // En este método creo la tabla empleados si aún no existe
    private static void crearTabla() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS empleados (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre TEXT NOT NULL,
                    cargo TEXT NOT NULL,
                    edad INTEGER NOT NULL,
                    sueldo REAL NOT NULL
                )
                """;
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    // En este método inserto un nuevo registro en la tabla
    private static void insertar() throws SQLException {
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese cargo: ");
        String cargo = sc.nextLine();

        System.out.print("Ingrese edad: ");
        int edad = sc.nextInt();

        System.out.print("Ingrese sueldo: ");
        double sueldo = sc.nextDouble();
        sc.nextLine(); // Limpio el buffer

        // Antes de insertar, verifico la clave de confirmación
        if (confirmarClave()) {
            String sql = "INSERT INTO empleados(nombre, cargo, edad, sueldo) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nombre);
                pstmt.setString(2, cargo);
                pstmt.setInt(3, edad);
                pstmt.setDouble(4, sueldo);
                pstmt.executeUpdate();
                System.out.println("Registro insertado correctamente.");
            }
        } else {
            System.out.println("Clave incorrecta. No se realizaron cambios.");
        }
    }

    // En este método muestro todos los registros almacenados
    private static void mostrar() throws SQLException {
        String sql = "SELECT * FROM empleados";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n=== LISTA DE EMPLEADOS ===");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String cargo = rs.getString("cargo");
                int edad = rs.getInt("edad");
                double sueldo = rs.getDouble("sueldo");

                // Muestro la información de forma ordenada
                System.out.printf("%d | %s | %s | %d años | S/%.2f%n",
                        id, nombre, cargo, edad, sueldo);
            }
        }
    }

    // En este método actualizo el sueldo de un empleado específico
    private static void actualizar() throws SQLException {
        System.out.print("Ingrese ID del empleado a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nuevo sueldo: ");
        double nuevoSueldo = sc.nextDouble();
        sc.nextLine();

        // Confirmo la clave antes de aplicar la actualización
        if (confirmarClave()) {
            String sql = "UPDATE empleados SET sueldo = ? WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setDouble(1, nuevoSueldo);
                pstmt.setInt(2, id);
                int filas = pstmt.executeUpdate();

                if (filas > 0)
                    System.out.println("Registro actualizado correctamente.");
                else
                    System.out.println("No se encontró el ID especificado.");
            }
        } else {
            System.out.println("Clave incorrecta. Cambios revertidos.");
        }
    }

    // En este método elimino un registro usando el ID del empleado
    private static void eliminar() throws SQLException {
        System.out.print("Ingrese ID del empleado a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine();

        // Confirmo la clave antes de borrar
        if (confirmarClave()) {
            String sql = "DELETE FROM empleados WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                int filas = pstmt.executeUpdate();

                if (filas > 0)
                    System.out.println("Registro eliminado correctamente.");
                else
                    System.out.println("No se encontró el ID especificado.");
            }
        } else {
            System.out.println("Clave incorrecta. No se eliminó ningún registro.");
        }
    }

    // En este método pido la clave de seguridad antes de cualquier cambio
    private static boolean confirmarClave() {
        System.out.print("Ingrese la clave para confirmar cambios: ");
        String clave = sc.nextLine();
        return CLAVE_ADMIN.equals(clave);
    }
}
