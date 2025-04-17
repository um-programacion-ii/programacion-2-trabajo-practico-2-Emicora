import java.util.HashMap;
import java.util.Map;

public class GestorUsuarios {
    private Map<String, Usuario> usuarios;

    public GestorUsuarios() {
        usuarios = new HashMap<>();
    }

    public void registrarUsuario(Usuario usuario) {
        if (usuarios.containsKey(usuario.getId())) {
            throw new IllegalArgumentException("El usuario ya está registrado.");
        }
        usuarios.put(usuario.getId(), usuario);
    }

    public Usuario buscarUsuario(String id) throws UsuarioNoEncontradoException {
        if (!usuarios.containsKey(id)) {
            throw new UsuarioNoEncontradoException("Usuario con ID " + id + " no encontrado.");
        }
        return usuarios.get(id);
    }
}
