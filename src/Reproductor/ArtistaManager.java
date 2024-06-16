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
                new Cancion("Manhattan", "src/Reproductor/musica/11. MANHATTAN - NATHY PELUSO, Duki  GRASA-YTConverter.app.wav", "src/Reproductor/img/Captura de pantalla 2024-06-15 143936.png"),
                new Cancion("Legendario", "src/Reproductor/musica/4. LEGENDARIO - NATHY PELUSO .wav", "src/Reproductor/img/Captura de pantalla 2024-06-15 143936.png"),
                new Cancion("La Presa", "src/Reproductor/musica/13. LA PRESA - NATHY PELUSO  GRASA-YTConverter.app.wav", "src/Reproductor/img/Captura de pantalla 2024-06-15 143936.png")
        ));
        artistasCanciones.put("TINI", Arrays.asList(
                new Cancion("Posta", "src/Reproductor/musica/TINI - posta (Official Video)-YTConverter.app.wav", "src/Reproductor/img/Captura de pantalla 2024-06-15 162651.png"),
                new Cancion("Ni de Ti", "src/Reproductor/musica/TINI - ni de ti (Visualizer)-YTConverter.app.wav", "src/Reproductor/img/Captura de pantalla 2024-06-15 162651.png")
        ));
        artistasCanciones.put("BZRP", Arrays.asList(
                new Cancion("Lismar", "src/Reproductor/musica/Lismar  BZRP Music Sessions 60-YTConverter.app.wav", "src/Reproductor/img/Lismar.png")
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