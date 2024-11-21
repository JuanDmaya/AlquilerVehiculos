package co.edu.umanizales.alquiler_carros.model;

public abstract class Vehiculo {

    private String matricula;
    private int km;
    private boolean disponible;
    private double valorAlquiler; // Nuevo atributo

    // Constructor
    public Vehiculo(String matricula, int km, boolean disponible, double valorAlquiler) {
        this.matricula = matricula;
        this.km = km;
        this.disponible = disponible;
        this.valorAlquiler = valorAlquiler;
    }
      //Asigna el valor recibido en el parámetro valorAlquiler al atributo valorAlquiler

    // Getters y Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double getValorAlquiler() {
        return valorAlquiler;
    }

    public void setValorAlquiler(double valorAlquiler) {
        this.valorAlquiler = valorAlquiler;
    }

    // Método abstracto que implementarán las subclases
    public abstract double calcularAlquiler(int km);
}
// Declara un método abstracto que calcula el costo del alquiler en función de
// los kilómetros recorridos. Este método debe ser implementado por cualquier clase que herede de Vehiculo