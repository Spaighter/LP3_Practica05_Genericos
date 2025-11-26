package ejercicios.propuestos;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ReproductorMusical extends JFrame {
    private Clip clip;
    private long tiempoPausa = 0;
    // RECUERDA: Cambia "cancion.wav" por tu archivo real
    private String rutaCancion = "recursos/audio/cancion.wav"; 

    public ReproductorMusical() {
        super("Ejercicio 4: Reproductor de Música");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));

        JButton btnPlay = new JButton("Reproducir ▶");
        JButton btnPause = new JButton("Pausar ⏸");
        JButton btnResume = new JButton("Reanudar ⏯");

        btnPlay.addActionListener(e -> play());
        btnPause.addActionListener(e -> pause());
        btnResume.addActionListener(e -> resume());

        add(btnPlay);
        add(btnPause);
        add(btnResume);
    }

    private void play() {
        try {
            if (clip != null && clip.isRunning()) clip.stop(); // Reiniciar si ya suena
            
            File archivo = new File(rutaCancion);
            if (archivo.exists()) {
                clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(archivo));
                clip.start();
                tiempoPausa = 0;
            } else {
                JOptionPane.showMessageDialog(this, "No encuentro: " + rutaCancion);
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void pause() {
        if (clip != null && clip.isRunning()) {
            tiempoPausa = clip.getMicrosecondPosition();
            clip.stop();
        }
    }

    private void resume() {
        if (clip != null && !clip.isRunning()) {
            clip.setMicrosecondPosition(tiempoPausa);
            clip.start();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReproductorMusical().setVisible(true));
    }
}