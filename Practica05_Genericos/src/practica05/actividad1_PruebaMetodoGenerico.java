package practica05;

public class actividad1_PruebaMetodoGenerico {

    // Versión simple
    public static <E> void imprimirArreglo(E[] arregloEntrada) {
        for (E elemento : arregloEntrada)
            System.out.printf("%s ", elemento);
        System.out.println();
    }

    // Versión sobrecargada con subíndices y validación
    public static <E> int imprimirArreglo(E[] arregloEntrada, int subInferior, int subSuperior) {
        if (subInferior < 0 || subSuperior > arregloEntrada.length || subSuperior <= subInferior) {
            throw new actividad1_InvalidSubscriptException(
                    "Índices inválidos: deben estar dentro del rango y subSuperior > subInferior.");
        }

        int contador = 0;
        for (int i = subInferior; i < subSuperior; i++) {
            System.out.printf("%s ", arregloEntrada[i]);
            contador++;
        }
        System.out.println();
        return contador;
    }

    public static void main(String[] args) {
        Integer[] arregloInteger = {1, 2, 3, 4, 5, 6};
        Double[] arregloDouble = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] arregloCharacter = {'H', 'O', 'L', 'A'};

        System.out.println("El arreglo Integer contiene:");
        imprimirArreglo(arregloInteger);

        System.out.println("\nEl arreglo Double contiene:");
        imprimirArreglo(arregloDouble);

        System.out.println("\nEl arreglo Character contiene:");
        imprimirArreglo(arregloCharacter);

        // Prueba sobrecargada válida
        try {
            System.out.println("\nParte del arreglo Integer (índices 2 a 5):");
            int cantidad = imprimirArreglo(arregloInteger, 2, 5);
            System.out.printf("Se imprimieron %d elementos.\n", cantidad);
        } catch (actividad1_InvalidSubscriptException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Prueba con error
        try {
            imprimirArreglo(arregloInteger, -1, 3);
        } catch (actividad1_InvalidSubscriptException e) {
            System.err.println("Excepción capturada: " + e.getMessage());
        }
    }
}
