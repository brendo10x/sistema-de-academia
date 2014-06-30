package br.com.brendo.generico;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.brendo.conexao.Conexao;

public abstract class DaoGeneric<Tipo> {

	private EntityManager gerEnt;
	private Class<Tipo> classePersistente;

	@SuppressWarnings("unchecked")
	protected DaoGeneric() {
		classePersistente = (Class<Tipo>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected EntityManager obterEntityManager() {

		return Conexao.getInstanciaConexao();
	}

	protected void salvar(Tipo t) {

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

		// fecha conex�o
		gerEnt.close();
	}

	protected void atualizar(Tipo t) {

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

		// fecha conex�o
		gerEnt.close();
	}

	protected void excluir(Integer id) {
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

		// fecha conex�o
		gerEnt.close();
	}

	protected Tipo carregar(Integer id) {

		// entrega inst�ncia do tipo EntityManager com conex�o mysql
		gerEnt = obterEntityManager();

		Tipo t = (Tipo) gerEnt.find(classePersistente, id);

		// fecha conex�o
		gerEnt.close();

		// retorna cliente
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
