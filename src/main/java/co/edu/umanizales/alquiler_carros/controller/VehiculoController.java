package co.edu.umanizales.alquiler_carros.controller;

import co.edu.umanizales.alquiler_carros.model.Vehiculo;
import co.edu.umanizales.alquiler_carros.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    @Autowired  //Indica a Spring que debe inyectar automáticamente una instancia de VehiculoService en esta clase para manejar la lógica de negocio relacionada con vehículos.
    private VehiculoService vehiculoService;

    @GetMapping("/disponibles")
    public List<Vehiculo> obtenerVehiculosDisponibles() {
        return vehiculoService.obtenerVehiculosDisponibles();
    }

    // Método POST para registrar un nuevo vehículo
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarVehiculo(@RequestBody Vehiculo vehiculo) {
        vehiculoService.registrarVehiculo(vehiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Vehículo registrado con éxito");

    }


    @DeleteMapping ("/eliminar/{matricula}")
        public ResponseEntity<String> eliminarVehiculo(@PathVariable String matricula) {  //Extrae el valor del parámetro {matricula} de la URL y lo asigna a la variable matricula.
            boolean eliminado = vehiculoService.eliminarVehiculo(matricula);
            if (eliminado) {
                return ResponseEntity.ok("Vehículo eliminado con éxito");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehículo no encontrado"); //Si no se encontró el vehículo, devuelve una respuesta 404 NOT FOUND con un mensaje de error.
            }
        }

}
