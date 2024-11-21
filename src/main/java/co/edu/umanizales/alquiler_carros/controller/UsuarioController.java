package co.edu.umanizales.alquiler_carros.controller;

import co.edu.umanizales.alquiler_carros.model.Usuario;
import co.edu.umanizales.alquiler_carros.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios") //Define el prefijo /usuarios para todas las rutas en este controlador.
public class UsuarioController {

    private final UsuarioService usuarioService; //Declara una dependencia del servicio UsuarioService para gestionar
    //la lógica de negocio de los usuarios.

    public UsuarioController(UsuarioService usuarioService) { //Recibe una instancia de UsuarioService (inyectada por Spring) y la asigna al atributo usuarioService.
        this.usuarioService = usuarioService;
    }


    // método post para registrar un nuevo usuario
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario) {
        usuarioService.registrarUsuario(usuario); //Llama al método registrarUsuario de UsuarioService para agregar el usuario recibido.
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado con éxito"); // Representa la respuesta HTTP, con un mensaje y un código de estado.
    }

    // Método PUT para editar un usuario existente
    @PutMapping("/editar/{login}")
    public ResponseEntity<String> editarUsuario(@PathVariable String login, @RequestBody Usuario usuarioEditado) {  //Extrae el valor del parámetro {login} de la URL.
        boolean editado = usuarioService.editarUsuario(login, usuarioEditado);
        if (editado) {
            return ResponseEntity.ok("Usuario editado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

    // Método DELETE para eliminar un usuario
    @DeleteMapping("/eliminar/{login}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable String login) {
        boolean eliminado = usuarioService.eliminarUsuario(login); //Llama al método eliminarUsuario de UsuarioService. Devuelve true si el usuario fue eliminado.
        if (eliminado) {
            return ResponseEntity.ok("Usuario eliminado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

    // Método GET para listar todos los usuarios registrados
    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios(); //Llama al método listarUsuarios de UsuarioService para obtener la lista de usuarios.
        return ResponseEntity.ok(usuarios);
    }
}
