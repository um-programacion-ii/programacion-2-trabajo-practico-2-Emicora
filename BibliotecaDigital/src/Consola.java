import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Consola {
    private GestorUsuarios gestorUsuarios;
    private GestorRecursos gestorRecursos;
    private GestorPrestamos gestorPrestamos;
    private GestorReservas gestorReservas;

    public Consola(GestorUsuarios gestorUsuarios, GestorRecursos gestorRecursos, GestorPrestamos gestorPrestamos, GestorReservas gestorReservas) {
        this.gestorUsuarios = gestorUsuarios;
        this.gestorRecursos = gestorRecursos;
        this.gestorPrestamos = gestorPrestamos;
        this.gestorReservas = gestorReservas;
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
                        gestorReservas.mostrarReservas();
                        break;
                    case 7:
                        listarRecursos();
                        break;
                    case 8:
                        buscarRecurso(scanner);
                        break;
                    case 9:
                        buscarUsuario(scanner);
                        break;
                    case 10:
                        mostrarNotificaciones();
                        break;
                    case 11:
                        mostrarPrestamosActivos();
                        break;
                    case 12:
                        generarReportesBasicos();
                        break;
                    case 13:
                        ejecutarAlertasVencimiento();
                        break;
                    case 14:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
            System.out.println();
        } while (opcion != 14);

        scanner.close();
    }
    private void mostrarMenuPrincipal() {
        System.out.println("----- Menú de Operaciones -----");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Agregar Recurso");
        System.out.println("3. Realizar Préstamo");
        System.out.println("4. Devolver Recurso");
        System.out.println("5. Realizar Reserva");
        System.out.println("6. Mostrar Reservas");
        System.out.println("7. Listar Recursos");
        System.out.println("8. Buscar Recurso");
        System.out.println("9. Buscar Usuario");
        System.out.println("10. Mostrar Notificaciones");
        System.out.println("11. Mostrar Prestamos Activos");
        System.out.println("12. Mostrar Reportes");
        System.out.println("13. Verificar Vencimiento de Prestamo");
        System.out.println("14. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void ejecutarAlertasVencimiento() {
            System.out.println("----- ALERTAS DE VENCIMIENTO -----");
            for (Prestamo p : gestorPrestamos.getPrestamos()) {
                new AlertaVencimiento(p, 7).validarYEnviar();
            }
    }

    private void mostrarNotificaciones() {
        System.out.println("----- Notificaciones Pendientes -----");
        List<String> notifs = NotificationCenter.getInstance().fetchAll();
        if (notifs.isEmpty()) {
            System.out.println("No hay notificaciones.");
        } else {
            notifs.forEach(System.out::println);
        }
    }

    private void buscarUsuario(Scanner scanner) {
        System.out.println("----- Buscar Usuario -----");
        System.out.print("Ingrese el ID del usuario: ");
        String id = scanner.nextLine();
        try {
            Usuario usuario = gestorUsuarios.buscarUsuario(id);
            System.out.println("Usuario encontrado:");
            System.out.println("  Nombre: " + usuario.getNombre());
            System.out.println("  ID:     " + usuario.getId());
            System.out.println("  Email:  " + usuario.getEmail());
        } catch (UsuarioNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void buscarRecurso(Scanner scanner) {
        System.out.println("----- Buscar Recurso -----");
        System.out.println("a. Por Título");
        System.out.println("b. Por Categoría");
        System.out.print("Seleccione filtro: ");
        String filtro = scanner.nextLine().trim().toLowerCase();

        switch (filtro) {
            case "a":
                System.out.print("Ingrese texto a buscar en el título: ");
                String texto = scanner.nextLine();
                List<RecursoDigital> resultadosTitulo =
                        gestorRecursos.buscarPorTitulo(texto);
                mostrarLista(resultadosTitulo);
                break;

            case "b":
                System.out.println("Categorías disponibles: " + Arrays.toString(CategoriaRecurso.values()));
                System.out.print("Ingrese la categoría: ");
                String catStr = scanner.nextLine().toUpperCase();
                try {
                    CategoriaRecurso categoria = CategoriaRecurso.valueOf(catStr);
                    List<RecursoDigital> resultadosCat =
                            gestorRecursos.buscarPorCategoria(categoria);
                    mostrarLista(resultadosCat);
                } catch (IllegalArgumentException e) {
                    System.out.println("Categoría inválida.");
                }
                break;

            default:
                System.out.println("Filtro no válido.");
        }
    }

    private void mostrarLista(List<RecursoDigital> lista) {
        if (lista.isEmpty()) {
            System.out.println("No se encontraron recursos.");
        } else {
            System.out.println("Resultados:");
            for (RecursoDigital r : lista) {
                r.mostrarInformacion();
            }
        }
    }


    private void registrarUsuario(Scanner scanner) {
        System.out.println("----- Registrar Usuario -----");
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el email: ");
        String email = scanner.nextLine();
        System.out.println("Ingrase el numero de telefono:");
        String numero = scanner.nextLine();

        try {
            Usuario usuario = new Usuario(nombre, id, email, numero);
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

        System.out.println("Categorías disponibles: " + Arrays.toString(CategoriaRecurso.values()));
        System.out.print("Ingrese la categoría: ");
        String catStr = scanner.nextLine().toUpperCase();
        CategoriaRecurso categoria = null;
        try {
            categoria = CategoriaRecurso.valueOf(catStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Categoría inválida. Se cancelará la operación.");
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
                    Libro libro = new Libro(idLibro, tituloLibro, categoria, autor, paginas);
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
                    Audiolibro audiolibro = new Audiolibro(idAudio, tituloAudio, categoria, narrador, duracion);
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
                    Historieta historieta = new Historieta(idHistorieta, tituloHistorieta, categoria, ilustrador);
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
        try {
            System.out.print("ID Usuario: ");
            Usuario u = gestorUsuarios.buscarUsuario(scanner.nextLine());
            System.out.print("ID Recurso: ");
            String rid = scanner.nextLine();
            RecursoDigital r = gestorRecursos.listarRecursos().stream()
                    .filter(x -> x.getIdentificador().equals(rid))
                    .findFirst().orElse(null);
            if (r == null) {
                System.out.println("Recurso no encontrado.");
            } else {
                gestorPrestamos.realizarPrestamo(u, r);
            }
        } catch (Exception e) {
            System.out.println("Error al prestar: " + e.getMessage());
        }
    }

    private void devolverRecurso(Scanner scanner) {
        System.out.println("----- Devolver Recurso -----");
        System.out.print("ID Recurso: ");
        String rid2 = scanner.nextLine();
        RecursoDigital r2 = gestorRecursos.listarRecursos().stream()
                .filter(x -> x.getIdentificador().equals(rid2))
                .findFirst().orElse(null);
        if (r2 != null) {
            gestorPrestamos.devolverRecurso(r2);
            Reserva siguiente = gestorReservas.procesarSiguienteReserva();
            if (siguiente == null) {
                System.out.println("No hay reservas pendientes para este recurso.");
            }
        } else {
            System.out.println("Recurso no encontrado.");
        }
    }

    private void realizarReserva(Scanner scanner) {
        System.out.println("----- Realizar Reserva -----");
        try {
            System.out.print("ID Usuario: ");
            Usuario u2 = gestorUsuarios.buscarUsuario(scanner.nextLine());
            System.out.print("ID Recurso: ");
            String rr = scanner.nextLine();
            RecursoDigital rd = gestorRecursos.listarRecursos().stream()
                    .filter(x -> x.getIdentificador().equals(rr))
                    .findFirst().orElse(null);
            if (rd == null) {
                System.out.println("Recurso no encontrado.");
            } else {
                gestorReservas.agregarReserva(new Reserva(u2, rd));
            }
        } catch (Exception e) {
            System.out.println("Error al reservar: " + e.getMessage());
        }
    }private void mostrarPrestamosActivos() {
        System.out.println("----- Préstamos Activos -----");
        List<Prestamo> activos = gestorPrestamos.getPrestamos().stream()
                .filter(p -> p.getFechaDevolucion() == null)
                .collect(Collectors.toList());

        if (activos.isEmpty()) {
            System.out.println("No hay préstamos activos.");
        } else {
            for (Prestamo p : activos) {
                System.out.printf("Recurso: %s | Usuario: %s | Fecha préstamo: %s%n",
                        p.getRecurso().getTitulo(),
                        p.getUsuario().getNombre(),
                        p.getFechaPrestamo());
            }
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
    private void generarReportesBasicos() {
        System.out.println("===== REPORTES BÁSICOS =====");
        List<Prestamo> prestamos = gestorPrestamos.getPrestamos();
        Reportes.reporteRecursosMasPrestados(prestamos);
        Reportes.reporteUsuariosActivos(prestamos);
        Reportes.reportePorCategoria(prestamos);
        System.out.println("=============================");
    }

    public static void main(String[] args) {
        GestorUsuarios gestorUsuarios = new GestorUsuarios();
        ServicioNotificacionPrestamos notificador = new ServicioNotificacionPrestamos();
        ServicioNotificaciones servicioNotificaciones = new ServicioNotificacionesEmail();
        GestorRecursos gestorRecursos = new GestorRecursos(servicioNotificaciones);
        GestorPrestamos gestorPrestamos = new GestorPrestamos(notificador);
        GestorReservas gestorReservas = new GestorReservas(gestorPrestamos);

        Consola consola = new Consola(gestorUsuarios, gestorRecursos, gestorPrestamos, gestorReservas);
        consola.iniciar();
        notificador.shutdown();
    }
}