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
@Table(name = "valor_observacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ValorObservacao.findAll", query = "SELECT v FROM ValorObservacao v"),
    @NamedQuery(name = "ValorObservacao.findById", query = "SELECT v FROM ValorObservacao v WHERE v.id = :id"),
    @NamedQuery(name = "ValorObservacao.findByResposta", query = "SELECT v FROM ValorObservacao v WHERE v.resposta = :resposta")})
public class ValorObservacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    private Integer resposta;
    @JoinColumn(name = "pergunta_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Pergunta perguntaId;
    @JoinColumn(name = "observacao_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Observacao observacaoId;

    public ValorObservacao() {
    }

    public ValorObservacao(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResposta() {
        return resposta;
    }

    public void setResposta(Integer resposta) {
        this.resposta = resposta;
    }

    public Pergunta getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(Pergunta perguntaId) {
        this.perguntaId = perguntaId;
    }

    public Observacao getObservacaoId() {
        return observacaoId;
    }

    public void setObservacaoId(Observacao observacaoId) {
        this.observacaoId = observacaoId;
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
        if (!(object instanceof ValorObservacao)) {
            return false;
        }
        ValorObservacao other = (ValorObservacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerador.ValorObservacao[ id=" + id + " ]";
    }
    
}
