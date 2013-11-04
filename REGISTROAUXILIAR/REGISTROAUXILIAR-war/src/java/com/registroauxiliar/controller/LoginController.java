package com.registroauxiliar.controller;

import com.registroauxiliar.entities.Persona;
import com.registroauxiliar.entities.Usuario;
import com.registroauxiliar.entities.UsuarioLog;
import com.registroauxiliar.facades.PersonaFacadeLocal;
import com.registroauxiliar.facades.UsuarioFacadeLocal;
import com.registroauxiliar.util.Constantes;
import com.registroauxiliar.util.Utilitarios;
import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "loginController")
@SessionScoped

public class LoginController implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    @EJB
    private PersonaFacadeLocal personaFacade;
    static final Logger log = Logger.getLogger(LoginController.class);
    private String usuario = "";
    private String contrasena = "";
    private String usuarioNombre = "";
    private int idUsuario;
    private boolean logueadoDoc = false;
    private boolean logueadoAlu = false;
    Persona persona;

    public LoginController() {
    }

    public String login() {
        RequestContext context = RequestContext.getCurrentInstance();
        Usuario user = usuarioFacade.findNombreUsuario(usuario);                
            if (user != null) {
                usuarioFacade.addLog(user, Utilitarios.obtenerFechaServidor());
                List<UsuarioLog> lista = usuarioFacade.findByUserName(user.getNIdUsuario());
                Integer nCantIntentos=0;
                if(!lista.isEmpty()){
                    nCantIntentos = lista.size();
                }
                if (nCantIntentos <= Constantes.NUMERO_ITENTOS_FALLIDOS) {
                    user = usuarioFacade.findUsuario(usuario, contrasena);    
                    System.out.println("no ");
                    if (user != null) {                        
                        persona = personaFacade.findbyIdPersona(user.getNIdPersona().getNIdPersona());
                        System.out.println("hasta aqui todo ok");
                        System.out.println("persona.getSNombresCompletos():"+persona.getSNombresCompletos());
                        this.usuarioNombre = persona.getSNombresCompletos();                    
                        if (user.getNIdRol().getNIdRol() == 2) {
                            this.logueadoDoc = true;
                            System.out.println("entra a docente");
                            return "/homeDocente";
                        } else {

                            this.logueadoAlu = true;
                            return "/homeAlumno";
                        }
                    } else {
                        context.execute("dlgValidaLoginContrasena.show()");
                        return null;
                    }
                } else{
                    context.execute("dlgbloquear.show()");
                    return null;
                }
                //      return redireccionar(user.getNIdRol());
            } else {
                context.execute("dlgValidaLogin.show()");
                return null;
            }
    }
   
    

    public String cerrarSesion() {
        logueadoAlu = false;
        logueadoDoc = false;
        usuario = "";
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "";
    }

    public String getContrasena() {
        return contrasena;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isLogueadoAlu() {
        return logueadoAlu;
    }

    public void setLogueadoAlu(boolean logueadoAlu) {
        this.logueadoAlu = logueadoAlu;
    }

    public boolean isLogueadoDoc() {
        return logueadoDoc;
    }

    public void setLogueadoDoc(boolean logueadoDoc) {
        this.logueadoDoc = logueadoDoc;
    }



    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public UsuarioFacadeLocal getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacadeLocal usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public PersonaFacadeLocal getPersonaFacade() {
        return personaFacade;
    }

    public void setPersonaFacade(PersonaFacadeLocal personaFacade) {
        this.personaFacade = personaFacade;
    }
}
