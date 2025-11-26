package actividades.teoria;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * Reproductor de Video Completo para la Guía 10.
 * Incluye: Play, Pause, Stop, Velocidad x2, Slider de búsqueda y Contador de Tiempo.
 */
public class VideoExample {

    private static final int ANCHO = 800;
    private static final int ALTO = 600;

    // Componentes estáticos para acceder desde los eventos
    private static MediaPlayer mediaPlayer;
    private static JSlider sliderTiempo;
    private static JLabel lblContadorTiempo;
    private static boolean moviendoSlider = false; // Bandera para evitar saltos mientras arrastras

    public static void main(String[] args) {
        // Iniciar la interfaz Swing
        SwingUtilities.invokeLater(VideoExample::initSwing);
    }

    private static void initSwing() {
        JFrame frame = new JFrame("Reproductor Multimedia (JavaFX + Swing)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(ANCHO, ALTO);
        frame.setLayout(new BorderLayout());

        // 1. Panel Central (Video)
        JFXPanel jfxPanel = new JFXPanel();
        jfxPanel.setBackground(Color.BLACK); // Fondo negro mientras carga
        frame.add(jfxPanel, BorderLayout.CENTER);

        // 2. Panel Inferior (Controles y Barra)
        JPanel panelSur = new JPanel(new BorderLayout());
        panelSur.setBackground(new Color(30, 30, 30)); // Gris oscuro
        panelSur.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // --- A. Barra de Tiempo y Contador ---
        JPanel panelBarra = new JPanel(new BorderLayout(10, 0));
        panelBarra.setOpaque(false);

        sliderTiempo = new JSlider(0, 100, 0);
        sliderTiempo.setBackground(new Color(30, 30, 30));
        sliderTiempo.setOpaque(false);
        sliderTiempo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sliderTiempo.setToolTipText("Arrastra para buscar");

        // Eventos del Slider (Mouse)
        sliderTiempo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                moviendoSlider = true; // El usuario atrapó la barra, detenemos la actualización automática
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                moviendoSlider = false; // El usuario soltó la barra
                actualizarVideoDesdeSlider(); // Saltamos al segundo elegido
            }
        });

        lblContadorTiempo = new JLabel("00:00 / --:--");
        lblContadorTiempo.setForeground(Color.WHITE);
        lblContadorTiempo.setFont(new Font("Consolas", Font.BOLD, 12));

        panelBarra.add(sliderTiempo, BorderLayout.CENTER);
        panelBarra.add(lblContadorTiempo, BorderLayout.EAST);
        panelSur.add(panelBarra, BorderLayout.NORTH);

        // --- B. Botonera ---
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        panelBotones.setOpaque(false);

        JButton btnPlay = crearBoton("▶ Play", new Color(46, 204, 113));
        JButton btnPause = crearBoton("⏸ Pausa", new Color(241, 196, 15));
        JButton btnStop = crearBoton("⏹ Stop", new Color(231, 76, 60));
        JButton btnSpeed = crearBoton("⏩ x2", new Color(52, 152, 219));

        panelBotones.add(btnPlay);
        panelBotones.add(btnPause);
        panelBotones.add(btnStop);
        panelBotones.add(btnSpeed);
        panelSur.add(panelBotones, BorderLayout.SOUTH);

        frame.add(panelSur, BorderLayout.SOUTH);

        // Lógica de Botones (Swing llama a JavaFX con Platform.runLater)
        btnPlay.addActionListener(e -> Platform.runLater(() -> {
            if (mediaPlayer != null) {
                mediaPlayer.setRate(1.0); // Velocidad normal
                mediaPlayer.play();
            }
        }));

        btnPause.addActionListener(e -> Platform.runLater(() -> {
            if (mediaPlayer != null) mediaPlayer.pause();
        }));

        btnStop.addActionListener(e -> Platform.runLater(() -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.setRate(1.0);
            }
        }));

        btnSpeed.addActionListener(e -> Platform.runLater(() -> {
            if (mediaPlayer != null) {
                mediaPlayer.setRate(2.0); // Doble velocidad
            }
        }));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // 3. Iniciar el hilo de JavaFX
        Platform.runLater(() -> initFX(jfxPanel));
    }

    // --- MÉTODOS DE JAVAFX ---

    private static void initFX(JFXPanel jfxPanel) {
        try {
            // RUTA DEL VIDEO: Asegúrate que coincide exactamente con tu archivo
            File archivoVideo = new File("recursos/video/video_demo.mp4");

            if (!archivoVideo.exists()) {
                System.err.println("❌ ERROR: No encuentro el archivo: " + archivoVideo.getAbsolutePath());
                JOptionPane.showMessageDialog(null, "Video no encontrado. Revisa la carpeta recursos/video");
                return;
            }

            System.out.println("✅ Cargando video: " + archivoVideo.getName());

            // Crear Media Player
            Media media = new Media(archivoVideo.toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(false); // Esperar al botón Play
            
            MediaView mediaView = new MediaView(mediaPlayer);

            // Contenedor (StackPane)
            StackPane root = new StackPane();
            root.setStyle("-fx-background-color: black;"); // Fondo negro
            root.getChildren().add(mediaView);

            // Ajustar video al tamaño de la ventana
            mediaView.fitWidthProperty().bind(root.widthProperty());
            mediaView.fitHeightProperty().bind(root.heightProperty());
            mediaView.setPreserveRatio(true);

            Scene scene = new Scene(root);
            jfxPanel.setScene(scene);

            // --- LISTENERS (Diagnóstico y Tiempo) ---
            
            // 1. Cuando el video está listo
            mediaPlayer.setOnReady(() -> {
                System.out.println("Estado: LISTO. Duración: " + mediaPlayer.getTotalDuration());
                Duration total = mediaPlayer.getTotalDuration();
                SwingUtilities.invokeLater(() -> lblContadorTiempo.setText("00:00 / " + formatearTiempo(total)));
            });

            // 2. Si ocurre un error
            mediaPlayer.setOnError(() -> {
                System.err.println("❌ ERROR EN PLAYER: " + mediaPlayer.getError().getMessage());
            });

            // 3. Actualización continua del tiempo
            mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
                Duration total = mediaPlayer.getTotalDuration();
                
                // Actualizar etiqueta siempre
                String actualStr = formatearTiempo(newValue);
                String totalStr = formatearTiempo(total);
                
                // Actualizar slider SOLO si el usuario no lo está moviendo
                if (!moviendoSlider && total.toMillis() > 0) {
                    double porcentaje = (newValue.toMillis() / total.toMillis()) * 100.0;
                    
                    SwingUtilities.invokeLater(() -> {
                        sliderTiempo.setValue((int) porcentaje);
                        lblContadorTiempo.setText(actualStr + " / " + totalStr);
                    });
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // --- MÉTODOS AUXILIARES ---

    private static void actualizarVideoDesdeSlider() {
        Platform.runLater(() -> {
            if (mediaPlayer != null) {
                Duration total = mediaPlayer.getTotalDuration();
                if (total.toMillis() > 0) {
                    // Calcular nuevo tiempo basado en el porcentaje del slider (0-100)
                    double nuevoTiempoMs = (sliderTiempo.getValue() / 100.0) * total.toMillis();
                    mediaPlayer.seek(Duration.millis(nuevoTiempoMs));
                }
            }
        });
    }

    private static String formatearTiempo(Duration duration) {
        if (duration == null || duration.isUnknown() || duration.isIndefinite()) return "00:00";
        int segundosTotal = (int) Math.floor(duration.toSeconds());
        int minutos = segundosTotal / 60;
        int segundos = segundosTotal % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }

    private static JButton crearBoton(String texto, Color color) {
        JButton btn = new JButton(texto);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        return btn;
    }
}