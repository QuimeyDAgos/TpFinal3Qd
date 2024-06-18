package ProductosPack;
import Interfaces.*;
import Excepciones.*;

import java.io.Serializable;

public class Merch extends Productos implements Vendible, Serializable {
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

    public Merch(String nombre, double precio, int stock, boolean disponibilad, int id, String tipo, String talle, String color) {
        super(nombre, precio, stock, disponibilad, id, tipo);
        this.talle = talle;
        this.color = color;
    }

    public Merch() {
    }

    @Override
    public void venta() {
        try {
            if (stock > 0 && disponibilad) {
                System.out.println("Se realizo la venta de" + nombre + " con exito");
                stock--;
                if (stock == 0) {
                    this.disponibilad = false;
                }
            } else {
                throw new ProductoNoDisponibleExepcion("El producto no esta disponible");
            }
        } catch (ProductoNoDisponibleExepcion e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void aumento(double porcentaje) {
        setPrecio(precio + (precio * porcentaje));
    }

    @Override
    public String toString() {
        return "Merch{" +
                "talle='" + talle + '\'' +
                ", color='" + color + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", disponibilad=" + disponibilad +
                ", id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}