package com.example.usuario.tcu_655.BaseDeDatos;


import com.example.usuario.tcu_655.Global;

import java.util.ArrayList;
import java.util.List;

public class Leyes{
    String nombre;
    int fuente;
    List<Articulo> articulos;


    public Leyes(String nombre, int fuente) {
        this.nombre = nombre;
        this.fuente = fuente;
        articulos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFuente() {
        return Global.links[fuente];
    }

    public void setFuente(int fuente) {
        this.fuente = fuente;
    }

    public void addArticulo(Articulo articulo){
        articulos.add(articulo);
    }

    public List<Articulo> getArticulos(){
        return articulos;
    }

}

