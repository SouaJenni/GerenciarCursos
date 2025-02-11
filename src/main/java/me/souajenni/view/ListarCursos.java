package me.souajenni.view;

import javax.swing.*;
import java.awt.*;

public class ListarCursos extends JFrame{
    private JTable tabelaCursos;
    private JPanel painelListarCursos;

    public ListarCursos() {
        setContentPane(painelListarCursos);
        setTitle("Lista de Cursos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
