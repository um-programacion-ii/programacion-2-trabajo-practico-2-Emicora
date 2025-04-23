package Project;

import java.time.LocalDateTime;

public class Prestamo {
    private Usuario usuario;
    private RecursoDigital recurso;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;

    public Prestamo(Usuario usuario, RecursoDigital recurso) {
        this.usuario = usuario;
        this.recurso = recurso;
        this.fechaPrestamo = LocalDateTime.now();
    }

    public Usuario getUsuario() { return usuario; }
    public RecursoDigital getRecurso() { return recurso; }
    public LocalDateTime getFechaPrestamo() { return fechaPrestamo; }
    public LocalDateTime getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDateTime fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }
}
