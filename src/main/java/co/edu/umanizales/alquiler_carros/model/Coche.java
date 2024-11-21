package co.edu.umanizales.alquiler_carros.model;

public class Coche extends Vehiculo {
    private boolean extras;

    // Constructor
    public Coche(String matricula, int km, boolean disponible, double valorAlquiler, boolean extras) {
        super(matricula, km, disponible, valorAlquiler); // Llama al constructor de Vehiculo
        this.extras = extras;  //Declara un atributo privado llamado extras que representa si el coche tiene o no características adicionales.
    }

    @Override
    public double calcularAlquiler(int kmRecorridos) {
        return kmRecorridos * 0.10; // Lógica de cálculo específica para coches
    }

    // Getters y setters
    public boolean isExtras() {
        return extras;
    } //Setter que permite asignar un valor al atributo extras.

    public void setExtras(boolean extras) {
        this.extras = extras;  //Inicializa el atributo extras de la clase Coche con el valor recibido como parámetro.
    }
}
