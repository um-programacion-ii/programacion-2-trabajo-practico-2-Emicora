import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class AlertaVencimiento {
    private final Prestamo prestamo;
    private final LocalDateTime fechaVencimiento;
    private final NivelUrgencia nivel;

    public AlertaVencimiento(Prestamo prestamo, int diasPrestamo) {
        this.prestamo = prestamo;
        this.fechaVencimiento = prestamo.getFechaPrestamo().plusDays(diasPrestamo);

        long diasFaltan = ChronoUnit.DAYS.between(
                LocalDateTime.now().toLocalDate(),
                fechaVencimiento.toLocalDate()
        );
        if (diasFaltan >= 2) {
            nivel = NivelUrgencia.INFO;
        } else if (diasFaltan == 1) {
            nivel = NivelUrgencia.WARNING;
        } else {
            nivel = NivelUrgencia.ERROR;
        }
    }

    public void validarYEnviar() {
        long diasFaltan = ChronoUnit.DAYS.between(
                LocalDateTime.now().toLocalDate(),
                fechaVencimiento.toLocalDate()
        );
        if (diasFaltan <= 1) {
            String msg = String.format(
                    "Préstamo de '%s' vence en %d día(s).",
                    prestamo.getRecurso().getTitulo(),
                    diasFaltan
            );
            System.out.println("[" + nivel + "] " + msg);
            HistorialAlertas.getInstance().agregar(nivel, msg);
            if (nivel != NivelUrgencia.INFO) {
                ofrecerRenovacion();
            }
        }
    }

    private void ofrecerRenovacion() {
        System.out.print("¿Desea renovar el préstamo? (s/n): ");
        String resp = new Scanner(System.in).nextLine().trim().toLowerCase();
        if ("s".equals(resp)) {
            prestamo.getRecurso().actualizarEstado("disponible");
            String renovMsg = "Préstamo de '" + prestamo.getRecurso().getTitulo() +
                    "' renovado por 7 días.";
            System.out.println("[INFO] " + renovMsg);
            HistorialAlertas.getInstance().agregar(NivelUrgencia.INFO, renovMsg);
        }
    }
}
