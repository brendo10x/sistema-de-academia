package br.com.academia.testes;

import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import br.com.academia.dao.MedidaDao;
import br.com.academia.modelo.Medida;

public class MedidaDaoTest {
	
	private MedidaDao medidaDao = new MedidaDao();
	private Medida medida;

	@Test
	public final void testSalvar() {
		 medida = new Medida();
		 medida.setCampo(2);
		 medida.setLocal("Panturilha");
		 medidaDao.salvar(medida);
	}

	@Test
	@Ignore
	public final void testAtualizar() {
		 
	}

	@Test
	@Ignore
	public final void testExcluir() {
		 
	}

	@Test
	@Ignore
	public final void testCarregar() {
	 
	}

	@Test
	@Ignore
	public final void testListar() {
		 
	}

}
