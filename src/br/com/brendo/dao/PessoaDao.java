package br.com.brendo.dao;

import java.util.List;

import br.com.brendo.generico.DaoGeneric;
import br.com.brendo.modelo.Pessoa;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class PessoaDao extends DaoGeneric<Pessoa> {

	public List<Pessoa> listarOrdemPorNome() {

		List<Pessoa> listaOrdemPorNome = super.listar("listarOrdemPorNome");

		return listaOrdemPorNome;
	}

}