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
@Table(name = "OPCIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opciones.findAll", query = "SELECT o FROM Opciones o"),
    @NamedQuery(name = "Opciones.findByNIdOpciones", query = "SELECT o FROM Opciones o WHERE o.nIdOpciones = :nIdOpciones"),
    @NamedQuery(name = "Opciones.findBySUrl", query = "SELECT o FROM Opciones o WHERE o.sUrl = :sUrl"),
    @NamedQuery(name = "Opciones.findBySDescripcion", query = "SELECT o FROM Opciones o WHERE o.sDescripcion = :sDescripcion")})
public class Opciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIdOpciones")
    private Integer nIdOpciones;
    @Size(max = 20)
    @Column(name = "sUrl")
    private String sUrl;
    @Size(max = 20)
    @Column(name = "sDescripcion")
    private String sDescripcion;
    @JoinTable(name = "ACCESO", joinColumns = {
        @JoinColumn(name = "nIdOpciones", referencedColumnName = "nIdOpciones")}, inverseJoinColumns = {
        @JoinColumn(name = "nIdRol", referencedColumnName = "nIdRol")})
    @ManyToMany
    private Collection<Rol> rolCollection;

    public Opciones() {
    }

    public Opciones(Integer nIdOpciones) {
        this.nIdOpciones = nIdOpciones;
    }

    public Integer getNIdOpciones() {
        return nIdOpciones;
    }

    public void setNIdOpciones(Integer nIdOpciones) {
        this.nIdOpciones = nIdOpciones;
    }

    public String getSUrl() {
        return sUrl;
    }

    public void setSUrl(String sUrl) {
        this.sUrl = sUrl;
    }

    public String getSDescripcion() {
        return sDescripcion;
    }

    public void setSDescripcion(String sDescripcion) {
        this.sDescripcion = sDescripcion;
    }

    @XmlTransient
    public Collection<Rol> getRolCollection() {
        return rolCollection;
    }

    public void setRolCollection(Collection<Rol> rolCollection) {
        this.rolCollection = rolCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nIdOpciones != null ? nIdOpciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opciones)) {
            return false;
        }
        Opciones other = (Opciones) object;
        if ((this.nIdOpciones == null && other.nIdOpciones != null) || (this.nIdOpciones != null && !this.nIdOpciones.equals(other.nIdOpciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.registroauxiliar.entities.Opciones[ nIdOpciones=" + nIdOpciones + " ]";
    }
    
}
