package org.example.Clases;
import org.example.Enums.NivelDificultad;

import java.util.*;

public class Sala {
    private static int contadorID = 1;
    private int id;
    private String nombre;
    private NivelDificultad nivelDificultad;
    private double valorTotal;
    private List<ObjetoDecoracion> objetoDecoracion;
    private List<Pista> pistas;

    public Sala (String nombre, NivelDificultad nivelDificultad){
        this.id = contadorID;
        this.nombre = nombre;
        this.nivelDificultad = nivelDificultad;
        this.objetoDecoracion = new ArrayList<>();
        this.pistas = new ArrayList<>();
        this.valorTotal = 0;
        contadorID++;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NivelDificultad getNivelDificultad() {
        return nivelDificultad;
    }
    public void setNivelDificultad(NivelDificultad nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public double getValorTotal() {
        for(Pista pista : pistas){
            valorTotal += pista.getPrecioConIva();
        }
        for(ObjetoDecoracion objetoDecoracion : objetoDecoracion){
            valorTotal += objetoDecoracion.getPrecioConIVA();
        }
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ObjetoDecoracion> getObjetoDecoracion() {
        return objetoDecoracion;
    }
    public void setObjetoDecoracion(List<ObjetoDecoracion> objetoDecoracion) {
        this.objetoDecoracion = objetoDecoracion;
    }

    public List<Pista> getPistas() {
        return pistas;
    }
    public void setPistas(List<Pista> pistas) {
        this.pistas = pistas;
    }
}
