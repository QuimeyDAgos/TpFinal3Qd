package GestoresPack;

import PersonasPack.Jackson;
import ProductosPack.Comida;
import ProductosPack.Merch;
import ProductosPack.Productos;

import java.io.File;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GestorProductos extends Productos {
    private TreeSet<Productos> ListadoProductos;
    private LinkedList<Productos> historialVentas;

    public GestorProductos() {
        this.ListadoProductos = new TreeSet<>();
        this.historialVentas = new LinkedList<>();
    }

    public GestorProductos(TreeSet<Productos> productos) {
        this.ListadoProductos = productos;
        this.historialVentas = new LinkedList<>();
    }

    public void cargarPredeterminados() {
        ListadoProductos.add(new Comida("Pizza", 10.5, 20, true, 1, "Comida", "Italiana"));
        ListadoProductos.add(new Comida("Hamburguesa", 8.0, 15, true, 2, "Comida", "Americana"));
        ListadoProductos.add(new Comida("Sushi", 12.0, 10, true, 3, "Comida", "Japonesa"));
        ListadoProductos.add(new Comida("Ensalada", 5.0, 30, true, 4, "Comida", "Vegetariana"));
        ListadoProductos.add(new Comida("Hot Dog", 4.5, 40, true, 5, "Comida", "Americana"));
        ListadoProductos.add(new Comida("Sandwich", 5.5, 25, true, 6, "Comida", "Variada"));
        ListadoProductos.add(new Comida("Empanada", 3.0, 35, true, 7, "Comida", "Latina"));
        ListadoProductos.add(new Merch("Camiseta", 15.0, 50, true, 8, "Merch", "M", "Rojo"));
        ListadoProductos.add(new Merch("Gorra", 12.0, 30, true, 9, "Merch", "L", "Azul"));
        ListadoProductos.add(new Merch("Taza", 8.0, 40, true, 10, "Merch", "Única", "Blanco"));
        ListadoProductos.add(new Merch("Llaveros", 5.0, 60, true, 11, "Merch", "Única", "Negro"));
        ListadoProductos.add(new Merch("Póster", 10.0, 20, true, 12, "Merch", "Única", "Multicolor"));
        ListadoProductos.add(new Merch("Sudadera", 25.0, 25, true, 13, "Merch", "L", "Gris"));
        ListadoProductos.add(new Merch("Bolígrafo", 2.0, 100, true, 14, "Merch", "Única", "Azul"));
        guardarProductos();
    }

    public void agregarProducto() {
        Scanner scanner = new Scanner(System.in);
        try {
            Jackson<Productos> jackson = new Jackson<>();
            ListadoProductos = jackson.cargarTreeSet("productos.json");
            System.out.println("Ingrese el tipo de Producto (Comida/Merch):");
            String tipoProducto = scanner.nextLine().trim();
            System.out.println("Ingrese el Nombre del Producto:");
            String nombreNuevo = scanner.nextLine();
            System.out.println("Ingrese el Precio del Producto:");
            double precio = scanner.nextDouble();
            System.out.println("Ingrese el Stock del Producto:");
            int stock = scanner.nextInt();
            System.out.println("Ingrese el ID del Producto:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            for (Productos aux : ListadoProductos) {
                if (aux.getId() == id) {
                    throw new Exception("Ya existe un Producto con ese ID.");
                }
            }

            Productos nuevo = null;

            if (tipoProducto.equalsIgnoreCase("Comida")) {
                System.out.println("Ingrese Variedad de Comida:");
                String variedad = scanner.nextLine();
                nuevo = new Comida(nombreNuevo, precio, stock, true, id, variedad, tipoProducto);
            } else if (tipoProducto.equalsIgnoreCase("Merch")) {
                System.out.println("Ingrese el Talle del Merch:");
                String talle = scanner.nextLine();
                System.out.println("Ingrese el Color del Merch:");
                String color = scanner.nextLine();
                nuevo = new Merch(nombreNuevo, precio, stock, true, id, talle, color, tipoProducto);
            } else {
                throw new Exception("Tipo de producto no reconocido. Debe ser 'Comida' o 'Merch'.");
            }

            ListadoProductos.add(nuevo);
            System.out.println("Producto agregado con éxito.");
            // Guardar la lista de productos actualizada en el archivo JSON
            guardarProductos();
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error al agregar la entrada: " + e.getMessage());
        }
    }

    public Productos buscarProducto(int id) {
        Jackson<Productos> jackson = new Jackson<>();
        ListadoProductos = jackson.cargarTreeSet("productos.json");
        Productos retorno = null;
        for (Productos aux : ListadoProductos) {
            if (id == aux.getId()) {
                retorno = aux;
            }
        }
        try {
            if (retorno == null) {
                throw new RuntimeException("Producto no Encontrado");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }

    public void mostrarSectores() {
        Jackson<Productos> jackson = new Jackson<>();
        ListadoProductos = jackson.cargarTreeSet("productos.json");
        System.out.println("Comida disponibles");
        for (Productos s : ListadoProductos) {
            if (s.getTipo().equalsIgnoreCase("Comida")) {
                System.out.println(s);
            }
        }
        

        System.out.println(" Merchandising disponibles");
        for (Productos s : ListadoProductos) {
            if (s.getTipo().equalsIgnoreCase("Merch")){
                System.out.println(s);
            }
        }
    }

    public void modificarProducto(int id) {
        Scanner scanner = new Scanner(System.in);
        try {
            Productos producto = buscarProducto(id);
            if (producto != null) {
                System.out.println("Ingrese el nuevo Nombre del Producto:");
                String nombreNuevo = scanner.nextLine();
                System.out.println("Ingrese el nuevo Precio del Producto:");
                double precio = scanner.nextDouble();
                System.out.println("Ingrese el nuevo Stock del Producto:");
                int stock = scanner.nextInt();

                producto.setNombre(nombreNuevo);
                producto.setPrecio(precio);
                producto.setStock(stock);

                scanner.close();
                System.out.println("Producto modificado con éxito.");

                // Guardar la lista de productos actualizada en el archivo JSON
                guardarProductos();
            } else {
                System.out.println("No existe un Producto con ese ID.");
            }
        } catch (Exception e) {
            System.out.println("Error al modificar el producto: " + e.getMessage());
        }
    }

    public void eliminarProducto(int id) {
        Productos eliminado = buscarProducto(id);
        if (eliminado != null) {
            ListadoProductos.remove(eliminado);
        }
        guardarProductos();
    }

    public void menuGestionarProductos() {
        System.out.println("|----Menu Gestor Productos----|");
        System.out.println("| [1] Agregar Producto        |");
        System.out.println("| [2] Modificar Producto      |");
        System.out.println("| [3] Eliminar Producto       |");
        System.out.println("| [4] Vender Producto         |");
        System.out.println("| [5] Salir                   |");
        System.out.println("|-----------------------------|");
    }

    public void gestionarProductos() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        GestorProductos gestorProductos = new GestorProductos();

        while (!salir) {

            menuGestionarProductos();
            System.out.print(">>");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    gestorProductos.agregarProducto();
                    break;
                case 2:

                    System.out.println("Escriba el id del producto a Modificar");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    gestorProductos.modificarProducto(id);

                    break;
                case 3:
                    System.out.println("Escriba el id del producto a Eliminar");
                    int id2 = scanner.nextInt();
                    scanner.nextLine();
                    gestorProductos.eliminarProducto(id2);
                    break;
                case 4:
                    mostrarSectores();
                    Scanner sc = new Scanner(System.in);
                    int id3 = sc.nextInt();
                    gestorProductos.ventaProducto(id3);
                    break;
                case 5:
                    salir = true;
                    System.out.println("Volviendo...");
                    break;
                case 6:
                    cargarPredeterminados();
                    break;
                default:
                    System.out.println("Valor invalido, intentelo denuevo");
                    break;

            }
        }
    }

    public void guardarProductos() {
        Jackson<Productos> jackson = new Jackson<>();
        jackson.guardarTreeSet("productos.json", ListadoProductos);
    }

    public void ventaProducto(int id) {
        Productos p = buscarProducto(id);

        if (p.getStock() > 0 && p.getDisponibilad()) {
            {
                p.setStock(p.getStock() - 1);
                System.out.println("Se realizo la venta con exito");
                if (p.getStock() == 0) {
                    p.setDisponibilad(false);
                }
                historialVentas.add(p);
            }
        }

        guardarProductos();

    }

    @Override
    public String toString() {
        return "GestorProductos{" +
                "ListadoProductos=" + ListadoProductos +
                '}';
    }
}
