/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.facades;

import com.registroauxiliar.entities.Opciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andrea
 */
@Local
public interface OpcionesFacadeLocal {

    void create(Opciones opciones);

    void edit(Opciones opciones);

    void remove(Opciones opciones);

    Opciones find(Object id);

    List<Opciones> findAll();

    List<Opciones> findRange(int[] range);

    int count();
    
}
