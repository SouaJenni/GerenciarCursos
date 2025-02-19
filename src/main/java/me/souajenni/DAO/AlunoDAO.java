package me.souajenni.DAO;

import me.souajenni.model.Aluno;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private Connection conexao;

    public AlunoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public boolean inserirAluno(Aluno aluno, int idCurso) throws SQLException {
        Statement statement = this.conexao.createStatement();

        String query = "insert into aluno (nome, email, telefone, faltas, Curso_idCurso) Values " +
                "(\""+aluno.getNome()+"\", \""+aluno.getEmail()+"\",\""+aluno.getTelefone()+"\", "+aluno.getFaltas()+", "+idCurso+")";
        int linhas = statement.executeUpdate(query);

        return linhas >0;
    }

    public List<Aluno> listarAlunos() throws SQLException {
        Statement statement = this.conexao.createStatement();

        String query = "select * from aluno";
        ResultSet resultado = statement.executeQuery(query);
        List<Aluno> alunos = new ArrayList<Aluno>();
        while (resultado.next()){
            Aluno aluno = new Aluno();
            aluno.setNome(resultado.getString("nome"));
            aluno.setEmail(resultado.getString("email"));
            aluno.setTelefone(resultado.getString("telefone"));
            aluno.setFaltas(resultado.getInt("faltas"));
            aluno.setIdAluno(resultado.getInt("idAluno"));
            alunos.add(aluno);
        }
        return alunos;
    }

    public List<Aluno> listarAlunosPorCurso(int idCurso) throws SQLException {
        Statement statement = this.conexao.createStatement();

        String query = "select * from aluno where Curso_idCurso =" +idCurso;
        ResultSet resultado = statement.executeQuery(query);
        List<Aluno> alunos = new ArrayList<Aluno>();
        while (resultado.next()){
            Aluno aluno = new Aluno();
            aluno.setNome(resultado.getString("nome"));
            aluno.setEmail(resultado.getString("email"));
            aluno.setTelefone(resultado.getString("telefone"));
            aluno.setFaltas(resultado.getInt("faltas"));
            aluno.setIdAluno(resultado.getInt("idAluno"));
            alunos.add(aluno);
        }
        return alunos;
    }

    public boolean excluirAluno(String email) throws SQLException {
        Statement statement = this.conexao.createStatement();

        String query = "delete from aluno where email = \"" +email+"\"";
        int linhas = statement.executeUpdate(query);

        return linhas > 0;
    }

    public boolean excluirAlunosDoCurso(int idCurso) throws SQLException {
        Statement statement = this.conexao.createStatement();

        String query = "delete from aluno where Curso_idCurso =" +idCurso;
        int linhas = statement.executeUpdate(query);

        return linhas > 0;
    }
}
