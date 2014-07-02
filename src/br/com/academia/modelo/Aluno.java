/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.academia.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import br.com.academia.enums.TipoSexo;

/**
 * 
 * @author Brendo
 */
@Entity
@Table(name = "aluno")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
		@NamedQuery(name = "Aluno.findById", query = "SELECT a FROM Aluno a WHERE a.id = :id"),
		@NamedQuery(name = "Aluno.findByNome", query = "SELECT a FROM Aluno a WHERE a.nome = :nome"),
		@NamedQuery(name = "Aluno.findBySexo", query = "SELECT a FROM Aluno a WHERE a.sexo = :sexo"),
		@NamedQuery(name = "Aluno.findByDataNascimento", query = "SELECT a FROM Aluno a WHERE a.dataNascimento = :dataNascimento"),
		@NamedQuery(name = "Aluno.findByPeso", query = "SELECT a FROM Aluno a WHERE a.peso = :peso"),
		@NamedQuery(name = "Aluno.findByAltura", query = "SELECT a FROM Aluno a WHERE a.altura = :altura"),
		@NamedQuery(name = "Aluno.findByCodigoAcesso", query = "SELECT a FROM Aluno a WHERE a.codigoAcesso = :codigoAcesso") })
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "nome", length = 200)
	private String nome;
	@Column(name = "sexo")
	@Enumerated(EnumType.ORDINAL)
	private TipoSexo sexo;
	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column(name = "peso", precision = 3, scale = 2)
	private Double peso;
	@Column(name = "altura", precision = 2, scale = 2)
	private Double altura;

	@Column(name = "codigo_acesso", length = 45)
	private String codigoAcesso;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "alunoId")
	private List<Contato> contatoList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "alunoId")
	private List<Observacao> observacaoList;
	@JoinColumn(name = "endereco_id", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Endereco enderecoId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "alunoId")
	private List<Treino> treinoList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "alunoId")
	private List<AlunoMedida> alunoMedidaList;

	public Aluno() {
	}

	public Aluno(Integer id) {
		this.id = id;
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

	public TipoSexo getSexo() {
		return sexo;
	}

	public void setSexo(TipoSexo sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public String getCodigoAcesso() {
		return codigoAcesso;
	}

	public void setCodigoAcesso(String codigoAcesso) {
		this.codigoAcesso = codigoAcesso;
	}

	@XmlTransient
	public List<Contato> getContatoList() {
		return contatoList;
	}

	public void setContatoList(List<Contato> contatoList) {
		this.contatoList = contatoList;
	}

	@XmlTransient
	public List<Observacao> getObservacaoList() {
		return observacaoList;
	}

	public void setObservacaoList(List<Observacao> observacaoList) {
		this.observacaoList = observacaoList;
	}

	public Endereco getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Endereco enderecoId) {
		this.enderecoId = enderecoId;
	}

	@XmlTransient
	public List<Treino> getTreinoList() {
		return treinoList;
	}

	public void setTreinoList(List<Treino> treinoList) {
		this.treinoList = treinoList;
	}

	@XmlTransient
	public List<AlunoMedida> getAlunoMedidaList() {
		return alunoMedidaList;
	}

	public void setAlunoMedidaList(List<AlunoMedida> alunoMedidaList) {
		this.alunoMedidaList = alunoMedidaList;
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
		if (!(object instanceof Aluno)) {
			return false;
		}
		Aluno other = (Aluno) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "gerador.Aluno[ id=" + id + " ]";
	}

}
