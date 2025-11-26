package ejercicios.propuestos;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class BotoneraSonidos extends JFrame {

    public BotoneraSonidos() {
        super("Ejercicio 3: Efectos de Sonido");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50));

        // Botones (Asegúrate de tener estos archivos en recursos/audio/)
        add(crearBoton("👏 Aplausos", "recursos/audio/aplausos.wav", Color.ORANGE));
        add(crearBoton("🔔 Campana", "recursos/audio/campana.wav", Color.CYAN));
        add(crearBoton("💥 Explosión", "recursos/audio/explosion.wav", Color.RED));
    }

    private JButton crearBoton(String texto, String ruta, Color color) {
        JButton btn = new JButton(texto);
        btn.setBackground(color);
        btn.addActionListener(e -> reproducir(ruta));
        return btn;
    }

    private void reproducir(String ruta) {
        try {
            File archivo = new File(ruta);
            if(archivo.exists()) {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(archivo));
                clip.start();
            } else {
                JOptionPane.showMessageDialog(this, "Falta archivo: " + ruta);
            }
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BotoneraSonidos().setVisible(true));
    }
}