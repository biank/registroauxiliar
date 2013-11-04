package com.registroauxiliar.entities;

import com.registroauxiliar.entities.Matricula;
import com.registroauxiliar.entities.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-11-02T20:51:43")
@StaticMetamodel(Docente.class)
public class Docente_ { 

    public static volatile SingularAttribute<Docente, Integer> nIdDocente;
    public static volatile CollectionAttribute<Docente, Matricula> matriculaCollection;
    public static volatile SingularAttribute<Docente, String> sCodigo;
    public static volatile SingularAttribute<Docente, Persona> nIdPersona;

}