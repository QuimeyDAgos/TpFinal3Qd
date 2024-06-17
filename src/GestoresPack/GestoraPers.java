package GestoresPack;

import AlbumPack.Album;
import AlbumPack.Cancion;
import PersonasPack.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;


public class GestoraPers {
    public GestoraPers() {
    }

    public void GestAddPers(Scanner scanner){
        boolean salir = false;
        Jackson<Persona> jack = new Jackson<>();
        Sistema<Persona> sis =new Sistema<Persona>();

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
                    jack.guardarHashSet("Personas.json",sis.getGeneral());
                    salir=true;
                    break;

                case 3:

                    // Creariamos una persona de tipo Cliente y se guardaria

                    Cliente cliente = new Cliente("Thomas", "Fernandez", 7777, "thomasFernandez", "2236915931");
                    if (!sis.getGeneral().contains(cliente)) {
                        sis.getGeneral().add(cliente);
                    }

                    Cliente cliente1 = new Cliente("Quimey","DAgostino",8888,"quimeyDagostini","2237843921");
                    if (!sis.getGeneral().contains(cliente1)) {
                        sis.getGeneral().add(cliente1);
                    }
                    Cliente cliente2 = new Cliente("Abril","del Rio",9999,"abruMay","2234674938");
                    if (!sis.getGeneral().contains(cliente2)) {
                    sis.getGeneral().add(cliente2);
                }
                    Cliente cliente3 = new Cliente("Damian","Lupo",2222,"damiLupo","2236578243");
                    if (!sis.getGeneral().contains(cliente3)) {
                        sis.getGeneral().add(cliente3);
                    }

                  sis.getGeneral().add (cliente1);
                  sis.getGeneral().add (cliente2);
                  sis.getGeneral().add (cliente3);
                  jack.guardarHashSet("Personas.json", sis.getGeneral());
                   salir=true;
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


    public void modificarPersona(String nombreArchi){
        
        Scanner in = new Scanner(System.in);
        System.out.println("|---------Tipo Persona--------|");
        System.out.println("| [1] Admin                   |");
        System.out.println("| [2] Artista                 |");
        System.out.println("| [3] Cliente                 |");
        System.out.println("| [4] Salir                   |");
        System.out.println("|-----------------------------|");
        System.out.print(">>");
        int opcion = in.nextInt();
        Sistema<Persona>sis = new Sistema<Persona>();
        HashSet<Persona>listaAdmin =sis.leerHashSet(nombreArchi);
        boolean salir = false;
        while (!salir){
            System.out.println("Escriba el dni de la persona a modificar");
            System.out.println("-----------------------------------------");
            System.out.print(">>");
            int dni = in.nextInt();
            switch (opcion) {
                case 1:
                   
    
                    Admin aux = (Admin) sis.buscarAdmin(listaAdmin, dni);
                    atributoAmodificar(aux, dni);
                    break;
    
                    case 2:
                    Artista auxDos = (Artista) sis.buscarAdmin(listaAdmin, dni);
                    atributoAmodificar(auxDos, dni);
                    
                    break;
    
                    case 3:       
                    Cliente auxTres = (Cliente) sis.buscarAdmin(listaAdmin, dni);
                    atributoAmodificar(auxTres, dni);

                    break;
                    case 4:
                        salir = true;
                        System.out.println("Volviendo...");
                    break;
            
                default:
                        System.out.println("[ERORR]");
                    break;
            }
        }
        sis.guardarHashSet(nombreArchi, listaAdmin);
        in.close();


    }
    public void atributoAmodificar (Persona aux, int dni){

        Scanner in = new Scanner(System.in);
        System.out.println("|-----------Modificar---------|");
        System.out.println("|-----------Atributo----------|");
        System.out.println("| [1] Nombre                  |");
        System.out.println("| [2] Apellido                |");
        System.out.println("| [3] Salir                   |");
        System.out.println("|-----------------------------|");
        System.out.print(">>");
        int opcion = in.nextInt();
        boolean salir = false;
            while (!salir){
                switch (opcion) {
                    case 1:
                    String nuevoNombre = in.nextLine();
                    aux.setNombre(nuevoNombre);
                   
         
                        break;
                        case 2:
                        String nuevoApellido = in.nextLine();
                        aux.setNombre(nuevoApellido);
        
                        //Cambiar apellido
                        break;
                        case 3:
                        salir= true;
                        System.out.println("Volviendo...");
                        break;
                
                    default:
                    System.out.println("[ERROR]");
                        break;
                }

            }
        in.close();
        



}

    }
