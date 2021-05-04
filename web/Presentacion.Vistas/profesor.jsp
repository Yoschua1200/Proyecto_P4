<%-- 
    Document   : profesor
    Created on : 18 abr. 2021, 23:04:15
    Author     : Danny
--%>
<%@page import="Logica.Matricula"%>
<%@page import="Datos.MatriculaDatos"%>
<%@page import="Datos.GrupoDatos"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logica.Grupo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CursosLibres.com</title>
        <link rel="shortcut icon" href="../images/logo.ico" type="">
    </head>
    <body style="padding-top: 70px; padding-bottom: 70px;">

        <%@ include file="header.jsp" %>
        
 <% String banderaLogin = (String)request.getSession().getAttribute("banderaLogin"); 
    tipoUsuario = (String) request.getSession().getAttribute("tipo");
    
    if(banderaLogin == "1" && tipoUsuario=="2"){
        
    String idg = (String) request.getAttribute("idgrupo");
    String bn = (String) request.getAttribute("banderaNota");
%>       
<%if(bn!=null){%>
<div class="alert alert-success" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
    <h4 class="alert-heading">¡Muy bien!</h4>
    <p>La nota se ha registrado correctamente. </p>
    <hr>
</div>


  <%}%>
        <div class="container"> 
            <div class="row">
                <div class="col-lg-5">

                    <div class="row">
                        <div class="col-lg-4"> 
                            <img src="../images/zhongli.png" class="rounded-circle img-fluid" alt="Placeholder image">
                        </div>

                        <div class="col-lg-8"> 
                            <h6>Nombre: ${nombre}</h6>
                            <h6>Cedula: ${cedulaPro}</h6>
                            <h6>Correo: ${correo}</h6>
                            <h6>Tel: ${telefono}</h6>
                            <h6>Especialidad 1: ${especialidad1}</h6>
                            <h6>Especialidad 2: ${especialidad2}</h6>
                            <h6>Especialidad 3: ${especialidad3}</h6>
                             
                        </div>
                    </div>

                </div>
           
            </div>
        </div>
        <br>
              
          <div class="container">
        <%
            if(idg==null){
                %>
          <div class="col-lg-7"><h4 class="texto-centrado">Cursos a cargo </h4></div>     
            <br>
    <%
           GrupoDatos mg = new GrupoDatos();
                  //List<Grupo> grupos = mg.consultarPorProf(Integer.parseInt(request.getParameter("cedulaProf")));
                  String id = (String) request.getSession().getAttribute("cedulaProf");
                  List<Grupo> grupos = mg.consultarPorProf(Integer.parseInt(id));
                  Iterator<Grupo> iter = grupos.iterator();
                  Grupo g = null;
                  while (iter.hasNext()) {
                      g = iter.next(); 
        %>                
        
         
            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg-10">

                    <div class="container">
                        <div class="row" border="1">

                            <div class="col-lg-12">
                                <table width="100%" >
                                    <tbody>
                                    <br>
                                    <tr>
                                    <h5>ID: <%=g.getId()%></h5>
                                    </tr>
                                    <tr>
                                    <h5>Curso: <%= g.getCurso().getNombre()%> </h5>
                                    </tr>
                                    <tr>
                                    <h5>Nombre de profesor a cargo: <%= g.getProfesor().getNombre()%> </h5>
                                    </tr>
                                    <tr>
                                    <h5>Horario <%= g.getHora()%></h5>
                                    </tr>

                                    <tr>
                                    <form class="form-inline my-2 my-lg-0" action="/Proyecto_P4/Presentacion.Vistas/PonerNotas" method="POST">
                                        <div class="form-group">

                                            <input type = "hidden" name="IdGrupo" class="form-control" value="<%= g.getId()%>" placeholder="Eliminar">
                                        </div>

                                        <button type="submit" class="btn btn-primary btn-lg">Poner notas</button>
                                    </form>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <%} %>
          <%}else{ %>
        </div>    
         <br>
         <div class="col-lg-7"><h4 class="texto-centrado">Estudiantes matriculados</h4></div>  
         <br>
         <div class="container">
        <%MatriculaDatos md = new MatriculaDatos();%>
        <%List<Matricula> matriculas = md.listarPorGrupo(Integer.parseInt(idg));%>
         <%Iterator<Matricula> iter = matriculas.iterator();
                  Matricula m = null;
                  while (iter.hasNext()) {
                      m = iter.next(); 
        %>
        
         <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg-10">

                    <div class="container">
                        <div class="row" border="1">

                            <div class="col-lg-12">
                                <table width="100%" >
                                    <tbody>
                                    <br>
                                    <tr>
                                    <h5>ID de matricula <%=m.getId()%></h5>
                                    </tr>
                                    <tr>
                                    <h5>Cédula de estudiante: <%=m.getEstudiante().getCedula()%></h5>
                                    </tr>
                                    <tr>
                                    <h5>Nombre de estudiante: <%=m.getEstudiante().getNombre()%></h5>
                                    </tr>
                                    <tr>
                                    <form class="form-inline my-2 my-lg-0" action="/Proyecto_P4/Presentacion.Vistas/MeterCifra" method="POST">
                                        <div class="form-group">
                                            <label>Nota de estudiante</label>
                                            <input type = "text" name="notaEst" class="form-control" placeholder="Nota de estudiante">
                                        </div>
                                         <div class="form-group">
                                           
                                            <input type = "hidden" name="idMatricula" class="form-control" value="<%=m.getId()%>">
                                        </div>
                                        <button type="submit" class="btn btn-primary btn-lg">Colocar nota</button>
                                    </form>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
         
            <%} %>
              <%} %>
           </div>
    </body>
<%}else{ response.sendRedirect("error.jsp"); }%>
    <%@ include file="footer.jsp" %>
</html>


