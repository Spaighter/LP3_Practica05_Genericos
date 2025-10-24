package practica05;

public class actividad2_PruebaPila {
    public static void main(String[] args) {
        System.out.println("Prueba de Pila Genérica\n");

        actividad2_Pila<Integer> pila1 = new actividad2_Pila<>(5);
        actividad2_Pila<Integer> pila2 = new actividad2_Pila<>(5);

        try {
            pila1.push(10);
            pila1.push(20);
            pila1.push(30);

            pila2.push(10);
            pila2.push(20);
            pila2.push(30);

            System.out.println("¿pila1 contiene 20? " + pila1.contains(20));
            System.out.println("Elemento retirado de pila1: " + pila1.pop());
            System.out.println("¿pila1 contiene 30? " + pila1.contains(30));
            System.out.println("¿pila1 es igual a pila2? " + pila1.esIgual(pila2));

        } catch (RuntimeException e) {
            System.err.println("⚠️ Error: " + e.getMessage());
        }
    }
}
