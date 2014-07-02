package br.com.academia.testes;

import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Test;

import br.com.academia.dao.MedidaDao;
import br.com.academia.modelo.Medida;

//Medida ok

public class MedidaDaoTest {

	private MedidaDao dao = new MedidaDao();
	private Medida medida;

	private Integer ID_EXCLUSAO = 11;
	private Integer ID_CARREGAR_OU_ATUALIZAR_OU_ALTERAR = 6;

	@Test
	public void testSalvar() {
		medida = new Medida();
		medida.setCampo(2);
		medida.setLocal("Panturilha");
		dao.salvar(medida);

	}

	@Test
	public void testCarregar() {
		medida = dao.carregar(ID_CARREGAR_OU_ATUALIZAR_OU_ALTERAR);

		System.out.println(medida.getCampo());
		System.out.println(medida.getLocal());
		System.out.println(medida.getId());
	}

	@Test
	public void testExcluir() {

		dao.excluir(ID_EXCLUSAO);
	}

	@Test
	public void testAtualizar() {

		medida = dao.carregar(ID_CARREGAR_OU_ATUALIZAR_OU_ALTERAR);
		medida.setLocal("Localzinho");
		dao.atualizar(medida);
	}

	@Test
	public void testListar() {

		List<Medida> medidas = dao.listarTodos();
		for (Medida medida : medidas) {
			System.out.println(medida.getCampo());
			System.out.println(medida.getLocal());
			System.out.println(medida.getId());
		}
	}

}
