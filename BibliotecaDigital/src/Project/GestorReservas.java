package Project;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GestorReservas {
    private final BlockingQueue<Reserva> colaReservas = new LinkedBlockingQueue<>();
    private final GestorPrestamos gestorPrestamos;

    public GestorReservas(GestorPrestamos gestorPrestamos) {
        this.gestorPrestamos = gestorPrestamos;
    }

    public void agregarReserva(Reserva reserva) {
        colaReservas.offer(reserva);
        System.out.println("Reserva agregada: \"" + reserva.getRecurso().getTitulo() +
                "\" por " + reserva.getUsuario().getNombre());
        reserva.getRecurso().actualizarEstado("reservado");
    }

    public Reserva procesarSiguienteReserva() {
        Reserva reserva = colaReservas.poll();
        if (reserva != null) {
            RecursoDigital recurso = reserva.getRecurso();
            if ("disponible".equalsIgnoreCase(recurso.getEstado())) {
                new AlertaDisponibilidad(
                        recurso,
                        reserva.getUsuario(),
                        gestorPrestamos
                ).enviarAlerta();
            }
        }
        return reserva;
    }

    public void mostrarReservas() {
        System.out.println("Reservas pendientes:");
        colaReservas.forEach(r ->
                System.out.println("- " + r.getRecurso().getTitulo() +
                        " reservado por " + r.getUsuario().getNombre())
        );
    }

    public BlockingQueue<Reserva> getColaReservas() {
        return colaReservas;
    }
}
