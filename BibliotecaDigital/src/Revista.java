
public class Revista extends RecursoDigital {
    private String editor;
    private int numero;

    public Revista(String identificador, String titulo, String editor, int numero) {
        super(identificador, titulo);
        this.editor = editor;
        this.numero = numero;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Revista: " + getTitulo()
                + " | Editor: " + editor
                + " | Número: " + numero
                + " | Estado: " + getEstado());
    }


}
