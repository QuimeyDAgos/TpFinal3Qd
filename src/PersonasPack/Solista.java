package PersonasPack;

import AlbumPack.Album;

import java.util.LinkedList;

public class Solista extends Artista {

    public Solista(String nombre, String apellido, int dni, String nombreEscenico, LinkedList<Album> albums) {
        super(nombre, apellido, dni, nombreEscenico, albums);
    }

    @Override
    public LinkedList<Album> getAlbums() {
        return albums;
    }
}

