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
@Table(name = "ALUMNO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a"),
    @NamedQuery(name = "Alumno.findByNIdPersona", query = "SELECT a FROM Alumno a WHERE a.nIdPersona.nIdPersona = :nIdPersona"),
    @NamedQuery(name = "Alumno.findByNIdAlumnoDetalle", query = "SELECT a FROM Alumno a WHERE (a.nIdAlumno not in (SELECT d.detallematriculaPK.nIdAlumno FROM Detallematricula d))"),
    @NamedQuery(name = "Alumno.findByFiltroApeNomb", query = "SELECT a FROM Alumno a "
    + "WHERE UPPER(a.nIdPersona.sNombresCompletos) LIKE UPPER(:sNombresCompletos)"),        
    @NamedQuery(name = "Alumno.findByNIdAlumno", query = "SELECT a FROM Alumno a WHERE a.nIdAlumno = :nIdAlumno")})
public class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIdAlumno")
    private Integer nIdAlumno;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "sPlanEstudio")
    private String sPlanEstudio;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "nCodigo")
    private String nCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Collection<Detallematricula> detallematriculaCollection;
    @JoinColumn(name = "nIdPersona", referencedColumnName = "nIdPersona")
    @ManyToOne(optional = false)
    private Persona nIdPersona;

    public Alumno() {
    }

    public Alumno(Integer nIdAlumno) {
        this.nIdAlumno = nIdAlumno;
    }

    public Alumno(Integer nIdAlumno, String sPlanEstudio, String nCodigo) {
        this.nIdAlumno = nIdAlumno;
        this.sPlanEstudio = sPlanEstudio;
        this.nCodigo = nCodigo;
    }

    public Integer getNIdAlumno() {
        return nIdAlumno;
    }

    public void setNIdAlumno(Integer nIdAlumno) {
        this.nIdAlumno = nIdAlumno;
    }

    public String getSPlanEstudio() {
        return sPlanEstudio;
    }

    public void setSPlanEstudio(String sPlanEstudio) {
        this.sPlanEstudio = sPlanEstudio;
    }

    public String getNCodigo() {
        return nCodigo;
    }

    public void setNCodigo(String nCodigo) {
        this.nCodigo = nCodigo;
    }

    @XmlTransient
    public Collection<Detallematricula> getDetallematriculaCollection() {
        return detallematriculaCollection;
    }

    public void setDetallematriculaCollection(Collection<Detallematricula> detallematriculaCollection) {
        this.detallematriculaCollection = detallematriculaCollection;
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
        hash += (nIdAlumno != null ? nIdAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.nIdAlumno == null && other.nIdAlumno != null) || (this.nIdAlumno != null && !this.nIdAlumno.equals(other.nIdAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.registroauxiliar.entities.Alumno[ nIdAlumno=" + nIdAlumno + " ]";
    }
    
}
