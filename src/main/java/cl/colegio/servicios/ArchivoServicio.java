package cl.colegio.servicios;

import cl.colegio.modelos.Alumno;
import cl.colegio.modelos.Materia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ArchivoServicio {
    private List<Alumno> alumnosACargar = new ArrayList();
    private PromedioServicioImp promediosServicioImp = new PromedioServicioImp();

    public ArchivoServicio() {
    }

    public void exportarDatos(Map<String, Alumno> alumnos, String ruta) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(ruta + "/promedios.txt"));

            try {
                Iterator var4 = alumnos.entrySet().iterator();

                while(var4.hasNext()) {
                    Map.Entry<String, Alumno> entry = (Map.Entry)var4.next();
                    Alumno alumno = (Alumno)entry.getValue();
                    Iterator var7 = alumno.getMaterias().iterator();

                    while(var7.hasNext()) {
                        Materia materia = (Materia)var7.next();
                        double promedio = this.promediosServicioImp.calcularPromedio(materia.getNotas());
                        writer.printf("Alumno : %s - %s%n", alumno.getRut(), alumno.getNombre());
                        writer.printf("Materia : %s - Promedio : %.1f%n", materia.getNombre(), promedio);
                    }
                }
            } catch (Throwable var12) {
                try {
                    writer.close();
                } catch (Throwable var11) {
                    var12.addSuppressed(var11);
                }

                throw var12;
            }

            writer.close();
        } catch (IOException var13) {
            System.out.println("Error al exportar datos: " + var13.getMessage());
        }

    }
}
