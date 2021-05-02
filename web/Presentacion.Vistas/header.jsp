<%-- 
    Document   : header
    Created on : 18 abr. 2021, 5:15:28
    Author     : Danny
--%>
<%
    String usuario="false";
    String tipoUsuario = "0";
        if (request.getSession().getAttribute("banderaLogin") != null) {
            usuario=(String) request.getSession().getAttribute("banderaLoginDos");

            if (request.getSession().getAttribute("tipo") != null) {
               tipoUsuario = (String) request.getSession().getAttribute("tipo");
            }
        }
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CursosLibres.com</title>
<link href="../css/bootstrap-4.4.1.css" rel="stylesheet" type="text/css">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="../images/logo.ico" type="">

</head>
<nav class="navbar fixed-top navbar-expand-lg color-menu bg-light" > 
    <a class="navbar-brand" href="index.jsp">CursosLibres.com</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent1" aria-controls="navbarSupportedContent1" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent1">
        <ul class="navbar-nav mx-auto">
            <!--action="/Guia/presentation/login/login"-->
            <form class="form-inline my-2 my-lg-0" action="/Proyecto_P4/Presentacion.Vistas/BuscarCurso" method="POST">
                <input class="form-control mr-sm-2" type="text" name ="nombre" placeholder="Buscar cursos" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
            </form>
        </ul>
        <ul class="navbar-nav ml-auto">
            
            <% if(usuario!="false"){ 
                if(tipoUsuario=="3"){
            %>  <li><a class="nav-link" href="admin.jsp">Administración <span class="sr-only">(current)</span></a></li>    
            <% }else if(tipoUsuario=="1"){ %>
                <li><a class="nav-link" href="estudiante.jsp">Estudiante <span class="sr-only">(current)</span></a></li>
            <% }else if(tipoUsuario=="2"){ %> 
                <li><a class="nav-link" href="profesor.jsp">Profesor <span class="sr-only">(current)</span></a></li>      
            <% } %>
                <li><a class="nav-link" href="Logout">Cerrar Sesion <span class="sr-only">(current)</span></a> </li>
            
                
            <% }%>
            <% if(usuario=="false"){ %>
                <li class="nav-item active"> 
                    <a class="nav-link" href="login.jsp">Login <span class="sr-only">(current)</span></a> 
                </li>
            <% }%>
        </ul>

    </div>
</nav>