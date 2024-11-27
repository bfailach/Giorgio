package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipal extends JFrame {
    private JPanel panelLateral;
    private JPanel panelDerecho;

    public PantallaPrincipal() {
        setTitle("Gestión Logística de Tienda de Ropa");
        setSize(1300, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelLateral = new JPanel();
        panelLateral.setLayout(new GridLayout(6, 1, 10, 10));
        panelLateral.setPreferredSize(new Dimension(250, 0));

        JButton btnRecibirOrden = new JButton("Recibir Orden");
        JButton btnGestionInventario = new JButton("Gestión de Inventario");
        JButton btnConfirmarEnvio = new JButton("Confirmar Envío");
        JButton btnGestionDevoluciones = new JButton("Gestionar Devoluciones");
        JButton btnReportes = new JButton("Reportes");

        panelLateral.add(btnRecibirOrden);
        panelLateral.add(btnGestionInventario);
        panelLateral.add(btnConfirmarEnvio);
        panelLateral.add(btnGestionDevoluciones);
        panelLateral.add(btnReportes);

        add(panelLateral, BorderLayout.WEST);

        panelDerecho = new JPanel();
        panelDerecho.setLayout(new CardLayout());
        add(panelDerecho, BorderLayout.CENTER);

        btnRecibirOrden.addActionListener(e -> mostrarPanel(new PanelOrdenes()));
        btnGestionInventario.addActionListener(e -> mostrarPanel(new PanelInventario()));
        btnConfirmarEnvio.addActionListener(e -> mostrarPanel(new PanelEnvio()));
    }

    private void mostrarPanel(JPanel panel) {
        panelDerecho.removeAll();
        panelDerecho.add(panel);
        panelDerecho.revalidate();
        panelDerecho.repaint();
    }

    public static void main(String[] args) {
        new PantallaPrincipal().setVisible(true);
    }
}
