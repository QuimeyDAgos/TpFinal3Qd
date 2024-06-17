package PersonasPack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

import AlbumPack.Album;
import AlbumPack.Cancion;

public class Sistema<T> extends Jackson<T> {

    private HashSet<Admin> listaAdmin;
    private HashSet<Artista> artistas;
    private HashSet<Cliente> clientes;

    public Sistema(HashSet<Admin> listaAdmin, HashSet<Artista> artistas, HashSet<Cliente> clientes) {
        this.listaAdmin = listaAdmin;
        this.artistas = artistas;
        this.clientes = clientes;

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

    // mostrar Listas
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
        System.out.println("| [2] Modificar Persona       |");
        System.out.println("| [3] Eliminar Persona        |");
        System.out.println("| [4] Salir                   |");
        System.out.println("|-----------------------------|");

    }

    public void menuTipoPersonas() {
        System.out.println("|------------Añadir-----------|");
        System.out.println("|--------Tipo de Persona------|");
        System.out.println("| [1] Admin                   |");
        System.out.println("| [2] Artista                 |");
        System.out.println("| [3] Cliente                 |");
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

    public void gestionarPersonas() {
        boolean salir = false;
        Jackson<Persona> jack = new Jackson<>();
        Scanner scanner = new Scanner(System.in);
        while (!salir) {
            menuGestionarPersonas();
            System.out.print(">>");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                boolean volver = false;
                while (!volver) {
                    menuTipoPersonas();
                    System.out.print(">>");
                    int opcionDos = scanner.nextInt();

                    switch (opcionDos) {
                        case 1:
                            // Creariamos una persona de tipo admin y se guardaria
                            // guardarUnoEnlista("personas.json",admin);
                            break;
                        case 2:
                            LinkedList<Cancion> lista_canciones2 = new LinkedList<>();
                            Album album2 = new Album("Future Nostalgia", 2021, lista_canciones2);
                            LinkedList<Album> lista_de_AlbumsDua = new LinkedList<>();
                            lista_de_AlbumsDua.add(album2);
                            Artista artista1 = new Artista("Dua", "Lipa", 432, "Dua Lipa", lista_de_AlbumsDua);

                            LinkedList<Cancion> lista_canciones3 = new LinkedList<>();
                            Album album3 = new Album("GRASA", 2024, lista_canciones3);
                            LinkedList<Album> lista_de_AlbumsNati = new LinkedList<>();
                            lista_de_AlbumsNati.add(album3);
                            Artista artista2 = new Artista("Natalia", "Peluso", 893, "Nathy Peluso",
                                    lista_de_AlbumsNati);

                            LinkedList<Cancion> lista_canciones4 = new LinkedList<>();
                            Album album4 = new Album("A Contraluz", 2018, lista_canciones4);
                            LinkedList<Album> lista_de_AlbumsVela = new LinkedList<>();
                            lista_de_AlbumsVela.add(album4);
                            Artista artista3 = new Artista("Vela", "Puerca", 962, "La Vela Puerca",
                                    lista_de_AlbumsVela);

                            LinkedList<Cancion> lista_canciones5 = new LinkedList<>();
                            Album album5 = new Album("Mechon de Pelo", 2024, lista_canciones5);
                            LinkedList<Album> lista_de_AlbumsTini = new LinkedList<>();
                            lista_de_AlbumsTini.add(album5);
                            Artista artista4 = new Artista("Martina", "Stoesel ", 324, "TINI", lista_de_AlbumsTini);

                            LinkedList<Cancion> lista_canciones = new LinkedList<>();
                            Album el_album = new Album("ameri", 2020, lista_canciones);
                            LinkedList<Album> lista_de_Albums = new LinkedList<>();
                            lista_de_Albums.add(el_album);
                            Artista artista = new Artista("Mauro", "Lombardo", 123, "Duki", lista_de_Albums);
                            jack.guardarUnoEnlista("Personas.json", artista);
                            jack.guardarUnoEnlista("Personas.json", artista1);
                            jack.guardarUnoEnlista("Personas.json", artista2);
                            jack.guardarUnoEnlista("Personas.json", artista3);
                            jack.guardarUnoEnlista("Personas.json", artista4);
                            break;

                        case 3:

                            // Creariamos una persona de tipo Cliente y se guardaria
                            Cliente cliente = new Cliente("Thomas", "Fernandez", 7777, "thomasFernandez", "2236915931");
                            jack.guardarUnoEnlista("Personas.json", cliente);

                            break;
                        case 4:

                            salir = true;
                            System.out.println("Volviendo...");

                            break;

                        default:

                            System.out.println("Opcion no valida ! :v");

                            break;
                    }
                }

                    break;
                case 2:
                    // falta funcionalidad de modificar persona
                    

                    break;
                case 3:

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
                            salir = true;
                            System.out.println("Volviendo...");
                            break;

                        default:
                            System.out.println("Opcion incorrecta.      [ERRROR]");
                            break;
                    }

                    break;

                default:
                    break;

            }

            scanner.close();

        }
    }

}
