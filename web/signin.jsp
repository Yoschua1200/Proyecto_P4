<%-- 
    Document   : registro
    Created on : 18 abr. 2021, 22:22:25
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
        <h2 class ="texto-login">
            Sign in
        </h2>
      <form>
        <div class="form-group">
          <label>Número de cédula</label>
          <input type="text" class="form-control" placeholder="Cédula">
        </div>
        <div class="form-group">
          <label>Nombre</label>
          <input type="text" class="form-control" placeholder="Nombre">
        </div>
        <div class="form-group">
          <label>Teléfono</label>
          <input type="text" class="form-control" placeholder="Teléfono">
        </div>
        <div class="form-group">
          <label for="exampleInputEmail1">Dirección de correo electrónico</label>
          <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Correo">
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">Contraseña</label>
          <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Contraseña">
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
<%@ include file="footer.jsp" %>
</html>
