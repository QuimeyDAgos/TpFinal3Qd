package GestoresPack;

import Reproductor.ArtistaManager;

import java.util.Scanner;

public class MenuAdmin {
    public void menuAdmin() {

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
                    MenuGestor gesti =new MenuGestor();
                   // gesti.menuGestor();
                    break;
                case 2:
                    MenuVenta venta =new MenuVenta();
                    venta.cajeroAdmin();
                    break;
                case 3:
                    System.out.println("-----------Proximos Artistas-------------");
                    System.out.println("1. Duki");
                    System.out.println("2. Dua Lipa");
                    System.out.println("3. Nathy Peluso");
                    System.out.println("4.Tini");
                    System.out.println("5.La Vela Puerca");
                    scanner.nextLine();
                    System.out.println("Ingese el artista que desee");
                    int opcionRep =scanner.nextInt();
                    String nomArt = switch (opcionRep) {
                        case 1 -> "Duki";
                        case 2 -> "Dua Lipa";
                        case 3 -> "Nathy Peluso";
                        case 4 -> "TINI";
                        case 5 -> "Vela Puerca";
                        default -> "Duki";
                    };

                    ArtistaManager artistaManager=new ArtistaManager();
                    System.out.println(">>");
                    artistaManager.runReproductor(nomArt);
                    break;
                case 4 :
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;

            }
            scanner.close();
    }
    }
}
