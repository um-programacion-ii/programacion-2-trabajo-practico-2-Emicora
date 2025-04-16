
public class ServicioNotificacionesEmail implements ServicioNotificaciones {
    @Override
    public void enviarNotificacion(String destinatario, String mensaje) {
        System.out.println("Enviando EMAIL a " + destinatario + ": " + mensaje);
    }
}
