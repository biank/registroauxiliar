/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.facades;

import com.registroauxiliar.entities.Matricula;
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
public class MatriculaFacade extends AbstractFacade<Matricula> implements MatriculaFacadeLocal {
    @PersistenceContext(unitName = "REGISTROAUXILIAR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatriculaFacade() {
        super(Matricula.class);
    }
     @Override
    public List<Matricula> listarCursosPorDocente(int idDocente){
        Query query = em.createNamedQuery("Matricula.findByNIdDocente");
        query.setParameter("nIdDocente",idDocente);
        List<Matricula> lstCursos=query.getResultList();        
        return lstCursos;
    }
     @Override
    public Matricula encontrarIdMatricula(int curso, int docente){
        Matricula usuario = null;
        Query query = em.createNamedQuery("Matricula.findByNIdDocenteCurso");
        query.setParameter("nIdDocente",docente);
        query.setParameter("nIdCurso",curso);        
        if (!query.getResultList().isEmpty()) {
            usuario = (Matricula) query.getResultList().get(0);
        }
        return usuario;    
    }
}
