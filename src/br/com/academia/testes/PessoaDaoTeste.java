package br.com.academia.testes;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.com.academia.dao.PessoaDao;
import br.com.academia.modelo.Pessoa;

public class PessoaDaoTeste {

	PessoaDao pessoaDao = new PessoaDao();

	@Test
	public void salvarTest() {
		Pessoa p = new Pessoa("Filasdasduta", 112);

		pessoaDao.salvar(p);

		Assert.assertTrue(true);

	}

	@Test
	public void atualizarTest() {
		Pessoa p = new Pessoa(19, "Gostosa de mais", 19);

		pessoaDao.atualizar(p);

		Assert.assertTrue(true);

	}

	@Test
	public void excluirTest() {

		pessoaDao.excluir(15);

		Assert.assertTrue(true);

	}

	@Test
	public void carregarTest() {

		Pessoa pessoa = pessoaDao.carregar(19);

		System.out.println("Id:" + pessoa.getId());
		System.out.println("Nome:" + pessoa.getId());
		System.out.println("Idade:" + pessoa.getId());

		Assert.assertTrue(true);

	}

	@Test
	@Ignore
	public void listar() {

		List<Pessoa> ps = pessoaDao.listarOrdemPorNome();

		for (Pessoa pessoa : ps) {
			System.out.println("Id:" + pessoa.getId());
			System.out.println("Nome:" + pessoa.getId());
			System.out.println("Idade:" + pessoa.getId());
			System.out.println("----PRÓXIMO------");
		}

		Assert.assertTrue(true);

	}

}
