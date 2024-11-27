package giorgio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pantalla_principal extends javax.swing.JFrame {
    private JPanel panelContenido;

    public pantalla_principal() {
        initComponents();
    }

    private void initComponents() {
        panelContenido = new JPanel();
        panelContenido.setLayout(new CardLayout());
        
        // Crear paneles para cada sección
        PanelRecibirOrden panelRecibirOrden = new PanelRecibirOrden();
        PanelGestionInventario panelGestionInventario = new PanelGestionInventario();
        PanelConfirmarEnvio panelConfirmarEnvio = new PanelConfirmarEnvio();
        
        // Añadir los paneles al panel principal
        panelContenido.add(panelRecibirOrden, "Recibir Orden");
        panelContenido.add(panelGestionInventario, "Gestión Inventario");
        panelContenido.add(panelConfirmarEnvio, "Confirmar Envío");

        // Configurar los botones y panel principal
        jPanel1 = new javax.swing.JPanel();
        recibir_orden = new javax.swing.JButton();
        gestion_inventario = new javax.swing.JButton();
        confirmar_envio = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        recibir_orden.setText("Recibir orden");
        recibir_orden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mostrarPanel("Recibir Orden");
            }
        });

        gestion_inventario.setText("Gestión de inventario");
        gestion_inventario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mostrarPanel("Gestión Inventario");
            }
        });

        confirmar_envio.setText("Confirmar envío");
        confirmar_envio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mostrarPanel("Confirmar Envío");
            }
        });

        titulo.setText("GIORGIO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recibir_orden)
                            .addComponent(gestion_inventario)
                            .addComponent(confirmar_envio)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(titulo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(panelContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, 731, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(titulo)
                .addGap(62, 62, 62)
                .addComponent(recibir_orden)
                .addGap(18, 18, 18)
                .addComponent(gestion_inventario)
                .addGap(18, 18, 18)
                .addComponent(confirmar_envio)
                .addContainerGap(378, Short.MAX_VALUE))
            .addComponent(panelContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    // Mostrar el panel correspondiente según el botón presionado
    private void mostrarPanel(String panelName) {
        CardLayout cl = (CardLayout) (panelContenido.getLayout());
        cl.show(panelContenido, panelName);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantalla_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton confirmar_envio;
    private javax.swing.JButton gestion_inventario;
    private javax.swing.JButton recibir_orden;
    private javax.swing.JLabel titulo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration
}
