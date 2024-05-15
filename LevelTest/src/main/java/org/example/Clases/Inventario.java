package org.example.Clases;
import org.example.Enums.NivelDificultad;
import org.example.Excepcions.SalaDuplicadaExcepcion;
import org.example.Excepcions.SalaNoExisteExcepcion;

import java.util.*;
public class Inventario {
    private List<Sala> salas;
    public Inventario() {
        this.salas = new ArrayList<>();
    }

    public void crearSala (String  nombre, NivelDificultad nivelDificultad) throws SalaDuplicadaExcepcion {
        for (Sala sala : salas) {
            if (sala.getNombre().equalsIgnoreCase(nombre)) {
                throw new SalaDuplicadaExcepcion("Sala duplicada");
            }
        }
        this.salas.add(new Sala(nombre, nivelDificultad));
    }
    public void anadirPistaASala(String nombreSala, Pista pista) throws SalaNoExisteExcepcion {
        for (Sala sala : salas) {
            if (sala.getNombre().equalsIgnoreCase(nombreSala)) {
                sala.getPistas().add(pista);
            }
            else{
                throw new SalaNoExisteExcepcion("La Sala con el nombre "+ nombreSala + " no existe");
            }
        }
    }
    public void quitarPistaASala (String nombreSala, String pista) throws SalaNoExisteExcepcion {
        for (Sala sala : salas) {
            if (sala.getNombre().equalsIgnoreCase(nombreSala)) {
                sala.getPistas().remove(pista);
            }
            else{
                throw new SalaNoExisteExcepcion("La Sala con el nombre "+ nombreSala + " no existe");
            }
        }
    }
    public void anadirObjetoDecoracionASala(String nombreSala, ObjetoDecoracion objetoDecoracion) throws SalaNoExisteExcepcion {
        for (Sala sala : salas) {
            if (sala.getNombre().equalsIgnoreCase(nombreSala)) {
                sala.getObjetoDecoracion().add(objetoDecoracion);
            }
            else{
                throw new SalaNoExisteExcepcion("La Sala con el nombre "+ nombreSala + " no existe");
            }
        }

    }
    public void quitarObjetoDecoracionASala (String nombreSala, String descripcionobjetoDecoracion) throws SalaNoExisteExcepcion {
        for (Sala sala : salas) {
            if (sala.getNombre().equalsIgnoreCase(nombreSala)) {
                sala.getObjetoDecoracion().remove(descripcionobjetoDecoracion);
            }
            else{
                throw new SalaNoExisteExcepcion("La Sala con el nombre "+ nombreSala + " no existe");
            }
        }

    }
    public void mostrarInventario(){
        for (Sala sala : salas) {
            System.out.println(sala.getId() + ". " + sala.getNombre());
        }
    }
    public void removeSala(String nombreSala) throws SalaNoExisteExcepcion {
        for (Sala sala : salas) {
            if (sala.getNombre().equalsIgnoreCase(nombreSala)) {
                salas.remove(nombreSala);
            }
            else{
                throw new SalaNoExisteExcepcion("La Sala con el nombre "+ nombreSala + " no existe");
            }
        }
    }
    public Sala getSala(int idSala){
        return salas.get(idSala);
    }
}
