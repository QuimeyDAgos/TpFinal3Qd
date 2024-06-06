package PersonasPack;



public class Admin extends Persona{
    private  String  User;
    private String Contrasenia;

    public Admin(String nombre, String apellido, int dni, String user, String contrasenia) {
        super(nombre, apellido, dni);
        User = user;
        Contrasenia = contrasenia;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
gi        User = user;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        Contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "User='" + User + '\'' +
                ", Contrasenia='" + Contrasenia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                '}';
    }




}
