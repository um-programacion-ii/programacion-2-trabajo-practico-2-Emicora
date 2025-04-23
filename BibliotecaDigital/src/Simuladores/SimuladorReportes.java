package Simuladores;
import Project.*;
import java.util.List;
import java.util.ArrayList;

public class SimuladorReportes {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("Lucas Ruiz", "lucas", "lucas@mail.com", "2611110000");
        Usuario u2 = new Usuario("Valeria Navas", "valen", "valen@mail.com", "2612220000");

        Libro libro = new Libro("lib123", "Algoritmos", CategoriaRecurso.TECNOLOGIA, "A. Torres", 350);
        Audiolibro audio = new Audiolibro("aud123", "Historia de la Ciencia", CategoriaRecurso.HISTORIA, "M. Gómez", 95);

        List<Prestamo> prestamos = new ArrayList<>();
        prestamos.add(new Prestamo(u1, libro));
        prestamos.add(new Prestamo(u1, libro));
        prestamos.add(new Prestamo(u2, audio));
        prestamos.add(new Prestamo(u2, libro));
        prestamos.add(new Prestamo(u2, audio));

        // Simular generación de reportes
        Reportes.reporteRecursosMasPrestados(prestamos);
        Reportes.reporteUsuariosActivos(prestamos);
        Reportes.reportePorCategoria(prestamos);
    }
}
