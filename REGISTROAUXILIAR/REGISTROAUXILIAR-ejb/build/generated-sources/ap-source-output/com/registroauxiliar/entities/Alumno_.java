package com.registroauxiliar.entities;

import com.registroauxiliar.entities.Detallematricula;
import com.registroauxiliar.entities.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-11-02T20:51:43")
@StaticMetamodel(Alumno.class)
public class Alumno_ { 

    public static volatile SingularAttribute<Alumno, String> nCodigo;
    public static volatile CollectionAttribute<Alumno, Detallematricula> detallematriculaCollection;
    public static volatile SingularAttribute<Alumno, Integer> nIdAlumno;
    public static volatile SingularAttribute<Alumno, String> sPlanEstudio;
    public static volatile SingularAttribute<Alumno, Persona> nIdPersona;

}