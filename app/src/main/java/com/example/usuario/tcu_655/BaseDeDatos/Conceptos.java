package com.example.usuario.tcu_655.BaseDeDatos;


public class Conceptos implements Comparable<Conceptos>{
    String nombre;
    String texto;
    String imagen;
    String fuente;
    int prioridad;
    String etiqueta;



    public Conceptos(String nombre, String texto, String imagen, String fuente, int prioridad, String etiqueta) {
        this.setNombre(nombre);
        this.setTexto(texto);
        this.setImagen(imagen);
        this.setFuente(fuente);
        this.setPrioridad(prioridad);
        this.setEtiqueta(etiqueta);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public int compareTo(Conceptos o) {
        int comp = this.getPrioridad() - o.getPrioridad();
        return comp;

    }

    @Override
    public String toString() {
        return "[]";
    }

}
