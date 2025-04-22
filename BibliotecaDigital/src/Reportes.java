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
                .collect(Collectors.groupingBy(p -> p.getUsuario().getNombre(), Collectors.counting()));
        conteoPorUsuario.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(e -> mostrarReporte(
                        "Usuario más activo",
                        List.of(e.getKey() + " con " + e.getValue() + " préstamos")
                ));
    }
    
    private static void mostrarReporte(String titulo, List<String> lineas) {
        System.out.println("\n=== " + titulo + " ===");
        lineas.forEach(System.out::println);
        System.out.println("=========================\n");
    }
}
