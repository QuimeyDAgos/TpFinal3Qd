package AlbumPack;

import Interfaces.Gestorable;

import java.util.LinkedList;

public class Album implements Gestorable<Cancion> {
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
/*    // Métodos para gestionar canciones
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
    }*/
@Override
public void agregar(Cancion item) {
    if(!ListaCanciones.contains(item)) {
        ListaCanciones.add(item);
    }
    else{
        System.out.println("La cancion ya esta cargada en la lista");
    }
}

    @Override
    public void eliminar(Cancion item) {
        if(ListaCanciones.contains(item)) {
            ListaCanciones.remove(item);
        }
        else{
            System.out.println("La cancion no se encuentra en la lista");
        }

    }

    @Override
    public Cancion buscar(Cancion item) {
        for(Cancion cancion : ListaCanciones) {
            if (cancion.getTitulo().equalsIgnoreCase(item.getTitulo())) {
                return cancion;
            }
        }
        return null;
    }

    @Override
    public void mostrar() {
        for (Cancion cancion : ListaCanciones) {
            System.out.println(cancion);
        }

    }

    @Override
    public void modificar(Cancion item) {
        for(int i=0;i<ListaCanciones.size();i++) {
            if(ListaCanciones.get(i).getTitulo().equalsIgnoreCase(item.getTitulo())) {
                ListaCanciones.set(i, item);
            }
        }
    }


    @Override
    public String toString() {
        return "AlbumPack.Album{" +
                "titulo='" + titulo + '\'' +
                ", anio=" + anio +
                ", ListaCanciones=" + ListaCanciones +
                '}';
    }

}
