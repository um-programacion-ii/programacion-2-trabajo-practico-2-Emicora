package Project;

public interface Prestable {
    boolean estaDisponible();
    void prestar(Usuario usuario);
    void devolver();
}
