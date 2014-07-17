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

 * */
@SuppressWarnings("unchecked")
public abstract class DaoGenerico<Tipo> {

	private EntityManager conexao;
	

	public void salvar(Tipo t) {
	// entrega inst�ncia do tipo EntityManager com conex�o mysql
		conexao = FabricaConexao.getInstanciaConexao();
		
		try {

			// inicia a transa��o
			conexao.getTransaction().begin();

			// adiciona propriet�rio
			conexao.persist(t);

			// transa��o com sucesso
			conexao.getTransaction().commit();

		} catch (TransactionException e) {

			// transa��o ocorreu erro
			conexao.getTransaction().rollback();
			
			//sempre sera execultado
		} finally{
			//fecha a conex�o
			conexao.close();
		}// fim catch e try

	}

	public void atualizar(Tipo t) {
		
		// entrega inst�ncia do tipo EntityManager com conex�o mysql
		conexao = FabricaConexao.getInstanciaConexao();
		
		try {

			// inicia a transa��o
			conexao.getTransaction().begin();

			// atuliza
			conexao.merge(t);

			// transa��o com sucesso
			conexao.getTransaction().commit();

		} catch (TransactionException e) {

			// transa��o ocorreu erro
			conexao.getTransaction().rollback();

		}finally{
			//fecha conex�o
			conexao.close();	
		}//fim do try catch finally

	}

	public void excluir(Integer id) {
		
		conexao = FabricaConexao.getInstanciaConexao();
		
		try {

			// inicia transa��o
			conexao.getTransaction().begin();

			// carrega objeto

			Tipo t = (Tipo) conexao.find(DevolveTipoClasse(), id);

			// exclui cliente
			conexao.remove(t);

			// transa��o com sucesso
			conexao.getTransaction().commit();

		} catch (TransactionException e) {

			// transa��o ocorreu erro
			conexao.getTransaction().rollback();

		}finally{
			conexao.close();
		}// fim catch e try

	}

	public Tipo carregar(Integer id) {
		
		conexao = FabricaConexao.getInstanciaConexao();
		Tipo t = null;
		
		try{
			t = (Tipo) conexao.find(DevolveTipoClasse(), id);
		
		}catch(TransactionException e){
	
			//mostra o erro
			e.getStackTrace();
		
		}finally{
			conexao.close();
			
		}
		return t;
	}

	public List<Tipo> listar(String strConsulta) {
		TypedQuery<Tipo> tpQConsulta = null;
		List<Tipo> resultados  = null;
		try{
			////So pra testar não sei qual tipo de exceção tem que tratar aqui
		tpQConsulta = (TypedQuery<Tipo>) conexao
				.createNamedQuery(strConsulta, DevolveTipoClasse());

		resultados = tpQConsulta.getResultList();
		
		}catch(TransactionException e){
			
		}
		return resultados;
	}
	
	public List<Tipo> listarTodos(){
		
		return	listar(DevolveTipoClasse()+".findAll");
		
	}

	private Class<?> DevolveTipoClasse(){
		
		Class<?> classe = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		
		return classe;
	}
	
	
	
}
