package com.registroauxiliar.entities;

import com.registroauxiliar.entities.Curso;
import com.registroauxiliar.entities.Detallematricula;
import com.registroauxiliar.entities.Docente;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-11-02T20:51:43")
@StaticMetamodel(Matricula.class)
public class Matricula_ { 

    public static volatile SingularAttribute<Matricula, Integer> nIdMatricula;
    public static volatile SingularAttribute<Matricula, Docente> nIdDocente;
    public static volatile CollectionAttribute<Matricula, Detallematricula> detallematriculaCollection;
    public static volatile SingularAttribute<Matricula, Curso> nIdCurso;

}