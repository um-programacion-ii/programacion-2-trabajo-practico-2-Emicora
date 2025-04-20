import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GestorReservas {
    private BlockingQueue<Reserva> colaReservas = new LinkedBlockingQueue<>();

    public void agregarReserva(Reserva reserva) {
        colaReservas.offer(reserva);
        System.out.println("Reserva agregada: \"" + reserva.getRecurso().getTitulo() +
                "\" por " + reserva.getUsuario().getNombre());
    }

    public Reserva procesarSiguienteReserva() {
        return colaReservas.poll();
    }

    public void mostrarReservas() {
        System.out.println("Reservas pendientes:");
        colaReservas.forEach(r ->
                System.out.println("- " + r.getRecurso().getTitulo() +
                        " reservado por " + r.getUsuario().getNombre())
        );
    }
}
