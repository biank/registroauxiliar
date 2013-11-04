package com.registroauxiliar.entities;

import com.registroauxiliar.entities.Persona;
import com.registroauxiliar.entities.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-11-02T20:51:43")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> sNombre;
    public static volatile SingularAttribute<Usuario, Rol> nIdRol;
    public static volatile SingularAttribute<Usuario, Integer> nIdUsuario;
    public static volatile SingularAttribute<Usuario, String> sContrasena;
    public static volatile SingularAttribute<Usuario, Persona> nIdPersona;

}