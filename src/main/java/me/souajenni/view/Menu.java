package me.souajenni.view;

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
        } catch (SQLException e) {
            utils.mostrarErro(e.getMessage());
        }

        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastrarCurso();
            }
        });


        btListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListarCursos();
            }
        });


        btListarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Buscar();
            }
        });


        btAdicionarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdicionarAluno();
            }
        });


        btAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Buscar();
            }
        });


        btRemoverAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Buscar();
            }
        });


        btRemoverCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Buscar();
            }
        });
    }

    public static void main(String[] args) {
        new Menu();
    }
}
