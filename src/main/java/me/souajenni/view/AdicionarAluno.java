package me.souajenni.view;

import me.souajenni.DAO.AlunoDAO;
import me.souajenni.DAO.CursoDAO;
import me.souajenni.model.Aluno;

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
    private Utils utils;

    public AdicionarAluno(Menu parent) {
        setContentPane(painelAdcAluno);
        setTitle("Adicionar Aluno ao Curso");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.parent = parent;
        this.utils = new Utils();

        btVoltar.addActionListener(this::voltar);
        btSalvar.addActionListener(this::salvar);
    }

    public void salvar(ActionEvent e){
        String nome = txtNomeAluno.getText();
        if(nome.isEmpty()){
            utils.mostrarAlerta("O nome não pode ser vazio");
            return;
        }
        String email = txtEmail.getText();
        if(!validarEmail(email)){
            utils.mostrarAlerta("Email inválido!");
            return;
        }
        String telefone = txtTelefone.getText();
        if(telefone.length() < 8){
            utils.mostrarAlerta("Telefone inválido!");
            return;
        }
        int faltas = 0;
        try {
            faltas = Integer.parseInt(txtFaltas.getText());
        }catch (NumberFormatException ex){
            utils.mostrarErro("Faltas deve ser um número.");
            return;
        }
        CursoDAO cursoDAO = new CursoDAO(parent.getConexao());
        int idCurso;
        try{
            idCurso = cursoDAO.buscarCursoPorNome(txtCurso.getText());
            if(idCurso == -1){
                utils.mostrarAlerta("Curso não enocntrado.");
                return;
            }
        }catch (Exception ex){
            utils.mostrarErro(ex.getMessage());
            return;
        }
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setTelefone(telefone);
        aluno.setFaltas(faltas);
        AlunoDAO alunoDAO = new AlunoDAO(parent.getConexao());
        try{
            alunoDAO.inserirAluno(aluno, idCurso);
            utils.mostrarInformacao("Aluno adicionado com sucesso!");
            parent.setVisible(true);
            dispose();
        }catch (Exception ex){
            utils.mostrarErro(ex.getMessage());
        }
    }

    public boolean validarEmail(String email){
        if(email.isEmpty()){
            return false;
        }
        return email.contains("@") && email.contains(".");
    }


    public void voltar(ActionEvent e){
        parent.setVisible(true);
        dispose();
    }

}
