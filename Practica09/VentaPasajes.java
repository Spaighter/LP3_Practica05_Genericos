package Practica09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentaPasajes extends JFrame {

    // Lista virtual para guardar los datos sin base de datos
    private ArrayList<Boleto> listaVentas;

    private JTextField txtNombre, txtDocumento, txtFecha;
    private JCheckBox chkAudifonos, chkManta, chkRevistas;
    private JRadioButton rbPiso1, rbPiso2;
    private JComboBox<String> cboOrigen, cboDestino;
    private JList<String> lstCalidad;
    private ButtonGroup grupoPiso;

    public VentaPasajes() {
        super("Venta de Pasajes - Lista Virtual");
        setSize(520, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        listaVentas = new ArrayList<>(); // Inicializamos la lista

        JLabel lblNombre = new JLabel("Nombres Completos:");
        lblNombre.setBounds(20, 20, 150, 20);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(180, 20, 250, 20);
        add(txtNombre);

        JLabel lblDoc = new JLabel("Documento Identidad:");
        lblDoc.setBounds(20, 50, 150, 20);
        add(lblDoc);

        txtDocumento = new JTextField();
        txtDocumento.setBounds(180, 50, 150, 20);
        add(txtDocumento);

        JLabel lblFecha = new JLabel("Fecha Viaje (dd/mm/aaaa):");
        lblFecha.setBounds(20, 80, 180, 20);
        add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setBounds(180, 80, 100, 20);
        add(txtFecha);

        JLabel lblOrigen = new JLabel("Origen:");
        lblOrigen.setBounds(20, 120, 100, 20);
        add(lblOrigen);

        String[] lugares = {"Arequipa", "Lima", "Cusco", "Tacna", "Puno"};
        cboOrigen = new JComboBox<>(lugares);
        cboOrigen.setBounds(80, 120, 120, 20);
        add(cboOrigen);

        JLabel lblDestino = new JLabel("Destino:");
        lblDestino.setBounds(240, 120, 100, 20);
        add(lblDestino);

        cboDestino = new JComboBox<>(lugares);
        cboDestino.setBounds(300, 120, 120, 20);
        add(cboDestino);

        JLabel lblPiso = new JLabel("Seleccione Piso:");
        lblPiso.setBounds(20, 160, 150, 20);
        add(lblPiso);

        rbPiso1 = new JRadioButton("1er Piso");
        rbPiso2 = new JRadioButton("2do Piso");
        rbPiso1.setBounds(20, 180, 100, 20);
        rbPiso2.setBounds(130, 180, 100, 20);
        
        grupoPiso = new ButtonGroup();
        grupoPiso.add(rbPiso1);
        grupoPiso.add(rbPiso2);
        rbPiso2.setSelected(true); 
        
        add(rbPiso1);
        add(rbPiso2);

        JLabel lblServicios = new JLabel("Servicios Opcionales:");
        lblServicios.setBounds(20, 220, 150, 20);
        add(lblServicios);

        chkAudifonos = new JCheckBox("Audífonos");
        chkAudifonos.setBounds(20, 240, 100, 20);
        add(chkAudifonos);

        chkManta = new JCheckBox("Manta");
        chkManta.setBounds(130, 240, 100, 20);
        add(chkManta);

        chkRevistas = new JCheckBox("Revistas");
        chkRevistas.setBounds(240, 240, 100, 20);
        add(chkRevistas);

        JLabel lblCalidad = new JLabel("Calidad de Servicio:");
        lblCalidad.setBounds(20, 280, 150, 20);
        add(lblCalidad);

        String[] calidades = {"Económico", "Standard", "VIP"};
        lstCalidad = new JList<>(calidades);
        lstCalidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstCalidad.setSelectedIndex(1); 
        
        JPanel panelLista = new JPanel();
        panelLista.setBounds(20, 300, 150, 60);
        panelLista.setLayout(new BorderLayout());
        panelLista.add(new JScrollPane(lstCalidad));
        add(panelLista);

        // --- Botones ---
        JButton btnGuardar = new JButton("Guardar Venta");
        btnGuardar.setBounds(50, 400, 180, 40);
        add(btnGuardar);

        JButton btnHistorial = new JButton("Ver Historial (" + listaVentas.size() + ")");
        btnHistorial.setBounds(250, 400, 180, 40);
        add(btnHistorial);

        // Evento Guardar
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarBoleto(btnHistorial);
            }
        });

        // Evento Ver Historial
        btnHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarHistorial();
            }
        });
    }

    private void guardarBoleto(JButton btnRef) {
        String nombre = txtNombre.getText();
        String doc = txtDocumento.getText();
        String fecha = txtFecha.getText();
        String origen = (String) cboOrigen.getSelectedItem();
        String destino = (String) cboDestino.getSelectedItem();
        
        if (origen.equals(destino)) {
            JOptionPane.showMessageDialog(this, "Origen y destino no pueden ser iguales.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(nombre.isEmpty() || doc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete los datos principales.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String piso = rbPiso1.isSelected() ? "1er Piso" : "2do Piso";
        String calidad = lstCalidad.getSelectedValue();
        
        String servicios = "";
        if (chkAudifonos.isSelected()) servicios += "Audífonos ";
        if (chkManta.isSelected()) servicios += "Manta ";
        if (chkRevistas.isSelected()) servicios += "Revistas ";
        if (servicios.isEmpty()) servicios = "Sin extras";

        // Crear objeto y guardar en lista
        Boleto nuevoBoleto = new Boleto(nombre, doc, fecha, origen, destino, piso, servicios, calidad);
        listaVentas.add(nuevoBoleto);

        JOptionPane.showMessageDialog(this, "¡Venta guardada exitosamente!\nTotal ventas en sesión: " + listaVentas.size());
        
        btnRef.setText("Ver Historial (" + listaVentas.size() + ")");
        limpiarFormulario();
    }

    private void mostrarHistorial() {
        if (listaVentas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ventas registradas aún.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("HISTORIAL DE VENTAS\n\n");
        
        for (int i = 0; i < listaVentas.size(); i++) {
            sb.append("Venta #").append(i + 1).append("\n");
            sb.append(listaVentas.get(i).toString()).append("\n");
            sb.append("-----------------------------------\n");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(this, scrollPane, "Registro de Ventas", JOptionPane.PLAIN_MESSAGE);
    }

    private void limpiarFormulario() {
        txtNombre.setText("");
        txtDocumento.setText("");
        txtFecha.setText("");
        cboOrigen.setSelectedIndex(0);
        cboDestino.setSelectedIndex(0);
        rbPiso2.setSelected(true);
        chkAudifonos.setSelected(false);
        chkManta.setSelected(false);
        chkRevistas.setSelected(false);
        lstCalidad.setSelectedIndex(1);
    }

    public static void main(String[] args) {
        VentaPasajes app = new VentaPasajes();
        app.setVisible(true);
    }

    // Clase interna para representar el objeto de datos
    class Boleto {
        String nombre, dni, fecha, origen, destino, piso, servicios, calidad;

        public Boleto(String nombre, String dni, String fecha, String origen, String destino, String piso, String servicios, String calidad) {
            this.nombre = nombre;
            this.dni = dni;
            this.fecha = fecha;
            this.origen = origen;
            this.destino = destino;
            this.piso = piso;
            this.servicios = servicios;
            this.calidad = calidad;
        }

        @Override
        public String toString() {
            return "Cliente: " + nombre + " (DNI: " + dni + ")\n" +
                   "Ruta: " + origen + " -> " + destino + " [" + fecha + "]\n" +
                   "Detalle: " + piso + " | " + calidad + "\n" +
                   "Extras: " + servicios;
        }
    }
}