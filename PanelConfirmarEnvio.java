package giorgio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelConfirmarEnvio extends JPanel {

    public PanelConfirmarEnvio() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel labelOrden = new JLabel("ID de Orden:");
        JTextField campoOrden = new JTextField(20);
        JButton botonConfirmar = new JButton("Confirmar Envío");

        botonConfirmar.addActionListener(e -> {
            try {
                int ordenId = Integer.parseInt(campoOrden.getText());
                confirmarEnvio(ordenId);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese un ID válido");
            }
        });

        add(labelOrden);
        add(campoOrden);
        add(botonConfirmar);
    }

    private void confirmarEnvio(int ordenId) {
        try {
            // Aquí iría el código para marcar la orden como enviada en la base de datos
            JOptionPane.showMessageDialog(this, "Envío confirmado para la orden " + ordenId);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al confirmar el envío");
        }
    }
}
