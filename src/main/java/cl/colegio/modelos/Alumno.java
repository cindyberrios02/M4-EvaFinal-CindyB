package cl.colegio.modelos;

import java.util.HashSet;
import java.util.Set;

public class Alumno {
    private String rut;
    private String nombre;
    private String apellido;
    private String direccion;
    private Set<Materia> materias = new HashSet();

    public Alumno() {
    }

    public Alumno(String rut, String nombre, String apellido, String direccion, Set<Materia> materias) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.materias = materias;
    }

    public String getRut() {
        return this.rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Materia> getMaterias() {
        return this.materias;
    }

    public void setMaterias(Set<Materia> materias) {
        this.materias = materias;
    }

    public String toString() {
        return "Alumno [rut=" + this.rut + ", nombre=" + this.nombre + ", apellido=" + this.apellido + ", direccion=" + this.direccion + ", materias=" + this.materias + "]";
    }

}
