package Reproductor;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Rep {
    private Clip clip;
    private boolean isPaused;
    private int pausaFrame;

    public void cargarSonido(String ruta) {
        try {
            File archivoSonido = new File(ruta);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivoSonido);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            isPaused = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reproducir() {
        if (clip != null) {
            if (isPaused) {
                clip.setFramePosition(pausaFrame);
                isPaused = false;
            }
            clip.start();
        }
    }

    public void pausar() {
        if (clip != null && clip.isRunning()) {
            pausaFrame = clip.getFramePosition();
            clip.stop();
            isPaused = true;
        }
    }

    public void detener() {
        if (clip != null) {
            clip.stop();
            clip.close();
            isPaused = false;
        }
    }

    public boolean isPlaying() {
        return clip != null && clip.isRunning();
    }

    public boolean isPaused() {
        return isPaused;
    }
}


