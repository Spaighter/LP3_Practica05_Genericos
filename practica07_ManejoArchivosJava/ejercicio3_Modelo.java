package practica07_ManejoArchivosJava;

import java.io.*;
import java.util.*;

/*
 * En esta clase manejo toda la lógica relacionada con los datos:
 * leer, guardar, buscar y eliminar empleados en el archivo.
 */
public class ejercicio3_Modelo {
    private final String archivo = "D:\\eclipse-workspace\\Practicas_LP\\empleados.txt";
    private List<ejercicio3_Empleado> empleados = new ArrayList<>();

    public ejercicio3_Modelo() {
        leerEmpleados();
    }

    // Leer empleados desde el archivo
    public void leerEmpleados() {
        empleados.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                ejercicio3_Empleado e = ejercicio3_Empleado.fromString(linea);
                if (e != null) empleados.add(e);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se creará uno nuevo al guardar.");
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        }
    }

    // Guardar todos los empleados en el archivo
    private void guardarEmpleados() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (ejercicio3_Empleado e : empleados)
                pw.println(e);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public List<ejercicio3_Empleado> getEmpleados() {
        return empleados;
    }

    public void agregarEmpleado(ejercicio3_Empleado emp) {
        for (ejercicio3_Empleado e : empleados)
            if (e.getNumero() == emp.getNumero()) {
                System.out.println("Ya existe un empleado con ese número.");
                return;
            }
        empleados.add(emp);
        guardarEmpleados();
        System.out.println("Empleado agregado correctamente.");
    }

    public ejercicio3_Empleado buscarEmpleado(int numero) {
        for (ejercicio3_Empleado e : empleados)
            if (e.getNumero() == numero)
                return e;
        return null;
    }

    public void eliminarEmpleado(int numero) {
        boolean eliminado = empleados.removeIf(e -> e.getNumero() == numero);
        if (eliminado) {
            guardarEmpleados();
            System.out.println("Empleado eliminado correctamente.");
        } else {
            System.out.println("No se encontró el empleado.");
        }
    }
}
