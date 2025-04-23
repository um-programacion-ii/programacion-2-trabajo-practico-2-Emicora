package Project;

public class Usuario {
    private String nombre;
    private String id;
    private String email;
    private String numero;

    public Usuario(String nombre, String id, String email, String numero) {
        if (nombre == null || nombre.isEmpty() ||
                id == null || id.isEmpty() ||
                email == null || email.isEmpty()
                 || numero == null || numero.isEmpty()) {
            throw new IllegalArgumentException("Los campos nombre, ID y email son obligatorios.");
        }
        this.nombre = nombre;
        this.id = id;
        this.email = email;
        this.numero = numero;
    }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
