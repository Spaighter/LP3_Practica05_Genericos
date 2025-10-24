package practica07_ManejoArchivosJava;

import java.io.Serializable;

/*
 * En esta clase defino el objeto Fecha, que guarda día, mes y año.
 * La marco como Serializable para poder guardarla dentro de un archivo binario.
 */
public class actividad6_Fecha implements Serializable {

    private int dia;
    private int mes;
    private int anio;

    // Constructor con parámetros
    public actividad6_Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    // Constructor vacío por si necesito crear el objeto sin valores iniciales
    public actividad6_Fecha() {
    }

    // Métodos get y set
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    // Muestro la fecha en formato día/mes/año
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }
}
