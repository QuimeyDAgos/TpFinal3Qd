package ProductosPack;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Productos implements Comparable<Productos>{

    protected String nombre;
    protected double precio;
    protected int stock;
    protected boolean disponibilad;
    protected int id;
    protected String tipo;

    public boolean isDisponibilad() {
        return disponibilad;
    }

    public void setDisponibilad(boolean disponibilad) {
        this.disponibilad = disponibilad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Productos() {
    }

    public Productos(String nombre, double precio, int stock, boolean disponibilad, int id, String tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.disponibilad = disponibilad;
        this.id = id;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "ProductosPack.Productos{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Productos productos = (Productos) o;
        return Double.compare(precio, productos.precio) == 0 && Objects.equals(nombre, productos.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, precio);
    }

    @Override
    public int compareTo(Productos o) {
        return Integer.compare(this.id, o.id);
    }



}
