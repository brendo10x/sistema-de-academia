package br.com.academia.testes;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import br.com.academia.dao.MedidaDao;
import br.com.academia.modelo.Medida;

//Medida ok

public class MedidaDaoTest {

	private MedidaDao medidaDao = new MedidaDao();
	private Medida medida;

	@Before
	public void antesDoTeste() {
		System.out.println("Inicia teste");

	}

	@After
	public void depoisDoTeste() {
		System.out.println("Termina teste");
	}

	@Test
	@Ignore
	public final void testSalvar() {
		medida = new Medida();
		medida.setCampo(2);
		medida.setLocal("Panturilha");
		medidaDao.salvar(medida);

		medida = new Medida();
		medida.setCampo(1);
		medida.setLocal("Caralho");
		medidaDao.salvar(medida);
	}

	@Test
	@Ignore
	public final void testAtualizar() {
		medida = medidaDao.carregar(2);
		medida.setLocal("Localzinho");
		medidaDao.atualizar(medida);
	}

	@Test
	@Ignore
	public final void testCarregar() {
		medida = medidaDao.carregar(2);
		System.out.println(medida.getCampo());
		System.out.println(medida.getLocal());
		System.out.println(medida.getId());
	}

	@Test
	@Ignore
	public final void testListar() {

		List<Medida> medidas = medidaDao.listarTodos();
		for (Medida medida : medidas) {
			System.out.println(medida.getCampo());
			System.out.println(medida.getLocal());
			System.out.println(medida.getId());
		}
	}

	@Test
	@Ignore
	public final void testExcluir() {
		medidaDao.excluir(2);
	}

}
