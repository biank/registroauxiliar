/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrea
 */
@Entity
@Table(name = "DOCENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d"),
    @NamedQuery(name = "Docente.findByNIdPersona", query = "SELECT d FROM Docente d WHERE d.nIdPersona.nIdPersona = :nIdPersona"),   
    @NamedQuery(name = "Docente.findBySCodigo", query = "SELECT d FROM Docente d WHERE d.sCodigo = :sCodigo")})
public class Docente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIdDocente")
    private Integer nIdDocente;
    @Size(max = 18)
    @Column(name = "sCodigo")
    private String sCodigo;
    @OneToMany(mappedBy = "nIdDocente")
    private Collection<Matricula> matriculaCollection;
    @JoinColumn(name = "nIdPersona", referencedColumnName = "nIdPersona")
    @ManyToOne
    private Persona nIdPersona;

    public Docente() {
    }

    public Docente(Integer nIdDocente) {
        this.nIdDocente = nIdDocente;
    }

    public Integer getNIdDocente() {
        return nIdDocente;
    }

    public void setNIdDocente(Integer nIdDocente) {
        this.nIdDocente = nIdDocente;
    }

    public String getSCodigo() {
        return sCodigo;
    }

    public void setSCodigo(String sCodigo) {
        this.sCodigo = sCodigo;
    }

    @XmlTransient
    public Collection<Matricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
    }

    public Persona getNIdPersona() {
        return nIdPersona;
    }

    public void setNIdPersona(Persona nIdPersona) {
        this.nIdPersona = nIdPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nIdDocente != null ? nIdDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.nIdDocente == null && other.nIdDocente != null) || (this.nIdDocente != null && !this.nIdDocente.equals(other.nIdDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.registroauxiliar.entities.Docente[ nIdDocente=" + nIdDocente + " ]";
    }
    
}
