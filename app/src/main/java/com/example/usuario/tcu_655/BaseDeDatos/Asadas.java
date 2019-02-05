package com.example.usuario.tcu_655.BaseDeDatos;

public class Asadas {

    String nombre;
    String canton;
    int numeroComunidadesAbastece;
    String comunidadesAbastece;
    int poblacionAbastecidas;
    int añoConstruccion;
    String condicion;
    TomasDeAgua toma;

    public Asadas(String nombre, String canton, int numeroComunidadesAbastece, String comunidadesAbastece, int poblacionAbastecidas, int añoConstruccion, String condicion){
        this.nombre = nombre;
        this.canton = canton;
        this.numeroComunidadesAbastece = numeroComunidadesAbastece;
        this.comunidadesAbastece = comunidadesAbastece;
        this.poblacionAbastecidas = poblacionAbastecidas;
        this.añoConstruccion = añoConstruccion;
        this.condicion = condicion;


    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public int getNumeroComunidadesAbastece() {
        return numeroComunidadesAbastece;
    }

    public void setNumeroComunidadesAbastece(int numeroComunidadesAbastece) {
        this.numeroComunidadesAbastece = numeroComunidadesAbastece;
    }

    public String getComunidadesAbastece() {
        return comunidadesAbastece;
    }

    public void setComunidadesAbastece(String comunidadesAbastece) {
        this.comunidadesAbastece = comunidadesAbastece;
    }

    public int getPoblacionAbastecidad() {
        return poblacionAbastecidas;
    }

    public void setPoblacionAbastecidad(int poblacionAbastecidad) {
        this.poblacionAbastecidas = poblacionAbastecidad;
    }

    public int getAñoConstrucción() {
        return añoConstruccion;
    }

    public void setAñoConstrucción(int añoConstrucción) {
        añoConstrucción = añoConstrucción;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public TomasDeAgua getToma() {
        return toma;
    }

    public void setToma(TomasDeAgua toma) {
        this.toma = toma;
    }
}
