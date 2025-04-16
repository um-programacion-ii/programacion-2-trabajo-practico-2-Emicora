public class Audiolibro extends RecursoDigital implements Prestable, Renovable {
    private String narrador;
    private int duracion;

    public Audiolibro(String identificador, String titulo, String narrador, int duracion) {
        super(identificador, titulo);
        this.narrador = narrador;
        this.duracion = duracion;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Audiolibro: " + getTitulo()
                + " | Narrador: " + narrador
                + " | Duración: " + duracion + " minutos"
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
            System.out.println("El audiolibro \"" + getTitulo() + "\" ha sido prestado a " + usuario.getNombre());
        } else {
            System.out.println("El audiolibro \"" + getTitulo() + "\" no está disponible para préstamo.");
        }
    }

    @Override
    public void devolver() {
        actualizarEstado("disponible");
        System.out.println("El audiolibro \"" + getTitulo() + "\" ha sido devuelto.");
    }


    @Override
    public void renovar() {
        System.out.println("El préstamo del audiolibro \"" + getTitulo() + "\" ha sido renovado.");
    }
}
