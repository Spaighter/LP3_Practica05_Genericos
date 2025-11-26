package ejercicios.propuestos;

import javax.swing.*;
import java.awt.*;

public class GestorProducto extends JFrame {
    private Producto modelo = new Producto();
    private JTextField txtNombre, txtPrecio, txtStock, txtCategoria;
    private JLabel lblResultado;

    public GestorProducto() {
        super("Ejercicio 1: Gestión de Producto");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Campos
        txtNombre = new JTextField();
        txtPrecio = new JTextField();
        txtStock = new JTextField();
        txtCategoria = new JTextField();

        panel.add(new JLabel("Nombre:")); panel.add(txtNombre);
        panel.add(new JLabel("Precio:")); panel.add(txtPrecio);
        panel.add(new JLabel("Stock:")); panel.add(txtStock);
        panel.add(new JLabel("Categoría:")); panel.add(txtCategoria);

        // Botón
        JButton btnActualizar = new JButton("Actualizar Producto");
        btnActualizar.setBackground(new Color(46, 204, 113));
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.addActionListener(e -> actualizar());
        
        panel.add(new JLabel("")); // Espacio vacío
        panel.add(btnActualizar);

        // Resultado
        lblResultado = new JLabel("Esperando datos...", SwingConstants.CENTER);
        lblResultado.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        add(panel, BorderLayout.CENTER);
        add(lblResultado, BorderLayout.SOUTH);
    }

    private void actualizar() {
        try {
            modelo.setNombre(txtNombre.getText());
            modelo.setPrecio(Double.parseDouble(txtPrecio.getText()));
            modelo.setCantidadStock(Integer.parseInt(txtStock.getText()));
            modelo.setCategoria(txtCategoria.getText());
            lblResultado.setText(modelo.toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Precio y Stock deben ser números.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GestorProducto().setVisible(true));
    }
}