package GestoresPack;

import AlbumPack.Album;
import AlbumPack.Cancion;
import PersonasPack.*;
import ProductosPack.Productos;

import java.util.*;


public class GestoraPers {

 private HashSet<Persona> listaPersonas;

    public GestoraPers() {
        listaPersonas= new HashSet<>();
    }

    public void GestAddPers(Scanner scanner) {
        boolean salir = false;
        Jackson<Persona> jack = new Jackson<>();
        SistemaPersona<Persona> sis = new SistemaPersona<>();

        while (!salir) {
            System.out.println("|------------Añadir-----------|");
            System.out.println("|--------Tipo de Persona------|");
            System.out.println("| [1] Admin                   |");
            System.out.println("| [2] Artista                 |");
            System.out.println("| [3] Cliente                 |");
            System.out.println("| [4] Salir                   |");
            System.out.println("|-----------------------------|");
            System.out.print(">>");
            int opcionDos = scanner.nextInt();

            switch (opcionDos) {
                case 1:
                    /// Gestor pers admin
                    break;
                case 2:

                    LinkedList<Cancion> lista_canciones2 = new LinkedList<>();
                    Album album2 = new Album("Future Nostalgia", 2021, lista_canciones2);
                    LinkedList<Album> lista_de_AlbumsDua = new LinkedList<>();
                    lista_de_AlbumsDua.add(album2);
                    Artista artista1 = new Artista("Dua", "Lipa", 432, "Dua Lipa", lista_de_AlbumsDua);

                    if (!sis.getGeneral().contains(artista1)) {
                        sis.getGeneral().add(artista1);
                    }

                    LinkedList<Cancion> lista_canciones3 = new LinkedList<>();
                    Album album3 = new Album("GRASA", 2024, lista_canciones3);
                    LinkedList<Album> lista_de_AlbumsNati = new LinkedList<>();
                    lista_de_AlbumsNati.add(album3);
                    Artista artista2 = new Artista("Natalia", "Peluso", 893, "Nathy Peluso", lista_de_AlbumsNati);

                    if (!sis.getGeneral().contains(artista2)) {
                        sis.getGeneral().add(artista2);
                    }

                    LinkedList<Cancion> lista_canciones4 = new LinkedList<>();
                    Album album4 = new Album("A Contraluz", 2018, lista_canciones4);
                    LinkedList<Album> lista_de_AlbumsVela = new LinkedList<>();
                    lista_de_AlbumsVela.add(album4);
                    Artista artista3 = new Artista("Vela", "Puerca", 962, "La Vela Puerca", lista_de_AlbumsVela);

                    if (!sis.getGeneral().contains(artista3)) {
                        sis.getGeneral().add(artista3);
                    }

                    LinkedList<Cancion> lista_canciones5 = new LinkedList<>();
                    Album album5 = new Album("Mechon de Pelo", 2024, lista_canciones5);
                    LinkedList<Album> lista_de_AlbumsTini = new LinkedList<>();
                    lista_de_AlbumsTini.add(album5);
                    Artista artista4 = new Artista("Martina", "Stoesel ", 324, "TINI", lista_de_AlbumsTini);

                    if (!sis.getGeneral().contains(artista4)) {
                        sis.getGeneral().add(artista4);
                    }

                    LinkedList<Cancion> lista_canciones = new LinkedList<>();
                    Album el_album = new Album("ameri", 2020, lista_canciones);
                    LinkedList<Album> lista_de_Albums = new LinkedList<>();
                    lista_de_Albums.add(el_album);
                    Artista artista = new Artista("Mauro", "Lombardo", 123, "Duki", lista_de_Albums);

                    if (!sis.getGeneral().contains(artista)) {
                        sis.getGeneral().add(artista);
                    }
                    jack.guardarHashSet("Personas.json", sis.getGeneral());
                    salir = true;
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.println("Ingrese nombre");
                    String nom = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Apellido");
                    String ape = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Mail");
                    String mail = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Telefono");
                    String tel = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("DNI");
                    int dni = scanner.nextInt();
                    Cliente aux = new Cliente(nom, ape, dni, mail, tel);
                    // Creariamos una persona de tipo Cliente y se guardaria
                    jack.guardarUnoEnlista("Personas.json", aux);
                    salir = true;
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

    }

    public Persona buscarPersonaDNI(int dni) {
        Jackson<Persona> jackson = new Jackson<>();
        listaPersonas = jackson.leerHashSetPersona("Personas.json");
        Persona retorno = null;
        for (Persona aux : listaPersonas) {
            {
                if (dni == aux.getDni()) {
                    retorno = aux;
                }
            }
        }
        try {
            if (retorno == null) {
                throw new RuntimeException("Persona no Encontrado");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }

}

   



