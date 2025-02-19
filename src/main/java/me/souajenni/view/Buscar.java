package me.souajenni.view;

import me.souajenni.DAO.AlunoDAO;
import me.souajenni.DAO.CursoDAO;
import me.souajenni.model.Curso;

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
                btBuscar.setText("Buscar");
                break;
            case "atualizarCurso":
                labelBuscar.setText("Digite o nome do curso:");
                btBuscar.setText("Buscar");
                break;
            case "excluirAluno":
                labelBuscar.setText("Digite o email do aluno:");
                btBuscar.setText("Excluir");
                break;
            default:
                labelBuscar.setText("Digite o nome do curso:");
                btBuscar.setText("Excluir");
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
                    dispose();
                } catch (SQLException ex) {
                    utils.mostrarErro(ex.getMessage());
                    return;
                }
                break;

            case "atualizarCurso":
                CursoDAO cursoDAO1 = new CursoDAO(parent.getConexao());
                try{
                    int idCurso =cursoDAO1.buscarCursoPorNome(txtBuscar.getText());
                    if(idCurso == -1){
                        utils.mostrarAlerta("Curso não encontrado");
                        return;
                    }
                    new CadastrarCurso(parent, idCurso);
                    dispose();
                }catch (Exception ex){
                    utils.mostrarErro(ex.getMessage());
                    return;
                }
                break;

            case "excluirAluno":
                AlunoDAO alunoDAO = new AlunoDAO(parent.getConexao());
                int resposta = utils.mostarConfirmacao("Deseja realmente excluir o aluno?");
                if(resposta == JOptionPane.NO_OPTION){
                    return;
                }
                try{
                    if(alunoDAO.excluirAluno(txtBuscar.getText())){
                        utils.mostrarInformacao("Aluno excluído com sucesso");
                        parent.setVisible(true);
                        dispose();
                    }else{
                        utils.mostrarAlerta("Aluno não encontrado");
                    }
                }catch (Exception ex){
                    utils.mostrarErro(ex.getMessage());
                    return;
                }
                break;

            default:
                CursoDAO cursoDAO2 = new CursoDAO(parent.getConexao());
                try {
                    int idCurso = cursoDAO2.buscarCursoPorNome(txtBuscar.getText());
                    if(idCurso == -1){
                        utils.mostrarAlerta("Curso não encontrado");
                        return;
                    }
                    int resposta1 = utils.mostarConfirmacao("Deseja realmente excluir o curso com todos os seus alunos?");
                    if(resposta1 == JOptionPane.NO_OPTION){
                        return;
                    }
                    if(cursoDAO2.excluirCursoESeusAlunos(idCurso)){
                        utils.mostrarInformacao("Curso exluído com sucesso!");
                        parent.setVisible(true);
                        dispose();
                    }else{
                        utils.mostrarAlerta("Ocorreu um erro ao excluir.");
                    }
                } catch (SQLException ex) {
                    utils.mostrarErro(ex.getMessage());
                    return;
                }
                break;
        }
    }


}
