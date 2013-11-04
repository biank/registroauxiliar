/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.facades;

import com.registroauxiliar.entities.Docente;
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
public class DocenteFacade extends AbstractFacade<Docente> implements DocenteFacadeLocal {
    @PersistenceContext(unitName = "REGISTROAUXILIAR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocenteFacade() {
        super(Docente.class);
    }
        @Override
    public Docente findbyIdPersona(int idpersona) {        
        Docente docente = null;
        Query query = em.createNamedQuery("Docente.findByNIdPersona");        
        query.setParameter("nIdPersona", idpersona);
        List<Docente> lstDocente = query.getResultList();        
        if (lstDocente != null) {
            if (lstDocente.size() > 0) {
                docente = lstDocente.get(0);
            }
        }
        return docente;
    }
}
