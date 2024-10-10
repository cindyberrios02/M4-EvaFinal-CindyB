package cl.colegio.servicios;

import java.util.List;

public class PromedioServicioImp {
    public PromedioServicioImp() {
    }

    public double calcularPromedio(List<Double> notas) {
        return notas != null && !notas.isEmpty() ? notas.stream().mapToDouble(Double::doubleValue).average().orElse(0.0) : 0.0;
    }
}
