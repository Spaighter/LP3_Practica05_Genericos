package practica07_ManejoArchivosJava;

/*
 * En esta clase defino los atributos y comportamiento básico de un personaje.
 * Todos los valores deben ser mayores que 0.
 */
public class ejercicio1_Personaje {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;

    public ejercicio1_Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        if (vida <= 0 || ataque <= 0 || defensa <= 0 || alcance <= 0) {
            throw new IllegalArgumentException("Los atributos deben ser mayores que cero.");
        }
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alcance = alcance;
    }

    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getAlcance() { return alcance; }

    public void setVida(int vida) { if (vida > 0) this.vida = vida; }
    public void setAtaque(int ataque) { if (ataque > 0) this.ataque = ataque; }
    public void setDefensa(int defensa) { if (defensa > 0) this.defensa = defensa; }
    public void setAlcance(int alcance) { if (alcance > 0) this.alcance = alcance; }

    @Override
    public String toString() {
        return nombre + "," + vida + "," + ataque + "," + defensa + "," + alcance;
    }

    public static ejercicio1_Personaje fromString(String linea) {
        String[] partes = linea.split(",");
        if (partes.length != 5) return null;
        return new ejercicio1_Personaje(
            partes[0],
            Integer.parseInt(partes[1]),
            Integer.parseInt(partes[2]),
            Integer.parseInt(partes[3]),
            Integer.parseInt(partes[4])
        );
    }
}
