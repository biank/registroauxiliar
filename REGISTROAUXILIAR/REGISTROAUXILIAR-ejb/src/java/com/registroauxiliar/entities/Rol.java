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
@Table(name = "ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "Rol.findByNIdRol", query = "SELECT r FROM Rol r WHERE r.nIdRol = :nIdRol"),
    @NamedQuery(name = "Rol.findBySDenominacion", query = "SELECT r FROM Rol r WHERE r.sDenominacion = :sDenominacion")})
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIdRol")
    private Integer nIdRol;
    @Size(max = 20)
    @Column(name = "sDenominacion")
    private String sDenominacion;
    @OneToMany(mappedBy = "nIdRol")
    private Collection<Usuario> usuarioCollection;

    public Rol() {
    }

    public Rol(Integer nIdRol) {
        this.nIdRol = nIdRol;
    }

    public Integer getNIdRol() {
        return nIdRol;
    }

    public void setNIdRol(Integer nIdRol) {
        this.nIdRol = nIdRol;
    }

    public String getSDenominacion() {
        return sDenominacion;
    }

    public void setSDenominacion(String sDenominacion) {
        this.sDenominacion = sDenominacion;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nIdRol != null ? nIdRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.nIdRol == null && other.nIdRol != null) || (this.nIdRol != null && !this.nIdRol.equals(other.nIdRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.registroauxiliar.entities.Rol[ nIdRol=" + nIdRol + " ]";
    }
    
}
