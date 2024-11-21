package co.edu.umanizales.alquiler_carros.service;

import co.edu.umanizales.alquiler_carros.model.Vehiculo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //decorador que declara la clase como un servicio
public class VehiculoService {
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public List<Vehiculo> obtenerVehiculosDisponibles() {
        List<Vehiculo> disponibles = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.isDisponible()) { // Verifica si el vehículo está disponible llamando al método isDisponible()
                disponibles.add(vehiculo); //Si el vehículo está disponible, se agrega a la lista disponibles.
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
   //Utiliza un predicado (expresión lambda) para buscar y eliminar vehículos de la lista cuyo atributo matricula coincida con el valor proporcionado.


    // Métodos para editar, eliminar, activar/desactivar
}
