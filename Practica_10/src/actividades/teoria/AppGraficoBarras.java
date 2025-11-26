package actividades.teoria;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Visualización de Datos: Gráfico de Barras.
 * Calcula dinámicamente la altura de las barras basándose en el valor máximo.
 */
public class AppGraficoBarras extends JPanel {

    // Datos de ejemplo (Modelo)
    private String[] productos = {"Teclado", "Mouse", "Monitor", "Laptop", "Headset"};
    private int[] ventas = {50, 120, 80, 150, 95}; // Unidades vendidas
    
    // Colores para las barras (para que no sean todas iguales)
    private Color[] colores = {
        new Color(52, 152, 219),   // Azul
        new Color(231, 76, 60),    // Rojo
        new Color(46, 204, 113),   // Verde
        new Color(155, 89, 182),   // Morado
        new Color(241, 196, 15)    // Amarillo
    };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // 1. Configuración de Graphics2D y Antialiasing
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fondo blanco
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // 2. Configuración de dimensiones
        int anchoBarra = 60;
        int espacioBarra = 30;
        int margenIzquierdo = 50;
        int margenInferior = 50;
        int margenSuperior = 50;
        
        // Área disponible para dibujar las barras (altura)
        int alturaDisponible = getHeight() - margenInferior - margenSuperior;

        // 3. Encontrar el valor máximo de ventas para escalar (Regla de 3)
        int maxVenta = 0;
        for (int venta : ventas) {
            if (venta > maxVenta) {
                maxVenta = venta;
            }
        }

        // 4. Dibujar Ejes
        g2d.setColor(Color.GRAY);
        // Eje Y
        g2d.drawLine(margenIzquierdo, margenSuperior, margenIzquierdo, getHeight() - margenInferior);
        // Eje X
        g2d.drawLine(margenIzquierdo, getHeight() - margenInferior, getWidth() - 20, getHeight() - margenInferior);

        // 5. Dibujar las barras
        Font fuenteEtiquetas = new Font("SansSerif", Font.PLAIN, 12);
        g2d.setFont(fuenteEtiquetas);

        for (int i = 0; i < productos.length; i++) {
            // Cálculo de la altura proporcional: (Valor / Max) * AlturaDisponible
            double porcentaje = (double) ventas[i] / maxVenta;
            int alturaBarra = (int) (porcentaje * alturaDisponible);
            
            // Coordenadas
            int x = margenIzquierdo + espacioBarra + (i * (anchoBarra + espacioBarra));
            int y = (getHeight() - margenInferior) - alturaBarra;

            // Dibujar Barra con color específico
            g2d.setColor(colores[i % colores.length]);
            g2d.fill(new Rectangle2D.Double(x, y, anchoBarra, alturaBarra));
            
            // Borde de la barra
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawRect(x, y, anchoBarra, alturaBarra);

            // Etiquetas (Valor encima de la barra)
            String valorTexto = String.valueOf(ventas[i]);
            int anchoTextoValor = g2d.getFontMetrics().stringWidth(valorTexto);
            g2d.drawString(valorTexto, x + (anchoBarra - anchoTextoValor) / 2, y - 5);

            // Etiquetas (Nombre del producto debajo del eje X)
            String prodTexto = productos[i];
            int anchoTextoProd = g2d.getFontMetrics().stringWidth(prodTexto);
            g2d.drawString(prodTexto, x + (anchoBarra - anchoTextoProd) / 2, getHeight() - margenInferior + 20);
        }
        
        // Título del Gráfico
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("SansSerif", Font.BOLD, 16));
        g2d.drawString("Reporte de Ventas por Producto", margenIzquierdo, 30);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Guía 10: Gráfico de Barras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(new AppGraficoBarras());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}