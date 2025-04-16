
public class Libro extends RecursoDigital implements Prestable, Renovable {
    private String autor;
    private int paginas;

    public Libro(String identificador, String titulo, String autor, int paginas) {
        super(identificador, titulo);
        this.autor = autor;
        this.paginas = paginas;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Libro: " + getTitulo()
                + " | Autor: " + autor
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
            System.out.println("El libro \"" + getTitulo() + "\" ha sido prestado a " + usuario.getNombre());
        } else {
            System.out.println("El libro \"" + getTitulo() + "\" no está disponible para préstamo.");
        }
    }

    @Override
    public void devolver() {
        actualizarEstado("disponible");
        System.out.println("El libro \"" + getTitulo() + "\" ha sido devuelto.");
    }

    @Override
    public void renovar() {
        System.out.println("El préstamo del libro \"" + getTitulo() + "\" ha sido renovado.");
    }
}
