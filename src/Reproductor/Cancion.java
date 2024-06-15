package Reproductor;

public class Cancion {
    private String nombre;
    private String ruta;
    private String imagen;

    public Cancion(String nombre, String ruta, String imagen) {
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
