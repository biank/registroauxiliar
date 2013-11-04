/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.facades;

import com.registroauxiliar.entities.Persona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Andrea
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> implements PersonaFacadeLocal {
    @PersistenceContext(unitName = "REGISTROAUXILIAR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
        @Override
    public Persona findbyIdPersona(int idpersona) {
    
        Persona persona = null;
        Query query = em.createNamedQuery("Persona.findByNIdPersona");
        query.setParameter("nIdPersona", idpersona);

        if (!query.getResultList().isEmpty()) {
            System.out.println("men sta devolvendo");
            persona = (Persona) query.getResultList().get(0);
        }
        return persona;

    }
}
