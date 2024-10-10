package cl.colegio;

import cl.colegio.vistas.Menu;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Gestión de Alumnos ===");
        System.out.println("Colegio Latinoamericano");
        System.out.println("================================");
        Menu menu = new Menu();
        menu.iniciarMenu();
    }
}