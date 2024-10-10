package cl.colegio.vistas;

import cl.colegio.modelos.Alumno;
import cl.colegio.modelos.Materia;
import cl.colegio.modelos.MateriaEnum;
import cl.colegio.servicios.AlumnoServicio;
import cl.colegio.servicios.ArchivoServicio;

import java.util.List;

public class Menu extends MenuTemplate{
    private AlumnoServicio alumnoServicio = new AlumnoServicio();
    private ArchivoServicio archivoServicio = new ArchivoServicio();

    public Menu() {
    }

    protected void exportarDatos() {
        System.out.println("\n--- Exportar Datos ---");
        System.out.print("Ingresa la ruta en donde se exportará el archivo: ");
        String ruta = this.scanner.nextLine();
        this.archivoServicio.exportarDatos(this.alumnoServicio.listarAlumnos(), ruta);
        System.out.println("Datos exportados correctamente.");
    }

    protected void crearAlumno() {
        System.out.println("\n--- Crear Alumno ---");
        Alumno alumno = new Alumno();
        System.out.print("Ingresa RUT: ");
        alumno.setRut(this.scanner.nextLine());
        System.out.print("Ingresa nombre: ");
        alumno.setNombre(this.scanner.nextLine());
        System.out.print("Ingresa apellido: ");
        alumno.setApellido(this.scanner.nextLine());
        System.out.print("Ingresa dirección: ");
        alumno.setDireccion(this.scanner.nextLine());
        this.alumnoServicio.crearAlumno(alumno);
        System.out.println("--- ¡Alumno agregado! ---");
    }

    protected void agregarMateria() {
        System.out.println("\n--- Agregar Materia ---");
        System.out.print("Ingresa rut del Alumno: ");
        String rut = this.scanner.nextLine();
        System.out.println("1. MATEMATICAS");
        System.out.println("2. LENGUAJE");
        System.out.println("3. CIENCIA");
        System.out.println("4. HISTORIA");
        System.out.print("Selecciona una Materia: ");
        int opcion = this.scanner.nextInt();
        this.scanner.nextLine();
        MateriaEnum var10000;
        switch (opcion) {
            case 1:
                var10000 = MateriaEnum.MATEMATICAS;
                break;
            case 2:
                var10000 = MateriaEnum.LENGUAJE;
                break;
            case 3:
                var10000 = MateriaEnum.CIENCIA;
                break;
            case 4:
                var10000 = MateriaEnum.HISTORIA;
                break;
            default:
                var10000 = null;
        }

        MateriaEnum materiaEnum = var10000;
        if (materiaEnum != null) {
            Materia materia = new Materia(materiaEnum);
            this.alumnoServicio.agregarMateria(rut, materia);
            System.out.println("--- ¡Materia agregada! ---");
        }

    }

    protected void agregarNotaPasoUno() {
        System.out.println("\n--- Agregar Nota ---");
        System.out.print("Ingresa rut del Alumno: ");
        String rut = this.scanner.nextLine();
        List<Materia> materias = this.alumnoServicio.materiasPorAlumnos(rut);
        if (materias != null && !materias.isEmpty()) {
            System.out.println("Alumno tiene las siguientes materias agregadas:");

            int opcion;
            for(opcion = 0; opcion < materias.size(); ++opcion) {
                System.out.println(opcion + 1 + "." + ((Materia)materias.get(opcion)).getNombre());
            }

            System.out.print("Seleccionar materia: ");
            opcion = this.scanner.nextInt();
            this.scanner.nextLine();
            if (opcion > 0 && opcion <= materias.size()) {
                System.out.print("Ingresar nota: ");
                double nota = this.scanner.nextDouble();
                this.scanner.nextLine();
                Materia materia = (Materia)materias.get(opcion - 1);
                materia.agregarNota(nota);
                System.out.println("--- ¡Nota agregada a " + materia.getNombre() + "! ---");
            }
        }

    }

    protected void listarAlumnos() {
        System.out.println("\n--- Listar Alumnos ---");
        this.alumnoServicio.listarAlumnos().forEach((rut, alumno) -> {
            System.out.println("Datos Alumno");
            System.out.println("RUT: " + alumno.getRut());
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Dirección: " + alumno.getDireccion());
            System.out.println("Materias:");
            alumno.getMaterias().forEach((materia) -> {
                System.out.println(materia.getNombre());
                System.out.print("Notas: ");
                System.out.println(materia.getNotas());
            });
            System.out.println("------------------------");
        });
    }

    protected void terminarPrograma() {
        System.out.println("\n--- Finalizando programa ---");
        System.out.println("¡Gracias por usar el sistema!");
        this.scanner.close();
        System.exit(0);
    }
}
