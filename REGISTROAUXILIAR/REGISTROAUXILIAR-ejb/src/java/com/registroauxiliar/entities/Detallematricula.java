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
@Table(name = "DETALLEMATRICULA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallematricula.findAll", query = "SELECT d FROM Detallematricula d"),
    @NamedQuery(name = "Detallematricula.findByNIdMatricula", query = "SELECT d FROM Detallematricula d WHERE d.detallematriculaPK.nIdMatricula = :nIdMatricula and d.bEstado=:'1' "),
    @NamedQuery(name = "Detallematricula.findByNIdAlumno", query = "SELECT d FROM Detallematricula d WHERE d.detallematriculaPK.nIdAlumno = :nIdAlumno"),
    @NamedQuery(name = "Detallematricula.findByBEstado", query = "SELECT d FROM Detallematricula d WHERE d.bEstado = :bEstado")})
public class Detallematricula implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallematriculaPK detallematriculaPK;
    @Column(name = "bEstado")
    private Integer bEstado;
    @JoinColumn(name = "nIdMatricula", referencedColumnName = "nIdMatricula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Matricula matricula;
    @JoinColumn(name = "nIdAlumno", referencedColumnName = "nIdAlumno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detallematricula")
    private Collection<Detalleevento> detalleeventoCollection;

    public Detallematricula() {
    }

    public Detallematricula(DetallematriculaPK detallematriculaPK) {
        this.detallematriculaPK = detallematriculaPK;
    }

    public Detallematricula(int nIdMatricula, int nIdAlumno) {
        this.detallematriculaPK = new DetallematriculaPK(nIdMatricula, nIdAlumno);
    }

    public DetallematriculaPK getDetallematriculaPK() {
        return detallematriculaPK;
    }

    public void setDetallematriculaPK(DetallematriculaPK detallematriculaPK) {
        this.detallematriculaPK = detallematriculaPK;
    }

    public Integer getBEstado() {
        return bEstado;
    }

    public void setBEstado(Integer bEstado) {
        this.bEstado = bEstado;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @XmlTransient
    public Collection<Detalleevento> getDetalleeventoCollection() {
        return detalleeventoCollection;
    }

    public void setDetalleeventoCollection(Collection<Detalleevento> detalleeventoCollection) {
        this.detalleeventoCollection = detalleeventoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallematriculaPK != null ? detallematriculaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallematricula)) {
            return false;
        }
        Detallematricula other = (Detallematricula) object;
        if ((this.detallematriculaPK == null && other.detallematriculaPK != null) || (this.detallematriculaPK != null && !this.detallematriculaPK.equals(other.detallematriculaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sismedic.entities.Detallematricula[ detallematriculaPK=" + detallematriculaPK + " ]";
    }
    
}
