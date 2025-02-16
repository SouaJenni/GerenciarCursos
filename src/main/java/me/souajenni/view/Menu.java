package me.souajenni.view;

import me.souajenni.DAO.AlunoDAO;
import me.souajenni.controller.Conector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class Menu extends JFrame{
    private JButton btCadastrar;
    private JButton btListar;
    private JButton btListarAluno;
    private JButton btAdicionarAluno;
    private JButton btAtualizar;
    private JButton btRemoverAluno;
    private JButton btRemoverCurso;
    private JPanel painelMenu;
    private Utils utils;
    private Conector conector;
    private Connection conexao;

    public Menu() {
        setContentPane(painelMenu);
        setTitle("Menu");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        utils = new Utils();
        try {
            conector = new Conector();
            conexao = conector.getConexao();
            AlunoDAO alunoDAO = new AlunoDAO(conexao);
            alunoDAO.listarAlunos();
        } catch (SQLException e) {
            utils.mostrarErro(e.getMessage());
        }

        btCadastrar.addActionListener(this::mostrarTelaCadastrarCruso);

        btListar.addActionListener(this::mostrarTelaListarCursos);

        btListarAluno.addActionListener(this::mostrarTelaListarAluno);

        btAdicionarAluno.addActionListener(this::mostrarTelaAdicionarAluno);

        btAtualizar.addActionListener(this::buscarCursoParaAtualizar);

        btRemoverAluno.addActionListener(this::buscarAlunoParaExcluir);

        btRemoverCurso.addActionListener(this::buscarCursoParaExcluir);
    }

    public void mostrarTelaCadastrarCruso(ActionEvent e) {
        new CadastrarCurso();
    }

    public void mostrarTelaListarCursos(ActionEvent e) {
        new ListarCursos();
    }

    public void mostrarTelaListarAluno(ActionEvent e) {
        new Buscar();
    }

    public void mostrarTelaAdicionarAluno(ActionEvent e) {
        new AdicionarAluno();
    }

    public void buscarCursoParaAtualizar(ActionEvent e) {
        new Buscar();
    }

    public void buscarAlunoParaExcluir(ActionEvent e) {
        new Buscar();
    }

    public void buscarCursoParaExcluir(ActionEvent e){
        new Buscar();
    }

    public static void main(String[] args) {
        new Menu();
    }
}
