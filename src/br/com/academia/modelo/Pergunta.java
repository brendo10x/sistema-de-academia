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
import javax.persistence.Table; 
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Brendo
 */
@Entity
@Table(name = "pergunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pergunta.findAll", query = "SELECT p FROM Pergunta p"),
    @NamedQuery(name = "Pergunta.findById", query = "SELECT p FROM Pergunta p WHERE p.id = :id"),
    @NamedQuery(name = "Pergunta.findByDescricao", query = "SELECT p FROM Pergunta p WHERE p.descricao = :descricao")})
public class Pergunta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
 
    @Column(name = "descricao", length = 200)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perguntaId")
    private List<ValorObservacao> valorObservacaoList;

    public Pergunta() {
    }

    public Pergunta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<ValorObservacao> getValorObservacaoList() {
        return valorObservacaoList;
    }

    public void setValorObservacaoList(List<ValorObservacao> valorObservacaoList) {
        this.valorObservacaoList = valorObservacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pergunta)) {
            return false;
        }
        Pergunta other = (Pergunta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerador.Pergunta[ id=" + id + " ]";
    }
    
}
