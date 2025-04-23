package Simuladores;
import Project.*;
import java.time.LocalDateTime;

public class SimuladorVencimiento {
    public static void main(String[] args) {
        // Crear un usuario
        Usuario usuario = new Usuario("Luis Soto", "luis123", "luis@mail.com", "2619876543");

        // Crear recurso digital y simular que ya fue prestado hace 6 días
        Libro libro = new Libro("lib101", "Harry Potter", CategoriaRecurso.TECNOLOGIA, "J. K. Rowling", 420);
        libro.actualizarEstado("prestado");

        // Crear préstamo simulado
        Prestamo prestamo = new Prestamo(usuario, libro);

        // Simular fecha de préstamo 6 días atrás (para que falte 1 día para vencimiento)
        prestamo.setFechaDevolucion(null); // aún no devuelto
        var field = Prestamo.class.getDeclaredFields()[2]; // fechaPrestamo
        field.setAccessible(true);
        try {
            field.set(prestamo, LocalDateTime.now().minusDays(6));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Ejecutar alerta
        AlertaVencimiento alerta = new AlertaVencimiento(prestamo, 7);
        alerta.validarYEnviar();
    }
}
