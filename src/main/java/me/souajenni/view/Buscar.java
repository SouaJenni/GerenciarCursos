package me.souajenni.view;

import javax.swing.*;
import java.awt.*;

public class Buscar extends JFrame {
    private JLabel labelBuscar;
    private JTextField textField1;
    private JButton btBuscar;
    private JPanel painelBuscar;

    public Buscar() {
        setContentPane(painelBuscar);
        setTitle("Buscar");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
