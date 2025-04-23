package Simuladores;
import Project.*;

public class SimuladorPrestamoFallido {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("Martina López", "ml123", "martina@mail.com", "2614441234");
        Usuario u2 = new Usuario("Tomás Herrera", "th456", "tomas@mail.com", "2615555678");

        Libro libro = new Libro("lib998", "Criptografía Moderna", CategoriaRecurso.CIENCIA, "E. Soto", 200);

        ServicioNotificacionPrestamos notificador = new ServicioNotificacionPrestamos();
        GestorPrestamos gestor = new GestorPrestamos(notificador);

        try {
            // Primer préstamo exitoso
            gestor.realizarPrestamo(u1, libro);
            // Segundo intento debe fallar
            gestor.realizarPrestamo(u2, libro);
        } catch (RecursoNoDisponibleException e) {
            System.out.println("❌ Error al prestar: " + e.getMessage());
        }

        notificador.shutdown();
    }
}
