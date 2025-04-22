import java.util.Scanner;

public class AlertaDisponibilidad {
    private final RecursoDigital recurso;
    private final Usuario usuarioReservante;
    private final GestorPrestamos gestorPrestamos;

    public AlertaDisponibilidad(RecursoDigital recurso,
                                Usuario usuarioReservante,
                                GestorPrestamos gestorPrestamos) {
        this.recurso = recurso;
        this.usuarioReservante = usuarioReservante;
        this.gestorPrestamos = gestorPrestamos;
    }
    
    public void enviarAlerta() {
        String msg = "Recurso '" + recurso.getTitulo()
                + "' reservado por " + usuarioReservante.getNombre()
                + " está disponible.";
        System.out.println("[INFO] " + msg);
        HistorialAlertas.getInstance().agregar(NivelUrgencia.INFO, msg);

        System.out.print("¿Prestar ahora? (s/n): ");
        String resp = new Scanner(System.in).nextLine().trim().toLowerCase();
        if ("s".equals(resp)) {
            try {
                gestorPrestamos.realizarPrestamo(usuarioReservante, recurso);
            } catch (Exception e) {
                System.out.println("No se pudo prestar: " + e.getMessage());
            }
        }
    }
}
