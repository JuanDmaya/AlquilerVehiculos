package co.edu.umanizales.alquiler_carros.model;

public class Moto extends Vehiculo {
    private boolean casco;

    public Moto(String matricula, int km, boolean disponible, double valorAlquiler, boolean casco) {
        super(matricula, km, disponible, valorAlquiler);
        this.casco = casco;
    }

    @Override
    public double calcularAlquiler(int kmRecorridos) {
        return kmRecorridos * 0.05;
    }

    // Getters y setters
}
