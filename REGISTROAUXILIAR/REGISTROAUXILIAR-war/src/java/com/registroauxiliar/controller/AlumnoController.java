/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.controller;

import com.registroauxiliar.entities.Alumno;
import com.registroauxiliar.facades.AlumnoFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "alumnoController")
@ViewScoped
public class AlumnoController {

    protected String codigo;
    protected String nombre;
    protected int idpersona;
    protected int iddocente;
    protected String nombreCompletos;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected String nombres;
    protected String telefono;
    protected String documento;
    protected String fechaNacimiento;
    protected Alumno selectedAlumno;
    
    @ManagedProperty(value = "#{loginController}")
    public LoginController loginController;
    protected String planEstudio;
    @EJB
    private AlumnoFacadeLocal alumnoFacade;
    protected List<Alumno>  lstalumno = new ArrayList<Alumno>();

    @PostConstruct
    public void init() {
        if(getLoginController().isLogueadoAlu()){
            buscarPersona();
        }
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public Alumno getSelectedAlumno() {
        return selectedAlumno;
    }

    public void setSelectedAlumno(Alumno selectedAlumno) {
        this.selectedAlumno = selectedAlumno;
    }

    public void buscarPersona() {
        
        apellidoPaterno = getLoginController().getPersona().getSApePaterno();
        apellidoMaterno = getLoginController().getPersona().getSApeMaterno();
        nombres = getLoginController().getPersona().getSNombres();
        fechaNacimiento = getLoginController().getPersona().getDFechaNacimiento();
        documento = getLoginController().getPersona().getNDocumento();
        telefono = getLoginController().getPersona().getSTelefono();
        idpersona = getLoginController().getPersona().getNIdPersona();
        Alumno alumno = alumnoFacade.findbyIdPersona(getLoginController().getPersona().getNIdPersona());
        System.out.println("devuelve");
        codigo = alumno.getNCodigo();
        planEstudio = alumno.getSPlanEstudio();
        nombreCompletos="";

    }

    public String getPlanEstudio() {
        return planEstudio;
    }

    public void setPlanEstudio(String planEstudio) {
        this.planEstudio = planEstudio;
    }

    public AlumnoFacadeLocal getAlumnoFacade() {
        return alumnoFacade;
    }

    public void setAlumnoFacade(AlumnoFacadeLocal alumnoFacade) {
        this.alumnoFacade = alumnoFacade;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getNombreCompletos() {
        return nombreCompletos;
    }

    public void setNombreCompletos(String nombreCompletos) {
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

    public List<Alumno> filtrar() {
        //log.info("Filtrando clientes");

        
        lstalumno = alumnoFacade.listarAlumnoNombre(this.nombreCompletos);        
        return this.lstalumno;
    }

    public List<Alumno> getLstalumno() {
        return lstalumno;
    }

    public void setLstalumno(List<Alumno> lstalumno) {
        this.lstalumno = lstalumno;
    }
    
    
}
