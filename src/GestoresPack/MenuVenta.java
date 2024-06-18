package GestoresPack;

import java.util.Scanner;
import java.util.TreeSet;

import ProductosPack.Productos;

public class MenuVenta {

    public void cajeroAdmin() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú de Venta ---");
            System.out.println("1. Entradas");
            System.out.println("2. Productos");
            System.out.println("3. Calcular Ingresos Totales");
            System.out.println("3. Salir");
            GestorEntry gestorEntry = new GestorEntry();
            TreeSet<Productos> listaProductos = new TreeSet<>();
            GestorProductos gestorProductos = new GestorProductos(listaProductos);
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:

                    gestorEntry.menuGestEntry();
                    break;
                case 2:
                    ///// gestora Productos
                    gestorProductos.gestionarProductos();
                    break;
                case 3:
                    double ingreso= gestorProductos.Ingreso()+ gestorEntry.calcularIngresosEntradas();
                    System.out.println(ingreso);
                    break;
                case 4:
                    salir = true;
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");

            }
        }
        scanner.close();
    }

}
