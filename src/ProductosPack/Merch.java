package ProductosPack;

public class Merch extends Productos {
    private String talle;
    private String color;

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Merch(String nombre, double precio, int stock, String talle, String color) {
        super(nombre, precio, stock);
        this.talle = talle;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Mercj{" +
                "talle='" + talle + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
