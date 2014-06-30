package br.com.academia.generico;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.academia.conexao.Conexao;

public abstract class DaoGeneric<Tipo> {

	private EntityManager gerEnt;
	private Class<Tipo> classePersistente;

	@SuppressWarnings("unchecked")
	protected DaoGeneric() {
		classePersistente = (Class<Tipo>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public EntityManager obterEntityManager() {

		return Conexao.getInstanciaConexao();
	}

	public void salvar(Tipo t) {

		// entrega inst�ncia do tipo EntityManager com conex�o mysql
		gerEnt = obterEntityManager();

		try {

			// inicia a transa��o
			gerEnt.getTransaction().begin();

			// adiciona propriet�rio
			gerEnt.persist(t);

			// transa��o com sucesso
			gerEnt.getTransaction().commit();

		} catch (Exception e) {

			// transa��o ocorreu erro
			gerEnt.getTransaction().rollback();

			// mostra erro
			e.printStackTrace();

		}// fim catch e try

	}

	public void atualizar(Tipo t) {

		// entrega inst�ncia do tipo EntityManager com conex�o mysql
		gerEnt = obterEntityManager();

		try {

			// inicia a transa��o
			gerEnt.getTransaction().begin();

			// atuliza
			gerEnt.merge(t);

			// transa��o com sucesso
			gerEnt.getTransaction().commit();

		} catch (Exception e) {

			// transa��o ocorreu erro
			gerEnt.getTransaction().rollback();

			// mostra erro
			e.printStackTrace();

		}// fim catch e try

	}

	public void excluir(Integer id) {
		// entrega inst�ncia do tipo EntityManager com conex�o mysql
		gerEnt = obterEntityManager();
		try {

			// inicia transa��o
			gerEnt.getTransaction().begin();

			// carrega objeto

			Tipo t = (Tipo) gerEnt.find(classePersistente, id);

			// exclui cliente
			gerEnt.remove(t);

			// transa��o com sucesso
			gerEnt.getTransaction().commit();

		} catch (Exception e) {

			// transa��o ocorreu erro
			gerEnt.getTransaction().rollback();

			// mostra erro
			e.getCause();

		}// fim catch e try

	}

	public Tipo carregar(Integer id) {

		// entrega inst�ncia do tipo EntityManager com conex�o mysql
		gerEnt = obterEntityManager();

		Tipo t = (Tipo) gerEnt.find(classePersistente, id);

		return t;

	}

	protected List<Tipo> listar(String strConsulta) {

		// entrega inst�ncia do tipo EntityManager com conex�o mysql
		gerEnt = obterEntityManager();

		TypedQuery<Tipo> tpQConsulta = (TypedQuery<Tipo>) gerEnt
				.createNamedQuery(strConsulta, classePersistente);

		List<Tipo> resultados = tpQConsulta.getResultList();

		return resultados;
	}
}
