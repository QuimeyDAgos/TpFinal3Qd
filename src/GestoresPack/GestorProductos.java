package GestoresPack;

import PersonasPack.Jackson;
import ProductosPack.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import SectoresPack.SectorComida;
import SectoresPack.SectorMerch;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class GestorProductos<T extends SectoresPack.GestorProductos> {

    private List<T> sectoresComida;
    private List<T> sectoresMerch;
    private List<Productos> productos;

    public GestorProductos(List<T> sectoresComida, List<T> sectoresMerch, ArrayList<Productos> productos) {
        this.sectoresComida = sectoresComida;
        this.sectoresMerch = sectoresMerch;
        this.productos = productos;
    }

    public void agregarProducto(Scanner scanner) {
        try {
            System.out.println("Ingrese el Nombre del Producto:");
            String nombreNuevo = scanner.nextLine();
            System.out.println("Ingrese el Precio del Producto:");
            double precio = scanner.nextDouble();
            System.out.println("Ingrese el Stock del Producto:");
            int stock = scanner.nextInt();
            System.out.println("Ingrese el ID del Producto:");
            int id = scanner.nextInt();
            for (Productos aux : productos) {
                if (aux.getId() == id) {
                    throw new Exception("Ya existe un Producto con ese ID.");
                }
            }
            Productos nuevo = new Productos(nombreNuevo, precio, stock, true, id);
            productos.add(nuevo);
            System.out.println("Entrada agregada con éxito.");
        } catch (Exception e) {
            System.out.println("Error al agregar la entrada: " + e.getMessage());
        }
    }



    public void mostrarSectores() {
        System.out.println("Sectores de comida disponibles");
        for (T s : sectoresComida) {
            System.out.println(s);
        }

        System.out.println("Sectores de Merchandising disponibles");
        for (T s : sectoresMerch) {
            System.out.println(s);
        }
    }

    public double calcularVentasSectores() {
        double ingreso = 0;
        for (T s : sectoresMerch) {
            for (Merch m : ((SectorMerch) s).getArbol().values()) {
                ingreso = ingreso + m.getPrecio();
            }

        }

        for (T c : sectoresComida) {
            for (Comida a : ((SectorComida) c).getMenu()) {
                ingreso = ingreso + a.getPrecio();
            }
        }

        return ingreso;
    }
    public void modificarProducto(Scanner scanner) {
        try {
            System.out.println("Ingrese el ID del Producto a modificar:");
            int id = scanner.nextInt();
            boolean encontrado = false;
            for (Productos aux : productos) {
                if (aux.getId() == id) {
                    encontrado = true;
                    System.out.println("Ingrese el nuevo Nombre del Producto:");
                    String nombreNuevo = scanner.nextLine();
                    System.out.println("Ingrese el nuevo Precio del Producto:");
                    double precio = scanner.nextDouble();
                    System.out.println("Ingrese el nuevo Stock del Producto:");
                    int stock = scanner.nextInt();
                    aux.setNombre(nombreNuevo);
                    aux.setPrecio(precio);
                    aux.setStock(stock);
                    System.out.println("Producto modificado con éxito.");

                    // Guardar la lista de productos actualizada en el archivo JSON
                    guardarProductos();
                }
            }
            if (!encontrado) {
                System.out.println("No existe un Producto con ese ID.");
            }
        } catch (Exception e) {
            System.out.println("Error al modificar el producto: " + e.getMessage());
        }
    }

    public void eliminarProducto(Scanner scanner) {
        try {
            System.out.println("Ingrese el ID del Producto a eliminar:");
            int id = scanner.nextInt();
            boolean encontrado = false;
            for (Productos aux : productos) {
                if (aux.getId() == id) {
                    encontrado = true;
                    productos.remove(aux);
                    System.out.println("Producto eliminado con éxito.");

                    // Guardar la lista de productos actualizada en el archivo JSON
                    guardarProductos();
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No existe un Producto con ese ID.");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        }
    }

    public void mostrarProductos() {
        for (Productos p : productos) {
            System.out.println(p);
        }
    }

    public void cargarProductos() {
        try {
            productos = leerArrayList("productos.json");
            System.out.println("Productos cargados con éxito.");
        } catch (Exception e) {
            System.out.println("Error al cargar los productos: " + e.getMessage());
        }
    }
    public void guardarProductos() {
        Jackson<Productos> jackson = new Jackson<>();
        jackson.guardarLista("productos.json", productos);
    }
    public List<Productos> leerArrayList(String nombreArchivo) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            archivo.createNewFile();
            return new ArrayList<>();
        }
        TypeReference<ArrayList<Productos>> typeRef = new TypeReference<>() {};
        ArrayList<Productos> lista = objectMapper.readValue(archivo, typeRef);
        return lista;
    }

}