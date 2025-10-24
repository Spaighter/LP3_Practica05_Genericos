package practica05;

public class actividad4_Par<F, S> {
    private F primero;
    private S segundo;

    public actividad4_Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public F getPrimero() {
        return primero;
    }

    public S getSegundo() {
        return segundo;
    }

    public void setPrimero(F primero) {
        this.primero = primero;
    }

    public void setSegundo(S segundo) {
        this.segundo = segundo;
    }

    public boolean esIgual(actividad4_Par<F, S> otroPar) {
        return this.primero.equals(otroPar.primero) && this.segundo.equals(otroPar.segundo);
    }

    @Override
    public String toString() {
        return "• " + primero + ": " + segundo;
    }
}
