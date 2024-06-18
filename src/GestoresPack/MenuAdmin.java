package GestoresPack;

import Reproductor.ArtistaManager;

import java.util.Scanner;

public class MenuAdmin {
    public void menu(Scanner scanner) {

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
                    gesti.menu();
                    break;
                case 2:
                    MenuVenta venta = new MenuVenta();
                    venta.cajeroAdmin();
                    break;
                case 3:
                    ArtistaManager artistaManager=new ArtistaManager();
                    System.out.println("\n--- ProximosArtistas---");
                    System.out.println("1. Vela Puerca");
                    System.out.println("2. Nathy Peluso");
                    System.out.println("3. DuaLipa");
                    System.out.println("4. Duki");
                    System.out.println("5. Tini0");
                    System.out.println(">>");
                    int opRep=scanner.nextInt();
                    String nomArt="Duki";
                    switch (opRep)
                    {
                        case 1:
                            nomArt="Vela Puerca";
                            break;
                        case 2:
                            nomArt="Nathy Peluso";
                            break;
                        case 3:
                            nomArt="Dua Lipa";
                            break;
                        case 4:
                            nomArt="Duki";
                            break;
                        case 5:
                            nomArt="TINI";
                            break;
                    }
                    artistaManager.runReproductor(nomArt);
                    scanner.close();
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
