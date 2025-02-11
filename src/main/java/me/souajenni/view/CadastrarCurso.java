package me.souajenni.view;

import javax.swing.*;

public class CadastrarCurso extends JFrame{
    private JTextField txtNomeCurso;
    private JTextField txtPreco;
    private JTextField txtCarga;
    private JPanel painelCadCurso;
    private JButton btSalvar;

    public CadastrarCurso() {
        setContentPane(painelCadCurso);
        setTitle("Cadastrar Curso");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
