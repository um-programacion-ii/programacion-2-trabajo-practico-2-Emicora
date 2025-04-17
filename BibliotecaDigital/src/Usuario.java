
public class Usuario {
    private String nombre;
    private String id;
    private String email;

    public Usuario(String nombre, String id, String email) {
        if (nombre == null || nombre.isEmpty() ||
                id == null || id.isEmpty() ||
                email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Los campos nombre, ID y email son obligatorios.");
        }
        this.nombre = nombre;
        this.id = id;
        this.email = email;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
