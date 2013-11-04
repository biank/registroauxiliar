package com.registroauxiliar.entities;

import com.registroauxiliar.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-11-02T20:51:43")
@StaticMetamodel(UsuarioLog.class)
public class UsuarioLog_ { 

    public static volatile SingularAttribute<UsuarioLog, Date> dFechaLog;
    public static volatile SingularAttribute<UsuarioLog, Usuario> nIdUsuario;
    public static volatile SingularAttribute<UsuarioLog, Integer> nIdLog;

}