package PersonasPack;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Admin extends Persona{
    protected String nombreDeUsuario;
    protected String contrasenia;

 public Admin(String nombre, String apellido, int dni, String nombreDeUsuario, String contrasenia) {
        super(nombre, apellido, dni);
        this.nombreDeUsuario = nombreDeUsuario;
        this.contrasenia = contrasenia;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void RegistrarAdmin(){
        Scanner scanAdmin= new Scanner(System.in);
        System.out.println("Ingrese Nombre");

        if (VerificarNombre(nombre, new File("administradores.txt"))) {
            System.out.println("Nombre ya existe en el archivo. Intente con otro nombre.");
            return;
        }

        System.out.println("Ingrese Contraseña:");
        String contrasenia = scanAdmin.nextLine();

        if (!validarContrasenia(contrasenia)) {
            System.out.println("La contraseña no cumple con los requisitos. Debe tener más de 8 caracteres y contener letras y números.");
            return;
        }

        // Si todo es válido, guardamos los datos en el archivo
        try (FileWriter writer = new FileWriter("administradores.txt", true)) {
            writer.write(nombre + "," + contrasenia + "\n");
            System.out.println("Administrador registrado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al registrar el administrador: " + e.getMessage());
        }
    }

    public boolean VerificarNombre(String nombre, File f) {
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(nombre)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;
    }

    public boolean validarContrasenia(String contrasenia) {
        // La contraseña debe tener más de 8 caracteres y debe contener al menos una letra y un número
        return contrasenia.length() > 8 && Pattern.compile(".*[A-Za-z].*").matcher(contrasenia).matches() && Pattern.compile(".*\\d.*").matcher(contrasenia).matches();
    }

    }



