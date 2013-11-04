/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.filters;

import com.registroauxiliar.controller.LoginController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author planvital
 */
@WebFilter(servletNames="Faces Servlet")
public class FacesSessionFilter implements Filter{
   // private Logger log = Logger.getLogger(FacesSessionFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String uri = req.getRequestURI();        
        boolean usuarioLogueado = usuarioLogueado(req, session);        
        if (!uri.endsWith("/seguridad/frmLogin.jsf") && !usuarioLogueado) {
            res.sendRedirect(req.getContextPath() + "/");
        } else {
            if (usuarioLogueado && !tieneAceso(uri, req, session)) {
                int indice = req.getContextPath().length() + 1;
                req.setAttribute("uri", uri.substring(indice));
                req.getRequestDispatcher("/sin-acceso.jsf").forward(request, response);
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {
        
    }
    
    private boolean usuarioLogueado(HttpServletRequest request, HttpSession session) {
        String uri = request.getRequestURI();        
        if (sonImagenes(uri)) {
            return true;
        }        
        if (session == null) {
            return false;
        } else {
            LoginController login = (LoginController) session.getAttribute("loginController");
            if (uri.endsWith("homeDocente.jsf")||uri.endsWith("homeAlumno.jsf")) {                                
                login.setLogueadoAlu(false);
                login.setLogueadoDoc(false);
                blanquearTextos(login);
                return false;
            }
            if (login.getUsuario().isEmpty()){
               login.setLogueadoAlu(false);
                login.setLogueadoDoc(false);
                blanquearTextos(login);
                return false;
            }
        }
        return true;
    }
    
    private void blanquearTextos(LoginController login) {
        login.setUsuario("");
        login.setContrasena("");
    }
    
    private boolean tieneAceso(String uri, HttpServletRequest request, HttpSession session) {        
        if (sonImagenes(uri)) {
            return true;
        }
        
        if (uri.endsWith("/seguridad/frmLogin.jsf")) {
            return true;
        }
        LoginController login = (LoginController) session.getAttribute("loginController");
        List<String> urls = new ArrayList<String>();
        System.out.println("tiene acceso siiii");
        urls.add(request.getContextPath() + "/registro/frmRegistroAlumnos.jsf");
        urls.add(request.getContextPath() + "/citas/frmGestionarCitas.jsf");
        urls.add(request.getContextPath() + "/citas/frmDetalleCitaMasivo.jsf");
        urls.add(request.getContextPath() + "/consultas/frmAptitudes.jsf");
        urls.add(request.getContextPath() + "/consultas/frmTrazabilidad.jsf");
        urls.add(request.getContextPath() + "/test.html");
               
        if (!urls.contains(uri)) {            
            return false;
        }        
        return true;
    }
    
    private boolean sonImagenes(String uri) {
        if (uri.endsWith("js.jsf") || uri.endsWith("css.jsf") || uri.endsWith("png.jsf")) {
            return true;
        } else {
            return false;
        }        
        
    }
}
