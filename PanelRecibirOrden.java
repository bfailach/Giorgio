package giorgio;

import javax.swing.*;

public class PanelRecibirOrden extends JPanel {

    public PanelRecibirOrden() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Formulario para recibir orden");
        JButton boton = new JButton("Confirmar");
        boton.addActionListener(e -> {

            System.out.println("Orden recibida");
        });

        add(label);
        add(boton);
    }
}
