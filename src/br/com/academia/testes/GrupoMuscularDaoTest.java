package br.com.academia.testes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.com.academia.dao.GrupoMuscularDao;
import br.com.academia.modelo.GrupoMuscular;

//Classe OK

public class GrupoMuscularDaoTest {

	private GrupoMuscularDao dao = new GrupoMuscularDao();
	private GrupoMuscular grupoMuscular;

	private Integer ID_EXCLUSAO = 3;
	private Integer ID_CARREGAR_OU_ATUALIZAR_OU_ALTERAR = 4;

	@Test
	public void testSalvar() {

		grupoMuscular = new GrupoMuscular();
		grupoMuscular.setNome("Biceps");
		dao.salvar(grupoMuscular);
	}

	@Test
	public void testAtualizar() {

		grupoMuscular = dao.carregar(ID_CARREGAR_OU_ATUALIZAR_OU_ALTERAR);
		grupoMuscular.setNome("Buceta atualizada!");
		dao.atualizar(grupoMuscular);
	}

	@Test
	public void testCarregar() {

		grupoMuscular = dao.carregar(ID_CARREGAR_OU_ATUALIZAR_OU_ALTERAR);
		System.out.println(grupoMuscular.getNome());
	}

	@Test
	public void testListar() {

		List<GrupoMuscular> lista = dao.listarTodos();

		for (GrupoMuscular grupoMuscular : lista) {
			System.out.println(grupoMuscular.getNome());
		}

	}

	@Test
	public void testExcluir() {

		dao.excluir(ID_EXCLUSAO);
	}

}
