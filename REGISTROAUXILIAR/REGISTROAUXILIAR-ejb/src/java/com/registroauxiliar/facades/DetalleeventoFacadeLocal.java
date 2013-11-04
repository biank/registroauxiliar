/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.facades;

import com.registroauxiliar.entities.Detalleevento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andrea
 */
@Local
public interface DetalleeventoFacadeLocal {

    void create(Detalleevento detalleevento);

    void edit(Detalleevento detalleevento);

    void remove(Detalleevento detalleevento);

    Detalleevento find(Object id);

    List<Detalleevento> findAll();

    List<Detalleevento> findRange(int[] range);

    int count();
    
}
