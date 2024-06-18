package PersonasPack;
import ConcertPack.Entradas;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Persona {
    protected String nombre;
    protected String apellido;
    protected int dni;
    protected HashMap<Integer, Entradas> historialEntr =new HashMap<>();

    public Persona(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public Persona(){};



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public HashMap<Integer, Entradas> getHistorialEntr() {
        return historialEntr;
    }

    public void setHistorialEntr(HashMap<Integer, Entradas> historialEntr) {
        this.historialEntr = historialEntr;
    }

    @Override
    public String toString() {
        return "PersonasPack.Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                '}';
    }
}
