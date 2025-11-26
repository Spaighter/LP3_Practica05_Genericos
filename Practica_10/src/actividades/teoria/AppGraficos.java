package actividades.teoria;

import javax.swing.*;
import java.awt.*;

public class AppGraficos extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // --- Fondo con Degradado ---
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(0, 0, new Color(240, 240, 255), 
                                                   0, getHeight(), new Color(200, 220, 255));
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // --- Dibujos Básicos ---
        g.setColor(new Color(50, 50, 50)); 
        g.setFont(new Font("SansSerif", Font.BOLD, 14));
        g.drawString("Ejemplo de Formas Básicas", 20, 30);
        
        // Línea
        g.setColor(Color.BLUE);
        g.drawLine(20, 50, 250, 50); 

        // Rectángulo
        g.setColor(new Color(220, 53, 69)); 
        g.drawRect(20, 70, 100, 60); 
        
        // Rectángulo Relleno
        g.setColor(new Color(220, 53, 69, 100)); 
        g.fillRect(140, 70, 100, 60);

        // Óvalo
        g.setColor(new Color(40, 167, 69));
        g.drawOval(20, 150, 100, 60);

        // Círculo Relleno
        g.setColor(new Color(40, 167, 69, 100)); 
        g.fillOval(140, 150, 60, 60);

        // Polígono (Triángulo)
        g.setColor(new Color(255, 193, 7));
        int[] xPoints = {300, 350, 400};
        int[] yPoints = {130, 70, 130};
        g.fillPolygon(xPoints, yPoints, 3);
        
        g.setColor(Color.BLACK);
        g.drawString("Línea", 260, 55);
        g.drawString("Rectángulos", 260, 105);
        g.drawString("Óvalos", 260, 185);
        g.drawString("Polígono", 320, 150);
        
    } // <--- ¡AQUÍ! Esta llave cierra el método paintComponent. Probablemente te faltaba.

    // Método Main para ejecutar independientemente
    public static void main(String[] args) {
        JFrame frame = new JFrame("Guía 10: Gráficos Básicos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        frame.add(new AppGraficos()); 
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    } // <--- Esta llave cierra el main

} // <--- Esta llave cierra la CLASE entera.