package Simuladores;
import Project.*;

public class SimuladorDisponibilidad {
    public static void main(String[] args) {
        // Crear usuario y recurso
        Usuario usuario = new Usuario("María Juárez", "mj456", "maria@mail.com", "2616547890");
        Audiolibro audio = new Audiolibro("audio300", "La Ciencia de Dormir", CategoriaRecurso.CIENCIA, "Carlos Vera", 90);
        audio.actualizarEstado("reservado");

        // Crear gestores necesarios
        ServicioNotificacionPrestamos notificador = new ServicioNotificacionPrestamos();
        GestorPrestamos gestorPrestamos = new GestorPrestamos(notificador);

        // Simular alerta de disponibilidad
        audio.actualizarEstado("disponible");
        AlertaDisponibilidad alerta = new AlertaDisponibilidad(audio, usuario, gestorPrestamos);
        alerta.enviarAlerta(); // pedirá input para prestar automáticamente

        notificador.shutdown();
    }
}
