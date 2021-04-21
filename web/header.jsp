<%-- 
    Document   : header
    Created on : 18 abr. 2021, 5:15:28
    Author     : Danny
--%>
<%
    boolean usuario=true;
    int tipoUsuario=2;         
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CursosLibres.com</title>
<link href="css/bootstrap-4.4.1.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<nav class="navbar fixed-top navbar-expand-lg color-menu bg-light" > 
    <a class="navbar-brand" href="index.jsp">CursosLibres.com</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent1" aria-controls="navbarSupportedContent1" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent1">
        <ul class="navbar-nav mx-auto">
            <form class="form-inline my-2 my-lg-0" action="/Consulta" method="POST">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </ul>
        <ul class="navbar-nav ml-auto">
            
            <% if(usuario!=false){ 
                 if(tipoUsuario==0){
            %>
            <li>
                 <a class="nav-link" href="admin.jsp">Administración <span class="sr-only">(current)</span></a> 
            </li>    
            <% }else if(tipoUsuario==1){ %>
            <li>
                 <a class="nav-link" href="estudiante.jsp">Estudiante <span class="sr-only">(current)</span></a> 
            </li>
            <% }else{ %> 
            <li>
                 <a class="nav-link" href="profesor.jsp">Profesor <span class="sr-only">(current)</span></a> 
            </li>      
            <% } %>
            <li>
                 <a class="nav-link" href="cerrarSesion">Cerrar Sesion <span class="sr-only">(current)</span></a> 
            </li>
            <%  }%>
            <% if(usuario==false){ %>
                <li class="nav-item active"> 
                    <a class="nav-link" href="login.jsp">Login <span class="sr-only">(current)</span></a> 
                </li>
            <% }%>
        </ul>

    </div>
</nav>