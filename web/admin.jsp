<%-- 
    Document   : estudiante
    Created on : 18 abr. 2021, 21:59:08
    Author     : Danny
--%>

<%@page import="Logica.Profesor"%>
<%@page import="Logica.Profesor"%>
<%@page import="Datos.ProfesorDatos"%>
<%@page import="java.lang.String"%>
<%@page import="Logica.Grupo"%>
<%@page import="Datos.GrupoDatos"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Curso"%>
<%@page import="Datos.CursoDatos"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CursosLibres.com</title>
        <link rel="shortcut icon" href="images/logo.ico" type="">
    </head>
    <body style="padding-top: 70px; padding-bottom: 70px;">

        <%@ include file="header.jsp" %>
        <% String banderaConsultarCurso = (String) request.getAttribute("ConsultaCurso"); %>
        <% String banderaConsultarGrupo = (String) request.getAttribute("ConsultaGrupo"); %>
        <% String banderaConsultarProfesor = (String) request.getAttribute("ConsultaProfesor"); %>
        <% String banderaLogin = (String) request.getSession().getAttribute("banderaLogin");
            tipoUsuario = (String) request.getSession().getAttribute("tipo");

            if (banderaLogin == "1" && tipoUsuario == "3") {
        %> 

        <div class="container"> 
            <div class="row">
                <div class="col-lg-5">

                    <div class="row">
                        <div class="col-lg-4"> 
                            <img src="images/pururin.jpg" class="rounded-circle img-fluid" alt="Placeholder image">
                        </div>

                        <div class="col-lg-8"> 
                            <h6>Nombre: ${nombre}</h6>
                            <h6>Cédula: ${cedulaAdmin}</h6>
                            <h6>Correo: ${correo}</h6>
                            <h6>Tel: ${telefono}</h6>
                        </div>
                    </div>

                </div>
                <div class="col-lg-7"><h4 class="texto-centrado">Panel administrativo </h4></div>
            </div>
        </div>
        <br>
        <div class="container">
            <h2 class="texto-centrado">Gestión de cursos</h2>
            <br>
            <div class="row">
                <div class="col-lg-6">

                    <div id="accordion1" role="tablist">
                        <div class="card">
                            <div class="card-header" role="tab" id="tituloUno">
                                <h5 class="mb-0"> 
                                    <a class="collapsed" data-toggle="collapse" href="#colapsarAcordionUno" role="button" aria-expanded="false" aria-controls="colapsarAcordionUno"> Insertar curso </a> 
                                </h5>
                            </div>
                            <div id="colapsarAcordionUno" class="collapse" role="tabpanel" aria-labelledby="tituloUno" data-parent="#accordion1">
                                <div class="card-body">

                                    <form action="RegistroCurso" method="POST">
                                        <div class="form-group">
                                            <label>Código</label>
                                            <input type="text" class="form-control" name="codigo" placeholder="Código">
                                        </div>
                                        <div class="form-group">
                                            <label>Nombre</label>
                                            <input type="text" class="form-control" name="nombre" placeholder="Nombre">
                                        </div>
                                        <div class="form-group">
                                            <label>Temática</label>
                                            <input type="text" class="form-control" name="tematica" placeholder="Temática">
                                        </div>
                                        <div class="form-group">
                                            <label>Costo</label>
                                            <input type="text" class="form-control" name="costo" placeholder="Costo">
                                        </div>
                                        <div class="form-group">
                                            <label>Status</label>
                                            <input type="text" class="form-control" name="status" placeholder="Status">
                                        </div>
                                        <div class="form-group">
                                            <label>Logo</label>
                                            <input type="text" class="form-control" name="logo" placeholder="Logo">
                                        </div>
                                        <div class="form-group">
                                        </div>
                                        <button type="submit" class="btn btn-primary">Registrar curso</button>
                                    </form>


                                </div>
                            </div>
                        </div>
                    </div>


                </div>
                <div class="col-lg-6">
                    <div id="accordion2" role="tablist">
                        <div class="card">
                            <div class="card-header" role="tab" id="tituloDos">
                                <h5 class="mb-0"> 
                                    <a class="collapsed" data-toggle="collapse" href="#colapsarAcordionDos" role="button" aria-expanded="false" aria-controls="colapsarAcordionDos">Eliminar curso </a> 
                                </h5>
                            </div>
                            <div id="colapsarAcordionDos" class="collapse" role="tabpanel" aria-labelledby="tituloDos" data-parent="#accordion2">
                                <div class="card-body">
                                    <div class="container">



                                        <%
                                            CursoDatos cursoD = new CursoDatos();
                                            List<Curso> list = cursoD.listar();
                                            Iterator<Curso> iter = list.iterator();
                                            Curso c = null;
                                            while (iter.hasNext()) {
                                                c = iter.next();
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
                                                                <h5>Código: <%= c.getCodigo()%></h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Nombre: <%= c.getNombre()%> </h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Temática: <%= c.getTematica()%> </h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Costo: <%= c.getCosto()%></h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Estado: <%= c.getStatus()%></h5>
                                                                </tr>

                                                                <tr>
                                                                <form class="form-inline my-2 my-lg-0" action="EliminarCurso" method="POST">
                                                                    <div class="form-group">

                                                                        <input type = "hidden" name="codigoElim" class="form-control" value="<%= c.getCodigo()%>" placeholder="Eliminar">
                                                                    </div>

                                                                    <button type="submit" class="btn btn-primary btn-lg">Eliminar</button>
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
                                    </div>


                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <br>
            <div class="row">
                <div class="col-lg-6">

                    <div id="accordion3" role="tablist">
                        <div class="card">
                            <div class="card-header" role="tab" id="tituloTres">
                                <h5 class="mb-0"> 
                                    <a class="collapsed" data-toggle="collapse" href="#colapsarAcordionTres" role="button" aria-expanded="false" aria-controls="colapsarAcordionTres"> Consultar curso</a> 
                                </h5>
                            </div>
                            <div id="colapsarAcordionTres" class="collapse" role="tabpanel" aria-labelledby="tituloTres" data-parent="#accordion3">
                                <div class="card-body">
                                    <form class="form-inline my-2 my-lg-0" action="ConsultarCurso" method="POST">
                                        <div class="form-group">

                                            <input type = "text" name="codigoConsul" class="form-control" placeholder="Código de curso">
                                        </div>

                                        <button type="submit" class="btn btn-primary btn-lg"> Consultar</button>
                                    </form>
                                   <%if(banderaConsultarCurso!=null){   
                                       Curso c2 = cursoD.consultarCurso(Integer.parseInt(banderaConsultarCurso));
                                   %>
                                    <div class="container">
                                                    <div class="row" border="1">
                                                        <div class="col-lg-12">
                                                            <table width="100%" >
                                                                <tbody>
                                                                <br>
                                                                <tr>
                                                                <h5>Código: <%= c2.getCodigo()%></h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Nombre: <%= c2.getNombre()%> </h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Temática: <%= c2.getTematica()%> </h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Costo: <%= c2.getCosto()%></h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Estado: <%= c2.getStatus()%></h5>
                                                                </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                   <%}%>
                                    
                                </div>
                            </div>
                        </div>
                    </div>


                </div>
                <div class="col-lg-6">
                    <div id="accordion4" role="tablist">
                        <div class="card">
                            <div class="card-header" role="tab" id="tituloCuatro">
                                <h5 class="mb-0"> 
                                    <a class="collapsed" data-toggle="collapse" href="#colapsarAcordionCuatro" role="button" aria-expanded="false" aria-controls="colapsarAcordionCuatro">Editar estado de curso </a> 
                                </h5>
                            </div>
                            <div id="colapsarAcordionCuatro" class="collapse" role="tabpanel" aria-labelledby="tituloCuatro" data-parent="#accordion4">
                                <div class="card-body">
                                    <div class="container">



                                        <%
                                           
                                            List<Curso> list4 = cursoD.listar();
                                            Iterator<Curso> iter4 = list4.iterator();
                                            Curso c3 = null;
                                            while (iter4.hasNext()) {
                                                c3 = iter4.next();
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
                                                                <h5>Código: <%= c3.getCodigo()%></h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Nombre: <%= c3.getNombre()%> </h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Estado actual: <%= c3.getStatus()%></h5>
                                                                </tr>

                                                                <tr>
                                                                <form class="form-inline my-2 my-lg-0" action="EditarCurso" method="POST">
                                                                    <div class="form-group">

                                                                        <input type = "hidden" name="codigoActualizar" class="form-control" value="<%= c3.getCodigo()%>" placeholder="Cambiar de estado">
                                                                    </div>

                                                                    <button type="submit" class="btn btn-primary btn-lg">Cambiar estado</button>
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
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br> 


        <!---GRUPOS-->

        <div class="container">
            <h2 class="texto-centrado">Gestión de grupos</h2>
            <br>
            <div class="row">
                <div class="col-lg-6">

                    <div id="accordion1Grupo" role="tablist">
                        <div class="card">
                            <div class="card-header" role="tab" id="tituloUnoGrupo">
                                <h5 class="mb-0"> 
                                    <a class="collapsed" data-toggle="collapse" href="#colapsarAcordionUnoGrupo" role="button" aria-expanded="false" aria-controls="colapsarAcordionUnoGrupo"> Insertar grupo </a> 
                                </h5>
                            </div>
                            <div id="colapsarAcordionUnoGrupo" class="collapse" role="tabpanel" aria-labelledby="tituloUnoGrupo" data-parent="#accordion1Grupo">
                                <div class="card-body">

                                    <form action="RegistroGrupo" method="POST">
                                        <div class="form-group">
                                            <label>Código de curso asociado</label>
                                            <input type="text" class="form-control" name="curso" placeholder="Código de curso asociado">
                                        </div>
                                        <div class="form-group">
                                            <label>Cédula de profesor encargado</label>
                                            <input type="text" class="form-control" name="profesor" placeholder="Cédula de profesor">
                                        </div>
                                        <div class="form-group">
                                            <label>Horario asignado</label>
                                            <input type="text" class="form-control" name="horario" placeholder="Horario asignado">
                                        </div>
                                        <button type="submit" class="btn btn-primary">Registrar grupo</button>
                                    </form>   
                                </div>
                            </div>
                        </div>
                    </div>


                </div>
                <div class="col-lg-6">
                    <div id="accordion2Grupo" role="tablist">
                        <div class="card">
                            <div class="card-header" role="tab" id="tituloDosGrupo">
                                <h5 class="mb-0"> 
                                    <a class="collapsed" data-toggle="collapse" href="#colapsarAcordionDosGrupo" role="button" aria-expanded="false" aria-controls="colapsarAcordionDosGrupo">Eliminar grupo </a> 
                                </h5>
                            </div>
                            <div id="colapsarAcordionDosGrupo" class="collapse" role="tabpanel" aria-labelledby="tituloDosGrupo" data-parent="#accordion2Grupo">
                                <div class="card-body">
                                     <div class="container">



                                        <%
                                           GrupoDatos grupoD = new GrupoDatos();
                                               List<Grupo> list2 = grupoD.listar();
                                               Iterator<Grupo> iter2 = list2.iterator();
                                               Grupo g = null;
                                               while (iter2.hasNext()) {
                                                   g = iter2.next();

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
                                                                <form class="form-inline my-2 my-lg-0" action="EliminarGrupo" method="POST">
                                                                    <div class="form-group">

                                                                        <input type = "hidden" name="IdElim" class="form-control" value="<%= g.getId()%>" placeholder="Eliminar">
                                                                    </div>

                                                                    <button type="submit" class="btn btn-primary btn-lg">Eliminar</button>
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
                                    </div>
                                    
                                 
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <br>
            <div class="row">
                <div class="col-lg-6">

                    <div id="accordion3Grupo" role="tablist">
                        <div class="card">
                            <div class="card-header" role="tab" id="tituloTresGrupo">
                                <h5 class="mb-0"> 
                                    <a class="collapsed" data-toggle="collapse" href="#colapsarAcordionTresGrupo" role="button" aria-expanded="false" aria-controls="colapsarAcordionTresGrupo">Consultar grupo</a> 
                                </h5>
                            </div>
                            <div id="colapsarAcordionTresGrupo" class="collapse" role="tabpanel" aria-labelledby="tituloTresGrupo" data-parent="#accordion3Grupo">
                                <div class="card-body">
                                    
                                    <form class="form-inline my-2 my-lg-0" action="ConsultarGrupo" method="POST">
                                        <div class="form-group">
                                            
                                            <input type = "text" name="codigoConsul" class="form-control" placeholder="Código de grupo">
                                        </div>

                                        <button type="submit" class="btn btn-primary btn-lg"> Consultar</button>
                                    </form>
                                    <%if(banderaConsultarGrupo!=null){   
                                       Grupo g2 = grupoD.consultar(Integer.parseInt(banderaConsultarGrupo));
                                   %>
                                    <div class="container">
                                                    <div class="row" border="1">
                                                        <div class="col-lg-12">
                                                           <table width="100%" >
                                                                <tbody>
                                                                <br>
                                                                <tr>
                                                                <h5>ID: <%=g2.getId()%></h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Curso: <%= g2.getCurso().getNombre()%> </h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Nombre de profesor a cargo: <%= g2.getProfesor().getNombre()%> </h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Horario <%= g2.getHora()%></h5>
                                                                </tr>

                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                   <%}%>
                                   
                                </div>
                            </div>
                        </div>
                    </div>


                </div>
                <div class="col-lg-6">
                    <div id="accordion4Grupo" role="tablist">
                        <div class="card">
                            <div class="card-header" role="tab" id="tituloCuatroGrupo">
                                <h5 class="mb-0"> 
                                    <a class="collapsed" data-toggle="collapse" href="#colapsarAcordionCuatroGrupo" role="button" aria-expanded="false" aria-controls="colapsarAcordionCuatroGrupo">Cambiar profesor encargado </a> 
                                </h5>
                            </div>
                            <div id="colapsarAcordionCuatroGrupo" class="collapse" role="tabpanel" aria-labelledby="tituloCuatroGrupo" data-parent="#accordion4Grupo">
                                <div class="card-body">
                                     <div class="container">



                                        <%
                                         
                                               List<Grupo> list5 = grupoD.listar();
                                               Iterator<Grupo> iter5 = list5.iterator();
                                               Grupo g2 = null;
                                               while (iter5.hasNext()) {
                                                   g2 = iter5.next();

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
                                                                <h5>ID: <%=g2.getId()%></h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Curso: <%= g2.getCurso().getNombre()%> </h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Nombre de profesor a cargo: <%= g2.getProfesor().getNombre()%> </h5>
                                                                </tr>
                                                              
                                                                <tr>
                                                                <form class="form-inline my-2 my-lg-0" action="EditarGrupo" method="POST">
                                                                    <div class="form-group">

                                                                        <input type = "text" name="EditGrupo" class="form-control"  placeholder="Cédula de nuevo profesor">
                                                                        <input type = "hidden" name="IdGrupo" class="form-control" value="<%= g2.getId()%>" placeholder="id grupo">
                                                                    </div>

                                                                    <button type="submit" class="btn btn-primary btn-lg">Actualizar</button>
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
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <br>
        <!---PROFES-->

        <div class="container">
            <h2 class="texto-centrado">Gestión de profesores</h2>
            <br>
            <div class="row">
                <div class="col-lg-6">

                    <div id="accordion1Profesor" role="tablist">
                        <div class="card">
                            <div class="card-header" role="tab" id="tituloUnoProfesor">
                                <h5 class="mb-0"> 
                                    <a class="collapsed" data-toggle="collapse" href="#colapsarAcordionUnoProfesor" role="button" aria-expanded="false" aria-controls="colapsarAcordionUnoProfe"> Insertar profesor </a> 
                                </h5>
                            </div>
                            <div id="colapsarAcordionUnoProfesor" class="collapse" role="tabpanelProfesor" aria-labelledby="tituloUnoProfesor" data-parent="#accordion1Profesor">
                                <div class="card-body">

                                    <form action="RegistroProfesor" method="POST">
                                        <div class="form-group">
                                            <label>Cédula</label>
                                            <input type="text" class="form-control" name="cedula" placeholder="Cédula">
                                        </div>
                                        <div class="form-group">
                                            <label>Nombre</label>
                                            <input type="text" class="form-control" name="nombre" placeholder="Nombre">
                                        </div>
                                        <div class="form-group">
                                            <label>Correo electrónico</label>
                                            <input type="text" class="form-control" name="correo" placeholder="Correo electrónico">
                                        </div>
                                        <div class="form-group">
                                            <label>Teléfono</label>
                                            <input type="text" class="form-control" name="telefono" placeholder="Teléfono">
                                        </div>
                                        <div class="form-group">
                                            <label>Primera especialidad</label>
                                            <input type="text" class="form-control" name="especialidad1" placeholder="Especialidad 1">
                                        </div>
                                        <div class="form-group">
                                            <label>Segunda especialidad</label>
                                            <input type="text" class="form-control" name="especialidad2" placeholder="Especialidad 2">
                                        </div>
                                        <div class="form-group">
                                            <label>Tercera especialidad</label>
                                            <input type="text" class="form-control" name="especialidad3" placeholder="Especialidad 3">
                                        </div>
                                        <div class="form-group">
                                        </div>
                                        <button type="submit" class="btn btn-primary">Registrar profesor</button>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>


                </div>
                <div class="col-lg-6">
                    <div id="accordion2Profesor" role="tablist">
                        <div class="card">
                            <div class="card-header" role="tab" id="tituloDosProfesor">
                                <h5 class="mb-0"> 
                                    <a class="collapsed" data-toggle="collapse" href="#colapsarAcordionDosProfesor" role="button" aria-expanded="false" aria-controls="colapsarAcordionDosProfesor">Eliminar profesor </a> 
                                </h5>
                            </div>
                            <div id="colapsarAcordionDosProfesor" class="collapse" role="tabpanel" aria-labelledby="tituloDosProfesor" data-parent="#accordion2Profesor">
                                <div class="card-body">
                                    <div class="container">



                                        <%
                                          ProfesorDatos profD = new ProfesorDatos();
                                               List<Profesor> list3 = profD.listar();
                                               Iterator<Profesor> iter3 = list3.iterator();
                                               Profesor p = null;
                                               while (iter3.hasNext()) {
                                                   p = iter3.next();

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
                                                                <h5>Cédula: <%=p.getCedula()%></h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Nombre: <%= p.getNombre()%> </h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Correo eléctronico: <%= p.getCorreo()%> </h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Teléfono <%= p.getTelefono()%></h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Especialidad 1: <%=p.getEspecialidad1()%></h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Especialidad 2: <%=p.getEspecialidad2()%></h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Especialidad 3: <%=p.getEspecialidad3()%></h5>
                                                                </tr>
                                                                <tr>
                                                                <form class="form-inline my-2 my-lg-0" action="EliminarProfesor" method="POST">
                                                                    <div class="form-group">

                                                                        <input type = "hidden" name="CedElim" class="form-control" value="<%= p.getCedula()%>" placeholder="Eliminar">
                                                                    </div>

                                                                    <button type="submit" class="btn btn-primary btn-lg">Eliminar</button>
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
                                    </div>
                                    
                                    
                                   </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <br>
            <div class="row">
                <div class="col-lg-6">

                    <div id="accordion3Profesor" role="tablist">
                        <div class="card">
                            <div class="card-header" role="tab" id="tituloTresProfesor">
                                <h5 class="mb-0"> 
                                    <a class="collapsed" data-toggle="collapse" href="#colapsarAcordionTresProfesor" role="button" aria-expanded="false" aria-controls="colapsarAcordionTresProfesor"> Consultar profesor</a> 
                                </h5>
                            </div>
                            <div id="colapsarAcordionTresProfesor" class="collapse" role="tabpanel" aria-labelledby="tituloTresProfesor" data-parent="#accordion3Profesor">
                                <div class="card-body">
                                     <form class="form-inline my-2 my-lg-0" action="ConsultarProfesor" method="POST">
                                        <div class="form-group">
                                            
                                            <input type = "text" name="cedulaConsul" class="form-control" placeholder="Cédula de profesor">
                                        </div>

                                        <button type="submit" class="btn btn-primary btn-lg"> Consultar</button>
                                    </form>
                                    <%if(banderaConsultarProfesor!=null){   
                                       Profesor p2 = profD.consultarProfesor(Integer.parseInt(banderaConsultarProfesor));
                                   %>
                                    <div class="container">
                                                    <div class="row" border="1">
                                                        <div class="col-lg-12">
                                                           <table width="100%" >
                                                                <tbody>
                                                                <br>
                                                                <tr>
                                                                <h5>Cédula: <%=p2.getCedula()%></h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Nombre: <%= p2.getNombre()%> </h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Correo eléctronico: <%= p2.getCorreo()%> </h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Teléfono <%= p2.getTelefono()%></h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Especialidad 1: <%=p2.getEspecialidad1()%></h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Especialidad 2: <%=p2.getEspecialidad2()%></h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Especialidad 3: <%=p2.getEspecialidad3()%></h5>
                                                                </tr>
                                                              
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                   <%}%>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>
                <div class="col-lg-6">
                    <div id="accordion4Profesor" role="tablist">
                        <div class="card">
                            <div class="card-header" role="tab" id="tituloCuatroProfesor">
                                <h5 class="mb-0"> 
                                    <a class="collapsed" data-toggle="collapse" href="#colapsarAcordionCuatroProfesor" role="button" aria-expanded="false" aria-controls="colapsarAcordionCuatroProfesor">Cambiar correo eléctronico </a> 
                                </h5>
                            </div>
                            <div id="colapsarAcordionCuatroProfesor" class="collapse" role="tabpanel" aria-labelledby="tituloCuatroProfesor" data-parent="#accordion4Profesor">
                                <div class="card-body">
                                     <div class="container">



                                        <%
                                        
                                               List<Profesor> list6 = profD.listar();
                                               Iterator<Profesor> iter6 = list6.iterator();
                                               Profesor p2 = null;
                                               while (iter6.hasNext()) {
                                                   p2 = iter6.next();

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
                                                                <h5>Cédula: <%=p2.getCedula()%></h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Nombre: <%= p2.getNombre()%> </h5>
                                                                </tr>
                                                                <tr>
                                                                <h5>Correo eléctronico: <%= p2.getCorreo()%> </h5>
                                                                </tr>
                                                                  <tr>
                                                                <form class="form-inline my-2 my-lg-0" action="EditarProfesor" method="POST">
                                                                    <div class="form-group">

                                                                        <input type = "text" name="correoEdit" class="form-control"  placeholder="Correo">
                                                                        <input type = "hidden" name="cedProf" class="form-control" value="<%= p2.getCedula()%>" placeholder="id prof">

                                                                    </div>

                                                                    <button type="submit" class="btn btn-primary btn-lg">Actualizar</button>
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
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
    <%} else {
            response.sendRedirect("error.jsp");
        }%>
    <%@ include file="footer.jsp" %>

</html>
