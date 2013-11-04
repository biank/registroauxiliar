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
@Table(name = "PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByNIdPersona", query = "SELECT p FROM Persona p WHERE p.nIdPersona = :nIdPersona"),
    @NamedQuery(name = "Persona.findBySNombres", query = "SELECT p FROM Persona p WHERE p.sNombres = :sNombres"),
    @NamedQuery(name = "Persona.findBySApePaterno", query = "SELECT p FROM Persona p WHERE p.sApePaterno = :sApePaterno"),
    @NamedQuery(name = "Persona.findBySApeMaterno", query = "SELECT p FROM Persona p WHERE p.sApeMaterno = :sApeMaterno"),
    @NamedQuery(name = "Persona.findBySNombresCompletos", query = "SELECT p FROM Persona p WHERE p.sNombresCompletos = :sNombresCompletos"),
    @NamedQuery(name = "Persona.findBySTelefono", query = "SELECT p FROM Persona p WHERE p.sTelefono = :sTelefono"),
    @NamedQuery(name = "Persona.findByNDocumento", query = "SELECT p FROM Persona p WHERE p.nDocumento = :nDocumento"),
    @NamedQuery(name = "Persona.findByDFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.dFechaNacimiento = :dFechaNacimiento")})
public class Persona implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nIdPersona")
    private Collection<Alumno> alumnoCollection;
    @OneToMany(mappedBy = "nIdPersona")
    private Collection<Docente> docenteCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIdPersona")
    private Integer nIdPersona;
    @Size(max = 18)
    @Column(name = "sNombres")
    private String sNombres;
    @Size(max = 18)
    @Column(name = "sApePaterno")
    private String sApePaterno;
    @Size(max = 18)
    @Column(name = "sApeMaterno")
    private String sApeMaterno;
    @Size(max = 18)
    @Column(name = "sNombresCompletos")
    private String sNombresCompletos;
    @Size(max = 18)
    @Column(name = "sTelefono")
    private String sTelefono;
    @Size(max = 18)
    @Column(name = "nDocumento")
    private String nDocumento;
    @Size(max = 18)
    @Column(name = "dFechaNacimiento")
    private String dFechaNacimiento;
    @OneToMany(mappedBy = "nIdPersona")
    private Collection<Usuario> usuarioCollection;

    public Persona() {
    }

    public Persona(Integer nIdPersona) {
        this.nIdPersona = nIdPersona;
    }

    public Integer getNIdPersona() {
        return nIdPersona;
    }

    public void setNIdPersona(Integer nIdPersona) {
        this.nIdPersona = nIdPersona;
    }

    public String getSNombres() {
        return sNombres;
    }

    public void setSNombres(String sNombres) {
        this.sNombres = sNombres;
    }

    public String getSApePaterno() {
        return sApePaterno;
    }

    public void setSApePaterno(String sApePaterno) {
        this.sApePaterno = sApePaterno;
    }

    public String getSApeMaterno() {
        return sApeMaterno;
    }

    public void setSApeMaterno(String sApeMaterno) {
        this.sApeMaterno = sApeMaterno;
    }

    public String getSNombresCompletos() {
        return sNombresCompletos;
    }

    public void setSNombresCompletos(String sNombresCompletos) {
        this.sNombresCompletos = sNombresCompletos;
    }

    public String getSTelefono() {
        return sTelefono;
    }

    public void setSTelefono(String sTelefono) {
        this.sTelefono = sTelefono;
    }

    public String getNDocumento() {
        return nDocumento;
    }

    public void setNDocumento(String nDocumento) {
        this.nDocumento = nDocumento;
    }

    public String getDFechaNacimiento() {
        return dFechaNacimiento;
    }

    public void setDFechaNacimiento(String dFechaNacimiento) {
        this.dFechaNacimiento = dFechaNacimiento;
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
        hash += (nIdPersona != null ? nIdPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.nIdPersona == null && other.nIdPersona != null) || (this.nIdPersona != null && !this.nIdPersona.equals(other.nIdPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.registroauxiliar.entities.Persona[ nIdPersona=" + nIdPersona + " ]";
    }

    @XmlTransient
    public Collection<Alumno> getAlumnoCollection() {
        return alumnoCollection;
    }

    public void setAlumnoCollection(Collection<Alumno> alumnoCollection) {
        this.alumnoCollection = alumnoCollection;
    }

    @XmlTransient
    public Collection<Docente> getDocenteCollection() {
        return docenteCollection;
    }

    public void setDocenteCollection(Collection<Docente> docenteCollection) {
        this.docenteCollection = docenteCollection;
    }
    
}
