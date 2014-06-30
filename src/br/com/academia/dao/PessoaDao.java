package br.com.academia.dao;

import java.util.List;

import br.com.academia.generico.DaoGenerico;
import br.com.academia.modelo.Pessoa;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class PessoaDao extends DaoGenerico<Pessoa> {

	public List<Pessoa> listarOrdemPorNome() {

		List<Pessoa> listaOrdemPorNome = super.listar("listarOrdemPorNome");

		return listaOrdemPorNome;
	}

}