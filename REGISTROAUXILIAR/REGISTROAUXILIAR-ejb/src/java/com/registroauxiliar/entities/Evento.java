/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "EVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findBySDescripcion", query = "SELECT e FROM Evento e WHERE e.sDescripcion = :sDescripcion"),
    @NamedQuery(name = "Evento.findByDFechaInicioPresentacion", query = "SELECT e FROM Evento e WHERE e.dFechaInicioPresentacion = :dFechaInicioPresentacion"),
    @NamedQuery(name = "Evento.findByDFechaFinPresentacion", query = "SELECT e FROM Evento e WHERE e.dFechaFinPresentacion = :dFechaFinPresentacion"),
    @NamedQuery(name = "Evento.findByDFechaCreacion", query = "SELECT e FROM Evento e WHERE e.dFechaCreacion = :dFechaCreacion"),
    @NamedQuery(name = "Evento.findByNIdEvento", query = "SELECT e FROM Evento e WHERE e.nIdEvento = :nIdEvento")})
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "sDescripcion")
    private String sDescripcion;
    @Column(name = "dFechaInicioPresentacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dFechaInicioPresentacion;
    @Column(name = "dFechaFinPresentacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dFechaFinPresentacion;
    @Column(name = "dFechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dFechaCreacion;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIdEvento")
    private Integer nIdEvento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evento")
    private Collection<Detalleevento> detalleeventoCollection;

    public Evento() {
    }

    public Evento(Integer nIdEvento) {
        this.nIdEvento = nIdEvento;
    }

    public String getSDescripcion() {
        return sDescripcion;
    }

    public void setSDescripcion(String sDescripcion) {
        this.sDescripcion = sDescripcion;
    }

    public Date getDFechaInicioPresentacion() {
        return dFechaInicioPresentacion;
    }

    public void setDFechaInicioPresentacion(Date dFechaInicioPresentacion) {
        this.dFechaInicioPresentacion = dFechaInicioPresentacion;
    }

    public Date getDFechaFinPresentacion() {
        return dFechaFinPresentacion;
    }

    public void setDFechaFinPresentacion(Date dFechaFinPresentacion) {
        this.dFechaFinPresentacion = dFechaFinPresentacion;
    }

    public Date getDFechaCreacion() {
        return dFechaCreacion;
    }

    public void setDFechaCreacion(Date dFechaCreacion) {
        this.dFechaCreacion = dFechaCreacion;
    }

    public Integer getNIdEvento() {
        return nIdEvento;
    }

    public void setNIdEvento(Integer nIdEvento) {
        this.nIdEvento = nIdEvento;
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
        hash += (nIdEvento != null ? nIdEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.nIdEvento == null && other.nIdEvento != null) || (this.nIdEvento != null && !this.nIdEvento.equals(other.nIdEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.registroauxiliar.entities.Evento[ nIdEvento=" + nIdEvento + " ]";
    }
    
}
