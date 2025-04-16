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
            mostrarMenuPrincipal();
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
                        realizarPrestamo(scanner);
                        break;
                    case 4:
                        devolverRecurso(scanner);
                        break;
                    case 5:
                        realizarReserva(scanner);
                        break;
                    case 6:
                        listarRecursos();
                        break;
                    case 7:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
            System.out.println();
        } while(opcion != 7);

        scanner.close();
    }

    private void mostrarMenuPrincipal() {
        System.out.println("----- Menú de Operaciones -----");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Agregar Recurso");
        System.out.println("3. Realizar Préstamo");
        System.out.println("4. Devolver Recurso");
        System.out.println("5. Realizar Reserva");
        System.out.println("6. Listar Recursos");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
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
        System.out.println("Seleccione el tipo de recurso a agregar:");
        System.out.println("1. Libro");
        System.out.println("2. Audiolibro");
        System.out.println("3. Historieta");
        System.out.print("Opción: ");
        int tipoRecurso = 0;
        try {
            tipoRecurso = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opción inválida. Se cancelará la operación.");
            return;
        }

        switch (tipoRecurso) {
            case 1:
                System.out.println("----- Agregar Libro -----");
                System.out.print("Ingrese el identificador: ");
                String idLibro = scanner.nextLine();
                System.out.print("Ingrese el título: ");
                String tituloLibro = scanner.nextLine();
                System.out.print("Ingrese el autor: ");
                String autor = scanner.nextLine();
                System.out.print("Ingrese el número de páginas: ");
                int paginas = 0;
                try {
                    paginas = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Número de páginas inválido. Se asignará 0.");
                }
                try {
                    Libro libro = new Libro(idLibro, tituloLibro, autor, paginas);
                    gestorRecursos.agregarRecurso(libro);
                    System.out.println("Libro agregado correctamente.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error al agregar el libro: " + e.getMessage());
                }
                break;
            case 2:
                System.out.println("----- Agregar Audiolibro -----");
                System.out.print("Ingrese el identificador: ");
                String idAudio = scanner.nextLine();
                System.out.print("Ingrese el título: ");
                String tituloAudio = scanner.nextLine();
                System.out.print("Ingrese el narrador: ");
                String narrador = scanner.nextLine();
                System.out.print("Ingrese la duración en minutos: ");
                int duracion = 0;
                try {
                    duracion = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Número de minutos inválido. Se asignará 0.");
                }
                try {
                    Audiolibro audiolibro = new Audiolibro(idAudio, tituloAudio, narrador, duracion);
                    gestorRecursos.agregarRecurso(audiolibro);
                    System.out.println("Audiolibro agregado correctamente.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error al agregar el audiolibro: " + e.getMessage());
                }
                break;
            case 3:
                System.out.println("----- Agregar Historieta -----");
                System.out.print("Ingrese el identificador: ");
                String idHistorieta = scanner.nextLine();
                System.out.print("Ingrese el título: ");
                String tituloHistorieta = scanner.nextLine();
                System.out.print("Ingrese el ilustrador: ");
                String ilustrador = scanner.nextLine();
                try {
                    Historieta historieta = new Historieta(idHistorieta, tituloHistorieta, ilustrador);
                    gestorRecursos.agregarRecurso(historieta);
                    System.out.println("Historieta agregada correctamente.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error al agregar la historieta: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Opción de recurso no válida.");
        }
    }

    private void realizarPrestamo(Scanner scanner) {
        System.out.println("----- Realizar Préstamo -----");
    }

    private void devolverRecurso(Scanner scanner) {
        System.out.println("----- Devolver Recurso -----");
    }

    private void realizarReserva(Scanner scanner) {
        System.out.println("----- Realizar Reserva -----");
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