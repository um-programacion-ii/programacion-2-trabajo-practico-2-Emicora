import java.util.ArrayList;
import java.util.List;


public class GestorRecursos {
    private List<RecursoDigital> recursos;

    public GestorRecursos() {

        this.recursos = new ArrayList<>();
    }

    public void agregarRecurso(RecursoDigital recurso) {
        recursos.add(recurso);
    }

    public List<RecursoDigital> listarRecursos() {
        return recursos;
    }


}
