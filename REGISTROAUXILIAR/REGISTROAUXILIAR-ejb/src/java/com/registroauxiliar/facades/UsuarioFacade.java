/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.facades;

import com.registroauxiliar.entities.Usuario;
import com.registroauxiliar.entities.UsuarioLog;
import java.util.Date;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Andrea
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {
    @PersistenceContext(unitName = "REGISTROAUXILIAR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    @Override
    public Usuario findUsuario(String sUsername, String sPassword) {
        Usuario usuario = null;
        Query query = em.createNamedQuery("Usuario.findBySUsernameSPassword");
        query.setParameter("sNombre", sUsername);
        query.setParameter("sContrasena", sPassword);
        if (!query.getResultList().isEmpty()) {
            usuario = (Usuario) query.getResultList().get(0);
        }
        return usuario;
    } 

    @Override
    public Usuario findNombreUsuario(String sUsername) {
        Usuario usuario = null;
        Query query = em.createNamedQuery("Usuario.findBySNombre");
        query.setParameter("sNombre", sUsername);    
        if (!query.getResultList().isEmpty()) {
            usuario = (Usuario) query.getResultList().get(0);
        }
        return usuario;
    }
    @Override
    public void addLog(Usuario usuario, Date fechaActual){
        UsuarioLog log = new UsuarioLog();
        log.setDFechaLog(fechaActual);
        log.setNIdUsuario(usuario);
        try {
            em.persist(log);
        } catch (Exception e) {
            System.out.println("Error en addLog:"+e.getMessage());
        }
    }
    @Override
    public List<UsuarioLog> findByUserName(Integer nIdUsuario){
        Query query = em.createNamedQuery("UsuarioLog.findByNIdUsuario");
        query.setParameter("nIdUsuario", nIdUsuario);
        query.setParameter("dFechaLog", new Date());        
        List<UsuarioLog> lista= query.getResultList();
        return lista;
    }
}
