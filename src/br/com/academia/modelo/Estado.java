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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * @author Brendo
 */
@Entity
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
		@NamedQuery(name = "Estado.findById", query = "SELECT e FROM Estado e WHERE e.id = :id"),
		@NamedQuery(name = "Estado.findBySigla", query = "SELECT e FROM Estado e WHERE e.sigla = :sigla"),
		@NamedQuery(name = "Estado.findByNome", query = "SELECT e FROM Estado e WHERE e.nome = :nome") })
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(nullable = false)
	private Integer id;

	@Column(length = 4)
	private String sigla;

	@Column(length = 45)
	private String nome;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoId")
	private List<Cidade> cidadeList;

	public Estado() {
	}

	public Estado(Integer id) {
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

	@XmlTransient
	public List<Cidade> getCidadeList() {
		return cidadeList;
	}

	public void setCidadeList(List<Cidade> cidadeList) {
		this.cidadeList = cidadeList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Estado)) {
			return false;
		}
		Estado other = (Estado) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "gerador.Estado[ id=" + id + " ]";
	}

}
