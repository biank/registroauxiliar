package com.registroauxiliar.entities;

import com.registroauxiliar.entities.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-11-02T20:51:43")
@StaticMetamodel(Opciones.class)
public class Opciones_ { 

    public static volatile SingularAttribute<Opciones, Integer> nIdOpciones;
    public static volatile CollectionAttribute<Opciones, Rol> rolCollection;
    public static volatile SingularAttribute<Opciones, String> sDescripcion;
    public static volatile SingularAttribute<Opciones, String> sUrl;

}