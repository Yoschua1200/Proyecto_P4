<%-- 
    Document   : registro
    Created on : 18 abr. 2021, 22:22:25
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
<% long num = (int) (Math.random() * 10000); %>
<div class="container-fluid">
  <div class="row" style="padding-top: 70px">
	<div class="col-lg-3"></div>
    <div class="col-lg-6 columna-login">
        <h2 class ="texto-login">
            Sign in
        </h2>
        
      <form action="/Proyecto_P4/Presentacion.Vistas/RegistroEstudiante" method="POST">
        <div class="form-group">
          <label>Número de cédula</label>
          <input type="text" name="cedula" class="form-control" placeholder="Cédula">
        </div>
        <div class="form-group">
          <label>Nombre</label>
          <input type="text" name="nombre" class="form-control" placeholder="Nombre">
        </div>
        <div class="form-group">
          <label>Teléfono</label>
          <input type="text" class="form-control" name="telefono" placeholder="Teléfono">
        </div>
        <div class="form-group">
          <input type="hidden" class="form-control" name="clave" value="<%=num%> ">
        </div>
        <div class="form-group">
          <label for="exampleInputEmail1">Dirección de correo electrónico</label>
          <input type="email" class="form-control" name="correo" id="exampleInputEmail1" placeholder="Correo">
        </div>
        <div class="form-group">
            <h6>¿Ya estás registrado? <a class="titulos" href="login.jsp"> Inicia sesión </a></h6>
        </div>
        <button type="submit" class="btn btn-primary">Enviar</button>
      </form>
    </div>
    <div class="col-lg-3"></div>
  </div>
</div>
<br>
</body>
<br>
<br>
<br>
<%@ include file="footer.jsp" %>
</html>
