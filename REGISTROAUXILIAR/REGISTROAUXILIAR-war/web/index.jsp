<%-- 
    Document   : index
    Created on : 04-abr-2013, 10:35:02
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    </head>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <c:if test="${loginController.logueadoAlu}">
        <jsp:forward page="/homeAlumno.jsf"/>
    </c:if>
    <c:if test="${loginController.logueadoDoc}">
        <jsp:forward page="/homeDocente.jsf"/>
    </c:if>
    <c:if test="${!loginController.logueadoDoc && !loginController.logueadoAlu }">   
        <jsp:forward page="/seguridad/frmLogin.jsf"></jsp:forward>
    </c:if>
</html>
