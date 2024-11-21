package co.edu.umanizales.alquiler_carros.model;

public class Furgoneta extends Vehiculo {
    private short capacidad;
    //Define un constructor para la clase Furgoneta que recibe parámetros para inicializar los atributos heredados de Vehiculo y el atributo específico capacidad.
    public Furgoneta(String matricula, int km, boolean disponible, double valorAlquiler, short capacidad) {
        super(matricula, km, disponible, valorAlquiler);
        this.capacidad = capacidad; //Asigna el valor recibido en el parámetro capacidad al atributo privado capacidad de la clase Furgoneta.
    }

    @Override  //Indica que este método sobrescribe el método calcularAlquiler de la clase base Vehiculo.
    public double calcularAlquiler(int kmRecorridos) {
        return kmRecorridos * 0.15;
    } //Método que calcula el costo de alquiler basado en los kilómetros recorridos.

    // Getters y setters
}
