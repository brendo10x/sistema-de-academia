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

/**
 *
 * @author Brendo
 */
@Entity
@Table(name = "aluno_tem_medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlunoTemMedida.findAll", query = "SELECT a FROM AlunoTemMedida a"),
    @NamedQuery(name = "AlunoTemMedida.findById", query = "SELECT a FROM AlunoTemMedida a WHERE a.id = :id")})
public class AlunoTemMedida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "medida_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Medida medidaId;
    @JoinColumn(name = "aluno_medida_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private AlunoMedida alunoMedidaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alunoTemMedidaId1")
    private List<ValorMedida> valorMedidaList;

    public AlunoTemMedida() {
    }

    public AlunoTemMedida(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Medida getMedidaId() {
        return medidaId;
    }

    public void setMedidaId(Medida medidaId) {
        this.medidaId = medidaId;
    }

    public AlunoMedida getAlunoMedidaId() {
        return alunoMedidaId;
    }

    public void setAlunoMedidaId(AlunoMedida alunoMedidaId) {
        this.alunoMedidaId = alunoMedidaId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoTemMedida)) {
            return false;
        }
        AlunoTemMedida other = (AlunoTemMedida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerador.AlunoTemMedida[ id=" + id + " ]";
    }
    
}
