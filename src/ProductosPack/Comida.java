package ProductosPack;

import Excepciones.ProductoNoDisponibleExepcion;
import Interfaces.Vendible;

public class Comida extends Productos implements Vendible {
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Comida(String nombre, double precio, int stock, String tipo,boolean disponibilidad) {
        super(nombre, precio, stock,disponibilidad);
        this.tipo = tipo;
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
        return "ProductosPack.Comida{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
