package PersonasPack;

import AlbumPack.Album;
import AlbumPack.Cancion;

import java.util.LinkedList;
import java.util.Scanner;

public class GestoraPers {



    public static void main(String[] args) {
        boolean salir = false;
        Jackson<Persona> jack = new Jackson<>();
        Scanner scanner = new Scanner(System.in);
        while (!salir)
        {
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
                    // Creariamos una persona de tipo admin y se guardaria
                    // guardarUnoEnlista("personas.json",admin);
                    break;
                case 2:
                    Sistema sis =new Sistema<>();
                    LinkedList<Cancion> lista_canciones2 = new LinkedList<>();
                    Album album2 = new Album("Future Nostalgia", 2021, lista_canciones2);
                    LinkedList<Album> lista_de_AlbumsDua = new LinkedList<>();
                    lista_de_AlbumsDua.add(album2);
                    Artista artista1 = new Artista("Dua", "Lipa", 432, "Dua Lipa", lista_de_AlbumsDua);

                    LinkedList<Cancion> lista_canciones3 = new LinkedList<>();
                    Album album3 = new Album("GRASA", 2024, lista_canciones3);
                    LinkedList<Album> lista_de_AlbumsNati = new LinkedList<>();
                    lista_de_AlbumsNati.add(album3);
                    Artista artista2 = new Artista("Natalia", "Peluso", 893, "Nathy Peluso", lista_de_AlbumsNati);

                    LinkedList<Cancion> lista_canciones4 = new LinkedList<>();
                    Album album4 = new Album("A Contraluz", 2018, lista_canciones4);
                    LinkedList<Album> lista_de_AlbumsVela = new LinkedList<>();
                    lista_de_AlbumsVela.add(album4);
                    Artista artista3 = new Artista("Vela", "Puerca", 962, "La Vela Puerca", lista_de_AlbumsVela);

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
                    sis.getGeneral().add(artista);
                    sis.getGeneral().add(artista1);
                    sis.getGeneral().add(artista2);
                    sis.getGeneral().add(artista3);
                    sis.getGeneral().add(artista4);
                    jack.guardarHashSet("Personas.json",sis.getGeneral());
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

        }


    }
