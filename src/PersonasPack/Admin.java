package PersonasPack;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends Persona implements Serializable {
    private String user;
    private String contrasenia;

    public Admin(String nombre, String apellido, int dni, String user, String contrasenia) {
        super(nombre, apellido, dni);
        this.user = user;
        this.contrasenia = contrasenia;
    }
    
    public Admin(){
        super();
    };

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Admin RegistrarAdmin() {
        Scanner scanAdmin = new Scanner(System.in);
        System.out.println("Ingrese Nombre: ");
        String nombre = scanAdmin.nextLine();

        System.out.println("Ingrese Apellido: ");
        String apellido = scanAdmin.nextLine();

        System.out.println("Ingrese DNI: ");
        int dni = scanAdmin.nextInt();
        scanAdmin.nextLine();// Consumir el salto de línea

        String nombreUsuario;
        boolean nombreValido = false;
        do {
            System.out.println("Ingrese Nombre de Usuario: ");
            nombreUsuario = scanAdmin.nextLine();

            // Verificar si el nombre de usuario ya existe en el archivo
            if (VerificarNombre(nombreUsuario, new File("administradores.json"))) {
                System.out.println("Nombre de Usuario ya existe. Intente con otro nombre.");
            } else {
                nombreValido = true;
            }
        } while (!nombreValido);

        System.out.println("Ingrese Contraseña:");
        String contrasenia = scanAdmin.nextLine();

        // Crear nuevo administrador
        Admin nuevoAdmin = new Admin(nombre, apellido, dni, nombreUsuario, contrasenia);

        // Guardar los datos en el archivo JSON
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Admin> adminList = new ArrayList<>();

            // Leer el archivo JSON si existe y no está vacío
            File file = new File("administradores.json");
            if (file.exists() && file.length() != 0) {
                CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class,
                        Admin.class);
                adminList = objectMapper.readValue(file, listType);
            }

            adminList.add(nuevoAdmin);
            objectMapper.writeValue(file, adminList);
            System.out.println("Administrador registrado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al registrar el administrador: " + e.getMessage());
        }
        scanAdmin.close();
        return nuevoAdmin;
    }

    public static boolean VerificarNombre(String nombreUsuario, File f) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            if (!f.exists() || f.length() == 0) {
                return false;
            }

            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class,
                    Admin.class);
            List<Admin> adminList = objectMapper.readValue(f, listType);

            for (Admin admin : adminList) {
                if (admin.getUser().equals(nombreUsuario)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;
    }

    public boolean validarContrasenia(String contrasenia) {
        // La contraseña debe tener más de 8 caracteres y debe contener al menos una
        // letra y un número
        return contrasenia.length() >= 8 && contrasenia.matches(".[a-zA-Z].") && contrasenia.matches(".\\d.");
    }

    public boolean login(String nombreUsuario, String contrasenia) {
        boolean retorno = false;
        try {
            File archi = new File("administradores.json");
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Admin> aux = mapper.readValue(archi, new TypeReference<ArrayList<Admin>>() {});
            for (Admin a : aux) {
                if (a.getUser().equals(nombreUsuario) && a.getContrasenia().equals(contrasenia)) {
                    // Si las credenciales son correctas, actualiza los datos del administrador actual (this)
                    this.setUser(a.getUser());
                    this.setContrasenia(a.getContrasenia());
                    this.setNombre(a.getNombre());
                    this.setApellido(a.getApellido());
                    this.setDni(a.getDni());
                    retorno = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
        return retorno;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "User='" + user + '\'' +
                ", Contrasenia='" + contrasenia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                '}';
    }
}
