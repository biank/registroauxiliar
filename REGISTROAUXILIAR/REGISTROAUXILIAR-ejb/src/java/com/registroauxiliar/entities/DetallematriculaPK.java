/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Andrea
 */
@Embeddable
public class DetallematriculaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIdMatricula")
    private int nIdMatricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIdAlumno")
    private int nIdAlumno;

    public DetallematriculaPK() {
    }

    public DetallematriculaPK(int nIdMatricula, int nIdAlumno) {
        this.nIdMatricula = nIdMatricula;
        this.nIdAlumno = nIdAlumno;
    }

    public int getNIdMatricula() {
        return nIdMatricula;
    }

    public void setNIdMatricula(int nIdMatricula) {
        this.nIdMatricula = nIdMatricula;
    }

    public int getNIdAlumno() {
        return nIdAlumno;
    }

    public void setNIdAlumno(int nIdAlumno) {
        this.nIdAlumno = nIdAlumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nIdMatricula;
        hash += (int) nIdAlumno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallematriculaPK)) {
            return false;
        }
        DetallematriculaPK other = (DetallematriculaPK) object;
        if (this.nIdMatricula != other.nIdMatricula) {
            return false;
        }
        if (this.nIdAlumno != other.nIdAlumno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.registroauxiliar.entities.DetallematriculaPK[ nIdMatricula=" + nIdMatricula + ", nIdAlumno=" + nIdAlumno + " ]";
    }
    
}
