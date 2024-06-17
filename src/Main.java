import PersonasPack.Admin;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin("AdminInicial", "Apellido", 12345678, "admin1", "password123");
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú de Administrador ---");
            System.out.println("1. Registrar nuevo administrador");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    admin.RegistrarAdmin();
                    break;
                case 2:
                    iniciarSesion(admin, scanner);
                    break;
                case 3:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }

        // Cerrar el Scanner al salir del programa
        scanner.close();
    }

    private static void iniciarSesion(Admin admin, Scanner scanner) {
        System.out.println("\n--- Inicio de Sesión ---");

        System.out.print("Ingrese Nombre de Usuario: ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Ingrese Contraseña: ");
        String contrasenia = scanner.nextLine();

        // Verificar las credenciales usando el método login de Admin
        if (admin.login(nombreUsuario, contrasenia)) {
            System.out.println("Inicio de sesión exitoso.");
            // Aquí podrías agregar más opciones para el administrador después de iniciar sesión
        } else {
            System.out.println("Credenciales incorrectas. Intente nuevamente.");
        }
    }
}