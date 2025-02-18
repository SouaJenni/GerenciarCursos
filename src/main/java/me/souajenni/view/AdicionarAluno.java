package me.souajenni.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarAluno extends JFrame{
    private JPanel painelAdcAluno;
    private JTextField txtNomeAluno;
    private JTextField txtEmail;
    private JTextField txtTelefone;
    private JTextField txtFaltas;
    private JTextField txtCurso;
    private JButton btSalvar;
    private JButton btVoltar;
    private Menu parent;

    public AdicionarAluno(Menu parent) {
        setContentPane(painelAdcAluno);
        setTitle("Adicionar Aluno ao Curso");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.parent = parent;

        btVoltar.addActionListener(this::voltar);
    }
    public void voltar(ActionEvent e){
        parent.setVisible(true);
        dispose();
    }

}
