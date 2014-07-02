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
@Table(name = "grupo_muscular")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoMuscular.findAll", query = "SELECT g FROM GrupoMuscular g"),
    @NamedQuery(name = "GrupoMuscular.findById", query = "SELECT g FROM GrupoMuscular g WHERE g.id = :id"),
    @NamedQuery(name = "GrupoMuscular.findByNome", query = "SELECT g FROM GrupoMuscular g WHERE g.nome = :nome")})
public class GrupoMuscular implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
 
    @Column(name = "nome", length = 45)
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoMuscularId")
    private List<Exercicio> exercicioList;

    public GrupoMuscular() {
    }

    public GrupoMuscular(Integer id) {
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

    @XmlTransient
    public List<Exercicio> getExercicioList() {
        return exercicioList;
    }

    public void setExercicioList(List<Exercicio> exercicioList) {
        this.exercicioList = exercicioList;
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
        if (!(object instanceof GrupoMuscular)) {
            return false;
        }
        GrupoMuscular other = (GrupoMuscular) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerador.GrupoMuscular[ id=" + id + " ]";
    }
    
}
