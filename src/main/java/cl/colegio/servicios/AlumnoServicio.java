package cl.colegio.servicios;

import cl.colegio.modelos.Alumno;
import cl.colegio.modelos.Materia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AlumnoServicio {
    private Map<String, Alumno> listaAlumnos = new HashMap();

    public AlumnoServicio() {
    }

    public void crearAlumno(Alumno alumno) {
        this.listaAlumnos.put(alumno.getRut(), alumno);
    }

    public void agregarMateria(String rutAlumno, Materia materia) {
        Alumno alumno = (Alumno)this.listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            alumno.getMaterias().add(materia);
        }

    }

    public List<Materia> materiasPorAlumnos(String rutAlumno) {
        Alumno alumno = (Alumno)this.listaAlumnos.get(rutAlumno);
        return alumno != null ? (List)alumno.getMaterias().stream().collect(Collectors.toList()) : null;
    }

    public Map<String, Alumno> listarAlumnos() {
        return this.listaAlumnos;
    }
}
