package PersonasPack;

import ConcertPack.Entradas;

import java.util.HashMap;

public class Cliente extends Persona {

    private String email;
    private String telefono;
    private HashMap<Integer, Entradas> historialEntr =new HashMap<>();

    public Cliente(String nombre, String apellido, int dni, String email, String telefono) {
        super(nombre, apellido, dni);
        this.email = email;
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public HashMap<Integer, Entradas> getHistorialEntr() {
        return historialEntr;
    }

    public void setHistorialEntr(HashMap<Integer, Entradas> historialEntr) {
        this.historialEntr = historialEntr;
    }



    @Override
    public String toString() {
        return "PersonasPack.Cliente{" +
                "email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                '}';
    }
}
