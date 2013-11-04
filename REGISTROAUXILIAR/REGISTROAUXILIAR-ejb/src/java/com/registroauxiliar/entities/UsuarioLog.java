/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrea
 */
@Entity
@Table(name = "USUARIO_LOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioLog.findAll", query = "SELECT u FROM UsuarioLog u"),
    @NamedQuery(name = "UsuarioLog.findByNIdLog", query = "SELECT u FROM UsuarioLog u WHERE u.nIdLog = :nIdLog"),
    @NamedQuery(name = "UsuarioLog.findByNIdUsuario", query = "SELECT u FROM UsuarioLog u WHERE u.nIdUsuario.nIdUsuario = :nIdUsuario and u.dFechaLog = :dFechaLog ORDER BY u.dFechaLog"),
    @NamedQuery(name = "UsuarioLog.findByDFechaLog", query = "SELECT u FROM UsuarioLog u WHERE u.dFechaLog = :dFechaLog")})
public class UsuarioLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nIdLog")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer nIdLog;
    @Column(name = "dFechaLog")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dFechaLog;
    @JoinColumn(name = "nIdUsuario", referencedColumnName = "nIdUsuario")
    @ManyToOne
    private Usuario nIdUsuario;

    public UsuarioLog() {
    }

    public UsuarioLog(Integer nIdLog) {
        this.nIdLog = nIdLog;
    }

    public Integer getNIdLog() {
        return nIdLog;
    }

    public void setNIdLog(Integer nIdLog) {
        this.nIdLog = nIdLog;
    }

    public Date getDFechaLog() {
        return dFechaLog;
    }

    public void setDFechaLog(Date dFechaLog) {
        this.dFechaLog = dFechaLog;
    }

    public Usuario getNIdUsuario() {
        return nIdUsuario;
    }

    public void setNIdUsuario(Usuario nIdUsuario) {
        this.nIdUsuario = nIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nIdLog != null ? nIdLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioLog)) {
            return false;
        }
        UsuarioLog other = (UsuarioLog) object;
        if ((this.nIdLog == null && other.nIdLog != null) || (this.nIdLog != null && !this.nIdLog.equals(other.nIdLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.registroauxiliar.entities.UsuarioLog[ nIdLog=" + nIdLog + " ]";
    }
    
}
