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

/**
 *
 * @author Brendo
 */
@Entity
@Table(name = "aluno_medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlunoMedida.findAll", query = "SELECT a FROM AlunoMedida a"),
    @NamedQuery(name = "AlunoMedida.findById", query = "SELECT a FROM AlunoMedida a WHERE a.id = :id"),
    @NamedQuery(name = "AlunoMedida.findByInicio", query = "SELECT a FROM AlunoMedida a WHERE a.inicio = :inicio")})
public class AlunoMedida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "inicio")
    @Temporal(TemporalType.DATE)
    private Date inicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alunoMedidaId")
    private List<AlunoTemMedida> alunoTemMedidaList;
    @JoinColumn(name = "aluno_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Aluno alunoId;

    public AlunoMedida() {
    }

    public AlunoMedida(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    @XmlTransient
    public List<AlunoTemMedida> getAlunoTemMedidaList() {
        return alunoTemMedidaList;
    }

    public void setAlunoTemMedidaList(List<AlunoTemMedida> alunoTemMedidaList) {
        this.alunoTemMedidaList = alunoTemMedidaList;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoMedida)) {
            return false;
        }
        AlunoMedida other = (AlunoMedida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerador.AlunoMedida[ id=" + id + " ]";
    }
    
}
