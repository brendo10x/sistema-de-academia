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
@Table(name = "treino", catalog = "sistema-academia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Treino.findAll", query = "SELECT t FROM Treino t"),
    @NamedQuery(name = "Treino.findById", query = "SELECT t FROM Treino t WHERE t.id = :id"),
    @NamedQuery(name = "Treino.findByInicio", query = "SELECT t FROM Treino t WHERE t.inicio = :inicio"),
    @NamedQuery(name = "Treino.findByDiaSemana", query = "SELECT t FROM Treino t WHERE t.diaSemana = :diaSemana"),
    @NamedQuery(name = "Treino.findByObjetivo", query = "SELECT t FROM Treino t WHERE t.objetivo = :objetivo")})
public class Treino implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "inicio")
    @Temporal(TemporalType.DATE)
    private Date inicio;
    @Column(name = "dia_semana")
    private Integer diaSemana;
 
    @Column(name = "objetivo", length = 255)
    private String objetivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "treinoId")
    private List<TreinoExercicio> treinoExercicioList;
    @JoinColumn(name = "aluno_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Aluno alunoId;

    public Treino() {
    }

    public Treino(Integer id) {
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

    public Integer getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Integer diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    @XmlTransient
    public List<TreinoExercicio> getTreinoExercicioList() {
        return treinoExercicioList;
    }

    public void setTreinoExercicioList(List<TreinoExercicio> treinoExercicioList) {
        this.treinoExercicioList = treinoExercicioList;
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
        if (!(object instanceof Treino)) {
            return false;
        }
        Treino other = (Treino) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerador.Treino[ id=" + id + " ]";
    }
    
}
