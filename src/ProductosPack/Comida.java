package ProductosPack;

import Excepciones.ProductoNoDisponibleExepcion;
import Interfaces.Vendible;

import java.io.Serializable;

public class Comida extends Productos implements Vendible, Serializable {
    private String variedad;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Comida(String nombre, double precio, int stock, boolean disponibilad, int id, String tipo, String variedad) {
        super(nombre, precio, stock, disponibilad, id, tipo);
        this.variedad = variedad;
    }

    public Comida() {
    }

    @Override
    public void venta()
    {
        try{
        if(stock>0 && disponibilad)
        {
           System.out.println("Se realizo la venta de" +nombre+ "con exito");
           stock--;
           if(stock==0)
           {
            this.disponibilad=false;
           }
        }
        else{
            throw new ProductoNoDisponibleExepcion("El producto no esta disponible");
        }
        }catch(ProductoNoDisponibleExepcion e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void aumento(double porcentaje)
    {  
        setPrecio(precio+(precio*porcentaje));
    }

    @Override
    public String toString() {
        return "Comida{" +
                "variedad='" + variedad + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", disponibilad=" + disponibilad +
                ", id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
