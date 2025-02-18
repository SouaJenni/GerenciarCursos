package me.souajenni.view;

import me.souajenni.DAO.AlunoDAO;
import me.souajenni.model.Aluno;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class ListarAluno extends JFrame {
    private JTable tabelaAluno;
    private JPanel painelListarAluno;
    private Menu parent;

    public ListarAluno(Menu parent, int idCurso) {
        setContentPane(painelListarAluno);
        setTitle("Lista de Alunos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.parent = parent;

        AlunoDAO alunoDAO = new AlunoDAO(parent.getConexao());
        try {
            List<Aluno> alunos = alunoDAO.listarAlunosPorCurso(idCurso);
        } catch (SQLException e) {
            Utils utils = new Utils();
            utils.mostrarErro(e.getMessage());
            return;
        }
    }
}
