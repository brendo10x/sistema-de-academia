/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.academia.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable; 

/**
 *
 * @author Brendo
 */
@Embeddable
public class AlunoTemMedidaPK implements Serializable {
    @Basic(optional = false)
    @Column(nullable = false)
    private int id;
    @Basic(optional = false)

    @Column(name = "aluno_medida_id", nullable = false)
    private int alunoMedidaId;
    @Basic(optional = false)

    @Column(name = "medida_id", nullable = false)
    private int medidaId;

    public AlunoTemMedidaPK() {
    }

    public AlunoTemMedidaPK(int id, int alunoMedidaId, int medidaId) {
        this.id = id;
        this.alunoMedidaId = alunoMedidaId;
        this.medidaId = medidaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlunoMedidaId() {
        return alunoMedidaId;
    }

    public void setAlunoMedidaId(int alunoMedidaId) {
        this.alunoMedidaId = alunoMedidaId;
    }

    public int getMedidaId() {
        return medidaId;
    }

    public void setMedidaId(int medidaId) {
        this.medidaId = medidaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) alunoMedidaId;
        hash += (int) medidaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoTemMedidaPK)) {
            return false;
        }
        AlunoTemMedidaPK other = (AlunoTemMedidaPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.alunoMedidaId != other.alunoMedidaId) {
            return false;
        }
        if (this.medidaId != other.medidaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerador.AlunoTemMedidaPK[ id=" + id + ", alunoMedidaId=" + alunoMedidaId + ", medidaId=" + medidaId + " ]";
    }
    
}
