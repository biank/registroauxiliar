package com.registroauxiliar.entities;

import com.registroauxiliar.entities.DetalleeventoPK;
import com.registroauxiliar.entities.Detallematricula;
import com.registroauxiliar.entities.Evento;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-11-02T20:51:43")
@StaticMetamodel(Detalleevento.class)
public class Detalleevento_ { 

    public static volatile SingularAttribute<Detalleevento, DetalleeventoPK> detalleeventoPK;
    public static volatile SingularAttribute<Detalleevento, Integer> nPeso;
    public static volatile SingularAttribute<Detalleevento, Detallematricula> detallematricula;
    public static volatile SingularAttribute<Detalleevento, Double> fNota;
    public static volatile SingularAttribute<Detalleevento, Evento> evento;

}