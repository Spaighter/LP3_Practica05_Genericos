package practica05;

public class actividad4_Main {

    public static <F, S> void imprimirPar(actividad4_Par<F, S> par) {
        System.out.println(par);
    }

    public static void main(String[] args) {
        System.out.println("Prueba de clase Par: ");
        actividad4_Par<String, Integer> par1 = new actividad4_Par<>("Edad", 25);
        actividad4_Par<String, Integer> par2 = new actividad4_Par<>("Edad", 25);
        actividad4_Par<Double, Boolean> par3 = new actividad4_Par<>(4.5, true);

        imprimirPar(par1);
        System.out.println("¿par1 es igual a par2? " + par1.esIgual(par2));
        System.out.println("¿par1 es igual a par3? " + par1.equals(par3));

        System.out.println("\nPrueba de clase Contenedor: ");
        actividad4_Contenedor<String, Integer> contenedor = new actividad4_Contenedor<>();
        contenedor.agregarPar("Altura", 180);
        contenedor.agregarPar("Peso", 75);
        contenedor.agregarPar("Edad", 25);

        contenedor.mostrarPares();
    }
}
