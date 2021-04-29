<%-- 
    Document   : login
    Created on : 18 abr. 2021, 6:16:30
    Author     : Danny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<body style="padding-top: 70px">
<%@ include file="header.jsp" %>
<div class="container-fluid">
  <div class="row" style="padding-top: 70px">
	<div class="col-lg-3"></div>
        <div class="col-lg-6 columna-login">
            <h2 class ="texto-login">Login</h2>
            <form action="Log" method="POST">
                <div class="form-group">
                    <label >Cedula</label>
                    <input type="text" name="cedula" class="form-control" placeholder="Correo">
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
