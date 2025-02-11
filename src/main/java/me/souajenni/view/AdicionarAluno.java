package me.souajenni.view;

import javax.swing.*;
import java.awt.*;

public class AdicionarAluno extends JFrame{
    private JPanel painelAdcAluno;
    private JTextField txtNomeAluno;
    private JTextField txtEmail;
    private JTextField txtTelefone;
    private JTextField txtFaltas;
    private JTextField txtCurso;
    private JButton btSalvar;

    public AdicionarAluno() {
        setContentPane(painelAdcAluno);
        setTitle("Adicionar Aluno ao Curso");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
