package practica05;

/*
 * Clase de prueba para la clase ejercicio1_Par.
 * Se crean objetos Par con distintos tipos de datos
 * y se verifica el funcionamiento del método esIgual().
 */
public class ejercicio2_PruebaPar {
    public static void main(String[] args) {

        System.out.println("Prueba de la clase ejercicio1_Par");
        System.out.println("----------------------------------");

        // Crea tres pares con distintos tipos de datos
        ejercicio1_Par<String, Integer> par1 = new ejercicio1_Par<>("Edad", 25);
        ejercicio1_Par<String, Integer> par2 = new ejercicio1_Par<>("Edad", 25);
        ejercicio1_Par<String, Double> par3 = new ejercicio1_Par<>("Peso", 70.5);

        // Muestra los pares creados
        System.out.println(par1);
        System.out.println(par2);
        System.out.println(par3);

        // Compara par1 y par2 (deben ser iguales)
        System.out.println("\n¿par1 es igual a par2? " + par1.esIgual(par2));

        // Modifica los valores de par2 y los muestra nuevamente
        par2.setPrimero("Altura");
        par2.setSegundo(180);
        System.out.println("\nPar2 modificado:\n " + par2);
    }
}
