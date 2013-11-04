/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.facades;

import com.registroauxiliar.entities.Alumno;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andrea
 */
@Local
public interface AlumnoFacadeLocal {

    void create(Alumno alumno);

    void edit(Alumno alumno);

    void remove(Alumno alumno);

    Alumno find(Object id);

    List<Alumno> findAll();

    List<Alumno> findRange(int[] range);

    int count();
    
    public Alumno findbyIdPersona(int idpersona);
    public List<Alumno> listarAlumnoNombre(String nombreCompleto);
}
