package org.example.Clases;

import org.example.Enums.TipoMaterial;

public class ObjetoDecoracion {
    private static int contadorId = 1;
    private int id;
    private double precio;
    private String descripcion;
    private TipoMaterial tipoMaterial;

    public ObjetoDecoracion(double precio, String descripcion, TipoMaterial tipoMaterial) {
        this.id = contadorId;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tipoMaterial = tipoMaterial;
        contadorId++;
    }
    public double getPrecioConIVA(){
        return this.precio*1.21;
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
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public TipoMaterial getTipoMaterial() {
        return tipoMaterial;
    }
    public void setTipoMaterial(TipoMaterial tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }
}
