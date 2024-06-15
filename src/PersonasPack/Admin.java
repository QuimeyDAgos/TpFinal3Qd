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
    public void RegistrarAdmin() {
        Scanner scanAdmin = new Scanner(System.in);
        System.out.println("Ingrese Nombre: ");
        String nombre = scanAdmin.nextLine();

        System.out.println("Ingrese Apellido: ");
        String apellido = scanAdmin.nextLine();

        System.out.println("Ingrese DNI: ");
        int dni = scanAdmin.nextInt();
        scanAdmin.nextLine(); // Consumir el salto de línea

        String nombreUsuario;
        boolean nombreValido = false;
        do {
            System.out.println("Ingrese Nombre de Usuario: ");
            nombreUsuario = scanAdmin.nextLine();

            // Verificar si el nombre de usuario ya existe en el archivo
            if (VerificarNombre(nombreUsuario, new File("administradores.txt"))) {
                System.out.println("Nombre de Usuario ya existe. Intente con otro nombre.");
            } else {
                nombreValido = true;
            }
        } while (!nombreValido);

        System.out.println("Ingrese Contraseña:");
        String contrasenia = scanAdmin.nextLine();

        // Validar la contraseña
        if (!validarContrasenia(contrasenia)) {
            System.out.println("La contraseña no cumple con los requisitos. Debe tener más de 8 caracteres y contener letras y números.");
            return;
        }

        // Guardar los datos en el archivo
        try (FileWriter writer = new FileWriter("administradores.txt", true)) {
            writer.write(nombre + "," + apellido + "," + dni + "," + nombreUsuario + "," + contrasenia + "\n");
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


    public boolean login(String nombreUsuario, String contrasenia) {
        // Verificar si el nombre de usuario y la contraseña coinciden con algún administrador en el archivo
        try (BufferedReader reader = new BufferedReader(new FileReader("administradores.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(nombreUsuario) && parts[1].equals(contrasenia)) {
                    return true; // Credenciales válidas encontradas
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;


    }
}




