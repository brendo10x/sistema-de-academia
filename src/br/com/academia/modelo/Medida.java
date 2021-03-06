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
@Table(name = "medida")
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
    @Column(name = "id", nullable = false)
    private Integer id;
 
    @Column(name = "local", length = 45)
    private String local;
    @Column(name = "campo")
    private Integer campo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medidaId")
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
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((alunoTemMedidaList == null) ? 0 : alunoTemMedidaList
						.hashCode());
		result = prime * result + ((campo == null) ? 0 : campo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medida other = (Medida) obj;
		if (alunoTemMedidaList == null) {
			if (other.alunoTemMedidaList != null)
				return false;
		} else if (!alunoTemMedidaList.equals(other.alunoTemMedidaList))
			return false;
		if (campo == null) {
			if (other.campo != null)
				return false;
		} else if (!campo.equals(other.campo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Medida [id=" + id + ", local=" + local + ", campo=" + campo
				+ ", alunoTemMedidaList=" + alunoTemMedidaList + "]";
	}


    
}
