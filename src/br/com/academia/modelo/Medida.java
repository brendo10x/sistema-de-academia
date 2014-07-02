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
    @NamedQuery(name = "Medida.findAll", query = "SELECT m FROM Medida m"),
    @NamedQuery(name = "Medida.findById", query = "SELECT m FROM Medida m WHERE m.id = :id"),
    @NamedQuery(name = "Medida.findByLocal", query = "SELECT m FROM Medida m WHERE m.local = :local"),
    @NamedQuery(name = "Medida.findByCampo", query = "SELECT m FROM Medida m WHERE m.campo = :campo")})
public class Medida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;

    @Column(length = 45)
    private String local;
    private Integer campo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medida")
    private List<AlunoTemMedida> alunoTemMedidaList;

    public Medida() {
    }

    public Medida(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getCampo() {
        return campo;
    }

    public void setCampo(Integer campo) {
        this.campo = campo;
    }

    @XmlTransient
    public List<AlunoTemMedida> getAlunoTemMedidaList() {
        return alunoTemMedidaList;
    }

    public void setAlunoTemMedidaList(List<AlunoTemMedida> alunoTemMedidaList) {
        this.alunoTemMedidaList = alunoTemMedidaList;
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
        if (!(object instanceof Medida)) {
            return false;
        }
        Medida other = (Medida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerador.Medida[ id=" + id + " ]";
    }
    
}
