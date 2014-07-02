/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.academia.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "aluno_tem_medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlunoTemMedida.findAll", query = "SELECT a FROM AlunoTemMedida a"),
    @NamedQuery(name = "AlunoTemMedida.findById", query = "SELECT a FROM AlunoTemMedida a WHERE a.alunoTemMedidaPK.id = :id"),
    @NamedQuery(name = "AlunoTemMedida.findByAlunoMedidaId", query = "SELECT a FROM AlunoTemMedida a WHERE a.alunoTemMedidaPK.alunoMedidaId = :alunoMedidaId"),
    @NamedQuery(name = "AlunoTemMedida.findByMedidaId", query = "SELECT a FROM AlunoTemMedida a WHERE a.alunoTemMedidaPK.medidaId = :medidaId")})
public class AlunoTemMedida implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlunoTemMedidaPK alunoTemMedidaPK;
    @JoinColumn(name = "medida_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medida medida;
    @JoinColumn(name = "aluno_medida_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AlunoMedida alunoMedida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alunoTemMedidaId")
    private List<ValorMedida> valorMedidaList;

    public AlunoTemMedida() {
    }

    public AlunoTemMedida(AlunoTemMedidaPK alunoTemMedidaPK) {
        this.alunoTemMedidaPK = alunoTemMedidaPK;
    }

    public AlunoTemMedida(int id, int alunoMedidaId, int medidaId) {
        this.alunoTemMedidaPK = new AlunoTemMedidaPK(id, alunoMedidaId, medidaId);
    }

    public AlunoTemMedidaPK getAlunoTemMedidaPK() {
        return alunoTemMedidaPK;
    }

    public void setAlunoTemMedidaPK(AlunoTemMedidaPK alunoTemMedidaPK) {
        this.alunoTemMedidaPK = alunoTemMedidaPK;
    }

    public Medida getMedida() {
        return medida;
    }

    public void setMedida(Medida medida) {
        this.medida = medida;
    }

    public AlunoMedida getAlunoMedida() {
        return alunoMedida;
    }

    public void setAlunoMedida(AlunoMedida alunoMedida) {
        this.alunoMedida = alunoMedida;
    }

    @XmlTransient
    public List<ValorMedida> getValorMedidaList() {
        return valorMedidaList;
    }

    public void setValorMedidaList(List<ValorMedida> valorMedidaList) {
        this.valorMedidaList = valorMedidaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alunoTemMedidaPK != null ? alunoTemMedidaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoTemMedida)) {
            return false;
        }
        AlunoTemMedida other = (AlunoTemMedida) object;
        if ((this.alunoTemMedidaPK == null && other.alunoTemMedidaPK != null) || (this.alunoTemMedidaPK != null && !this.alunoTemMedidaPK.equals(other.alunoTemMedidaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerador.AlunoTemMedida[ alunoTemMedidaPK=" + alunoTemMedidaPK + " ]";
    }
    
}
