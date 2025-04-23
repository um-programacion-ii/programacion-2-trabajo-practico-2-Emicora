package Project;

import java.util.ArrayList;
import java.util.List;

public class HistorialAlertas {
    private static final HistorialAlertas INSTANCE = new HistorialAlertas();
    private final List<String> alertas = new ArrayList<>();

    private HistorialAlertas() {}

    public static HistorialAlertas getInstance() {
        return INSTANCE;
    }

    public void agregar(NivelUrgencia nivel, String mensaje) {
        alertas.add("[" + nivel + "] " + mensaje);
    }

    public void mostrar() {
        System.out.println("----- Historial de Alertas -----");
        if (alertas.isEmpty()) {
            System.out.println("No hay alertas registradas.");
        } else {
            alertas.forEach(System.out::println);
        }
        System.out.println("-------------------------------");
    }
}
