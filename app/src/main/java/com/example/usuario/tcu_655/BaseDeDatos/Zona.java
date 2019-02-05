package com.example.usuario.tcu_655.BaseDeDatos;

public class Zona {

    String zona;
    String comunidades;
    String uso;

    public Zona(String zona, String comunidades, String uso){
        this.setZona(zona);
        this.setComunidades(comunidades);
        this.setUso(uso);
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getComunidades() {
        return comunidades;
    }

    public void setComunidades(String comunidades) {
        this.comunidades = comunidades;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }
}
