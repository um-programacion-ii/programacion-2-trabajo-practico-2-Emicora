
public class Libro extends RecursoDigital {
    private String autor;
    private int paginas;


    public Libro(String identificador, String titulo, String autor, int paginas) {
        super(identificador, titulo);
        this.autor = autor;
        this.paginas = paginas;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Libro: " + getTitulo() + " | Autor: " + autor + " | Estado: " + getEstado());
    }


}
