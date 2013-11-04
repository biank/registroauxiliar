package com.registroauxiliar.entities;

import com.registroauxiliar.entities.Detalleevento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-11-02T20:51:43")
@StaticMetamodel(Evento.class)
public class Evento_ { 

    public static volatile CollectionAttribute<Evento, Detalleevento> detalleeventoCollection;
    public static volatile SingularAttribute<Evento, String> sDescripcion;
    public static volatile SingularAttribute<Evento, Date> dFechaCreacion;
    public static volatile SingularAttribute<Evento, Date> dFechaInicioPresentacion;
    public static volatile SingularAttribute<Evento, Date> dFechaFinPresentacion;
    public static volatile SingularAttribute<Evento, Integer> nIdEvento;

}