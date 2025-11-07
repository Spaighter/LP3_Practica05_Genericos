package Practica04;

import java.util.Scanner;

// Clase que procesa caracteres y lanza diferentes excepciones según su tipo
public class ProcesadorEntrada {

    // Método que lee un carácter del teclado
    public static char getChar(Scanner sc) {
        System.out.print("Ingrese un carácter (# para salir): ");
        return sc.next().charAt(0); // Devuelve el primer carácter leído
    }

    // Método que procesa el carácter y lanza excepciones personalizadas
    public static void procesar(char c) throws ExcepcionVocal, ExcepcionNumero, ExcepcionBlanco, ExcepcionSalida {
        if (Character.isWhitespace(c)) {
            // Si es un espacio, se lanza ExcepcionBlanco
            throw new ExcepcionBlanco("Se ingresó un espacio en blanco.");
        } else if (Character.isDigit(c)) {
            // Si es un número, se lanza ExcepcionNumero
            throw new ExcepcionNumero("Se ingresó un número.");
        } else if ("aeiouAEIOU".indexOf(c) != -1) {
            // Si es una vocal, se lanza ExcepcionVocal
            throw new ExcepcionVocal("Se ingresó una vocal.");
        } else if (c == '#') {
            // Si es el carácter de salida, se lanza ExcepcionSalida
            throw new ExcepcionSalida("Fin del programa detectado.");
        } else {
            // Si no es ninguna de las anteriores, se muestra el carácter
            System.out.println("Carácter válido ingresado: " + c);
        }
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            try {
                char caracter = getChar(sc);
                procesar(caracter);
            } catch (ExcepcionVocal | ExcepcionNumero | ExcepcionBlanco e) {
                // Captura de las tres excepciones y muestra mensaje
                System.out.println("Excepción: " + e.getMessage());
            } catch (ExcepcionSalida e) {
                // Excepción de salida: termina el bucle
                System.out.println("Excepción de salida: " + e.getMessage());
                continuar = false;
            }
        }

        System.out.println("Programa finalizado correctamente.");
        sc.close();
    }
}
