package me.souajenni.DAO;

import me.souajenni.model.Aluno;

import java.util.List;

public class AlunoDAO {
    // usar Statement para adicionar os dados com proteção contra injeção SQL
    public boolean inserirAluno(Aluno aluno, int idCurso) {
        String inserirAluno = "insert into aluno (nome, email, telefone, faltas, Curso_idCurso) Values " +
                "(\"+aluno.getNome()+\", \"+aluno.getEmail()+\",\"+aluno.getTelefone()\", \"+aluno.getFaltas()\", \"+idCurso+\")";
        return false;
    }

    public List<Aluno> listarAlunos() {
        String listarAlunos = "select * from aluno";
        return null;
    }

    public List<Aluno> listarAlunosPorCurso(int idCurso) {
        String listarPorCurso = "select * from aluno where Curso_idCurso = curso.getIdCurso()";
        return null;
    }

    public boolean excluirAluno(String email) {
        String excluirAluno = "delete * from aluno where email = aluno.getEmail()";
        return false;
    }
}
