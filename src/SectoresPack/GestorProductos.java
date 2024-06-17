package SectoresPack;


import PersonasPack.Jackson;
import ProductosPack.Comida;
import ProductosPack.Merch;
import ProductosPack.Productos;


import java.util.*;

public abstract class GestorProductos <T extends Productos> {

    HashSet<T> ListadoProductos;

    public GestorProductos(HashSet<T> listadoProductos) {
        ListadoProductos = listadoProductos;
    }


    public void agregarProducto(Scanner scanner) {
        try {
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

            for (T aux : ListadoProductos) {
                if (aux.getId() == id) {
                    throw new Exception("Ya existe un Producto con ese ID.");
                }
            }

            Productos nuevo = null;

            if (tipoProducto.equalsIgnoreCase("Comida")) {
                System.out.println("Ingrese Variedad de Comida:");
                String variedad = scanner.nextLine();
                nuevo = new Comida(nombreNuevo, precio, stock, true, id, variedad,tipoProducto);
            } else if (tipoProducto.equalsIgnoreCase("Merch")) {
                System.out.println("Ingrese el Talle del Merch:");
                String talle = scanner.nextLine();
                System.out.println("Ingrese el Color del Merch:");
                String color = scanner.nextLine();
                nuevo = new Merch(nombreNuevo, precio, stock, true, id, talle, color, tipoProducto);
            } else {
                throw new Exception("Tipo de producto no reconocido. Debe ser 'Comida' o 'Merch'.");
            }

            ListadoProductos.add((T) nuevo);
            System.out.println("Producto agregado con éxito.");

            // Guardar la lista de productos actualizada en el archivo JSON
            guardarProductos();
        } catch (Exception e) {
            System.out.println("Error al agregar la entrada: " + e.getMessage());
        }
    }
    public T buscarProducto(int id){
        T retorno = null;
        for (T aux : ListadoProductos) {
            if (id==aux.getId()) {
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
        System.out.println("Comida disponibles");
        for (T s : ListadoProductos) {
            if(s instanceof Comida){
            System.out.println(s);
        }}

        System.out.println(" Merchandising disponibles");
        for (T s : ListadoProductos) {
            if(s instanceof Merch){
            System.out.println(s);
        }}
    }


    public void modificarProducto(int id) {
        Scanner scanner=new Scanner(System.in);
        try {
            T producto = buscarProducto(id);
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
        T eliminado = buscarProducto(id);
        if (eliminado != null) {
            ListadoProductos.remove(eliminado);
        }
        guardarProductos();
    }

    public void mostrarProductos() {
        for (T p : ListadoProductos) {
            System.out.println(p);
        }
    }




    public void guardarProductos() {
        Jackson<T> jackson = new Jackson<>();
        jackson.guardarHashSet("productos.json", ListadoProductos);
    }




    @Override
    public String toString() {
        return "GestorProductos{" +
                "ListadoProductos=" + ListadoProductos +
                '}';
    }
}
