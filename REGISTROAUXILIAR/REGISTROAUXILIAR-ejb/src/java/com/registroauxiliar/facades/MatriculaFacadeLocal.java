/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.facades;

import com.registroauxiliar.entities.Matricula;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andrea
 */
@Local
public interface MatriculaFacadeLocal {

    void create(Matricula matricula);

    void edit(Matricula matricula);

    void remove(Matricula matricula);

    Matricula find(Object id);

    List<Matricula> findAll();

    List<Matricula> findRange(int[] range);

    int count();
    public List<Matricula> listarCursosPorDocente(int idDocente);
    public Matricula encontrarIdMatricula(int curso, int docente);
}
