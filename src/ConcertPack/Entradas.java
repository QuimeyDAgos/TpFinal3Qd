package ConcertPack;

import Excepciones.EntradaNoDisponibleExcepcion;
import Interfaces.Vendible;

public class Entradas implements Vendible {
    private boolean disponibilad;
    private double precio;    
    private TipoEntrada tipo;
    private int id;     

    public Entradas(int stock, TipoEntrada tipo,int id) {    
        this.precio =calcularPrecio();    
        this.tipo = tipo;
        this.disponibilad=true;
        this.id = id;
    }

    public double calcularPrecio()
    {
        double prc = 10000;
        if (this.getTipo() == TipoEntrada.VIP)
        {
            prc+=5000;
        }
        return prc;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
         this.precio = precio;
    }

    public TipoEntrada getTipo() {
        return tipo;
    }

    public void setTipo(TipoEntrada tipo) {
        this.tipo = tipo;
    }
        
    public void setDisponibilad(boolean disponibilad) {
        this.disponibilad = disponibilad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDisponibilad() {
        return this.disponibilad;
    }
    @Override
    public void venta() {
        try {
            if(disponibilad){
                System.out.println("Venta de entrada realizada con exito");
                this.disponibilad=false;
            }
            else{
                throw new EntradaNoDisponibleExcepcion("La entrada no esta disponible");
            }
        } catch (EntradaNoDisponibleExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void aumento(double porcentaje) {
        setPrecio(precio+(precio*porcentaje));
    }

    @Override
    public String toString() {
        return "ConcertPack.Entradas{" +
                "disponibilidad=" + disponibilad +
                ", precio=" + precio +
                ", tipo=" + tipo +
                '}';
    }

}

