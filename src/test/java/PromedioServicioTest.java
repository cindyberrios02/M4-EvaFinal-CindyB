import cl.colegio.servicios.PromedioServicioImp;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromedioServicioTest {
    PromedioServicioImp promedioServicioImp = new PromedioServicioImp();

    @Test
    public void calcularPromedioTest() {
        List<Double> notas = new ArrayList<>();
        notas.add(7.0);
        notas.add(1.0);
        notas.add(4.0);
        double resultado = promedioServicioImp.calcularPromedio(notas);

        double promedioEsperado = 4.0;
        assertEquals(promedioEsperado, resultado);
    }
}
