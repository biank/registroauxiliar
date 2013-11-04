/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.facades;

import com.registroauxiliar.entities.Curso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andrea
 */
@Local
public interface CursoFacadeLocal {

    void create(Curso curso);

    void edit(Curso curso);

    void remove(Curso curso);

    Curso find(Object id);

    List<Curso> findAll();

    List<Curso> findRange(int[] range);

    int count();
    
}
