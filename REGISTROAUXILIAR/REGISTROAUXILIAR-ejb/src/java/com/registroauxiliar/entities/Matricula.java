/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrea
 */
@Entity
@Table(name = "MATRICULA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findByNIdDocente", query = "SELECT m FROM Matricula m WHERE m.nIdDocente.nIdDocente = :nIdDocente"),
    @NamedQuery(name = "Matricula.findByNIdDocenteCurso", query = "SELECT m FROM Matricula m WHERE m.nIdDocente.nIdDocente = :nIdDocente and m.nIdCurso.nIdCurso =:nIdCurso"),
    @NamedQuery(name = "Matricula.findByNIdMatricula", query = "SELECT m FROM Matricula m WHERE m.nIdMatricula = :nIdMatricula")})
public class Matricula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIdMatricula")
    private Integer nIdMatricula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricula")
    private Collection<Detallematricula> detallematriculaCollection;
    @JoinColumn(name = "nIdDocente", referencedColumnName = "nIdDocente")
    @ManyToOne
    private Docente nIdDocente;
    @JoinColumn(name = "nIdCurso", referencedColumnName = "nIdCurso")
    @ManyToOne
    private Curso nIdCurso;

    public Matricula() {
    }

    public Matricula(Integer nIdMatricula) {
        this.nIdMatricula = nIdMatricula;
    }

    public Integer getNIdMatricula() {
        return nIdMatricula;
    }

    public void setNIdMatricula(Integer nIdMatricula) {
        this.nIdMatricula = nIdMatricula;
    }

    @XmlTransient
    public Collection<Detallematricula> getDetallematriculaCollection() {
        return detallematriculaCollection;
    }

    public void setDetallematriculaCollection(Collection<Detallematricula> detallematriculaCollection) {
        this.detallematriculaCollection = detallematriculaCollection;
    }

    public Docente getNIdDocente() {
        return nIdDocente;
    }

    public void setNIdDocente(Docente nIdDocente) {
        this.nIdDocente = nIdDocente;
    }

    public Curso getNIdCurso() {
        return nIdCurso;
    }

    public void setNIdCurso(Curso nIdCurso) {
        this.nIdCurso = nIdCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nIdMatricula != null ? nIdMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.nIdMatricula == null && other.nIdMatricula != null) || (this.nIdMatricula != null && !this.nIdMatricula.equals(other.nIdMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.registroauxiliar.entities.Matricula[ nIdMatricula=" + nIdMatricula + " ]";
    }
    
}
