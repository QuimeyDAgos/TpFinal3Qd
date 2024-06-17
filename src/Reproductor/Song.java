package Reproductor;

public class Song {
    private String nombre;
    private String ruta;
    private String imagen;

    public Song(String nombre, String ruta, String imagen) {
        this.nombre = nombre;
        this.ruta = ruta;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public String getImagen() {
        return imagen;
    }
}
