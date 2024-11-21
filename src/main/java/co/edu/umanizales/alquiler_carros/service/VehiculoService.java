package co.edu.umanizales.alquiler_carros.service;

import co.edu.umanizales.alquiler_carros.model.Vehiculo;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service //decorador que declara la clase como un servicio
public class VehiculoService {
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public List<Vehiculo> obtenerVehiculosDisponibles() {
        List<Vehiculo> disponibles = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.isDisponible()) {
                disponibles.add(vehiculo);
            }
        }
        return disponibles;
    }

    public void registrarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public boolean eliminarVehiculo(String matricula) {
        return vehiculos.removeIf(vehiculo -> vehiculo.getMatricula().equals(matricula));
    }

    //método para obtener la cantidad de vehículos disponibles por tipo
    public Map<String, Integer> contarVehiculosDisponiblesPorTipo() {
        Map<String, Integer> conteoPorTipo = new HashMap<>();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.isDisponible()) {
                String tipo = vehiculo.getClass().getSimpleName(); // Obtiene el tipo de clase
                conteoPorTipo.put(tipo, conteoPorTipo.getOrDefault(tipo, 0) + 1);
            }
        }
        return conteoPorTipo;
    }
}
