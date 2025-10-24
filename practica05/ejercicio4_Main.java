package practica05;

/*
 * Clase principal de prueba para los ejercicios 3 y 4.
 * Demuestra el uso de las clases ejercicio1_Par y ejercicio3_Contenedor.
 */
public class ejercicio4_Main {

    // Método genérico que imprime un par recibido por parámetro
    public static <F, S> void imprimirPar(ejercicio1_Par<F, S> par) {
        System.out.println(par);
    }

    public static void main(String[] args) {

        System.out.println("Prueba de las clases ejercicio1_Par y ejercicio3_Contenedor");
        System.out.println("\n");

        // Crea objetos de tipo ejercicio1_Par con distintos tipos
        ejercicio1_Par<String, Integer> par1 = new ejercicio1_Par<>("Edad", 25);
        ejercicio1_Par<String, Double> par2 = new ejercicio1_Par<>("Altura", 1.80);
        ejercicio1_Par<String, Boolean> par3 = new ejercicio1_Par<>("Estudiante", true);

        // Muestra los pares utilizando el método genérico imprimirPar()
        System.out.println("Mostrando pares individuales:");
        imprimirPar(par1);
        imprimirPar(par2);
        imprimirPar(par3);

        // Crea un contenedor para almacenar varios pares
        ejercicio3_Contenedor<String, Integer> contenedor = new ejercicio3_Contenedor<>();
        contenedor.agregarPar("Edad", 25);
        contenedor.agregarPar("Año de Nacimiento", 1999);
        contenedor.agregarPar("Horas de Estudio", 6);

        // Muestra el contenido del contenedor
        System.out.println("\nContenido del contenedor:");
        contenedor.mostrarPares();
    }
}
