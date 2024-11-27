package giorgio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PanelGestionInventario extends JPanel {

    public PanelGestionInventario() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel labelProducto = new JLabel("Producto ID:");
        JTextField campoProducto = new JTextField(20);
        JLabel labelCantidad = new JLabel("Nueva Cantidad:");
        JTextField campoCantidad = new JTextField(20);
        JButton botonActualizar = new JButton("Actualizar Inventario");

        botonActualizar.addActionListener(e -> {
            try {
                int productoId = Integer.parseInt(campoProducto.getText());
                int cantidad = Integer.parseInt(campoCantidad.getText());
                actualizarInventario(productoId, cantidad);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese valores válidos");
            }
        });

        add(labelProducto);
        add(campoProducto);
        add(labelCantidad);
        add(campoCantidad);
        add(botonActualizar);
    }

    private void actualizarInventario(int productoId, int cantidad) {
        try (Connection conn = ConexionBD.getConexion()) {
            String query = "UPDATE productos SET cantidad = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, cantidad);
            stmt.setInt(2, productoId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Inventario actualizado");
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al actualizar el inventario");
        }
    }
}
