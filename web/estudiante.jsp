<%-- 
    Document   : estudiante
    Created on : 18 abr. 2021, 21:59:08
    Author     : Danny
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body style="padding-top: 70px; padding-bottom: 70px;">
    
<%@ include file="header.jsp" %>
<% String banderaLogin = (String)request.getSession().getAttribute("banderaLogin"); 
    if(banderaLogin == "1"){
%>
<div class="container"> 
  <div class="row">
    <div class="col-lg-5">
		
	  <div class="row">
			<div class="col-lg-4"> 
                            <img src="images/akko.jpg" class="rounded-circle img-fluid" alt="Placeholder image">
                        </div>
		  
			<div class="col-lg-8"> 
				<h6>Nombre: ${nombre}</h6>
                                <h6>Cedula: ${cedulaEst}</h6>
				<h6>Correo: ${correo}</h6>
				<h6>Tel: ${telefono}</h6>
		</div>
		</div>
	
	  </div>
      <div class="col-lg-7"><h4 class="texto-centrado">Cursos matriculados </h4></div>
  </div>
</div>
</body>
<%}else{ response.sendRedirect("error.jsp"); }%>
<%@ include file="footer.jsp" %>
</html>
