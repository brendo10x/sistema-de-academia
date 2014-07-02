package br.com.academia.dao;

import java.util.List;

import br.com.academia.generico.DaoGenerico;
import br.com.academia.modelo.Medida;

public class MedidaDao extends DaoGenerico<Medida> {

	public List<Medida> listarTodos() {
		return super.listar("Medida.findAll");
	}
}
