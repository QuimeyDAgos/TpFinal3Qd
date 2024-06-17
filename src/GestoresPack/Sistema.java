package GestoresPack;

import PersonasPack.*;


import java.util.*;

public class Sistema<T> extends Jackson<T> {

    private HashSet<Admin> listaAdmin=new HashSet<>();
    private HashSet<Artista> artistas=new HashSet<>();
    private HashSet<Cliente> clientes=new HashSet<>();
    private HashSet<Persona> general = new HashSet<>();

    public Sistema(HashSet<Admin> listaAdmin, HashSet<Artista> artistas, HashSet<Cliente> clientes) {
        this.listaAdmin = listaAdmin;
        this.artistas = artistas;
        this.clientes = clientes;
        
    }

    public Sistema() {
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

        for (Cliente cliente: clientes) {

            System.out.println(cliente);
            

        }

    }
    public void menuGestionarPersonas() {
        System.out.println("|------Menu Gestor Personas---|");
        System.out.println("| [1] Agregar Persona         |");
        System.out.println("| [2] Modificar Persona       |");
        System.out.println("| [3] Eliminar Persona        |");
        System.out.println("| [4] Salir                   |");
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

    public void gestionarPersonas(Scanner scanner) {
        boolean salir = false;
        Jackson<Persona> jack = new Jackson<>();

        while (!salir) {
            System.out.println("a");
            menuGestionarPersonas();
            System.out.print(">>");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                        GestoraPers gestoraPers =new GestoraPers();
                        gestoraPers.GestAddPers(scanner);

                    break;
                case 2:
                    // falta funcionalidad de modificar persona


                    break;
                case 3:
                    gestionarEliminacionPersona(scanner);
                    break;
                case 4 :
                    salir=true;
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

    private void gestionarEliminacionPersona(Scanner scanner) {
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
                eliminarAdmin("Personas.json", dniAeliminar);
                break;
            case 2:
                eliminarArtista("Personas.json", dniAeliminar);
                break;
            case 3:
                eliminarCliente("Personas.json", dniAeliminar);
                break;
            case 4:
                System.out.println("Volviendo...");
                break;
            default:
                System.out.println("Opción incorrecta. [ERROR]");
                break;
        }
    }
}
