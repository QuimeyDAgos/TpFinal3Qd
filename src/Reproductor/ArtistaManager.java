package Reproductor;

import javax.swing.*;
import java.util.*;

public class ArtistaManager {
    private Map<String, List<Cancion>> artistasCanciones;
    private Map<String, Boolean> visibilidadBotones = new HashMap<>();
    private Window window;

    public ArtistaManager() {
        artistasCanciones = new HashMap<>();
        // Agregar datos de los artistas y canciones
        agregarCanciones();
    }

    private void agregarCanciones() {
        artistasCanciones.put("Nathy Peluso", Arrays.asList(
                new Cancion("Manhattan", "src/Reproductor/musica/nati/11. MANHATTAN - NATHY PELUSO, Duki .wav", "src/Reproductor/img/Nati.png"),
                new Cancion("Legendario", "src/Reproductor/musica/nati/4. LEGENDARIO - NATHY PELUSO  GRASA-YTConverter.app.wav", "src/Reproductor/img/Nati.png"),
                new Cancion("Real","src/Reproductor/musica/nati/3. REAL - NATHY PELUSO .wav","src/Reproductor/img/Nati.png"),
                new Cancion("La Presa", "src/Reproductor/musica/nati/13. LA PRESA - NATHY PELUSO .wav", "src/Reproductor/img/Nati.png"),
                new Cancion("Ideas Radicales","src/Reproductor/musica/nati/10. IDEAS RADICALES - NATHY PELUSO.wav","src/Reproductor/img/Nati.png")
        ));
        artistasCanciones.put("TINI", Arrays.asList(
                new Cancion("Posta", "src/Reproductor/musica/Tini/TINI - posta .wav", "src/Reproductor/img/Tini.png"),
                new Cancion("Ni de Ti", "src/Reproductor/musica/Tini/TINI - ni de ti .wav", "src/Reproductor/img/Tini.png"),
                new Cancion("Las Jordans","src/Reproductor/musica/Tini/TINI - Las Jordans .wav","src/Reproductor/img/Tini.png"),
                new Cancion("Mienteme","src/Reproductor/musica/Tini/TINI, Maria Becerra - Miénteme .wav","src/Reproductor/img/Tini.png"),
                new Cancion("Maldita Foto","src/Reproductor/musica/Tini/TINI, Manuel Turizo - Maldita Foto .wav","src/Reproductor/img/Tini.png")
        ));
        artistasCanciones.put("Vela Puerca", Arrays.asList(
                new Cancion("El Profeta", "src/Reproductor/musica/VelaPuerca/La Vela Puerca - El Profeta.wav", "src/Reproductor/img/Vela Puerca.png"),
                new Cancion("Por Dentro","src/Reproductor/musica/VelaPuerca/La Vela Puerca - Por Dentro.wav","src/Reproductor/img/Vela Puerca.png"),
                new Cancion("Por la Ciudad","src/Reproductor/musica/VelaPuerca/La Vela Puerca - Por la Ciudad.wav","src/Reproductor/img/Vela Puerca.png"),
                new Cancion("El viejo","src/Reproductor/musica/VelaPuerca/La Vela Puerca  El Viejo .wav","src/Reproductor/img/Vela Puerca.png"),
                new Cancion("Va A Escampar","src/Reproductor/musica/VelaPuerca/La Vela Puerca  Va A Escampar .wav","src/Reproductor/img/Vela Puerca.png")
        ));
        artistasCanciones.put ("Dua Lipa",Arrays.asList(
                new Cancion("Houdini","src/Reproductor/musica/Dua/Dua Lipa - Houdini .wav","src/Reproductor/img/Dua .png"),
                new Cancion("Potion","src/Reproductor/musica/Dua/Dua Lipa - Potion .wav","src/Reproductor/img/Dua .png"),
                new Cancion("Good in Bed","src/Reproductor/musica/Dua/Dua Lipa - Good In Bed .wav","src/Reproductor/img/Dua .png"),
                new Cancion("Pretty please","src/Reproductor/musica/Dua/Dua Lipa - Pretty Please.wav","src/Reproductor/img/Dua .png"),
                new Cancion("Hallucinate","src/Reproductor/musica/Dua/Dua Lipa - Hallucinate .wav","src/Reproductor/img/Dua .png")
        ));
        artistasCanciones.put("Duki",Arrays.asList(
                new Cancion("Dont Lie","src/Reproductor/musica/Duki/DUKI, Quevedo - dont Lie.wav",""),
                new Cancion("Celosa","src/Reproductor/musica/Duki/DUKI - Celosa .wav",""),
                new Cancion("Chico Estrella","src/Reproductor/musica/Duki/DUKI - Chico Estrella .wav",""),
                new Cancion("GiGi","src/Reproductor/musica/Duki/DUKI - GiGi .wav",""),
                new Cancion("GIVENCHY","src/Reproductor/musica/Duki/DUKI - GIVENCHY .wav","")
        ));
    }

    public Map<String, List<Cancion>> getArtistasCanciones() {
        return artistasCanciones;
    }

    public void mostrarBoton(String nombreCancion) {
        if (window != null) {
            window.mostrarBoton(nombreCancion);
            visibilidadBotones.put(nombreCancion, true);
        }
    }

    public void ocultarBoton(String nombreCancion) {
        if (window != null) {
            window.ocultarBoton(nombreCancion);
            visibilidadBotones.put(nombreCancion, false);
        }
    }

    public void runReproductor(String nombreArtista){
        ArtistaManager artistaManager = new ArtistaManager();

        SwingUtilities.invokeLater(() -> {
            artistaManager.window = new Window(nombreArtista, artistaManager.getArtistasCanciones());
            artistaManager.window.setVisible(false); // Ocultar la ventana al principio
        });

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ejecutar programa");
            System.out.println("2. Ocultar botón");
            System.out.println("3. Mostrar botón");
            System.out.println("4. Salir");
            System.out.println("Su opcion:");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (option) {
                case 1:
                    SwingUtilities.invokeLater(() -> {
                        artistaManager.window.setVisible(true);
                    });
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la canción para ocultar el botón:");
                    String cancionOcultar = scanner.nextLine();
                    artistaManager.ocultarBoton(cancionOcultar);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre de la canción para mostrar el botón:");
                    String cancionMostrar = scanner.nextLine();
                    artistaManager.mostrarBoton(cancionMostrar);
                    break;
                case 4:
                    exit = true;
                    // Cerrar la ventana manualmente
                    if (artistaManager.window != null) {
                        artistaManager.window.dispose();
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}