package me.souajenni.view;

import me.souajenni.DAO.CursoDAO;
import me.souajenni.model.Curso;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CadastrarCurso extends JFrame{
    private JTextField txtNomeCurso;
    private JTextField txtPreco;
    private JTextField txtCarga;
    private JPanel painelCadCurso;
    private JButton btSalvar;
    private JButton btVoltar;
    private Menu parent;
    private Utils utils;
    private int idCurso = -1;

    public CadastrarCurso(Menu parent) {
        setContentPane(painelCadCurso);
        setTitle("Cadastrar Curso");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.parent = parent;
        utils = new Utils();

        btSalvar.addActionListener(this::salvar);
        btSalvar.setText("Salvar");
        btVoltar.addActionListener(this::voltar);
    }

    public CadastrarCurso(Menu parent, int idCurso) {
        setContentPane(painelCadCurso);
        setTitle("Cadastrar Curso");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.parent = parent;
        utils = new Utils();
        this.idCurso = idCurso;

        CursoDAO cursoDAO = new CursoDAO(parent.getConexao());
        try {
            Curso curso = cursoDAO.buscarPorId(idCurso);
            txtNomeCurso.setText(curso.getNome());
            txtPreco.setText(curso.getPreco()+"");
            txtCarga.setText(curso.getCargaHoraria()+"");
        } catch (SQLException e) {
            utils.mostrarErro(e.getMessage());
        }

        btSalvar.addActionListener(this::atualizar);
        btSalvar.setText("Atualizar");
        btVoltar.addActionListener(this::voltar);
    }

    public void atualizar(ActionEvent e){
        Curso curso = new Curso();
        String nome = txtNomeCurso.getText();
        if(nome.isEmpty()){
            utils.mostrarErro("O nome do curso não pode ser vazio.");
            return;
        }
        curso.setNome(nome);
        try {
            float preco = Float.parseFloat(txtPreco.getText());
            curso.setPreco(preco);
        }catch (NumberFormatException ex){
            utils.mostrarErro("O preço do curso deve ser um número.");
            return;
        }
        try{
            int carga = Integer.parseInt(txtCarga.getText());
            curso.setCargaHoraria(carga);
        }catch (NumberFormatException ex){
            utils.mostrarErro("A carga horária do curso deve ser um número.");
            return;
        }
        curso.setIdCurso(idCurso);
        CursoDAO cursoDAO = new CursoDAO(parent.getConexao());
        try {
            cursoDAO.atualizarCurso(curso);
            utils.mostrarInformacao("Curso atualizado com sucesso!");
            parent.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            utils.mostrarErro(ex.getMessage());
        }
    }

    public void voltar(ActionEvent e){
        parent.setVisible(true);
        dispose();
    }

    public void salvar(ActionEvent e){
        Curso curso = new Curso();
        String nome = txtNomeCurso.getText();
        if(nome.isEmpty()){
            utils.mostrarErro("O nome do curso não pode ser vazio.");
            return;
        }
        curso.setNome(nome);
        try {
            float preco = Float.parseFloat(txtPreco.getText());
            curso.setPreco(preco);
        }catch (NumberFormatException ex){
            utils.mostrarErro("O preço do curso deve ser um número.");
            return;
        }
        try{
            int carga = Integer.parseInt(txtCarga.getText());
            curso.setCargaHoraria(carga);
        }catch (NumberFormatException ex){
            utils.mostrarErro("A carga horária do curso deve ser um número.");
            return;
        }
        CursoDAO cursoDAO = new CursoDAO(parent.getConexao());
        try{
            cursoDAO.inserirCurso(curso);
            utils.mostrarInformacao("Curso cadastrado com sucesso!");
            parent.setVisible(true);
            dispose();
        }catch(Exception ex){
            utils.mostrarErro(ex.getMessage());
        }

    }
}
