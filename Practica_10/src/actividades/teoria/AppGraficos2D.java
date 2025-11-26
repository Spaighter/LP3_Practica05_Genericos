package actividades.teoria;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Demostración de Transformaciones 2D (Graphics2D).
 * Incluye: Traslación, Rotación, Escalado, Sesgado y Antialiasing.
 */
public class AppGraficos2D extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // 1. Convertir a Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        // 2. Activar Antialiasing (Suavizado de bordes)
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fondo limpio
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Variables base para nuestras formas
        int rectW = 100;
        int rectH = 50;
        int startX = 50;
        int startY = 50;

        // --- ESTADO ORIGINAL ---
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(startX, startY, rectW, rectH);
        g2d.setColor(Color.BLACK);
        g2d.drawString("Original", startX, startY - 5);

        // Guardamos la transformación original para restaurarla después de cada cambio
        AffineTransform oldTransform = g2d.getTransform();

        // --- A. TRASLACIÓN (Translate) ---
        // Movemos el origen de coordenadas 200px a la derecha
        g2d.translate(200, 0); 
        
        g2d.setColor(new Color(0, 123, 255)); // Azul
        g2d.fillRect(startX, startY, rectW, rectH);
        g2d.drawString("Traslación", startX, startY - 5);
        
        // Restaurar
        g2d.setTransform(oldTransform);

        // --- B. ROTACIÓN (Rotate) ---
        // Movemos coordenadas abajo para no superponer
        g2d.translate(0, 150); 
        
        // Rotamos 45 grados sobre el centro del rectángulo
        // Math.toRadians(45) convierte grados a radianes necesarios
        g2d.rotate(Math.toRadians(45), startX + rectW/2, startY + rectH/2);
        
        g2d.setColor(new Color(40, 167, 69)); // Verde
        g2d.fillRect(startX, startY, rectW, rectH);
        g2d.setColor(Color.BLACK);
        g2d.drawString("Rotación 45°", startX, startY - 20);
        
        // Restaurar
        g2d.setTransform(oldTransform);

        // --- C. ESCALADO (Scale) ---
        g2d.translate(200, 150);
        
        // Escalamos: 1.5x en ancho, 0.8x en alto
        g2d.scale(1.5, 0.8);
        
        g2d.setColor(new Color(255, 193, 7)); // Amarillo
        g2d.fillRect(startX, startY, rectW, rectH);
        g2d.setColor(Color.BLACK);
        g2d.drawString("Escalado", startX, startY - 5);
        
        // Restaurar
        g2d.setTransform(oldTransform);

        // --- D. SESGADO (Shear) ---
        g2d.translate(0, 300);
        
        // Sesgar eje X
        g2d.shear(0.5, 0.0);
        
        g2d.setColor(new Color(111, 66, 193)); // Morado
        g2d.fillRect(startX, startY, rectW, rectH);
        g2d.setColor(Color.WHITE); // Texto blanco para contraste
        g2d.drawString("Sesgado", startX + 20, startY + 30);
        
        // Restaurar final
        g2d.setTransform(oldTransform);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Guía 10: Transformaciones 2D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500); // Ventana más grande para que quepan las transformaciones
        frame.add(new AppGraficos2D());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}