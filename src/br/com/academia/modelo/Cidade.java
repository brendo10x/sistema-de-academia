/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.academia.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table; 
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "cidade")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c"),
		@NamedQuery(name = "Cidade.findById", query = "SELECT c FROM Cidade c WHERE c.id = :id"),
		@NamedQuery(name = "Cidade.findBySigla", query = "SELECT c FROM Cidade c WHERE c.sigla = :sigla"),
		@NamedQuery(name = "Cidade.findByNome", query = "SELECT c FROM Cidade c WHERE c.nome = :nome") })
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "sigla", length = 2)
	private String sigla;

	@Column(name = "nome", length = 50)
	private String nome;
	@JoinColumn(name = "estado_id", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Estado estadoId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cidadeId")
	private List<Endereco> enderecoList;

	public Cidade() {
	}

	public Cidade(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Estado estadoId) {
		this.estadoId = estadoId;
	}

	@XmlTransient
	public List<Endereco> getEnderecoList() {
		return enderecoList;
	}

	public void setEnderecoList(List<Endereco> enderecoList) {
		this.enderecoList = enderecoList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((enderecoList == null) ? 0 : enderecoList.hashCode());
		result = prime * result
				+ ((estadoId == null) ? 0 : estadoId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (enderecoList == null) {
			if (other.enderecoList != null)
				return false;
		} else if (!enderecoList.equals(other.enderecoList))
			return false;
		if (estadoId == null) {
			if (other.estadoId != null)
				return false;
		} else if (!estadoId.equals(other.estadoId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", sigla=" + sigla + ", nome=" + nome
				+ ", estadoId=" + estadoId + ", enderecoList=" + enderecoList
				+ "]";
	}



}
