import cl.colegio.modelos.Alumno;
import cl.colegio.modelos.Materia;
import cl.colegio.modelos.MateriaEnum;
import cl.colegio.servicios.AlumnoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

public class AlumnoServicioTest {
    private AlumnoServicio alumnoServicio;

    @Mock
    private AlumnoServicio alumnoServicioMock;

    private Materia matematicas;
    private Materia lenguaje;
    private Alumno mapu;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        alumnoServicio = new AlumnoServicio();
        matematicas = new Materia(MateriaEnum.MATEMATICAS);
        lenguaje = new Materia(MateriaEnum.LENGUAJE);
        Set<Materia> materias = new HashSet<>();
            mapu = new Alumno("15155155-5", "Mapu","Alvarado", "Santiago", materias);

    }


    @Test
    void crearAlumnoTest() {
        alumnoServicio.crearAlumno(mapu);

        Map<String,Alumno> alumnos = alumnoServicio.listarAlumnos();
        boolean alumnoExiste = alumnos.containsKey("15155155-5");
        boolean alumnoNoExiste = alumnos.containsKey("11111111-1");
        Assertions.assertTrue(alumnoExiste);
        Assertions.assertFalse(alumnoNoExiste);
    }

    @Test
    void agregarMateriaTest() {
        alumnoServicio.crearAlumno(mapu);
        alumnoServicio.agregarMateria("15155155-5",matematicas);

        Map<String,Alumno> alumnos = alumnoServicio.listarAlumnos();
        Alumno alumno = alumnos.get("15155155-5");
        Set<Materia> materiasAlumno = alumno.getMaterias();

        Assertions.assertTrue(materiasAlumno.contains(matematicas));
        Assertions.assertFalse(materiasAlumno.contains(lenguaje));
    }

    @Test
    void materiasPorAlumnosTest() {
        alumnoServicio.crearAlumno(mapu);
        alumnoServicio.agregarMateria("15155155-5",lenguaje);

        List<Materia> listaMaterias = alumnoServicio.materiasPorAlumnos("15155155-5");

        Assertions.assertTrue(listaMaterias.contains(lenguaje));
        Assertions.assertFalse(listaMaterias.contains(matematicas));
    }

    @Test
    void listarAlumnosTest() {
        alumnoServicio.crearAlumno(mapu);
        alumnoServicio.listarAlumnos();
        Map<String,Alumno> alumnos = alumnoServicio.listarAlumnos();
        System.out.println(alumnos);
        Assertions.assertTrue(alumnos.containsKey("15155155-5"));
    }
}
