package GestoresPack;
import ConcertPack.Entradas;
import ConcertPack.TipoEntrada;
import PersonasPack.Cliente;
import PersonasPack.Jackson;
import PersonasPack.Persona;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class GestorEntry {
    private HashMap<Integer, Entradas> entradas;
    private Sistema<Persona> sistema;

    public GestorEntry() {
        this.entradas = new HashMap<>();
        this.sistema = new Sistema<>(); // Crear una instancia de Sistema
    }
    public void agregarEntrada(Scanner scanner) {
        try {
            System.out.println("Ingrese el ID de la entrada:");
            int id = scanner.nextInt();
            if (entradas.containsKey(id)) {
                System.out.println("Ya existe una entrada con ese ID.");
                return;
            }

            Entradas entrada = new Entradas(50, TipoEntrada.GENERAL, id);
            entradas.put(id, entrada);
            System.out.println("Entrada agregada con éxito.");
        } catch (Exception e) {
            System.out.println("Error al agregar la entrada: " + e.getMessage());
        }
    }

    public void eliminarEntrada(Scanner scanner) {
        try {
            System.out.println("Ingrese el ID de la entrada a eliminar:");
            int id = scanner.nextInt();
            if (!entradas.containsKey(id)) {
                System.out.println("No existe una entrada con ese ID.");
                return;
            }

            entradas.remove(id);
            System.out.println("Entrada eliminada con éxito.");
        } catch (Exception e) {
            System.out.println("Error al eliminar la entrada: " + e.getMessage());
        }
    }

    public void modificarDisponibilidad(Scanner scanner) {
        try {
            System.out.println("Ingrese el ID de la entrada a modificar:");
            int id = scanner.nextInt();
            if (!entradas.containsKey(id)) {
                System.out.println("No existe una entrada con ese ID.");
                return;
            }

            Entradas entrada = entradas.get(id);
            entrada.setDisponibilad(!entrada.isDisponibilad());
            entradas.put(id, entrada);
            System.out.println("Disponibilidad modificada con éxito.");
        } catch (Exception e) {
            System.out.println("Error al modificar la disponibilidad: " + e.getMessage());
        }
    }
    public void guardarEntradas() {
        Jackson<Entradas>jackson = new Jackson<>();
        jackson.guardarHashMap("Entradas.json", entradas);
    }

    public void cargarEntradas() {
        try {
            for (int i = 0; i < 500; i++) {
                TipoEntrada tipo = (i / 50) % 2 == 0 ? TipoEntrada.GENERAL : TipoEntrada.VIP;
                double precio = tipo == TipoEntrada.VIP ? calcularPrecioVIP() : 10000; // Calcular el precio según el tipo de entrada
                Entradas entrada = new Entradas(precio, tipo, i + 1);
                entradas.put(i + 1, entrada);
            }
            System.out.println("Entradas cargadas con éxito.");

            // Guardar las entradas en el JSON después de cargarlas
            guardarEntradas();
        } catch (Exception e) {
            System.out.println("Error al cargar las entradas: " + e.getMessage());
        }
    }

    public double calcularPrecioVIP() {
        return 15000; // Precio base de entrada VIP
    }

    public void mostrarEntradas() {
        for (Map.Entry<Integer, Entradas> entry : entradas.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Entrada: " + entry.getValue());
        }
    }

    public HashMap<Integer, Entradas> getEntradas() {
        return entradas;
    }

    public void setEntradas(HashMap<Integer, Entradas> entradas) {
        this.entradas = entradas;
    }

    public void venderEntrada(int idEntrada, int dniCliente) {
        try {
            if (!entradas.containsKey(idEntrada)) {
                System.out.println("No existe una entrada con ese ID.");
                return;
            }

            Entradas entrada = entradas.get(idEntrada);
            if (!entrada.isDisponibilad()) {
                System.out.println("La entrada no está disponible para la venta.");
                return;
            }

            Cliente cliente = sistema.buscarClientePorDni(dniCliente);
            if (cliente == null) {
                System.out.println("No existe un cliente con ese DNI.");
                return;
            }

            cliente.getHistorialEntr().put(idEntrada, entrada); // Agregar entrada al historial del cliente

            entrada.venta(); // Realizar la venta
            entrada.setDisponibilad(false); // Marcar como vendida

            // Actualizar la entrada en el HashMap
            entradas.put(idEntrada, entrada);
            System.out.println("Entrada vendida con éxito.");

            // Guardar las entradas actualizadas en el archivo
            guardarEntradas();
        } catch (Exception e) {
            System.out.println("Error al vender la entrada: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEntry gestorEntry = new GestorEntry();

        boolean salir = false;
        while (!salir) {
            System.out.println("|-----Menú Gestor de Entradas-----|");
            System.out.println("| [1] Agregar Entrada             |");
            System.out.println("| [2] Eliminar Entrada            |");
            System.out.println("| [3] Modificar Disponibilidad    |");
            System.out.println("| [4] Cargar Entradas             |");
            System.out.println("| [5] Mostrar Entradas            |");
            System.out.println("| [6] Vender Entrada              |");
            System.out.println("| [7] Salir                       |");
            System.out.println("|---------------------------------|");
            System.out.print(">> ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    gestorEntry.agregarEntrada(scanner);
                    break;
                case 2:
                    gestorEntry.eliminarEntrada(scanner);
                    break;
                case 3:
                    gestorEntry.modificarDisponibilidad(scanner);
                    break;
                case 4:
                    gestorEntry.cargarEntradas();
                    break;
                case 5:
                    gestorEntry.mostrarEntradas();
                    break;
                case 6:
                    System.out.println("Ingrese el ID de la entrada a vender:");
                    int idEntrada = scanner.nextInt();
                    System.out.println("Ingrese el DNI del cliente:");
                    int dniCliente = scanner.nextInt();
                    gestorEntry.venderEntrada(idEntrada, dniCliente);
                    break;
                case 7:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }

        scanner.close();
    }

}