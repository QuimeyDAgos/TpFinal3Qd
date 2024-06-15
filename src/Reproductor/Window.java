package Reproductor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Window extends JFrame {
    private Rep reproductor;
    private Map<JButton, String> cancionesMap = new HashMap<>();
    private String rutaActual = "";

    public Window(String artista, Map<String, List<Cancion>> artistasCanciones) {
        setTitle("Natuki");
        setSize(400, 400);
        setLayout(new GridLayout(0, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        reproductor = new Rep();

        // Obtener las canciones del artista
        List<Cancion> canciones = artistasCanciones.getOrDefault(artista, Collections.emptyList());

        // Crear botones para cada canción
        for (Cancion cancion : canciones) {
            agregarBotonCancion(cancion.getNombre(), cancion.getRuta(), cancion.getImagen());
        }

        setVisible(true);
    }

    private void agregarBotonCancion(String nombreCancion, String rutaCancion, String rutaImagen) {
        ImageIcon iconNathy = new ImageIcon(rutaImagen);
        Image image = iconNathy.getImage();
        Image nuevaimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        iconNathy = new ImageIcon(nuevaimg);

        JButton botonCancion = new JButton(nombreCancion, iconNathy);
        botonCancion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    if (reproductor.isPlaying()) {
                        reproductor.pausar();
                    } else if (reproductor.isPaused()) {
                        reproductor.reproducir();
                    } else {
                        reproductor.detener();
                        reproductor.cargarSonido(rutaCancion);
                        reproductor.reproducir();
                    }
                } else if (e.getClickCount() == 2) {
                    reproductor.detener();
                    reproductor.cargarSonido(rutaCancion);
                    reproductor.reproducir();
                }
                rutaActual = rutaCancion;
            }
        });
        add(botonCancion);
    }
}


