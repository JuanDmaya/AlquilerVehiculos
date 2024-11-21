package co.edu.umanizales.alquiler_carros.service;

import co.edu.umanizales.alquiler_carros.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private final List<Usuario> usuarios = new ArrayList<>();

    // Método para registrar un nuevo usuario
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Método para editar un usuario existente
    //Si se encuentra el usuario, actualiza su nombre, contraseña y rol con los valores del objeto usuarioEditado.

    public boolean editarUsuario(String login, Usuario usuarioEditado) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                usuario.setNombre(usuarioEditado.getNombre());
                usuario.setPassword(usuarioEditado.getPassword());
                usuario.setRol(usuarioEditado.getRol());
                return true;
            }
        }
        return false;
    }

    // Método para eliminar un usuario existente
    //Utiliza un predicado (expresión lambda) para buscar y eliminar usuarios cuyo login coincida con el proporcionado.
    public boolean eliminarUsuario(String login) {
        return usuarios.removeIf(usuario -> usuario.getLogin().equals(login));
    }

    // Método para listar todos los usuarios registrados
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }
}

