/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.facades;

import com.registroauxiliar.entities.Alumno;
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
public class AlumnoFacade extends AbstractFacade<Alumno> implements AlumnoFacadeLocal {
    @PersistenceContext(unitName = "REGISTROAUXILIAR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlumnoFacade() {
        super(Alumno.class);
    }
    
        @Override
    public Alumno findbyIdPersona(int idpersona) {
        System.out.println("entra");
        Alumno alumno = null;
        Query query = em.createNamedQuery("Alumno.findByNIdPersona");
        query.setParameter("nIdPersona", idpersona);

        if (!query.getResultList().isEmpty()) {
            alumno = (Alumno) query.getResultList().get(0);
        }
        return alumno;

    }

    @Override
    public List<Alumno> listarAlumnoNombre(String nombreCompleto) {
        Query query = em.createNamedQuery("Alumno.findByFiltroApeNomb");
        query.setParameter("sNombresCompletos", "%"+nombreCompleto+"%");
        List<Alumno> lstAlumnos = query.getResultList();
        return lstAlumnos;
    }
}
