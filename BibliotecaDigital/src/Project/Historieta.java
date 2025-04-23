package Project;

public class Historieta extends RecursoDigital implements Prestable, Renovable {
    private String ilustrador;

    public Historieta(String identificador, String titulo, CategoriaRecurso categoria, String ilustrador) {
        super(identificador, titulo, categoria);
        this.ilustrador = ilustrador;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Project.Historieta: " + getTitulo()
                + " | Categoría: " + getCategoria()
                + " | Ilustrador: " + ilustrador
                + " | Estado: " + getEstado());
    }

    @Override
    public boolean estaDisponible() {
        return getEstado().equalsIgnoreCase("disponible");
    }

    @Override
    public void prestar(Usuario usuario) {
        if (estaDisponible()) {
            actualizarEstado("prestado");
            System.out.println("La historieta \"" + getTitulo() + "\" ha sido prestada a " + usuario.getNombre());
        } else {
            System.out.println("La historieta \"" + getTitulo() + "\" no está disponible para préstamo.");
        }
    }

    @Override
    public void devolver() {
        actualizarEstado("disponible");
        System.out.println("La historieta \"" + getTitulo() + "\" ha sido devuelta.");
    }

    @Override
    public void renovar() {
        System.out.println("El préstamo de la historieta \"" + getTitulo() + "\" ha sido renovado.");
    }
}
