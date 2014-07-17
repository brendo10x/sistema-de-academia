package br.com.academia.generico;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;

import org.hibernate.TransactionException;

import br.com.academia.conexao.FabricaConexao;

/**
 * Classe genérica do Dao
 * */
@SuppressWarnings("unchecked")
public abstract class DaoGenerico<Tipo> {

	private EntityManager gerEnt;
	private Class<Tipo> classePersistente;

	@SuppressWarnings("unchecked")
	protected DaoGenerico() {

		// obtem a tipo da classe que está usando o DaoGenerico em tempo de
		// execução
		classePersistente = (Class<Tipo>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];

	
	}
	private EntityManager conexao;
	
	public void salvar(Tipo t) {
		// entrega instância do tipo EntityManager com conexão mysql
		conexao = FabricaConexao.getInstanciaConexao();

		try {

			// inicia a transação
			conexao.getTransaction().begin();

			// adiciona
			gerEnt.persist(t);

			// adiciona proprietário
			conexao.persist(t);

			// transação com sucesso
			conexao.getTransaction().commit();

		} catch (TransactionException e) {

			// transação ocorreu erro
			conexao.getTransaction().rollback();

			// sempre sera execultado
		} finally {
			// fecha a conexão
			conexao.close();
		}// fim catch e try

	}

	public void atualizar(Tipo t) {

		// entrega instância do tipo EntityManager com conexão mysql
		conexao = FabricaConexao.getInstanciaConexao();

		try {

			// inicia a transação
			conexao.getTransaction().begin();

			// atuliza
			conexao.merge(t);

			// transação com sucesso
			conexao.getTransaction().commit();

		} catch (TransactionException e) {

			// transação ocorreu erro
			conexao.getTransaction().rollback();

		} finally {
			// fecha conexão
			conexao.close();
		}// fim do try catch finally

	}

	public void excluir(Integer id) {
		
		conexao = FabricaConexao.getInstanciaConexao();
		
		try {

			// inicia transação
			conexao.getTransaction().begin();

			// carrega objeto

			Tipo t = (Tipo) conexao.find(DevolveTipoClasse(), id);


			// exclui objeto
			gerEnt.remove(t);

			// exclui cliente
			conexao.remove(t);


			// transação com sucesso
			conexao.getTransaction().commit();

		} catch (TransactionException e) {

			// transação ocorreu erro
			conexao.getTransaction().rollback();

		}finally{
			conexao.close();
		}// fim catch e try

	}

	public Tipo carregar(Integer id) {

		conexao = FabricaConexao.getInstanciaConexao();
		Tipo t = null;

		try {
			t = (Tipo) conexao.find(DevolveTipoClasse(), id);

		} catch (TransactionException e) {

			// mostra o erro
			e.getStackTrace();

		} finally {
			conexao.close();

		}
		return t;
	}

	public List<Tipo> listar(String strConsulta) {

		TypedQuery<Tipo> tpQConsulta = (TypedQuery<Tipo>) conexao
				.createNamedQuery(strConsulta, DevolveTipoClasse());

		List<Tipo> resultados = tpQConsulta.getResultList();

		return resultados;
	}

	public List<Tipo> listarTodos() {

		return listar(DevolveTipoClasse() + ".findAll");

	}

	private Class<?> DevolveTipoClasse() {

		Class<?> classe = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];

		return classe;
	}

}
