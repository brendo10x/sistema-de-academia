package br.com.brendo.dao;

import java.util.List;

import br.com.brendo.generico.DaoGeneric;
import br.com.brendo.modelo.Pessoa;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class PessoaDao extends DaoGeneric<Pessoa> {

	@Override
	public void salvar(Pessoa t) {
		super.salvar(t);
	}

	@Override
	public void atualizar(Pessoa t) {

		super.atualizar(t);

	}

	@Override
	public void excluir(Integer id) {

		super.excluir(id);
	}

	@Override
	public Pessoa carregar(Integer id) {

		return super.carregar(id);
	}

	public List<Pessoa> listarOrdemPorNome() {

		List<Pessoa> listaOrdemPorNome = super.listar("listarOrdemPorNome");

		return listaOrdemPorNome;
	}

}
