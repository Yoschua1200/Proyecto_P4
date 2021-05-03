<%-- 
    Document   : historial
    Created on : 02/05/2021, 08:14:14 PM
    Author     : yosch
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logica.*"%>
<%@page import="java.util.List"%>
<%@page import="Datos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<HistorialEst> hist_est = null;
    MatriculaDatos m1 = new MatriculaDatos();
    //tomar el id del estudiante en la sesion 
    /*String ced = (String)(request.getParameter("cedula"));
    if(ced!=null){
      hist_est = m1.listar_hist_est(Integer.parseInt(ced));  
    }*/
    
     //int ced_estu = (int)request.getSession().getAttribute("cedulaEst");
     String ced=(String)request.getSession().getAttribute("cedulaString");
     
    hist_est = m1.listar_hist_est(Integer.parseInt(ced));
    //List<Grupo> grupos = g1.listar();
%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Bootstrap core CSS -->
        <link href="../css/specific.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap-4.4.1.css" rel="stylesheet" type="text/css"/>
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            body{
                background-color: #1c1d1f;
            }   
            td { text-align: center; }

        </style> 
    </head>
    <br>
    <br>
    <br>
  
    <br>
    <br>
    <br>
    <div class="container">

        <h2>Cursos Matriculados</h2>

        <table class="t">
            <tr>
                <th>Nombre del Curso</th>
                <th>Profesor</th>
                <th>Horario</th>
            </tr>
            
            <%if (hist_est != null) {%>
            <% if (!(hist_est.isEmpty())) {%>
            <% for (HistorialEst h : hist_est) {%>
            <tr>
                <td><%=h.getNombre_curso()%></td>
                <td><%=h.getNombre_prof()%></td>
                <td><%=h.getHorario()%></td>
            </tr>
            <%}%>
            <%}%>
            <%}%>



        </table>
    </div>
    <br>
    <br>
    <br>
    <div class="container">
        <button type="submit" class="btn btn-primary btn-lg">Generar Reporte en formato PDF</button>
    </div>
    <div class="container">
        <br>
        <br>
        <br>    
        <a href="busqueda.jsp" class="btn btn-primary btn-lg">Matricular Más Cursos</a>

    </div>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <%@ include file="footer.jsp" %>
</html>