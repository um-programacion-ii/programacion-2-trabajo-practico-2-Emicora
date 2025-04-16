import java.util.ArrayList;
import java.util.List;


public class GestorRecursos {
    private List<RecursoDigital> recursos;
    private ServicioNotificaciones servicioNotificaciones;


    public GestorRecursos(ServicioNotificaciones servicioNotificaciones) {
        this.recursos = new ArrayList<>();
        this.servicioNotificaciones = servicioNotificaciones;
    }

    public void agregarRecurso(RecursoDigital recurso) {
        recursos.add(recurso);
    }

    public List<RecursoDigital> listarRecursos() {
        return recursos;
    }
}
