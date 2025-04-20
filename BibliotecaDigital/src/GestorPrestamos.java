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
        if (!recurso.getEstado().equalsIgnoreCase("disponible")) {
            throw new RecursoNoDisponibleException("El recurso " + recurso.getTitulo() + " no está disponible.");
        }
        recurso.actualizarEstado("prestado");
        Prestamo prestamo = new Prestamo(usuario, recurso);
        prestamos.add(prestamo);
        notificador.notificarPrestamo(usuario, recurso);
        System.out.println("Préstamo realizado: " + recurso.getTitulo() + " a " + usuario.getNombre());
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
