package practica07_ManejoArchivosJava;

/*
 * En esta clase represento un personaje con nivel incluido.
 * Cuando sube de nivel, los atributos aumentan proporcionalmente.
 */
public class ejercicio2_Personaje {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;
    private int nivel;

    public ejercicio2_Personaje(String nombre, int vida, int ataque, int defensa, int alcance, int nivel) {
        if (vida <= 0 || ataque <= 0 || defensa <= 0 || alcance <= 0 || nivel <= 0)
            throw new IllegalArgumentException("Los valores deben ser mayores que cero.");
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alcance = alcance;
        this.nivel = nivel;
    }

    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getAlcance() { return alcance; }
    public int getNivel() { return nivel; }

    public void subirNivel() {
        nivel++;
        vida += 2;
        ataque += 1;
        defensa += 1;
        alcance += 1;
    }

    public void setVida(int vida) { if (vida > 0) this.vida = vida; }
    public void setAtaque(int ataque) { if (ataque > 0) this.ataque = ataque; }
    public void setDefensa(int defensa) { if (defensa > 0) this.defensa = defensa; }
    public void setAlcance(int alcance) { if (alcance > 0) this.alcance = alcance; }

    @Override
    public String toString() {
        return nombre + "," + vida + "," + ataque + "," + defensa + "," + alcance + "," + nivel;
    }

    public static ejercicio2_Personaje fromString(String linea) {
        String[] partes = linea.split(",");
        if (partes.length != 6) return null;
        return new ejercicio2_Personaje(
            partes[0],
            Integer.parseInt(partes[1]),
            Integer.parseInt(partes[2]),
            Integer.parseInt(partes[3]),
            Integer.parseInt(partes[4]),
            Integer.parseInt(partes[5])
        );
    }
}
