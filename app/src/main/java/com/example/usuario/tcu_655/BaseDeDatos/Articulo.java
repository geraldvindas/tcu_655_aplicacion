package com.example.usuario.tcu_655.BaseDeDatos;

import android.support.annotation.NonNull;

public class Articulo implements Comparable<Articulo> {
    private String articulo;
    private String descripcion;

    public Articulo(String articulo, String descripcion){
        this.articulo = articulo;
        this.descripcion = descripcion;

    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int compareTo(@NonNull Articulo o) {
        return this.articulo.compareTo(o.articulo);
    }
}
