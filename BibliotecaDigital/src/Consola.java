import java.util.Scanner;

public class Consola {
    private GestorUsuarios gestorUsuarios;
    private GestorRecursos gestorRecursos;

    public Consola(GestorUsuarios gestorUsuarios, GestorRecursos gestorRecursos) {
        this.gestorUsuarios = gestorUsuarios;
        this.gestorRecursos = gestorRecursos;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al Sistema de Gestión de Biblioteca Digital");

        System.out.println("1. Registrar Usuario");
        System.out.println("2. Agregar Recurso");
        System.out.println("Seleccione una opción:");

        int opcion = Integer.parseInt(scanner.nextLine());
        System.out.println("Opción seleccionada: " + opcion);
        scanner.close();
    }

    public static void main(String[] args) {

        GestorUsuarios gestorUsuarios = new GestorUsuarios();
        GestorRecursos gestorRecursos = new GestorRecursos();
        Consola consola = new Consola(gestorUsuarios, gestorRecursos);
        consola.iniciar();
    }
}
