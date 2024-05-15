package org.example;
import java.util.*;

import org.example.Clases.ObjetoDecoracion;
import org.example.Clases.Pista;
import org.example.Enums.NivelDificultad;
import org.example.Excepcions.SalaDuplicadaExcepcion;
import org.example.Clases.Inventario;
import org.example.Excepcions.SalaNoExisteExcepcion;
import org.example.Enums.*;
public class EscapeRoomApp {
    Inventario inventario = new Inventario();

    public void Menu() throws SalaNoExisteExcepcion {
        Scanner sc = new Scanner(System.in);
        int chivato = 1;
        while (chivato == 1) {
            System.out.println("Qué quieres hacer?");
            System.out.println("1. Crear Sala");
            System.out.println("2. Entrar en una Sala");
            System.out.println("3. Eliminar una Sala");
            System.out.println("4. Mostrar Salas");
            System.out.println("5. Salir");
            switch (sc.nextInt()) {
                case 1:
                    try {
                        inventario.crearSala(validateString("Introduce el nombre de la sala"), escogernivelDificultad());
                    } catch (SalaDuplicadaExcepcion e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    inventario.mostrarInventario();
                    menuSala(validateInt("A que sala quieres entrar?"));
                    break;
                case 3:
                    inventario.removeSala(validateString("Introduce el nombre de la sala a eliminar"));
                    break;
                    case 4:
                    inventario.mostrarInventario();
                case 5:
                    chivato = 0;
                    break;
                default:
                    validateInt("No has seleccionado una opcion valida, por favor, selecciona una opción del 1 al 3");
            }
        }
    }

    public int validateInt(String mensaje) {
        System.out.println(mensaje);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    public double validateDouble(String mensaje) {
        System.out.println(mensaje);
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }
    public String validateString(String mensaje) {
        System.out.println(mensaje);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public NivelDificultad escogernivelDificultad() {
        System.out.println("Qué dificultad es? Pon el numero\n  1-Facil\n  2-Intermedio\n  3-Dificil");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                return NivelDificultad.FACIL;
            case 2:
                return NivelDificultad.INTERMEDIO;
            case 3:
                return NivelDificultad.DIFICIL;
            default:
                return null;
        }
    }
    public TipoMaterial escogerTipoMaterial() {
        System.out.println("Qué material es?\n + 1-Madera\n + 2-Metal\n + 3-Plastico\n + 4-Otro");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                return TipoMaterial.MADERA;
            case 2:
                return TipoMaterial.METAL;
            case 3:
                return TipoMaterial.PLASTICO;
            case 4:
                return TipoMaterial.OTRO;
            default:
                return null;
        }
    }
    public void menuSala(int idSala) throws SalaNoExisteExcepcion {
        Scanner sc = new Scanner(System.in);
        int chivato1 = 1;
        while (chivato1 == 1) {
            System.out.println("Has entrado en la sala +" + inventario.getSala(idSala-1).getNombre());
            System.out.println("Qué quieres hacer?\n" +
                    " 1-Cambiar Nombre Sala\n " +
                    " 2-Cambiar Nivel Dificultad\n " +
                    " 3-Calcular Precio Total de la Sala\n " +
                    " 4-Añadir Pista\n " +
                    " 5-Quitar Pista \n " +
                    " 6-Añadir Objeto\n " +
                    " 7-Quitar Objeto\n " +
                    " 8-Salir");
            switch (sc.nextInt()) {
                case 1:
                    inventario.getSala(idSala-1).setNombre(validateString("Introduce el nuevo nombre de la sala"));
                    break;
                case 2:
                    inventario.getSala(idSala-1).setNivelDificultad(escogernivelDificultad());
                    break;
                case 3:
                    System.out.println(inventario.getSala(idSala-1).getValorTotal());
                    break;
                case 4:
                    inventario.anadirPistaASala(inventario.getSala(idSala-1).getNombre(), new Pista(validateDouble("Introduce el precio"), validateString("Introduce el nombre"), validateInt("Introduce el tiempo estimado"), validateString("Introduce la tematica")));
                    break;
                case 5:
                    inventario.getSala(idSala-1).getNombresPistas();
                    String pistax = validateString("Que pista quieres quitar? Escribela");
                    inventario.quitarPistaASala(inventario.getSala(idSala).getNombre(), pistax);
                    break;
                case 6:
                    inventario.anadirObjetoDecoracionASala(inventario.getSala(idSala-1).getNombre(), new ObjetoDecoracion(validateDouble("Introduce el precio"), validateString("Introduce la descripción"), escogerTipoMaterial()));
                    break;
                case 7:
                    inventario.getSala(idSala-1).getDescripcionsObjetosDecoracion();
                    String objetox = validateString("Que objeto quieres quitar? Escribelo");
                    inventario.quitarObjetoDecoracionASala(inventario.getSala(idSala-1).getNombre(), objetox);
                    break;
                case 8:
                    chivato1 = 0;
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        }

    }
}
