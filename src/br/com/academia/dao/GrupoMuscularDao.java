package br.com.academia.dao;

import java.util.List;

import br.com.academia.generico.DaoGenerico;
import br.com.academia.modelo.GrupoMuscular;
import br.com.academia.modelo.Medida;

public class GrupoMuscularDao extends DaoGenerico<GrupoMuscular> {

	public List<GrupoMuscular> listarTodos() {
		return super.listar("GrupoMuscular.findAll");
	}
}
