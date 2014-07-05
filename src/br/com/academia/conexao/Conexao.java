package br.com.academia.conexao;

//Aqui weslly alguma altera��o
//Aqui weslly alguma altera��o


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Aplicando o padr�o de projeto Singleton
public class Conexao {

	// vari�veis de f�bricas de gerenciador de entidades
	private static EntityManager conexao = null;

	private Conexao() {

	}// fim construtor padr�o

	/*
	 * *
	 * Recupera gerenciador de entidades com conex�o com o banco de dado mysql
	 */

	public static EntityManager getInstanciaConexao() {

		// verifica se est� null
		if (conexao == null) {

			// gera gerenciador de entidades
			EntityManagerFactory fabrica = Persistence
					.createEntityManagerFactory("ConexaoMysql");

			conexao = fabrica.createEntityManager();
			
			return conexao;
		}

		// retorna gerenciador de entidades
		// retornando sempre um �nica inst�ncia
		return conexao;

	}// fim
}
