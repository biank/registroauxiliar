/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroauxiliar.controller;

import com.registroauxiliar.entities.*;
import com.registroauxiliar.facades.DetallematriculaFacade;
import com.registroauxiliar.facades.DetallematriculaFacadeLocal;
import com.registroauxiliar.facades.MatriculaFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.ViewScoped;

/**
 *
 * @author Andrea
 */
@ManagedBean(name = "matriculaController")
@ViewScoped
public class MatriculaController {

    protected List<Alumno> lstalumno;
    protected List<Curso> lstacurso = new ArrayList<Curso>();
    @ManagedProperty(value = "#{docenteController}")
    public DocenteController docenteController;
    protected Docente docente;
    protected Curso selectedCurso;
    protected Alumno selectedAlumno;
    @EJB
    private MatriculaFacadeLocal matriculafacade;
    @EJB
    private DetallematriculaFacadeLocal detallematriculafacade;
    String cursoFiltro;
    protected List<Matricula> lstMatricula;
    protected List<Detallematricula> lstDetalleMatricula;
    protected int idCurso = -1;
    protected boolean esNuevo = false;
    private DetallematriculaPK detallematriculapk;

    @PostConstruct
    public void init() {

        docente = docenteController.getDocente();
        System.out.println("llega asqui");
        /*
  º       * lstacurso=matriculafacade.listarCursosPorDocente(docente.getNIdDocente());
         * System.out.println("lstacurso.size():"+lstacurso.size()); for(int
         * i=0;i<lstacurso.size();i++){
         * System.out.println("lst:"+lstacurso.get(i).getSDescripcion()); }
         */ docente = docenteController.getDocente();
        System.out.println("llega asqui");
        lstMatricula = matriculafacade.listarCursosPorDocente(docente.getNIdDocente());
        int indice = 0;
        for (int i = 0; i < lstMatricula.size(); i++) {
            lstacurso.add(lstMatricula.get(i).getNIdCurso());
            indice++;
        }

        System.out.println("excellent");
    }

    public DetallematriculaPK getDetallematriculapk() {
        return detallematriculapk;
    }

    public void setDetallematriculapk(DetallematriculaPK detallematriculapk) {
        this.detallematriculapk = detallematriculapk;
    }

    public DetallematriculaFacadeLocal getDetallematriculafacade() {
        return detallematriculafacade;
    }

    public void setDetallematriculafacade(DetallematriculaFacadeLocal detallematriculafacade) {
        this.detallematriculafacade = detallematriculafacade;
    }

    public List<Detallematricula> getLstDetalleMatricula() {
        return lstDetalleMatricula;
    }

    public void setLstDetalleMatricula(List<Detallematricula> lstDetalleMatricula) {
        this.lstDetalleMatricula = lstDetalleMatricula;
    }

    public DetallematriculaFacadeLocal getDetallematricula() {
        return detallematriculafacade;
    }

    public void setDetallematricula(DetallematriculaFacadeLocal detallematricula) {
        this.detallematriculafacade = detallematricula;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public boolean isEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

    public void cancelar() {
        //log.info("Cancelando selección de cliente--");
        this.setEsNuevo(false);
        this.setSelectedAlumno(null);
    }

    public List<Matricula> getLstMatricula() {
        return lstMatricula;
    }

    public void setLstMatricula(List<Matricula> lstMatricula) {
        this.lstMatricula = lstMatricula;
    }

    public Alumno getSelectedAlumno() {
        return selectedAlumno;
    }

    public void setSelectedAlumno(Alumno selectedAlumno) {
        this.selectedAlumno = selectedAlumno;
    }

    public List<Alumno> filtrar() {
        //log.info("Filtrando clientes");

        lstalumno = new ArrayList<Alumno>();
        Matricula matri = matriculafacade.encontrarIdMatricula(idCurso, this.docente.getNIdDocente());
        if (matri != null) {
            int idmatricuka = matri.getNIdMatricula();
            System.out.println("idmatricuka:" + idmatricuka);
            lstDetalleMatricula = detallematriculafacade.listarCursosPorDocenteCurso(idmatricuka);
            System.out.println("lstDetalleMatricula:" + lstDetalleMatricula.size());
            for (int i = 0; i < lstDetalleMatricula.size(); i++) {
                lstalumno.add(lstDetalleMatricula.get(i).getAlumno());
            }
        }
        return this.lstalumno;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public DocenteController getDocenteController() {
        return docenteController;
    }

    public void setDocenteController(DocenteController docenteController) {
        this.docenteController = docenteController;
    }

    public void verDetallesCursos(Curso curso) {
        selectedCurso = curso;
        cursoFiltro = "";
        lstacurso = new ArrayList<Curso>();
    }

    public String getCursoFiltro() {
        return cursoFiltro;
    }

    public void setCursoFiltro(String cursoFiltro) {
        this.cursoFiltro = cursoFiltro;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public MatriculaFacadeLocal getMatriculafacade() {
        return matriculafacade;
    }

    public void setMatriculafacade(MatriculaFacadeLocal matriculafacade) {
        this.matriculafacade = matriculafacade;
    }

    public Curso getSelectedCurso() {
        return selectedCurso;
    }

    public void setSelectedCurso(Curso selectedCurso) {
        this.selectedCurso = selectedCurso;
    }

    public List<Curso> getLstacurso() {
        return lstacurso;
    }

    public void setLstacurso(List<Curso> lstacurso) {
        this.lstacurso = lstacurso;
    }

    public List<Alumno> getLstalumno() {
        return lstalumno;
    }

    public void setLstalumno(List<Alumno> lstalumno) {
        this.lstalumno = lstalumno;
    }

    public void verDetallesAlumno(Alumno alumno) {
        detallematriculapk = new DetallematriculaPK();
        this.setSelectedAlumno(alumno);
        this.setEsNuevo(false);
        Detallematricula detallematricula = new Detallematricula();
        detallematricula.setAlumno(alumno);
        detallematricula.setBEstado(1);
        detallematriculapk.setNIdAlumno(alumno.getNIdAlumno());   
        Matricula matri=matriculafacade.encontrarIdMatricula(idCurso, docente.getNIdDocente());
        detallematriculapk.setNIdMatricula(matri.getNIdMatricula());        
        detallematricula.setDetallematriculaPK(detallematriculapk);
        detallematricula.setMatricula(matri);
        detallematriculafacade.create(detallematricula);

    }
}
