import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestorRecursos {
    private List<RecursoDigital> recursos;
    private ServicioNotificaciones servicioNotificaciones;


    public GestorRecursos(ServicioNotificaciones servicioNotificaciones) {
        this.recursos = new ArrayList<>();
        this.servicioNotificaciones = servicioNotificaciones;
    }

    public List<RecursoDigital> buscarPorTitulo(String titulo) {
        return recursos.stream()
                .filter(r -> r.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void agregarRecurso(RecursoDigital recurso) {
        recursos.add(recurso);
    }

    public List<RecursoDigital> listarRecursos() {
        return recursos;
    }
}
