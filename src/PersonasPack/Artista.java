package PersonasPack;

import AlbumPack.Album;

import java.util.LinkedList;

public abstract class Artista extends Persona {
    protected String nombreEscenico;
    protected LinkedList<Album> albums;

    public Artista(String nombre, String apellido, int dni, String nombreEscenico, LinkedList<Album> albums) {
        super(nombre, apellido, dni);
        this.nombreEscenico = nombreEscenico;
        this.albums = albums;
    }

    public void setAlbums(LinkedList<Album> albums) {
        this.albums = albums;
    }

    public String getNombreEscenico() {
        return nombreEscenico;
    }

    public void setNombreEscenico(String nombreEscenico) {
        this.nombreEscenico = nombreEscenico;
    }

    public boolean agregarAlbum(Album album) {
        if (buscarAlbumPorTitulo(album.getTitulo()) == null) {
            this.albums.add(album);
            return true;
        }
        return false; // No se agrega el álbum porque ya existe uno con el mismo título
    }

    public boolean eliminarAlbumPorTitulo(String titulo) {
        Album album = buscarAlbumPorTitulo(titulo);
        if (album != null) {
            this.albums.remove(album);
            return true;
        }
        return false; // No se encuentra el álbum con el título especificado
    }

    public Album buscarAlbumPorTitulo(String titulo) {
        for (Album album : albums) {
            if (album.getTitulo().equalsIgnoreCase(titulo)) {
                return album;
            }
        }
        return null;
    }


    // Método abstracto que debe ser implementado por las subclases
    public abstract LinkedList<Album> getAlbums();



    @Override
    public String toString() {
        return "PersonasPack.Artista{" +
                "nombreEscenico='" + nombreEscenico + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                '}';
    }
}
