package me.souajenni.view;

import me.souajenni.DAO.AlunoDAO;
import me.souajenni.model.Aluno;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ListarAluno extends JFrame {
    private JTable tabelaAluno;
    private JPanel painelListarAluno;
    private JButton btVoltar;
    private Menu parent;

    public ListarAluno(Menu parent, int idCurso) {
        setContentPane(painelListarAluno);
        setTitle("Lista de Alunos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.parent = parent;

        String[] colunas = {"Nome", "Email", "Telefone", "Faltas"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        AlunoDAO alunoDAO = new AlunoDAO(parent.getConexao());
        try {
            List<Aluno> alunos = alunoDAO.listarAlunosPorCurso(idCurso);
            for(Aluno aluno : alunos) {
                Object[] linha = {aluno.getNome(), aluno.getEmail(), aluno.getTelefone(), aluno.getFaltas()};
                modelo.addRow(linha);
            }
        } catch (SQLException e) {
            Utils utils = new Utils();
            utils.mostrarErro(e.getMessage());
            return;
        }
        tabelaAluno.setModel(modelo);

        btVoltar.addActionListener(this::voltar);
    }

    public void voltar(ActionEvent e){
        parent.setVisible(true);
        dispose();
    }
}
