package com.registroauxiliar.entities;

import com.registroauxiliar.entities.Alumno;
import com.registroauxiliar.entities.Detalleevento;
import com.registroauxiliar.entities.DetallematriculaPK;
import com.registroauxiliar.entities.Matricula;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-11-02T20:51:43")
@StaticMetamodel(Detallematricula.class)
public class Detallematricula_ { 

    public static volatile SingularAttribute<Detallematricula, Integer> bEstado;
    public static volatile CollectionAttribute<Detallematricula, Detalleevento> detalleeventoCollection;
    public static volatile SingularAttribute<Detallematricula, Alumno> alumno;
    public static volatile SingularAttribute<Detallematricula, DetallematriculaPK> detallematriculaPK;
    public static volatile SingularAttribute<Detallematricula, Matricula> matricula;

}