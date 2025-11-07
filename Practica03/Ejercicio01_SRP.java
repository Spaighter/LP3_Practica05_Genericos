package Practica03;

// Clase que representa los datos de un empleado
class Empleado {
    private String nombre;
    private double salarioBase;
    private int horasExtras;

    // Constructor que inicializa los atributos
    public Empleado(String nombre, double salarioBase, int horasExtras) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.horasExtras = horasExtras;
    }

    // Devuelve el nombre del empleado
    public String getNombre() {
        return nombre;
    }

    // Devuelve el salario base
    public double getSalarioBase() {
        return salarioBase;
    }

    // Devuelve la cantidad de horas extras trabajadas
    public int getHorasExtras() {
        return horasExtras;
    }
}

// Clase separada con la única responsabilidad de calcular el pago (cumple SRP)
class CalculadoraPago {
    private static final double TARIFA_HORA_EXTRA = 12.5; // Valor fijo por hora extra

    // Método que calcula el pago total de un empleado
    public double calcularPago(Empleado e) {
        // Calcula el pago adicional por horas extras
        double pagoExtras = e.getHorasExtras() * TARIFA_HORA_EXTRA;

        // Retorna el total sumando salario base + pago extra
        return e.getSalarioBase() + pagoExtras;
    }
}

// Clase principal que prueba el funcionamiento
public class Ejercicio01_SRP {
    public static void main(String[] args) {
        // Se crea un empleado con nombre, salario base y horas extras
        Empleado emp = new Empleado("Michael Arroyo", 1800, 10);

        // Se crea el objeto calculadora que manejará los cálculos
        CalculadoraPago calculadora = new CalculadoraPago();

        // Se calcula el pago total usando la calculadora
        double pagoTotal = calculadora.calcularPago(emp);

        // Se muestran los resultados
        System.out.println("Empleado: " + emp.getNombre());
        System.out.println("Pago total del mes: S/ " + pagoTotal);
    }
}
