package SectoresPack;

public class Sectores  {
    private int capacidad;



    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Sectores(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "SectoresPack.Sectores{" +
                "capacidad=" + capacidad +
                '}';
    }


}
