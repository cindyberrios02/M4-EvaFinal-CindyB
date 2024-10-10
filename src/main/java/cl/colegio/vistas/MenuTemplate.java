package cl.colegio.vistas;

import java.util.Scanner;

public abstract class MenuTemplate {
    protected Scanner scanner;

    public MenuTemplate() {
        this.scanner = new Scanner(System.in);
    }

    protected abstract void exportarDatos();

    protected abstract void crearAlumno();

    protected abstract void agregarMateria();

    protected abstract void agregarNotaPasoUno();

    protected abstract void listarAlumnos();

    protected abstract void terminarPrograma();

    public final void iniciarMenu() {
        while(true) {
            this.mostrarMenu();
            int opcion = this.scanner.nextInt();
            this.scanner.nextLine();
            switch (opcion) {
                case 1:
                    this.crearAlumno();
                    break;
                case 2:
                    this.listarAlumnos();
                    break;
                case 3:
                    this.agregarMateria();
                    break;
                case 4:
                    this.agregarNotaPasoUno();
                    break;
                case 5:
                    this.terminarPrograma();
                    return;
                case 6:
                    this.exportarDatos();
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Crear Alumnos");
        System.out.println("2. Listar Alumnos");
        System.out.println("3. Agregar Materias");
        System.out.println("4. Agregar Notas");
        System.out.println("5. Salir");
        System.out.println("6. Exportar Datos");
        System.out.print("Selección: ");
    }
}
