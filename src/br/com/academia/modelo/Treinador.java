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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Brendo
 */
@Entity
@Table(name = "treinador")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Treinador.findAll", query = "SELECT t FROM Treinador t"),
		@NamedQuery(name = "Treinador.findById", query = "SELECT t FROM Treinador t WHERE t.id = :id"),
		@NamedQuery(name = "Treinador.findByNome", query = "SELECT t FROM Treinador t WHERE t.nome = :nome") })
public class Treinador implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Integer id;
	@Basic(optional = false)
	@Column(name = "nome", nullable = false, length = 45)
	private String nome;
	@JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Usuario usuarioId;

	public Treinador() {
	}

	public Treinador(Integer id) {
		this.id = id;
	}

	public Treinador(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
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

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
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
		if (!(object instanceof Treinador)) {
			return false;
		}
		Treinador other = (Treinador) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "gerador.Treinador[ id=" + id + " ]";
	}

}
