/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.facades;

import com.registroauxiliar.entities.Detallematricula;
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
public class DetallematriculaFacade extends AbstractFacade<Detallematricula> implements DetallematriculaFacadeLocal {
    @PersistenceContext(unitName = "REGISTROAUXILIAR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallematriculaFacade() {
        super(Detallematricula.class);
    }
    
    @Override
      public List<Detallematricula> listarCursosPorDocenteCurso(int idMatricula){  
         System.out.println("no entra");
         System.out.println("nIdMatricula:"+idMatricula);
        Query query = em.createNamedQuery("Detallematricula.findByNIdMatricula");
         System.out.println("no entra");
         
        query.setParameter("nIdMatricula",idMatricula);
         System.out.println("no entra");
         List<Detallematricula> lstDeMatricula=query.getResultList();
         System.out.println("no entra");
        return lstDeMatricula;
      }

}
