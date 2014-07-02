package br.com.academia.testes;

import java.util.List;

import org.junit.Test;

import br.com.academia.dao.PerguntaDao;
import br.com.academia.modelo.Pergunta;

//Classe OK
public class PerguntaDaoTest {

	private PerguntaDao dao = new PerguntaDao();
	private Pergunta pergunta;

	private Integer ID_EXCLUSAO = 2;
	private Integer ID_CARREGAR_OU_ATUALIZAR_OU_ALTERAR = 3;

	@Test
	public void testSalvar() {
		pergunta = new Pergunta();
		pergunta.setDescricao("PerguntaDaoPerguntaDaoPerguntaDao");
		dao.salvar(pergunta);

	}

	@Test
	public void testCarregar() {
		pergunta = dao.carregar(ID_CARREGAR_OU_ATUALIZAR_OU_ALTERAR);
		System.out.println(pergunta.getDescricao());
	}

	@Test
	public void testExcluir() {

		dao.excluir(ID_EXCLUSAO);
	}

	@Test
	public void testAtualizar() {

		pergunta = dao.carregar(ID_CARREGAR_OU_ATUALIZAR_OU_ALTERAR);
		pergunta.setDescricao("Pergunta atualizada");
		dao.atualizar(pergunta);
	}

	@Test
	public void testListar() {

		List<Pergunta> perguntas = dao.listarTodos();
		for (Pergunta pergunta : perguntas) {
			System.out.println(pergunta.getDescricao());

		}
	}

}
