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
@Table(name = "CURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByNIdCurso", query = "SELECT c FROM Curso c WHERE c.nIdCurso = :nIdCurso"),
    @NamedQuery(name = "Curso.findBySDescripcion", query = "SELECT c FROM Curso c WHERE c.sDescripcion = :sDescripcion"),
    @NamedQuery(name = "Curso.findBySCodigo", query = "SELECT c FROM Curso c WHERE c.sCodigo = :sCodigo")})
public class Curso implements Serializable {
    @OneToMany(mappedBy = "nIdCurso")
    private Collection<Matricula> matriculaCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIdCurso")
    private Integer nIdCurso;
    @Size(max = 30)
    @Column(name = "sDescripcion")
    private String sDescripcion;
    @Size(max = 30)
    @Column(name = "sCodigo")
    private String sCodigo;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "bEstado")
    private String bEstado;

    public Curso() {
    }

    public Curso(Integer nIdCurso) {
        this.nIdCurso = nIdCurso;
    }

    public Integer getNIdCurso() {
        return nIdCurso;
    }

    public void setNIdCurso(Integer nIdCurso) {
        this.nIdCurso = nIdCurso;
    }

    public String getSDescripcion() {
        return sDescripcion;
    }

    public void setSDescripcion(String sDescripcion) {
        this.sDescripcion = sDescripcion;
    }

    public String getSCodigo() {
        return sCodigo;
    }

    public void setSCodigo(String sCodigo) {
        this.sCodigo = sCodigo;
    }

    public String getBEstado() {
        return bEstado;
    }

    public void setBEstado(String bEstado) {
        this.bEstado = bEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nIdCurso != null ? nIdCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.nIdCurso == null && other.nIdCurso != null) || (this.nIdCurso != null && !this.nIdCurso.equals(other.nIdCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.registroauxiliar.entities.Curso[ nIdCurso=" + nIdCurso + " ]";
    }

    @XmlTransient
    public Collection<Matricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
    }
    
}
