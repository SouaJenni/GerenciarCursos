package me.souajenni.view;

import javax.swing.*;
import java.awt.*;

public class ListarAluno extends JFrame {
    private JTable tabelaAluno;
    private JPanel painelListarAluno;

    public ListarAluno() {
        setContentPane(painelListarAluno);
        setTitle("Lista de Alunos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
