package me.souajenni.view;

import me.souajenni.DAO.CursoDAO;
import me.souajenni.model.Curso;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ListarCursos extends JFrame{
    private JTable tabelaCursos;
    private JPanel painelListarCursos;
    private JButton btVoltar;
    private Menu parent;

    public ListarCursos(Menu parent) {
        setContentPane(painelListarCursos);
        setTitle("Lista de Cursos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.parent = parent;

        btVoltar.addActionListener(this::voltar);
        String[] colunas = {"Nome", "Preço", "Carga Horaria"};

        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        CursoDAO cursoDAO = new CursoDAO(parent.getConexao());

        try {
            List<Curso> cursos = cursoDAO.listarCursos();
            for(Curso curso: cursos) {
                String preco = String.format("R$ %.2f", curso.getPreco());
                Object[] linha = {curso.getNome(), preco, curso.getCargaHoraria()};
                modelo.addRow(linha);
            }
        } catch (SQLException e) {
            Utils utils = new Utils();
            utils.mostrarErro(e.getMessage());
        }

        tabelaCursos.setModel(modelo);
    }

    public void voltar(ActionEvent e) {
        parent.setVisible(true);
        dispose();
    }
}
