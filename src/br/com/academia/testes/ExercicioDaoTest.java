package br.com.academia.testes;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.academia.dao.ExercicioDao;
import br.com.academia.dao.GrupoMuscularDao;
import br.com.academia.modelo.Exercicio;
import br.com.academia.modelo.GrupoMuscular;

//Classe testada ok
public class ExercicioDaoTest {

	private ExercicioDao dao = new ExercicioDao();
	private Exercicio exercicio;

	private Integer ID_EXCLUSAO = 0;
	private Integer ID_CARREGAR_OU_ATUALIZAR_OU_ALTERAR = 1;

	@Test
	@Ignore
	public void testSalvar() {

		exercicio = new Exercicio();

		exercicio.setDescricao("Exercício descrição!");

		exercicio.setNome("Nome descrição");

		GrupoMuscularDao grupoMuscularDao = new GrupoMuscularDao();

		GrupoMuscular grupoMuscular = grupoMuscularDao.carregar(3);

		exercicio.setGrupoMuscularId(grupoMuscular);

		dao.salvar(exercicio);

	}

	@Test
	@Ignore
	public void testCarregar() {
		exercicio = dao.carregar(ID_CARREGAR_OU_ATUALIZAR_OU_ALTERAR);

		System.out.println("Exercicio Nome:" + exercicio.getNome());
		System.out.println("Exercicio Descrição:" + exercicio.getDescricao());
		System.out.println("Exercicio Id:" + exercicio.getId());

		GrupoMuscular grupM = exercicio.getGrupoMuscularId();
		System.out.println("Grupo muscular Nome: " + grupM.getNome());
		System.out.println("Grupo muscular Id: " + grupM.getId());

		List<Exercicio> lista = grupM.getExercicioList();
		for (Exercicio exercicio : lista) {
			System.out.println("Lista");
			System.out.println("Exercicio Nome:" + exercicio.getNome());
			System.out.println("Exercicio Descrição:"
					+ exercicio.getDescricao());
			System.out.println("Exercicio Id:" + exercicio.getId());

		}

	}

	@Test
	@Ignore
	public void testExcluir() {

		dao.excluir(ID_EXCLUSAO);
	}

	@Test
	@Ignore
	public void testAtualizar() {

		exercicio = dao.carregar(ID_CARREGAR_OU_ATUALIZAR_OU_ALTERAR);
		exercicio.setDescricao("Exercício descrição atualizado!");

		dao.atualizar(exercicio);

	}

	@Test
	@Ignore
	public void testListar() {

		List<Exercicio> exercicios = dao.listarTodos();
		for (Exercicio exercicio : exercicios) {
			System.out.println(exercicio.getNome());
			System.out.println(exercicio.getDescricao());
			System.out.println(exercicio.getId());
		}
	}

}
