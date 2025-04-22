import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class AlertaVencimiento {
    private final Prestamo prestamo;
    private final LocalDateTime fechaVencimiento;

    public AlertaVencimiento(Prestamo prestamo, int diasPrestamo) {
        this.prestamo = prestamo;
        this.fechaVencimiento = prestamo.getFechaPrestamo().plusDays(diasPrestamo);
    }

    public void validarYEnviar() {
        LocalDateTime ahora = LocalDateTime.now();
        long diasFaltan = ChronoUnit.DAYS.between(ahora.toLocalDate(), fechaVencimiento.toLocalDate());
        if (diasFaltan == 1 || diasFaltan == 0) {
            System.out.println("********** ALERTA **********");
            System.out.println("Préstamo del recurso '"
                    + prestamo.getRecurso().getTitulo()
                    + "' vence en " + diasFaltan + " día(s).");
            System.out.println("****************************");
        }
    }
}
