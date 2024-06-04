
import java.util.LinkedList;

public class Album {
    private String titulo;
    private int anio;
    private LinkedList<Cancion>ListaCanciones;

    public Album(String titulo, int anio, LinkedList<Cancion> listaCanciones) {
        this.titulo = titulo;
        this.anio = anio;
        ListaCanciones = listaCanciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public LinkedList<Cancion> getListaCanciones() {
        return ListaCanciones;
    }

    public void setListaCanciones(LinkedList<Cancion> listaCanciones) {
        ListaCanciones = listaCanciones;
    }
    // Métodos para gestionar canciones
    public void agregarCancion(Cancion cancion) {
        this.ListaCanciones.add(cancion);
    }

    public boolean modificarCancion(String titulo, Cancion nuevaCancion) {
        for (int i = 0; i < ListaCanciones.size(); i++) {
            Cancion cancion = ListaCanciones.get(i);
            if (cancion.getTitulo().equalsIgnoreCase(titulo)) {
                ListaCanciones.set(i, nuevaCancion);
                return true;
            }
        }
        return false; // No se encontró la canción con el título especificado
    }

    public boolean eliminarCancionPorTitulo(String titulo) {
        for (Cancion cancion : ListaCanciones) {
            if (cancion.getTitulo().equalsIgnoreCase(titulo)) {
                ListaCanciones.remove(cancion);
                return true;
            }
        }
        return false; // No se encontró la canción con el título especificado
    }

    public Cancion buscarCancionPorTitulo(String titulo) {
        for (Cancion cancion : ListaCanciones) {
            if (cancion.getTitulo().equalsIgnoreCase(titulo)) {
                return cancion;
            }
        }
        return null; // No se encontró la canción con el título especificado
    }

    @Override
    public String toString() {
        return "Album{" +
                "titulo='" + titulo + '\'' +
                ", anio=" + anio +
                ", ListaCanciones=" + ListaCanciones +
                '}';
    }
}
