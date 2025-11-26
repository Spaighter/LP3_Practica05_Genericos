package actividades.teoria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Demostración de Binding de Datos manual (View <-> Model) con Swing.
 */
public class AppBinding extends JFrame {

    // 1. Componentes de la Vista (Interfaz de Usuario)
    private JTextField txtNombre, txtEdad, txtCiudad;
    private JButton btnActualizarModelo, btnActualizarVista;
    
    // 2. Instancia del Modelo (Objeto de Datos)
    private Persona modeloPersona; 

    public AppBinding() {
        super("Sincronización de Datos (Binding Manual)");
        
        // --- A. Configuración Estética (Nimbus L&F) ---
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Si Nimbus no está disponible, se usa el L&F por defecto.
            System.out.println("No se pudo cargar Nimbus. Usando LookAndFeel por defecto.");
        }
        
        // 3. Inicializar el Modelo con datos iniciales
        modeloPersona = new Persona("Ana Pérez", 30, "Arequipa");

        // 4. Inicializar Componentes de la Vista
        txtNombre = new JTextField(15);
        txtEdad = new JTextField(15);
        txtCiudad = new JTextField(15);
        
        // Sincronizar la vista con el modelo al inicio
        sincronizarModeloAVista(); 
        
        btnActualizarModelo = new JButton("Actualizar Modelo (Vista -> Modelo)");
        btnActualizarModelo.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnActualizarModelo.setBackground(new Color(0, 123, 255)); // Azul
        btnActualizarModelo.setForeground(Color.WHITE);

        btnActualizarVista = new JButton("Mostrar Datos (Modelo -> Vista)");
        btnActualizarVista.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnActualizarVista.setBackground(new Color(40, 167, 69)); // Verde
        btnActualizarVista.setForeground(Color.WHITE);


        // 5. Configurar el Layout y la Interfaz
        setLayout(new BorderLayout(10, 10)); // Marco principal con espacio
        
        JPanel panelFormulario = crearPanelFormulario();
        JPanel panelBotones = crearPanelBotones();
        
        // Agregar un título al norte
        JLabel titulo = new JLabel("Formulario de Edición de Persona", JLabel.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        add(titulo, BorderLayout.NORTH);
        add(panelFormulario, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // 6. Configuración final de la Ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // Ajusta el tamaño de la ventana a sus componentes
        setLocationRelativeTo(null); // Centra la ventana
        setVisible(true);

        // 7. Configurar Listeners (Controladores)
        btnActualizarModelo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sincronizarVistaAModelo();
            }
        });
        
        btnActualizarVista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sincronizarModeloAVista();
            }
        });
    }
    
    /**
     * Crea y configura el panel principal del formulario usando GridBagLayout.
     */
    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Estilo de la etiqueta
        Font labelFont = new Font("SansSerif", Font.PLAIN, 14);

        // Fila 1: Nombre
        gbc.gridx = 0; // Columna 0
        gbc.gridy = 0; // Fila 0
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(labelFont);
        panel.add(lblNombre, gbc);

        gbc.gridx = 1; // Columna 1
        panel.add(txtNombre, gbc);

        // Fila 2: Edad
        gbc.gridx = 0; // Columna 0
        gbc.gridy = 1; // Fila 1
        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setFont(labelFont);
        panel.add(lblEdad, gbc);

        gbc.gridx = 1; // Columna 1
        panel.add(txtEdad, gbc);

        // Fila 3: Ciudad
        gbc.gridx = 0; // Columna 0
        gbc.gridy = 2; // Fila 2
        JLabel lblCiudad = new JLabel("Ciudad:");
        lblCiudad.setFont(labelFont);
        panel.add(lblCiudad, gbc);

        gbc.gridx = 1; // Columna 1
        panel.add(txtCiudad, gbc);
        
        return panel;
    }
    
    /**
     * Crea y configura el panel de botones.
     */
    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panel.add(btnActualizarModelo);
        panel.add(btnActualizarVista);
        return panel;
    }

    // --- LÓGICA DE BINDING ---
    
    /**
     * Función que transfiere datos desde la VISTA (JTextField) al MODELO (Objeto Persona).
     */
    private void sincronizarVistaAModelo() {
        // Validación básica
        try {
            String nombre = txtNombre.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String ciudad = txtCiudad.getText();
            
            // 1. Actualiza el Modelo
            modeloPersona.setNombre(nombre);
            modeloPersona.setEdad(edad);
            modeloPersona.setCiudad(ciudad);
            
            // 2. Muestra confirmación
            JOptionPane.showMessageDialog(this, 
                "¡Modelo de Datos Actualizado!\n" + modeloPersona.toString(), 
                "Éxito en el Binding", 
                JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error: La Edad debe ser un número entero válido.", 
                "Error de Formato", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Función que transfiere datos desde el MODELO (Objeto Persona) a la VISTA (JTextField).
     */
    private void sincronizarModeloAVista() {
        // 1. Obtiene datos del Modelo
        txtNombre.setText(modeloPersona.getNombre());
        txtEdad.setText(String.valueOf(modeloPersona.getEdad()));
        txtCiudad.setText(modeloPersona.getCiudad());
        
        // 2. Muestra confirmación (Opcional, pero útil para demostrar)
        JOptionPane.showMessageDialog(this, 
                "Vista Sincronizada con el Modelo Actual:\n" + modeloPersona.toString(), 
                "Éxito en el Binding", 
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        // Ejecuta la interfaz en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(() -> new AppBinding());
    }
}