package cl.colegio.modelos;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private MateriaEnum nombre;
    private List<Double> notas;

    public Materia(MateriaEnum nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList();
    }

    public MateriaEnum getNombre() {
        return this.nombre;
    }

    public void setNombre(MateriaEnum nombre) {
        this.nombre = nombre;
    }

    public List<Double> getNotas() {
        return this.notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public void agregarNota(Double nota) {
        this.notas.add(nota);
    }

    public String toString() {
        return "Materia [nombre=" + this.nombre + ", notas=" + this.notas + "]";
    }
}
