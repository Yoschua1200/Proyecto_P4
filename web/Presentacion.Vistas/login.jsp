<%-- 
    Document   : login
    Created on : 18 abr. 2021, 6:16:30
    Author     : Danny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CursosLibres.com</title>
        <link rel="shortcut icon" href="../images/logo.ico" type="">
    </head>
    <body style="padding-top: 70px">
<%@ include file="header.jsp" %>

<%String flag = (String) request.getAttribute("error");%>
<%String flagE = (String) request.getAttribute("flagE");%>
<%if(flag!=null){%>
<%if(flag.equalsIgnoreCase("si")){%>
  <div class="alert alert-danger" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
    <h4 class="alert-heading">¡Error de autenticación!</h4>
    <p>Usuario o contraseña incorrectos. </p>
    <hr>
</div>
<%}%>
<%}%>
<%if(flagE!=null){%>
<%if(flagE.equalsIgnoreCase("si")){%>
  <div class="alert alert-success" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
    <h4 class="alert-heading">¡Bienvenido!</h4>
    <p>Te has registrado. ¡Inicia sesión! </p>
    <hr>
</div>
<%}%>
<%}%>
<div class="container-fluid">
  <div class="row" style="padding-top: 70px">
	<div class="col-lg-3"></div>
        <div class="col-lg-6 columna-login">
            <h2 class ="texto-login">Login</h2>
            <form action="/Proyecto_P4/Presentacion.Vistas/Log" method="POST">
                <div class="form-group">
                    <label >Cedula</label>
                    <input type="text" name="cedula" class="form-control" placeholder="Cédula">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Contraseña</label>
                    <input type="password" name="contrasena" class="form-control" id="exampleInputPassword1" placeholder="Contraseña">
                </div>
                <div class="form-group">
                    <h6>¿No estás registrado? <a class="titulos" href="signin.jsp"> ¡Hazlo ahora! </a></h6>
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
	<div class="col-lg-3"></div>
  </div>
</div>
</body>
<%@ include file="footer.jsp" %>
</html>
