package org.example;


import org.example.Excepcions.SalaNoExisteExcepcion;

public class Main {
    public static void main(String[] args) throws SalaNoExisteExcepcion {
        System.out.println("Hello world!");
        EscapeRoomApp escapeRoomApp = new EscapeRoomApp();
        escapeRoomApp.Menu();
    }
}