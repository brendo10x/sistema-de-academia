package br.com.academia.dao;

import java.util.List;

import br.com.academia.generico.DaoGenerico;
import br.com.academia.modelo.Exercicio;
import br.com.academia.modelo.Pergunta;

public class ExercicioDao extends DaoGenerico<Exercicio> {

	public List<Exercicio> listarTodos() {
		return super.listar("Exercicio.findAll");
	}
}
