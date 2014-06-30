package br.com.academia.interfaces;

import java.util.List;

public interface Dao<Tipo> {

	public void salvar(Tipo t);

	public void atualizar(Tipo t);

	public void excluir(Integer id);

	public Tipo carregar(Integer id);

	public List<Tipo> listar(String strConsulta);
}
