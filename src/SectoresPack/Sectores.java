package SectoresPack;

public abstract class  Sectores {
    
    protected int capacidad;

    public Sectores(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

   

    @Override
    public String toString() {
        return "SectoresPack.Sectores{" +
                "capacidad=" + capacidad +
                '}';
    }


}
