import Reproductor.ArtistaManager;

import java.util.Scanner;

public class MenuAdmin {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú de Administrador ---");
            System.out.println("1. Gestor");
            System.out.println("2. Vender");
            System.out.println("3. Reproductor");
            System.out.println("4.Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion)
            {
                case 1:
                    //// Aca llamamos MenuGestor
                    break;
                case 2:
                    ///Menu Venta
                    break;
                case 3:
                    ArtistaManager artistaManager=new ArtistaManager();
                    System.out.println(">>");/// Habria que escanear el artista o ingresarlo segun evento
                    artistaManager.runReproductor("Duki");
                    break;
                case 4 :
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;

            }


    }
    }
}
