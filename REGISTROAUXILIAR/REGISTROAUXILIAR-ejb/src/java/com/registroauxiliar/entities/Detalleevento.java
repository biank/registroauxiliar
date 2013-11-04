/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrea
 */
@Entity
@Table(name = "DETALLEEVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleevento.findAll", query = "SELECT d FROM Detalleevento d"),
    @NamedQuery(name = "Detalleevento.findByNIdMatricula", query = "SELECT d FROM Detalleevento d WHERE d.detalleeventoPK.nIdMatricula = :nIdMatricula"),
    @NamedQuery(name = "Detalleevento.findByNIdAlumno", query = "SELECT d FROM Detalleevento d WHERE d.detalleeventoPK.nIdAlumno = :nIdAlumno"),
    @NamedQuery(name = "Detalleevento.findByNIdEvento", query = "SELECT d FROM Detalleevento d WHERE d.detalleeventoPK.nIdEvento = :nIdEvento"),
    @NamedQuery(name = "Detalleevento.findByNPeso", query = "SELECT d FROM Detalleevento d WHERE d.nPeso = :nPeso"),
    @NamedQuery(name = "Detalleevento.findByFNota", query = "SELECT d FROM Detalleevento d WHERE d.fNota = :fNota")})
public class Detalleevento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleeventoPK detalleeventoPK;
    @Column(name = "nPeso")
    private Integer nPeso;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fNota")
    private Double fNota;
    @JoinColumn(name = "nIdEvento", referencedColumnName = "nIdEvento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Evento evento;
    @JoinColumns({
        @JoinColumn(name = "nIdMatricula", referencedColumnName = "nIdMatricula", insertable = false, updatable = false),
        @JoinColumn(name = "nIdAlumno", referencedColumnName = "nIdAlumno", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Detallematricula detallematricula;

    public Detalleevento() {
    }

    public Detalleevento(DetalleeventoPK detalleeventoPK) {
        this.detalleeventoPK = detalleeventoPK;
    }

    public Detalleevento(int nIdMatricula, int nIdAlumno, int nIdEvento) {
        this.detalleeventoPK = new DetalleeventoPK(nIdMatricula, nIdAlumno, nIdEvento);
    }

    public DetalleeventoPK getDetalleeventoPK() {
        return detalleeventoPK;
    }

    public void setDetalleeventoPK(DetalleeventoPK detalleeventoPK) {
        this.detalleeventoPK = detalleeventoPK;
    }

    public Integer getNPeso() {
        return nPeso;
    }

    public void setNPeso(Integer nPeso) {
        this.nPeso = nPeso;
    }

    public Double getFNota() {
        return fNota;
    }

    public void setFNota(Double fNota) {
        this.fNota = fNota;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Detallematricula getDetallematricula() {
        return detallematricula;
    }

    public void setDetallematricula(Detallematricula detallematricula) {
        this.detallematricula = detallematricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleeventoPK != null ? detalleeventoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleevento)) {
            return false;
        }
        Detalleevento other = (Detalleevento) object;
        if ((this.detalleeventoPK == null && other.detalleeventoPK != null) || (this.detalleeventoPK != null && !this.detalleeventoPK.equals(other.detalleeventoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.registroauxiliar.entities.Detalleevento[ detalleeventoPK=" + detalleeventoPK + " ]";
    }
    
}
