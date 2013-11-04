package com.registroauxiliar.entities;

import com.registroauxiliar.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-11-02T20:51:43")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> sTelefono;
    public static volatile SingularAttribute<Persona, String> sNombres;
    public static volatile CollectionAttribute<Persona, Usuario> usuarioCollection;
    public static volatile SingularAttribute<Persona, String> sApeMaterno;
    public static volatile SingularAttribute<Persona, String> nDocumento;
    public static volatile SingularAttribute<Persona, String> dFechaNacimiento;
    public static volatile SingularAttribute<Persona, Integer> nIdPersona;
    public static volatile SingularAttribute<Persona, String> sApePaterno;
    public static volatile SingularAttribute<Persona, String> sNombresCompletos;

}