package Simuladores;
import Project.*;

public class SimuladorConcurrente {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("Ana", "a1", "ana@mail.com", "261000000");
        Usuario u2 = new Usuario("Bruno", "b2", "bruno@mail.com", "261111111");
        Libro libro = new Libro("lib001", "Redes Neuronales", CategoriaRecurso.TECNOLOGIA, "Dr. Pérez", 300);

        GestorPrestamos gestor = new GestorPrestamos(new ServicioNotificacionPrestamos());

        Runnable tarea1 = () -> {
            try {
                gestor.realizarPrestamo(u1, libro);
            } catch (RecursoNoDisponibleException e) {
                System.out.println("Usuario 1: " + e.getMessage());
            }
        };

        Runnable tarea2 = () -> {
            try {
                gestor.realizarPrestamo(u2, libro);
            } catch (RecursoNoDisponibleException e) {
                System.out.println("Usuario 2: " + e.getMessage());
            }
        };

        Thread hilo1 = new Thread(tarea1);
        Thread hilo2 = new Thread(tarea2);

        hilo1.start();
        hilo2.start();
    }
}
