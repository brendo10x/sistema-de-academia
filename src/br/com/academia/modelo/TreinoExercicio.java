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
@Table(name = "treino_exercicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TreinoExercicio.findAll", query = "SELECT t FROM TreinoExercicio t"),
    @NamedQuery(name = "TreinoExercicio.findById", query = "SELECT t FROM TreinoExercicio t WHERE t.id = :id"),
    @NamedQuery(name = "TreinoExercicio.findBySerie", query = "SELECT t FROM TreinoExercicio t WHERE t.serie = :serie"),
    @NamedQuery(name = "TreinoExercicio.findByRepeticoes", query = "SELECT t FROM TreinoExercicio t WHERE t.repeticoes = :repeticoes"),
    @NamedQuery(name = "TreinoExercicio.findByPeso", query = "SELECT t FROM TreinoExercicio t WHERE t.peso = :peso")})
public class TreinoExercicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    private Integer serie;
    private Integer repeticoes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 3, scale = 2)
    private Double peso;
    @JoinColumn(name = "treino_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Treino treinoId;
    @JoinColumn(name = "exercicio_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Exercicio exercicioId;

    public TreinoExercicio() {
    }

    public TreinoExercicio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public Integer getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(Integer repeticoes) {
        this.repeticoes = repeticoes;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Treino getTreinoId() {
        return treinoId;
    }

    public void setTreinoId(Treino treinoId) {
        this.treinoId = treinoId;
    }

    public Exercicio getExercicioId() {
        return exercicioId;
    }

    public void setExercicioId(Exercicio exercicioId) {
        this.exercicioId = exercicioId;
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
        if (!(object instanceof TreinoExercicio)) {
            return false;
        }
        TreinoExercicio other = (TreinoExercicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerador.TreinoExercicio[ id=" + id + " ]";
    }
    
}
