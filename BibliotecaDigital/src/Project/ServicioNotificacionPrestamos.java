package Project;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServicioNotificacionPrestamos {
    private final ServicioNotificaciones emailService;
    private final ServicioNotificaciones smsService;
    private final ExecutorService executor;

    public ServicioNotificacionPrestamos() {
        this.emailService = new ServicioNotificacionesEmail();
        this.smsService   = new ServicioNotificacionesSMS();
        this.executor     = Executors.newFixedThreadPool(2);
    }


    public void notificarPrestamo(Usuario usuario, RecursoDigital recurso) {
        String mensaje = "Se ha realizado un préstamo del recurso: " + recurso.getTitulo();
        executor.submit(() ->
                emailService.enviarNotificacion(usuario.getEmail(), mensaje)
        );
        executor.submit(() ->
                smsService.enviarNotificacion(usuario.getNumero(), mensaje)
        );
    }

    public void shutdown() {
        executor.shutdown();
    }
}
