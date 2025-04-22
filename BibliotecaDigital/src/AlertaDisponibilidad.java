import java.util.Scanner;

public class AlertaDisponibilidad {
    private final RecursoDigital recurso;
    private final Usuario usuarioReservante;
    private final GestorPrestamos gestorPrestamos;  // <-- nuevo campo

    public AlertaDisponibilidad(RecursoDigital recurso,
                                Usuario usuarioReservante,
                                GestorPrestamos gestorPrestamos) {
        this.recurso = recurso;
        this.usuarioReservante = usuarioReservante;
        this.gestorPrestamos = gestorPrestamos;
    }

    public void enviarAlerta() {
        System.out.println("+++ RECURSO DISPONIBLE +++");
        System.out.println("El recurso '" + recurso.getTitulo()
                + "' reservado por " + usuarioReservante.getNombre()
                + " está disponible.");
        System.out.print("¿Prestar ahora? (s/n): ");
        String resp = new Scanner(System.in).nextLine().trim().toLowerCase();
        if (resp.equals("s")) {
            try {
                gestorPrestamos.realizarPrestamo(usuarioReservante, recurso);
            } catch (Exception e) {
                System.out.println("No se pudo prestar: " + e.getMessage());
            }
        }
    }
}
