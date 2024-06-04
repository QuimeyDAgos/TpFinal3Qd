import java.util.*;

public class Concierto extends Entradas {
    private String nombreEvento;
    private Date fecha;
    private double duracion;
    private String lugar;
    private LinkedList<String> sectores;
    private LinkedList<String> listaVentas;
    private Stack<String> actos;
    private HashMap<Integer, Entradas> entradas;

    public Concierto(int stock, TipoEntrada tipo, String nombreEvento, Date fecha, double duracion, String lugar) {
        super(stock, tipo);
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.duracion = duracion;
        this.lugar = lugar;
        this.sectores = new LinkedList<>();
        this.listaVentas = new LinkedList<>();
        this.actos = new Stack<>();
        this.entradas = new HashMap<>();
    }

    // Métodos getter y setter

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

    // Método para calcular los ingresos del concierto
    public double calcularIngresos() {
        // Aquí puedes implementar la lógica para calcular los ingresos
        // Por ejemplo, sumando el precio de todas las entradas vendidas
        double ingresos = 0.0;
        for (String venta : listaVentas) {
            ingresos += getPrecio();
        }
        return ingresos;
    }

    // Método para calcular la duración total del concierto
    // Falta agregar la duracion de canciones y o albumes
    public double calcularDuracion() {
        return duracion;
    }
}







