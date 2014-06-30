package br.com.brendo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.swing.JOptionPane;

@Entity
@NamedQueries({

@NamedQuery(name = "listarOrdemPorNome", query = "SELECT p FROM Pessoa p ORDER BY p.id DESC") })
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;

	@Column(length = 70)
	public String nome;

	public Integer idade;

	public Pessoa() {

	}

	public Pessoa(String nome, Integer idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	public Pessoa(Integer id, String nome, Integer idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

}
