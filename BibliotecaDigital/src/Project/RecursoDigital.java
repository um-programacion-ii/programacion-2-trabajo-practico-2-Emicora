package Project;
public abstract class RecursoDigital {
    private String identificador;
    private String titulo;
    private String estado;
    private CategoriaRecurso categoria; // Nuevo atributo

    public RecursoDigital(String identificador, String titulo, CategoriaRecurso categoria) {
        if (identificador == null || identificador.isEmpty() ||
                titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("Identificador y título son obligatorios.");
        }
        this.identificador = identificador;
        this.titulo = titulo;
        this.estado = "disponible";
        this.categoria = categoria;
    }

    public String getIdentificador() { return identificador; }
    public String getTitulo() { return titulo; }
    public String getEstado() { return estado; }
    public void actualizarEstado(String nuevoEstado) { this.estado = nuevoEstado; }

    public CategoriaRecurso getCategoria() { return categoria; }
    public void setCategoria(CategoriaRecurso categoria) { this.categoria = categoria; }

    public abstract void mostrarInformacion();
}
