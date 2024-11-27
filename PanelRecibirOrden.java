package giorgio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PanelRecibirOrden extends JPanel {

    public PanelRecibirOrden() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JLabel labelProducto = new JLabel("Producto ID:");
        JTextField campoProducto = new JTextField(20);
        JLabel labelCantidad = new JLabel("Cantidad:");
        JTextField campoCantidad = new JTextField(20);
        JButton botonRecibir = new JButton("Recibir Orden");

        botonRecibir.addActionListener(e -> {
            try {
                int productoId = Integer.parseInt(campoProducto.getText());
                int cantidad = Integer.parseInt(campoCantidad.getText());
                recibirOrden(productoId, cantidad);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese valores válidos");
            }
        });

        add(labelProducto);
        add(campoProducto);
        add(labelCantidad);
        add(campoCantidad);
        add(botonRecibir);
    }

    private void recibirOrden(int productoId, int cantidad) {
        try (Connection conn = ConexionBD.getConexion()) {
            String query = "INSERT INTO ordenes (id_producto, cantidad) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, productoId);
            stmt.setInt(2, cantidad);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Orden recibida correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al recibir la orden");
        }
    }
}
