package ProductosPack;
import Interfaces.*;
import Excepciones.*;

public class Merch extends Productos implements Vendible {
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

    public Merch(String nombre, double precio, int stock, String talle, String color, boolean disponibilidad) {
        super(nombre, precio, stock, disponibilidad);
        this.talle = talle;
        this.color = color;
    }

   @Override 
    public void venta()
    {
        try{
        if(stock>0 && disponibilad)
        {
           System.out.println("Se realizo la venta con exito");
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
        return "Mercj{" +
                "talle='" + talle + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
