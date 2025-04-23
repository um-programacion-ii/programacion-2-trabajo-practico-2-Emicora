package Project;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Reportes {

    public static void reporteRecursosMasPrestados(List<Prestamo> prestamos) {
        Map<String, Long> conteoPorRecurso = prestamos.stream()
                .collect(Collectors.groupingBy(p -> p.getRecurso().getTitulo(), Collectors.counting()));
        conteoPorRecurso.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(e -> mostrarReporte(
                        "Recurso más prestado",
                        List.of(e.getKey() + " con " + e.getValue() + " préstamos")
                ));
    }

    public static void reporteUsuariosActivos(List<Prestamo> prestamos) {
        Map<String, Long> conteoPorUsuario = prestamos.stream()
                .collect(Collectors.groupingBy(
                        p -> p.getUsuario().getNombre(),
                        Collectors.counting()
                ));
        List<String> top10 = conteoPorUsuario.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(e -> e.getKey() + " con " + e.getValue() + " préstamos")
                .collect(Collectors.toList());

        mostrarReporte("Top 10 Usuarios más activos", top10);
    }

    public static void reportePorCategoria(List<Prestamo> prestamos) {
        Map<CategoriaRecurso, Long> conteoPorCategoria = prestamos.stream()
                .collect(Collectors.groupingBy(p -> p.getRecurso().getCategoria(), Collectors.counting()));
        List<String> lineas = conteoPorCategoria.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue() + " préstamos")
                .collect(Collectors.toList());
        mostrarReporte("Préstamos por Categoría", lineas);
    }

    private static void mostrarReporte(String titulo, List<String> lineas) {
        System.out.println("\n=== " + titulo + " ===");
        lineas.forEach(System.out::println);
        System.out.println("=========================\n");
    }
}
