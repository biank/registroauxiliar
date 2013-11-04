/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.facades;

import com.registroauxiliar.entities.Detallematricula;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andrea
 */
@Local
public interface DetallematriculaFacadeLocal {

    void create(Detallematricula detallematricula);

    void edit(Detallematricula detallematricula);

    void remove(Detallematricula detallematricula);

    Detallematricula find(Object id);

    List<Detallematricula> findAll();

    List<Detallematricula> findRange(int[] range);

    int count();
    public List<Detallematricula> listarCursosPorDocenteCurso(int idMatricula);
}
