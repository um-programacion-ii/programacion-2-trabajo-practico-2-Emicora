package Project;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GestorPrestamos {
    private List<Prestamo> prestamos = new ArrayList<>();
    private ServicioNotificacionPrestamos notificador;

    public GestorPrestamos(ServicioNotificacionPrestamos notificador) {
        this.notificador = notificador;
    }
    public synchronized void realizarPrestamo(Usuario usuario, RecursoDigital recurso) throws RecursoNoDisponibleException {
        String hilo = Thread.currentThread().getName();
        if (!recurso.getEstado().equalsIgnoreCase("disponible")) {
            System.out.printf("[%s] PRÉSTAMO FALLIDO: recurso '%s' ya prestado.%n",
                    hilo, recurso.getTitulo());
            throw new RecursoNoDisponibleException(
                    "El recurso '" + recurso.getTitulo() + "' no está disponible."
            );
        }
        recurso.actualizarEstado("prestado");
        Prestamo prestamo = new Prestamo(usuario, recurso);
        prestamos.add(prestamo);
        System.out.printf("[%s] PRÉSTAMO OK: '%s' a %s%n",
                hilo, recurso.getTitulo(), usuario.getNombre());
        notificador.notificarPrestamo(usuario, recurso);
    }

    public synchronized void devolverRecurso(RecursoDigital recurso) {
        recurso.actualizarEstado("disponible");
        prestamos.stream()
                .filter(p -> p.getRecurso() == recurso && p.getFechaDevolucion() == null)
                .findFirst()
                .ifPresent(p -> p.setFechaDevolucion(LocalDateTime.now()));
        System.out.println("Recurso devuelto: \"" + recurso.getTitulo() + "\"");
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
}
