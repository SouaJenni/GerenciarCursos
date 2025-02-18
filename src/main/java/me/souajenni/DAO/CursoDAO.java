package me.souajenni.DAO;

import me.souajenni.model.Aluno;
import me.souajenni.model.Curso;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    private Connection conexao;

    public CursoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Curso> listarCursos() throws SQLException {
        Statement statement = this.conexao.createStatement();
        String query = "select * from curso";
        ResultSet resultado = statement.executeQuery(query);
        List<Curso> cursos = new ArrayList<Curso>();
        while(resultado.next()) {
            Curso curso = new Curso();
            curso.setNome(resultado.getString("nome"));
            curso.setIdCurso(resultado.getInt("idCurso"));
            curso.setPreco(resultado.getFloat("preco"));
            curso.setCargaHoraria(resultado.getInt("cargaHoraria"));
            cursos.add(curso);
        }
        return cursos;
    }

    public int buscarCursoPorNome(String nome) throws SQLException {
        Statement statement = this.conexao.createStatement();
        String query = "select idCurso from curso where nome = \""+nome+"\"";
        ResultSet resultado = statement.executeQuery(query);
        int idCurso = -1;
        while(resultado.next()) {
            idCurso = resultado.getInt("idCurso");
        }
        return idCurso;
    }

    public boolean inserirCurso(Curso curso) throws SQLException {
        Statement statement = this.conexao.createStatement();

        String query = "insert into curso (nome, preco, cargaHoraria) values " +
                "(\""+curso.getNome()+"\", "+curso.getPreco()+","+curso.getCargaHoraria()+")";
        int linhas = statement.executeUpdate(query);

        return linhas >0;
    }

    public int  atualizarCurso(Curso curso) throws SQLException {
        Statement statement = this.conexao.createStatement();

        String query = "update curso set nome = \""+curso.getNome()+"\", preco = "+curso.getPreco()+", " +
                "cargaHoraria = "+curso.getCargaHoraria()+" where id =" +curso.getIdCurso();
        int linhas = statement.executeUpdate(query);

        return linhas;
    }

    public boolean excluirCursoESeusAlunos(int id) throws SQLException {
        Statement statement = this.conexao.createStatement();
        AlunoDAO alunoDAO = new AlunoDAO(conexao);
        alunoDAO.excluirAlunosDoCurso(id);

        String query = "delete from curso where idCurso =" +id;
        int linhas = statement.executeUpdate(query);

        return linhas > 0;
    }
}
