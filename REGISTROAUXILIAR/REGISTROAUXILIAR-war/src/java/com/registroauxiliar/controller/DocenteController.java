/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.controller;
import com.registroauxiliar.entities.Docente;
import com.registroauxiliar.facades.DocenteFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Andrea
 */
@ManagedBean(name = "docenteController")
@ViewScoped
public class DocenteController {
    protected String codigo;
    protected String nombre;
    protected int idpersona;
    protected int iddocente;
   protected int nombreCompletos;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected String nombres;
    protected String telefono;
    protected String documento;
    protected String fechaNacimiento;  
    Docente docente;
    @ManagedProperty(value = "#{loginController}")
    public LoginController loginController;
    
    @EJB
    private DocenteFacadeLocal docenteFacade;

        @PostConstruct
        
    public void init() {
        buscarPersona() ;
    }
    public DocenteFacadeLocal getDocenteFacade() {
        return docenteFacade;
    }
    public void setDocenteFacade(DocenteFacadeLocal docenteFacade) {
        this.docenteFacade = docenteFacade;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getIddocente() {
        return iddocente;
    }

    public void setIddocente(int iddocente) {
        this.iddocente = iddocente;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getNombreCompletos() {
        return nombreCompletos;
    }

    public void setNombreCompletos(int nombreCompletos) {
        this.nombreCompletos = nombreCompletos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
    
    public void buscarPersona() {
        apellidoPaterno =  getLoginController().getPersona().getSApePaterno();
        apellidoMaterno = getLoginController().getPersona().getSApeMaterno();
        nombres = getLoginController().getPersona().getSNombres();
        fechaNacimiento = getLoginController().getPersona().getDFechaNacimiento();
        documento = getLoginController().getPersona().getNDocumento();
        telefono = getLoginController().getPersona().getSTelefono();
        idpersona= getLoginController().getPersona().getNIdPersona();
        docente = docenteFacade.findbyIdPersona(getLoginController().getPersona().getNIdPersona());
        System.out.println("devuelve");
        codigo = docente.getSCodigo(); 
    }
     
     

}
