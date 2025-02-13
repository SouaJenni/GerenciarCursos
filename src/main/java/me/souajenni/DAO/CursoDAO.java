package me.souajenni.DAO;

import me.souajenni.model.Curso;

import java.util.List;

public class CursoDAO {

    public List<Curso> listarCursos() {
        String listarCursos = "select * from curso";
        return null;
    }

    public boolean inserirCurso(Curso curso) {
        String inserirCurso = "insert into curso (nome, preco, cargaHoraria) values " +
                "(\"+curso.getNome()+\", \"+curso.getPreco()+\",\"+curso.getCargaHoraria()\")";
        return false;
    }

    public int  atualizarCurso(Curso curso) {
        String atualizarCurso = "update curso set nome = \"+curso.getNome()+\", preco = \"+curso.getPreco()+\", " +
                "cargaHoraria = \"+curso.getCargaHoraria() where id = curso.getId()";
        return 0;
    }

    public boolean excluirCurso(Curso curso) {
        String excluirCurso = "delete * from curso were idCurso = curso.getIdCurso()";
        return false;
    }
}
