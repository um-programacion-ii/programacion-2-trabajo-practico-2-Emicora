package Project;

public class ServicioNotificacionesSMS implements ServicioNotificaciones {
    @Override
    public void enviarNotificacion(String destinatario, String mensaje) {
        System.out.println("Enviando SMS a " + destinatario + ": " + mensaje);
        NotificationCenter.getInstance()
                .addNotification("[SMS] Para " + destinatario + ": " + mensaje);
    }
}
