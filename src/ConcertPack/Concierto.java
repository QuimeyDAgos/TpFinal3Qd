package ConcertPack;


import java.util.*;

public class Concierto {
    private String nombreEvento;
    private Date fecha;
    private double duracion;
    private String lugar;
    private LinkedList<String> sectores;
    private LinkedList<String> listaVentas;
    private Stack<String> actos;
    private HashMap<Integer, Entradas> entradas;
    private HashMap<String, Double> duracionesActos;

    public Concierto( String nombreEvento, Date fecha, double duracion, String lugar) {
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.duracion = duracion;
        this.lugar = lugar;
        this.sectores = new LinkedList<>();
        this.listaVentas = new LinkedList<>();
        this.actos = new Stack<>();
        this.entradas = new HashMap<>();
        this.duracionesActos = new HashMap<>();
    }
    
    

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LinkedList<String> getSectores() {
        return sectores;
    }

    public void setSectores(LinkedList<String> sectores) {
        this.sectores = sectores;
    }

    public LinkedList<String> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(LinkedList<String> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public Stack<String> getActos() {
        return actos;
    }

    public void setActos(Stack<String> actos) {
        this.actos = actos;
    }

    public HashMap<Integer, Entradas> getEntradas() {
        return entradas;
    }

    public void setEntradas(HashMap<Integer, Entradas> entradas) {
        this.entradas = entradas;
    }

    public void agregarSector(String sector) {
        sectores.add(sector);
    }

    public void registrarVenta(String venta) {
        listaVentas.add(venta);
        venta();
    }
    public void agregarActo(String acto) {
        actos.push(acto);
    }
    public void agregarEntrada(int id, Entradas entrada) {
        entradas.put(id, entrada);
    }
    public String obtenerActoActual() {
        return actos.peek();
    }
    public String removerActo() {
        return actos.pop();
    }
    public List<String> listarSectores() {
        return new ArrayList<>(sectores);
    }
    public double obtenerDuracionActo(String acto) {
        return duracionesActos.getOrDefault(acto, 0.0);
    }

    public void agregarDuracionActo(String acto, double duracion) {
        duracionesActos.put(acto, duracion);
    }

    public double calcularIngresos() {
        double ingresos = 0.0;
        for (String venta : listaVentas) {
            ingresos += ;
        }
        return ingresos;
    }
    public double calcularDuracionTotal() {
        double duracionTotal = duracion;
        // Suponiendo que cada acto tiene una duración, podrías almacenarla en una estructura adecuada
        for (String acto : actos) {
            // Aquí podrías sumar la duración de cada acto si tienes esa información
            duracionTotal += obtenerDuracionActo(acto); // Método ficticio para obtener la duración de un acto
        }
        return duracionTotal;
    }

    ///Falta codear aumento de entradas
}







