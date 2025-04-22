import java.time.LocalDateTime;

public class AlertaVencimiento {
    private final Prestamo prestamo;
    private final LocalDateTime fechaVencimiento;

    public AlertaVencimiento(Prestamo prestamo, int diasPrestamo) {
        this.prestamo = prestamo;
        this.fechaVencimiento = prestamo.getFechaPrestamo().plusDays(diasPrestamo);
    }
    
}
