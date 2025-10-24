package practica08_JDBC_SQLite;

import java.sql.*;
import java.util.*;

/*
 * En este programa implemento una clase gestora que carga los datos
 * de una tabla SQLite a una lista de objetos Empleado.
 * Luego, puedo hacer búsquedas, filtrados, ordenamientos o limitar
 * resultados directamente desde Java, sin usar consultas SQL.
 */
public class ejercicio2_GestorEmpleados {

    private static final String URL = "jdbc:sqlite:basedatos_ejercicio.db"; // Base de datos reutilizada
    private Connection conn;
    private List<Empleado> empleados; // Lista donde almaceno los objetos cargados

    public ejercicio2_GestorEmpleados() {
        empleados = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);
            cargarEmpleadosDesdeBD();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    // Método auxiliar para imprimir títulos sin símbolos
    private static void titulo(String texto) {
        System.out.println("\n   " + texto + "   ");
    }

    // Aquí cargo todos los empleados desde SQLite y los guardo en la lista
    private void cargarEmpleadosDesdeBD() throws SQLException {
        String sql = "SELECT * FROM empleados";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String cargo = rs.getString("cargo");
                int edad = rs.getInt("edad");
                double sueldo = rs.getDouble("sueldo");
                empleados.add(new Empleado(id, nombre, cargo, edad, sueldo));
            }
        }
        titulo("EMPLEADOS CARGADOS EN MEMORIA");
        System.out.println("Total de empleados: " + empleados.size());
    }

    // En este método muestro los empleados con filtros y condiciones
    public void consultar(String campoMostrar, String condicionCampo, String operador, String valorCondicion,
                          String campoOrden, boolean descendente, int limite) {

        // Empiezo con una copia de la lista original
        List<Empleado> resultado = new ArrayList<>(empleados);

        // Aplico un filtro si el usuario indicó una condición
        if (condicionCampo != null && operador != null && valorCondicion != null) {
            resultado = filtrar(resultado, condicionCampo, operador, valorCondicion);
        }

        // Ordeno la lista si el usuario lo pidió
        if (campoOrden != null) {
            ordenar(resultado, campoOrden, descendente);
        }

        // Si hay un límite de registros, aplico el tope
        if (limite > 0 && limite < resultado.size()) {
            resultado = resultado.subList(0, limite);
        }

        // Muestro los resultados con el formato correcto
        titulo("RESULTADO DE CONSULTA");
        for (Empleado emp : resultado) {
            switch (campoMostrar.toLowerCase()) {
                case "id" -> System.out.println("ID: " + emp.getId());
                case "nombre" -> System.out.println("Nombre: " + emp.getNombre());
                case "cargo" -> System.out.println("Cargo: " + emp.getCargo());
                case "edad" -> System.out.println("Edad: " + emp.getEdad());
                case "sueldo" -> System.out.println("Sueldo: " + emp.getSueldo());
                case "todo" -> System.out.println(emp);
                default -> System.out.println("Campo inválido.");
            }
        }
    }

    // Filtro los empleados según un campo, un operador y un valor
    private List<Empleado> filtrar(List<Empleado> lista, String campo, String operador, String valor) {
        List<Empleado> filtrados = new ArrayList<>();

        for (Empleado e : lista) {
            switch (campo.toLowerCase()) {
                case "nombre" -> {
                    if (operador.equals("=") && e.getNombre().equalsIgnoreCase(valor)) filtrados.add(e);
                }
                case "cargo" -> {
                    if (operador.equals("=") && e.getCargo().equalsIgnoreCase(valor)) filtrados.add(e);
                }
                case "edad" -> {
                    int v = Integer.parseInt(valor);
                    if (operador.equals(">") && e.getEdad() > v) filtrados.add(e);
                    else if (operador.equals("<") && e.getEdad() < v) filtrados.add(e);
                    else if (operador.equals("=") && e.getEdad() == v) filtrados.add(e);
                }
                case "sueldo" -> {
                    double v = Double.parseDouble(valor);
                    if (operador.equals(">") && e.getSueldo() > v) filtrados.add(e);
                    else if (operador.equals("<") && e.getSueldo() < v) filtrados.add(e);
                    else if (operador.equals("=") && e.getSueldo() == v) filtrados.add(e);
                }
            }
        }
        return filtrados;
    }

    // Ordeno los empleados de acuerdo a un campo y tipo de orden
    private void ordenar(List<Empleado> lista, String campo, boolean descendente) {
        Comparator<Empleado> comparador = switch (campo.toLowerCase()) {
            case "nombre" -> Comparator.comparing(Empleado::getNombre);
            case "cargo" -> Comparator.comparing(Empleado::getCargo);
            case "edad" -> Comparator.comparingInt(Empleado::getEdad);
            case "sueldo" -> Comparator.comparingDouble(Empleado::getSueldo);
            default -> Comparator.comparingInt(Empleado::getId);
        };
        if (descendente) comparador = comparador.reversed();
        lista.sort(comparador);
    }

    // Cierro la conexión
    public void cerrar() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    // Clase interna para representar un empleado
    public static class Empleado {
        private int id;
        private String nombre;
        private String cargo;
        private int edad;
        private double sueldo;

        public Empleado(int id, String nombre, String cargo, int edad, double sueldo) {
            this.id = id;
            this.nombre = nombre;
            this.cargo = cargo;
            this.edad = edad;
            this.sueldo = sueldo;
        }

        public int getId() { return id; }
        public String getNombre() { return nombre; }
        public String getCargo() { return cargo; }
        public int getEdad() { return edad; }
        public double getSueldo() { return sueldo; }

        @Override
        public String toString() {
            return id + " | " + nombre + " | " + cargo + " | " + edad + " años | S/ " + sueldo;
        }
    }

    // Clase main de demostración
    public static void main(String[] args) {
        ejercicio2_GestorEmpleados gestor = new ejercicio2_GestorEmpleados();

        // Ejemplo 1: mostrar todos los empleados ordenados por sueldo descendente
        gestor.consultar("todo", null, null, null, "sueldo", true, 0);

        // Ejemplo 2: mostrar empleados con sueldo mayor a 2000
        gestor.consultar("todo", "sueldo", ">", "2000", null, false, 0);

        // Ejemplo 3: mostrar solo los nombres, máximo 3 resultados
        gestor.consultar("nombre", null, null, null, "nombre", false, 3);

        gestor.cerrar();
    }
}
