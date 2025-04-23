package Project;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

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

    public List<RecursoDigital> buscarPorCategoria(CategoriaRecurso categoria) {
        return recursos.stream()
                .filter(r -> r.getCategoria().equals(categoria))
                .collect(Collectors.toList());
    }

    public List<RecursoDigital> ordenarPorTitulo() {
        return recursos.stream()
                .sorted(Comparator.comparing(RecursoDigital::getTitulo))
                .collect(Collectors.toList());
    }

    public void agregarRecurso(RecursoDigital recurso) {
        recursos.add(recurso);
    }

    public List<RecursoDigital> listarRecursos() {
        return recursos;
    }
}
