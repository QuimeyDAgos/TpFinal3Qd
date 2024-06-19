package GestoresPack;

import PersonasPack.*;


import java.util.*;

public class SistemaPersona<T> extends Jackson<T> {

    private HashSet<Admin> listaAdmin = new HashSet<>();
    private HashSet<Artista> artistas = new HashSet<>();
    private HashSet<Cliente> clientes = new HashSet<>();
    private HashSet<Persona> general = new HashSet<>();

    public SistemaPersona(HashSet<Admin> listaAdmin, HashSet<Artista> artistas, HashSet<Cliente> clientes) {
        this.listaAdmin = listaAdmin;
        this.artistas = artistas;
        this.clientes = clientes;

    }

    public SistemaPersona() {
    }

    // Metodos
    public void leerPersonas(String nombreArchi) {

        for (T persona : leerHashSet(nombreArchi)) {
            if (persona instanceof Admin) {

                listaAdmin.add((Admin) persona);

            } else if (persona instanceof Cliente) {
                clientes.add((Cliente) persona);

            } else {

                artistas.add((Artista) persona);

            }

        }

    }

    //mostrar Listas
    public void mostrarListaArtista() {

        for (Artista artista : artistas) {

            System.out.println(artista);

        }

    }

    public void mostrarListaAdmin() {

        for (Admin admin : listaAdmin) {

            System.out.println(admin);

        }

    }

    public void mostrarListaClientes() {

        for (Cliente cliente : clientes) {

            System.out.println(cliente);


        }

    }

    public void menuGestionarPersonas() {
        System.out.println("|------Menu Gestor Personas---|");
        System.out.println("| [1] Agregar Persona         |");
        System.out.println("| [2] Salir                   |");
        System.out.println("|-----------------------------|");

    }

    public void menuEliminarPersona() {
        System.out.println("|-----------Eliminar----------|");
        System.out.println("|--------Tipo de Persona------|");
        System.out.println("| [1] Admin                   |");
        System.out.println("| [2] Artista                 |");
        System.out.println("| [3] Cliente                 |");
        System.out.println("| [4] Salir                   |");
        System.out.println("|-----------------------------|");

    }

    public void gestionarPersonas(String nombreArchi, Scanner scanner) {
        boolean salir = false;
        GestoraPers gestoraPers = new GestoraPers();

        while (!salir) {
            menuGestionarPersonas();
            System.out.print(">>");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:

                    gestoraPers.GestAddPers(scanner);

                    break;
                case 2:
                    salir = true;
                    System.out.println("Volviendo...");

                default:
                    System.out.println("Valor invalido, intentelo denuevo");
                    break;

            }

        }
        scanner.close();
    }

    public HashSet<Admin> getListaAdmin() {
        return listaAdmin;
    }

    public void setListaAdmin(HashSet<Admin> listaAdmin) {
        this.listaAdmin = listaAdmin;
    }

    public HashSet<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(HashSet<Artista> artistas) {
        this.artistas = artistas;
    }

    public HashSet<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashSet<Cliente> clientes) {
        this.clientes = clientes;
    }

    public HashSet<Persona> getGeneral() {
        return general;
    }

    public void setGeneral(HashSet<Persona> general) {
        this.general = general;
    }

    private void gestionarEliminacionPersona(String nombreArchi, Scanner scanner) {
        menuEliminarPersona();
        System.out.print(">>");
        int opcionTres = scanner.nextInt();

        // Eliminar Persona
        System.out.println("Escriba el dni de la persona a eliminar");
        System.out.print(">>");
        int dniAeliminar = scanner.nextInt();

        switch (opcionTres) {
            case 1:
                // Eliminar admin
                eliminarAdmin(nombreArchi, dniAeliminar);
                break;
            case 2:
                eliminarArtista(nombreArchi, dniAeliminar);
                break;
            case 3:
                eliminarCliente(nombreArchi, dniAeliminar);
                break;
            case 4:
                System.out.println("Volviendo...");
                break;
            default:
                System.out.println("Opción incorrecta. [ERROR]");
                break;
        }
    }

    public Cliente buscarClientePorDni(int dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == dni) {
                return cliente;
            }
        }
        return null; // Si no se encuentra el cliente
    }

    /* 
    public T buscar(HashSet<T> lista, int id) {

        T persona = null;
        for (T dato : lista) {
            if (dato instanceof Cliente aux) {
                if (aux.getDni() == id) {
                    persona = dato;
                }
            } else if (dato instanceof Admin aux) {
                if (aux.getDni() == id) {
                    persona = dato;
                }
            } else {
                Artista aux = (Artista) dato;
                if (aux.getDni() == id) {
                    persona = dato;
                }
            }
        }
        try {
            if (persona != null) {
                System.out.println("Persona Encontrada");
            } else {
                throw new RuntimeException("Persona no encontrda");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
      return persona;
    }
      */
}
