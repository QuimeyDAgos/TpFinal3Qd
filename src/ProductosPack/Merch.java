package ProductosPack;
import Interfaces.*;
import Excepciones.*;

public class Merch extends Productos implements Vendible {
    private String talle;
    private String color;
    private int codigo;

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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Merch(String nombre, double precio, int stock, String talle, String color, boolean disponibilidad, int codigo) {
        super(nombre, precio, stock, disponibilidad);
        this.talle = talle;
        this.color = color;
        this.codigo= codigo;
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
