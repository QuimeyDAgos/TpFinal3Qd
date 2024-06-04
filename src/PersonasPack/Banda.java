package PersonasPack;

import AlbumPack.Album;

import java.util.ArrayList;
import java.util.LinkedList;


public class Banda extends Artista {
    ArrayList<Persona> miembros;

    public Banda(String nombre, String apellido, int dni, String nombreEscenico, LinkedList<Album> albums, ArrayList<Persona> miembros) {
        super(nombre, apellido, dni, nombreEscenico, albums);
        this.miembros = miembros;
    }

    public ArrayList<Persona> getMiembros() {
        return miembros;
    }

    public void setMiembros(ArrayList<Persona> miembros) {
        this.miembros = miembros;
    }

    @Override
    public LinkedList<Album> getAlbums() {
        return albums;
    }
}

