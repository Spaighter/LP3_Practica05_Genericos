package practica07_ManejoArchivosJava;

/*
 * En esta clase represento a un empleado.
 * Contiene sus atributos, constructor y método toString para mostrarlo.
 */
public class ejercicio3_Empleado {
    private int numero;
    private String nombre;
    private double sueldo;

    public ejercicio3_Empleado(int numero, String nombre, double sueldo) {
        this.numero = numero;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public int getNumero() { return numero; }
    public String getNombre() { return nombre; }
    public double getSueldo() { return sueldo; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }

    @Override
    public String toString() {
        return numero + "," + nombre + "," + sueldo;
    }

    public static ejercicio3_Empleado fromString(String linea) {
        String[] partes = linea.split(",");
        if (partes.length != 3) return null;
        int numero = Integer.parseInt(partes[0]);
        String nombre = partes[1];
        double sueldo = Double.parseDouble(partes[2]);
        return new ejercicio3_Empleado(numero, nombre, sueldo);
    }
}
