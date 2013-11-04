/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.facades;

import com.registroauxiliar.entities.Usuario;
import com.registroauxiliar.entities.UsuarioLog;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andrea
 */
@Local
public interface UsuarioFacadeLocal {

    
    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();
    public Usuario findUsuario(String sUsername, String sPassword);
    public Usuario findNombreUsuario(String sUsername) ;
    public void addLog(Usuario usuario, Date fechaActual);
    public List<UsuarioLog> findByUserName(Integer nIdUsuario);
    
}
