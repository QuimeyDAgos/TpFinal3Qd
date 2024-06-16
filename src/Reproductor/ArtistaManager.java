package Reproductor;

import javax.swing.*;
import java.util.*;

public class ArtistaManager {
    private Map<String, List<Cancion>> artistasCanciones;

    public ArtistaManager() {
        artistasCanciones = new HashMap<>();
        // Agregar datos de los artistas y canciones
        agregarCanciones();
    }

    private void agregarCanciones() {
        artistasCanciones.put("Nathy Peluso", Arrays.asList(
                new Cancion("Manhattan", "src/Reproductor/musica/11. MANHATTAN - NATHY PELUSO, Duki  GRASA-YTConverter.app.wav", "src/Reproductor/img/Captura de pantalla 2024-06-15 143936.png"),
                new Cancion("Legendario", "src/Reproductor/musica/4. LEGENDARIO - NATHY PELUSO  GRASA-YTConverter.app.wav", "src/Reproductor/img/Captura de pantalla 2024-06-15 143936.png"),
                new Cancion("La Presa","src/Reproductor/musica/13. LA PRESA - NATHY PELUSO  GRASA-YTConverter.app.wav","src/Reproductor/img/Captura de pantalla 2024-06-15 143936.png")
        ));
        artistasCanciones.put("TINI", Arrays.asList(
                new Cancion("Posta", "src/Reproductor/musica/TINI - posta (Official Video)-YTConverter.app.wav", "src/Reproductor/img/Captura de pantalla 2024-06-15 162651.png"),
                new Cancion("Ni de Ti", "src/Reproductor/musica/TINI - ni de ti (Visualizer)-YTConverter.app.wav", "src/Reproductor/img/Captura de pantalla 2024-06-15 162651.png")
        ));
    }

    public Map<String, List<Cancion>> getArtistasCanciones() {
        return artistasCanciones;
    }

    public static void main(String[] args) {
        ArtistaManager artistaManager = new ArtistaManager();

        // Nombre del artista a mostrar
        String nombreArtista = "TINI";

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Window(nombreArtista, artistaManager.getArtistasCanciones());
            }
        });
    }
}