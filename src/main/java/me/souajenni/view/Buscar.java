package me.souajenni.view;

import me.souajenni.DAO.CursoDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class Buscar extends JFrame {
    private JLabel labelBuscar;
    private JTextField txtBuscar;
    private JButton btBuscar;
    private JPanel painelBuscar;
    private JButton btVoltar;
    private Menu parent;
    private String opcao;
    private Utils utils;

    public Buscar(Menu parent, String opcao) {
        setContentPane(painelBuscar);
        setTitle("Buscar");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.parent = parent;
        this.opcao = opcao;
        this.utils = new Utils();

        switch (opcao){
            case "listarAluno":
                labelBuscar.setText("Digite o nome do curso:");
                break;
        }
        btVoltar.addActionListener(this::voltar);
        btBuscar.addActionListener(this::buscar);
    }

    public void voltar(ActionEvent e){
        parent.setVisible(true);
        dispose();
    }

    public void buscar(ActionEvent e){
        switch (opcao){
            case "listarAluno":
                CursoDAO cursoDAO = new CursoDAO(parent.getConexao());
                try {
                    int idCurso = cursoDAO.buscarCursoPorNome(txtBuscar.getText());
                    if(idCurso == -1){
                        utils.mostrarAlerta("Curso não encontrado.");
                        return;
                    }
                    new ListarAluno(parent, idCurso);
                } catch (SQLException ex) {
                    utils.mostrarErro(ex.getMessage());
                    return;
                }
                break;
        }
    }

}
