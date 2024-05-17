package test;

import dao.CursoDAO;
import dao.ICursoDAO;
import domain.Curso;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CursoTest {

    private ICursoDAO cursoDAO;

    public CursoTest(){
        cursoDAO = new CursoDAO();
    }

    @Test
    public void cadastrar(){
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setDescricao("CURSO");
        curso.setNome("Curso 1");
        cursoDAO.cadastrar(curso);

        assertNotNull(curso);
        assertNotNull(curso.getCodigo());
    }
}
