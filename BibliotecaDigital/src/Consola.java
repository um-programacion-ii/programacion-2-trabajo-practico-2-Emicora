import java.util.Scanner;
import java.util.List;

public class Consola {
    private GestorUsuarios gestorUsuarios;
    private GestorRecursos gestorRecursos;


    public Consola(GestorUsuarios gestorUsuarios, GestorRecursos gestorRecursos) {
        this.gestorUsuarios = gestorUsuarios;
        this.gestorRecursos = gestorRecursos;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("----- Menú Principal -----");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Agregar Recurso");
            System.out.println("3. Listar Recursos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        registrarUsuario(scanner);
                        break;
                    case 2:
                        agregarRecurso(scanner);
                        break;
                    case 3:
                        listarRecursos();
                        break;
                    case 4:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }

            System.out.println();
        } while(opcion != 4);

        scanner.close();
    }

    private void registrarUsuario(Scanner scanner) {
        System.out.println("----- Registrar Usuario -----");
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el email: ");
        String email = scanner.nextLine();

        try {
            Usuario usuario = new Usuario(nombre, id, email);
            gestorUsuarios.registrarUsuario(usuario);
            System.out.println("Usuario registrado correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
    }

    private void agregarRecurso(Scanner scanner) {
        System.out.println("----- Agregar Recurso -----");
        // En este ejemplo se implementa solo para agregar un Libro.
        System.out.println("Tipo de recurso a agregar: Libro");
        System.out.print("Ingrese el identificador: ");
        String identificador = scanner.nextLine();
        System.out.print("Ingrese el título: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el número de páginas: ");
        int paginas = 0;
        try {
            paginas = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Número de páginas inválido. Se usará 0.");
        }

        try {
            Libro libro = new Libro(identificador, titulo, autor, paginas);
            gestorRecursos.agregarRecurso(libro);
            System.out.println("Recurso (Libro) agregado correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al agregar el recurso: " + e.getMessage());
        }
    }

    private void listarRecursos() {
        System.out.println("----- Listado de Recursos -----");
        List<RecursoDigital> recursos = gestorRecursos.listarRecursos();
        if (recursos.isEmpty()) {
            System.out.println("No hay recursos disponibles.");
        } else {
            for (RecursoDigital r : recursos) {
                r.mostrarInformacion();
            }
        }
    }

    public static void main(String[] args) {
        GestorUsuarios gestorUsuarios = new GestorUsuarios();
        GestorRecursos gestorRecursos = new GestorRecursos();


        Consola consola = new Consola(gestorUsuarios, gestorRecursos);
        consola.iniciar();
    }
}
