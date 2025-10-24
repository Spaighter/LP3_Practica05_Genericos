package practica05;

public class actividad3_IgualGenerico {

    public static <T> boolean esIgualA(T a, T b) {
        if (a == null || b == null)
            return false;
        return a.equals(b);
    }

    public static void main(String[] args) {
        System.out.println("Comparando tipos:");
        System.out.println("Integer: " + esIgualA(10, 10));
        System.out.println("String: " + esIgualA("Hola", "Hola"));
        System.out.println("Object: " + esIgualA(new Object(), new Object()));
        System.out.println("Nulls: " + esIgualA(null, "Texto"));
    }
}
