
public class Historieta extends RecursoDigital {
    private String ilustrador;

    public Historieta(String identificador, String titulo, String ilustrador) {
        super(identificador, titulo);
        this.ilustrador = ilustrador;
    }


    @Override
    public void mostrarInformacion() {
        System.out.println("Historieta: " + getTitulo()
                + " | Ilustrador: " + ilustrador
                + " | Estado: " + getEstado());
    }
}
