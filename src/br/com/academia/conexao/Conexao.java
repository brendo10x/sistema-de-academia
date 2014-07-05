package br.com.academia.conexao;

//Aqui weslly alguma alteração
//Aqui weslly alguma alteração


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Aplicando o padrão de projeto Singleton
public class Conexao {

	// variáveis de fábricas de gerenciador de entidades
	private static EntityManager conexao = null;

	private Conexao() {

	}// fim construtor padrão

	/*
	 * *
	 * Recupera gerenciador de entidades com conexão com o banco de dado mysql
	 */

	public static EntityManager getInstanciaConexao() {

		// verifica se está null
		if (conexao == null) {

			// gera gerenciador de entidades
			EntityManagerFactory fabrica = Persistence
					.createEntityManagerFactory("ConexaoMysql");

			conexao = fabrica.createEntityManager();
			
			return conexao;
		}

		// retorna gerenciador de entidades
		// retornando sempre um única instância
		return conexao;

	}// fim
}
