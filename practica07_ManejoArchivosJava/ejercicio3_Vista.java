package practica07_ManejoArchivosJava;

import java.util.List;
import java.util.Scanner;

/*
 * En esta clase manejo toda la interacción con el usuario.
 * Muestro menús, mensajes y leo entradas por consola.
 */
public class ejercicio3_Vista {
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n  MENÚ DE EMPLEADOS  ");
        System.out.println("1. Listar todos los empleados");
        System.out.println("2. Agregar un nuevo empleado");
        System.out.println("3. Buscar empleado por número");
        System.out.println("4. Eliminar empleado por número");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public int leerOpcion() {
        return sc.nextInt();
    }

    public ejercicio3_Empleado leerEmpleado() {
        System.out.print("Número: ");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Sueldo: ");
        double sueldo = sc.nextDouble();
        return new ejercicio3_Empleado(numero, nombre, sueldo);
    }

    public int leerNumeroEmpleado() {
        System.out.print("Introduce el número del empleado: ");
        return sc.nextInt();
    }

    public void mostrarEmpleados(List<ejercicio3_Empleado> empleados) {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("\n=== LISTA DE EMPLEADOS ===");
            for (ejercicio3_Empleado e : empleados)
                System.out.println(e);
        }
    }

    public void mostrarEmpleado(ejercicio3_Empleado e) {
        if (e != null)
            System.out.println("Empleado encontrado: " + e);
        else
            System.out.println("Empleado no encontrado.");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
