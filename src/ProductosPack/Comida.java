public class Comida extends Productos{
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Comida(String nombre, double precio, int stock, String tipo) {
        super(nombre, precio, stock);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Comida{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
