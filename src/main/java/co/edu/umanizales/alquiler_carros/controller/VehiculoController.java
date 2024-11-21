package co.edu.umanizales.alquiler_carros.controller;

import co.edu.umanizales.alquiler_carros.model.Vehiculo;
import co.edu.umanizales.alquiler_carros.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;


import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping("/disponibles")
    public List<Vehiculo> obtenerVehiculosDisponibles() {
        return vehiculoService.obtenerVehiculosDisponibles();
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarVehiculo(@RequestBody Vehiculo vehiculo) {
        vehiculoService.registrarVehiculo(vehiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Vehículo registrado con éxito");
    }

    @DeleteMapping("/eliminar/{matricula}")
    public ResponseEntity<String> eliminarVehiculo(@PathVariable String matricula) {
        boolean eliminado = vehiculoService.eliminarVehiculo(matricula);
        if (eliminado) {
            return ResponseEntity.ok("Vehículo eliminado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehículo no encontrado");
        }
    }

    //endpoint para obtener el conteo de vehículos disponibles por tipo
    @GetMapping("/conteo-disponibles")
    public ResponseEntity<Map<String, Integer>> obtenerConteoVehiculosDisponiblesPorTipo() {
        Map<String, Integer> conteo = vehiculoService.contarVehiculosDisponiblesPorTipo();
        return ResponseEntity.ok(conteo);
    }
}