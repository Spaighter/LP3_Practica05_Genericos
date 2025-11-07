package Practica03;

// Interfaz para dispositivos que pueden imprimir
interface Impresion {
    void imprimir();
}

// Interfaz para dispositivos que pueden escanear
interface Escaneo {
    void escanear();
}

// Clase que representa una impresora básica (solo imprime)
class ImpresoraBasica implements Impresion {
    public void imprimir() {
        System.out.println("Imprimiendo documento en impresora básica...");
    }
}

// Clase que representa una multifuncional (imprime y escanea)
class ImpresoraMultifuncional implements Impresion, Escaneo {
    public void imprimir() {
        System.out.println("Imprimiendo documento desde multifuncional...");
    }

    public void escanear() {
        System.out.println("Escaneando documento desde multifuncional...");
    }
}

// Clase principal para probar el funcionamiento
public class Ejercicio04_ISP {
    public static void main(String[] args) {
        // La impresora básica solo usa la interfaz Impresion
        ImpresoraBasica impresora = new ImpresoraBasica();
        impresora.imprimir();

        // La multifuncional usa ambas interfaces
        ImpresoraMultifuncional multifuncional = new ImpresoraMultifuncional();
        multifuncional.imprimir();
        multifuncional.escanear();
    }
}
