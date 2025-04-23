package Project;

public class Revista extends RecursoDigital {
    private String editor;
    private int numero;

    public Revista(String identificador, String titulo, CategoriaRecurso categoria,
                   String editor, int numero) {
        super(identificador, titulo, categoria);
        this.editor = editor;
        this.numero = numero;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Project.Revista: " + getTitulo()
                + " | Categoría: " + getCategoria()
                + " | Editor: " + editor
                + " | Número: " + numero
                + " | Estado: " + getEstado());
    }


}
