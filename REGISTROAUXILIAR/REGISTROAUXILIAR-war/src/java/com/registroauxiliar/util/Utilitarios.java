package com.registroauxiliar.util;

import java.io.StringWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

/**
 *
 * @author cdurand
 */
public class Utilitarios {

    public static Flash flashScope() {
        return (FacesContext.getCurrentInstance().getExternalContext().getFlash());
    }

    public static Date obtenerFechaServidor() {
        java.util.Date fecha = new java.util.Date();
        return new java.sql.Date(fecha.getTime());
    }

    public static void mostrarMensajeUsuario(String objectName, String summary, String details) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(objectName, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, details + " " + obtenerFechaHoraServidor()));
    }

    public static void mostrarMensajeUsuario(String objectName, String summary, String details, Severity severity) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(objectName, new FacesMessage(severity, summary, details));
    }

    public static void validarCadenaVacia(FacesContext context, UIComponent validate, Object value, String summary, String details) {
        String cadena = (String) value;
        if (cadena.trim().equals("")) {
            ((UIInput) validate).setValid(false);
            Utilitarios.mostrarMensajeUsuario(null, summary, details, FacesMessage.SEVERITY_ERROR);
        }
    }
       
    public static String padRight(String cadena, int lenght, char caracter) {
        return String.format("%1$-" + lenght + "s", cadena).replace(' ', caracter);
    }

    public static String padLeft(String cadena, int lenght, char caracter) {
        return String.format("%" + lenght + "s", cadena).replace(' ', caracter);
    }

    private static Timestamp obtenerFechaHoraServidor() {
        java.util.Date fecha = new java.util.Date();
        long lnMilisegundos = fecha.getTime();
        Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos);
        return sqlTimestamp;
    }

    public static String formatearFechaToString(Date fecha, String patron) {
        SimpleDateFormat sdf = new java.text.SimpleDateFormat(patron);
        return sdf.format(fecha);
    }

    public static Date formatearFechaToDate(String fecha, String patron) throws ParseException {
        Date dFecha = new Date(new SimpleDateFormat(patron).parse(fecha).getTime());
        return dFecha;
    }

    public String getHour(String time) {
        return time.substring(0, 2);
    }

    public String getMinutes(String time) {
        return time.substring(2, 4);
    }

    public String getStringDateDMA(String dateTime) {
        String anio = dateTime.substring(0, 4);
        String mes = dateTime.substring(4, 6);
        String dia = dateTime.substring(6, 8);
        return dia + "/" + mes + "/" + anio;
    }


    public int getNumberFormatHour(String time) {
        String hour = time.substring(0, 2);
        String minutes = time.substring(3, 5);
        int timeI = Integer.parseInt(hour + "" + minutes);
        return timeI;
    }

    public String formatHour(String time) {
        String hour = time.substring(0, 2);
        String minutes = time.substring(2, 4);
        return hour + ":" + minutes;
    }

    public static boolean esFechaMayor(String sFec1DMY, String sFec2DMY) {
        int iFec1DMY = Integer.parseInt(sFec1DMY);
        int iFec2DMY = Integer.parseInt(sFec2DMY);
        return iFec1DMY > iFec2DMY;
    }

    public static boolean esFechaMenor(String sFec1DMY, String sFec2DMY) {
        int iFec1DMY = Integer.parseInt(sFec1DMY);
        int iFec2DMY = Integer.parseInt(sFec2DMY);
        return iFec1DMY < iFec2DMY;

    }

    public static boolean esFechaIgual(String sFec1DMY, String sFec2DMY) {
        int iFec1DMY = Integer.parseInt(sFec1DMY);
        int iFec2DMY = Integer.parseInt(sFec2DMY);
        return iFec1DMY == iFec2DMY;
    }

    public static boolean esFechaValida() {
        boolean esValida = false;

        return esValida;
    }

  
    public static String transformListToCSV(List<String> list) {
        StringWriter sw = new StringWriter();
        for(int i = 0; i < list.size(); i++) {
            if (i > 0) sw.append(",");
            sw.append(list.get(i));
        }
        return sw.toString();        
    }
    
    public static List<String> transformCSVToList(String string) {
        List<String> list = new ArrayList<String>();        
        String[] separatedArray = null;
        if (string != null) {
            separatedArray = string.split(",");
        } else {
            separatedArray = new String[]{};
        }
        
        list = Arrays.asList(separatedArray);
        return list;
    }
    
    public static  String[] transformListToArray(List<String> list) {
        String[] strings = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            strings[i] = item;
        }
        return strings;
    }
    
}
