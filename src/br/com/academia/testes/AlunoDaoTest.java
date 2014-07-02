package br.com.academia.testes;

import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import br.com.academia.dao.AlunoDao;
import br.com.academia.modeloBackup.Aluno;

public class AlunoDaoTest {

	private Aluno aluno;
	private AlunoDao alunoDao = new AlunoDao();

	@Test
	public final void testListar() {

	}

	@Test
	@Ignore
	public final void testSalvar() {

	}

	@Test
	@Ignore
	public final void testAtualizar() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	@Ignore
	public final void testExcluir() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	@Ignore
	public final void testCarregar() {
		fail("Not yet implemented"); // TODO
	}

}
