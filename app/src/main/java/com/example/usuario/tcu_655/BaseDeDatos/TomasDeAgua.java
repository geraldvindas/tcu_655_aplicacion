package com.example.usuario.tcu_655.BaseDeDatos;

public class TomasDeAgua {
    String zona;
    String calidad;
    String imagen1;
    String descripcion1;
    String imagen2;
    String descripcion2;

    public TomasDeAgua(String zona, String calidad, String imagen1, String descripcion1, String imagen2, String descripcion2){
        this.setZona(zona);
        this.setCalidad(calidad);
        this.setImagen1(imagen1);
        this.setDescripcion1(descripcion1);
        this.setImagen2(imagen2);
        this.setDescripcion2(descripcion2);
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public String getImagen1() {
        return imagen1;
    }

    public void setImagen1(String imagen1) {
        this.imagen1 = imagen1;
    }

    public String getDescripcion1() {
        return descripcion1;
    }

    public void setDescripcion1(String descripcion1) {
        this.descripcion1 = descripcion1;
    }

    public String getImagen2() {
        return imagen2;
    }

    public void setImagen2(String imagen2) {
        this.imagen2 = imagen2;
    }

    public String getDescripcion2() {
        return descripcion2;
    }

    public void setDescripcion2(String descripcion2) {
        this.descripcion2 = descripcion2;
    }
}
