/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.academia.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.academia.enums.TipoContato;

/**
 * 
 * @author Brendo
 */
@Entity
@Table(name = "contato")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Contato.findAll", query = "SELECT c FROM Contato c"),
		@NamedQuery(name = "Contato.findById", query = "SELECT c FROM Contato c WHERE c.id = :id"),
		@NamedQuery(name = "Contato.findByTipo", query = "SELECT c FROM Contato c WHERE c.tipo = :tipo"),
		@NamedQuery(name = "Contato.findByValor", query = "SELECT c FROM Contato c WHERE c.valor = :valor") })
public class Contato implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Integer id;
	@Column(name = "tipo")
	@Enumerated(EnumType.ORDINAL)
	private TipoContato tipo;

	@Column(name = "valor", length = 45)
	private String valor;
	@JoinColumn(name = "aluno_id", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Aluno alunoId;

	public Contato() {
	}

	public Contato(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoContato getTipo() {
		return tipo;
	}

	public void setTipo(TipoContato tipo) {
		this.tipo = tipo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Aluno getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Aluno alunoId) {
		this.alunoId = alunoId;
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
		if (!(object instanceof Contato)) {
			return false;
		}
		Contato other = (Contato) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "gerador.Contato[ id=" + id + " ]";
	}

}
