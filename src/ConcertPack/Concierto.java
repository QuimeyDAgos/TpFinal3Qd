package ConcertPack;


import java.util.*;

public class Concierto {

    private String nombreEvento;
    private String fecha;
    private String lugar;
    private double listaVentas;
    private HashMap<Integer, Entradas> entradas;

    public Concierto(String nombreEvento, String fecha, String lugar) {
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.lugar = lugar;
        this.entradas = new HashMap<>();
    }
    

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }


    public HashMap<Integer, Entradas> getEntradas() {
        return entradas;
    }

    public void setEntradas(HashMap<Integer, Entradas> entradas) {
        this.entradas = entradas;
    }

    public void registrarVenta(Double venta) {
        this.listaVentas+=venta;
    }

    public void agregarEntrada(int id, Entradas entrada) {
        entradas.put(id, entrada);
    }

    public double getListaVentas() {
        return listaVentas;
    }


    public void setListaVentas(double listaVentas) {
        this.listaVentas = listaVentas;
    }
   
 

    ///Falta codear aumento de entradas
}







