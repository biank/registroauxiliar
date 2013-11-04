/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrea
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findBySNombre", query = "SELECT u FROM Usuario u WHERE u.sNombre = :sNombre"),
    @NamedQuery(name = "Usuario.findByNIdRol", query = "SELECT u FROM Usuario u WHERE u.nIdRol = :nIdRol"),
    @NamedQuery(name = "Usuario.findBySUsernameSPassword", query = "SELECT u FROM Usuario u WHERE u.sContrasena = :sContrasena AND u.sNombre = :sNombre"),
    @NamedQuery(name = "Usuario.findBySContrasena", query = "SELECT u FROM Usuario u WHERE u.sContrasena = :sContrasena"),
    @NamedQuery(name = "Usuario.findByNIdUsuario", query = "SELECT u FROM Usuario u WHERE u.nIdUsuario = :nIdUsuario")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "sNombre")
    private String sNombre;
    @Size(max = 20)
    @Column(name = "sContrasena")
    private String sContrasena;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIdUsuario")
    private Integer nIdUsuario;
    @JoinColumn(name = "nIdRol", referencedColumnName = "nIdRol")
    @ManyToOne
    private Rol nIdRol;
    @JoinColumn(name = "nIdPersona", referencedColumnName = "nIdPersona")
    @ManyToOne
    private Persona nIdPersona;

    public Usuario() {
    }

    public Usuario(Integer nIdUsuario) {
        this.nIdUsuario = nIdUsuario;
    }

    public Usuario(Integer nIdUsuario, String sNombre) {
        this.nIdUsuario = nIdUsuario;
        this.sNombre = sNombre;
    }

    public String getSNombre() {
        return sNombre;
    }

    public void setSNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getSContrasena() {
        return sContrasena;
    }

    public void setSContrasena(String sContrasena) {
        this.sContrasena = sContrasena;
    }

    public Integer getNIdUsuario() {
        return nIdUsuario;
    }

    public void setNIdUsuario(Integer nIdUsuario) {
        this.nIdUsuario = nIdUsuario;
    }

    public Rol getNIdRol() {
        return nIdRol;
    }

    public void setNIdRol(Rol nIdRol) {
        this.nIdRol = nIdRol;
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
        hash += (nIdUsuario != null ? nIdUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.nIdUsuario == null && other.nIdUsuario != null) || (this.nIdUsuario != null && !this.nIdUsuario.equals(other.nIdUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.registroauxiliar.entities.Usuario[ nIdUsuario=" + nIdUsuario + " ]";
    }
    
}
