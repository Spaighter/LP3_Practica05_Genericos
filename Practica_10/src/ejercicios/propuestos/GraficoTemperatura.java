package ejercicios.propuestos;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class GraficoTemperatura extends JFrame {
    private JTextField[] inputs = new JTextField[7];
    private String[] dias = {"Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"};
    private PanelDibujo panelDibujo = new PanelDibujo();

    public GraficoTemperatura() {
        super("Ejercicio 2: Gráfico Semanal");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel Izquierdo (Inputs)
        JPanel panelDatos = new JPanel(new GridLayout(8, 2, 5, 5));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        for (int i = 0; i < 7; i++) {
            panelDatos.add(new JLabel(dias[i] + ":"));
            inputs[i] = new JTextField("0");
            panelDatos.add(inputs[i]);
        }
        
        JButton btnGraficar = new JButton("Mostrar Gráfico");
        btnGraficar.addActionListener(e -> panelDibujo.repaint());
        add(panelDatos, BorderLayout.WEST);
        add(btnGraficar, BorderLayout.SOUTH);
        add(panelDibujo, BorderLayout.CENTER);
    }

    // Panel interno para dibujar
    class PanelDibujo extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            int w = getWidth();
            int h = getHeight();
            int padding = 40;

            // Ejes
            g2d.drawLine(padding, h - padding, w - padding, h - padding); // X
            g2d.drawLine(padding, padding, padding, h - padding); // Y

            double[] temps = new double[7];
            double max = 0;
            
            // Leer datos
            try {
                for (int i = 0; i < 7; i++) temps[i] = Double.parseDouble(inputs[i].getText());
            } catch (Exception e) { return; } // Si hay error al leer, no dibuja

            for (double t : temps) if (t > max) max = t;
            if (max == 0) max = 10; // Evitar división por cero

            // Dibujar Línea
            g2d.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(2));
            Path2D path = new Path2D.Double();
            int stepX = (w - 2 * padding) / 6;

            for (int i = 0; i < 7; i++) {
                int x = padding + i * stepX;
                int y = (h - padding) - (int) ((temps[i] / (max + 5)) * (h - 2 * padding));
                
                if (i == 0) path.moveTo(x, y);
                else path.lineTo(x, y);
                
                // Puntos
                g2d.fillOval(x - 4, y - 4, 8, 8);
                g2d.drawString(dias[i], x - 10, h - padding + 20);
            }
            g2d.draw(path);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GraficoTemperatura().setVisible(true));
    }
}