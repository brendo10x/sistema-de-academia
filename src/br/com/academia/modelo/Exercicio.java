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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Brendo
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exercicio.findAll", query = "SELECT e FROM Exercicio e"),
    @NamedQuery(name = "Exercicio.findById", query = "SELECT e FROM Exercicio e WHERE e.id = :id"),
    @NamedQuery(name = "Exercicio.findByNome", query = "SELECT e FROM Exercicio e WHERE e.nome = :nome"),
    @NamedQuery(name = "Exercicio.findByDescricao", query = "SELECT e FROM Exercicio e WHERE e.descricao = :descricao")})
public class Exercicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
   
    @Column(length = 70)
    private String nome;
 
    @Column(length = 255)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exercicioId")
    private List<TreinoExercicio> treinoExercicioList;
    @JoinColumn(name = "grupo_muscular_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private GrupoMuscular grupoMuscularId;

    public Exercicio() {
    }

    public Exercicio(Integer id) {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<TreinoExercicio> getTreinoExercicioList() {
        return treinoExercicioList;
    }

    public void setTreinoExercicioList(List<TreinoExercicio> treinoExercicioList) {
        this.treinoExercicioList = treinoExercicioList;
    }

    public GrupoMuscular getGrupoMuscularId() {
        return grupoMuscularId;
    }

    public void setGrupoMuscularId(GrupoMuscular grupoMuscularId) {
        this.grupoMuscularId = grupoMuscularId;
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
        if (!(object instanceof Exercicio)) {
            return false;
        }
        Exercicio other = (Exercicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerador.Exercicio[ id=" + id + " ]";
    }
    
}
