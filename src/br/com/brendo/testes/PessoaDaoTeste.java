package br.com.brendo.testes;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.com.brendo.dao.PessoaDao;
import br.com.brendo.modelo.Pessoa;

public class PessoaDaoTeste {

	// caraaalho!
	
	@Test
	public void salvarTest() {
		Pessoa p = new Pessoa("Filho dad puta", 112);

		PessoaDao pDao = new PessoaDao();

		pDao.salvar(p);

		Assert.assertTrue(true);

	}

	@Test
	@Ignore
	public void atualizarTest() {
		Pessoa p = new Pessoa(19, "Gostosa de mais", 19);
		PessoaDao pDao = new PessoaDao();

		pDao.atualizar(p);

		Assert.assertTrue(true);

	}

	@Test
	@Ignore
	public void excluirTest() {
		PessoaDao pDao = new PessoaDao();

		pDao.excluir(15);

		Assert.assertTrue(true);

	}

	@Test
	@Ignore
	public void carregarTest() {

		PessoaDao pDao = new PessoaDao();

		Pessoa p = pDao.carregar(19);
		/*
		 * JOptionPane.showMessageDialog(null, "Id: " + p.getId());
		 * JOptionPane.showMessageDialog(null, "Nome: " + p.getNome());
		 * JOptionPane.showMessageDialog(null, "Idade: " + p.getIdade());
		 */

		Assert.assertTrue(true);

	}

	@Test
	@Ignore
	public void listar() {

		PessoaDao pDao = new PessoaDao();

		List<Pessoa> ps = pDao.listarOrdemPorNome();

		/*
		 * for (Pessoa pessoa : ps) { System.out.println("Id:" +
		 * pessoa.getId()); System.out.println("Nome:" + pessoa.getId());
		 * System.out.println("Idade:" + pessoa.getId());
		 * System.out.println("----PRÓXIMO------"); }
		 */
		Assert.assertTrue(true);

	}

}
