<%-- 
    Document   : Pruebas
    Created on : 21 abr. 2021, 4:13:15
    Author     : Danny
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Curso"%>
<%@page import="Datos.CursosDatos"%>
<%
    /*String placa = request.getParameter("placa");
    String dia = (String)request.getAttribute("dia");*/
        String flag = (String)request.getAttribute("flag");
        
        String codigo = (String)request.getAttribute("codigo");
        String nombre = (String)request.getAttribute("nombre");
        String tematica = (String)request.getAttribute("tematica");
        String costo = (String)request.getAttribute("costo");
        String status = (String)request.getAttribute("status");
        String logo = (String)request.getAttribute("logo");
        
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="background-color: green;">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--<h1>Placa: <%//=placa%></h1>
        <h1>Dia: <%//=dia%></h1>-->
        <!--<h1>Codigo: <%//=codigo%></h1>
        <h1>Nombre: <%//=nombre%></h1>
        <h1>Temática: <%//=tematica%></h1>
        <h1>Costo: <%//=costo%></h1>
        <h1>Status: <%//=status%></h1>
        <h1>Logo: <%//=logo%></h1>-->

        <% if(flag=="ver"){%>
            <h2>VER</h2> 
        <%}else if(flag=="registrar"){ %>
            <h2>REGISTRO</h2>
        <% }%> 
        
        <% 
            CursosDatos curso = new CursosDatos();
            List<Curso>list=curso.listar();
            Iterator<Curso>iter=list.iterator();
            Curso c = null;
            while(iter.hasNext()){
                c=iter.next();
        %>
            <tr>
                <td> 
                    
                </td>
            </tr>
            <%}%>
    </body>
</html>
