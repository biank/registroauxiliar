/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.facades;

import com.registroauxiliar.entities.Opciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andrea
 */
@Stateless
public class OpcionesFacade extends AbstractFacade<Opciones> implements OpcionesFacadeLocal {
    @PersistenceContext(unitName = "REGISTROAUXILIAR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OpcionesFacade() {
        super(Opciones.class);
    }
    
}
