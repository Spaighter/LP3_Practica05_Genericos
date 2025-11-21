package Practica09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActividadEsquemas {

    public static void main(String[] args) {
        mostrarFlowLayout();
        mostrarBorderLayout();
        mostrarGridLayout();
    }

    private static JButton crearBotonInteractivo(String texto, String nombreEsquema, Component parent) {
        JButton btn = new JButton(texto);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(parent, 
                    "Has presionado: " + texto + "\nEsquema actual: " + nombreEsquema,
                    "Interacción Detectada", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });
        return btn;
    }

    private static void mostrarFlowLayout() {
        JFrame frame = new JFrame("FlowLayout - Interactivo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(450, 150);
        frame.setLayout(new FlowLayout()); 

        frame.add(crearBotonInteractivo("Botón 1", "FlowLayout", frame));
        frame.add(crearBotonInteractivo("Botón 2", "FlowLayout", frame));
        frame.add(crearBotonInteractivo("Botón 3", "FlowLayout", frame));
        frame.add(crearBotonInteractivo("Botón Largo 4", "FlowLayout", frame));
        frame.add(crearBotonInteractivo("Btn 5", "FlowLayout", frame));

        frame.setVisible(true);
    }

    private static void mostrarBorderLayout() {
        JFrame frame = new JFrame("BorderLayout - Interactivo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        frame.add(crearBotonInteractivo("NORTE", "BorderLayout", frame), BorderLayout.NORTH);
        frame.add(crearBotonInteractivo("SUR", "BorderLayout", frame), BorderLayout.SOUTH);
        frame.add(crearBotonInteractivo("ESTE", "BorderLayout", frame), BorderLayout.EAST);
        frame.add(crearBotonInteractivo("OESTE", "BorderLayout", frame), BorderLayout.WEST);
        frame.add(crearBotonInteractivo("CENTRO", "BorderLayout", frame), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static void mostrarGridLayout() {
        JFrame frame = new JFrame("GridLayout - Interactivo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(2, 3));

        for (int i = 1; i <= 6; i++) {
            frame.add(crearBotonInteractivo("Celda " + i, "GridLayout", frame));
        }

        frame.setVisible(true);
    }
}