package br.com.academia.generico;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;

import br.com.academia.conexao.Conexao;

/**
 * Classe genérica do Dao
 * */
public abstract class DaoGenerico<Tipo> {

	private EntityManager gerEnt;
	private Class<Tipo> classePersistente;
	public Integer ultimoID;

	@SuppressWarnings("unchecked")
	protected DaoGenerico() {

		// obtem a tipo da classe que está usando o DaoGenerico em tempo de execução
		classePersistente = (Class<Tipo>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];

		// entrega instância do tipo EntityManager com conexão mysql
		gerEnt = Conexao.getInstanciaConexao();
	}

	public void salvar(Tipo t) {

		try {

			// inicia a transação
			gerEnt.getTransaction().begin();

			// adiciona 
			gerEnt.persist(t);

			// transação com sucesso
			gerEnt.getTransaction().commit();

		} catch (Exception e) {

			// transação ocorreu erro
			gerEnt.getTransaction().rollback();

			// mostra erro
			e.printStackTrace();

		}// fim catch e try

	}

	public void atualizar(Tipo t) {

		try {

			// inicia a transação
			gerEnt.getTransaction().begin();

			// atuliza
			gerEnt.merge(t);

			// transação com sucesso
			gerEnt.getTransaction().commit();

		} catch (Exception e) {

			// transação ocorreu erro
			gerEnt.getTransaction().rollback();

			// mostra erro
			e.printStackTrace();

		}// fim catch e try

	}

	public void excluir(Integer id) {

		try {

			// inicia transação
			gerEnt.getTransaction().begin();

			// carrega objeto

			Tipo t = (Tipo) gerEnt.find(classePersistente, id);

			// exclui objeto
			gerEnt.remove(t);

			// transação com sucesso
			gerEnt.getTransaction().commit();

		} catch (Exception e) {

			// transação ocorreu erro
			gerEnt.getTransaction().rollback();

			// mostra erro
			e.getCause();

		}// fim catch e try

	}

	public Tipo carregar(Integer id) {

		Tipo t = (Tipo) gerEnt.find(classePersistente, id);

		return t;

	}

	protected List<Tipo> listar(String strConsulta) {

		TypedQuery<Tipo> tpQConsulta = (TypedQuery<Tipo>) gerEnt
				.createNamedQuery(strConsulta, classePersistente);

		List<Tipo> resultados = tpQConsulta.getResultList();

		return resultados;
	}

}
