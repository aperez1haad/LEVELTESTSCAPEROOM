package org.example.Clases;

public class Pista {
    private static int contadorID = 1;
    private int id;
    private double precio;
    private String nombre;
    private int tiempoEstimado; // minutos
    private String tematica;
    public Pista (double precio, String nombre, int tiempoEstimado, String tematica){
        this.id = contadorID;
        this.precio = precio;
        this.nombre = nombre;
        this.tiempoEstimado = tiempoEstimado;
        this.tematica = tematica;
        contadorID++;
    }
    public double getPrecioConIva() {
        return this.precio*1.10;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }
}
