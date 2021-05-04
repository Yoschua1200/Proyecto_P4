<%-- 
    Document   : estudiante
    Created on : 18 abr. 2021, 21:59:08
    Author     : Danny
--%>
<%@page import="Datos.MatriculaDatos"%>
<%@page import="Logica.HistorialEst"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CursosLibres.com</title>
        <link rel="shortcut icon" href="../images/logo.ico" type="">
        <!-- Bootstrap core CSS -->
        <link href="../css/tabla.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap-4.4.1.css" rel="stylesheet" type="text/css"/>
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            body{
                background-color: #1c1d1f;
            }   
            td { text-align: center; }

        </style> 
    </head>
    <body style="padding-top: 70px; padding-bottom: 70px;">

        <%@ include file="header.jsp" %>

        <% String banderaLogin = (String) request.getSession().getAttribute("banderaLogin");
            tipoUsuario = (String) request.getSession().getAttribute("tipo");

            if (banderaLogin == "1" && tipoUsuario == "1") {
        %>
        <%
            List<HistorialEst> hist_est = null;
            MatriculaDatos m1 = new MatriculaDatos();
            //tomar el id del estudiante en la sesion 
            /*String ced = (String)(request.getParameter("cedula"));
            if(ced!=null){
              hist_est = m1.listar_hist_est(Integer.parseInt(ced));  
            }*/

            //int ced_estu = (int)request.getSession().getAttribute("cedulaEst");
            String ced = (String) request.getSession().getAttribute("cedulaString");

            hist_est = m1.listar_hist_est(Integer.parseInt(ced));
            //List<Grupo> grupos = g1.listar();
        %>
        <div class="container"> 
            <div class="row">
                <div class="col-lg-5">

                    <div class="row">
                        <div class="col-lg-4"> 
                            <img src="../images/akko.jpg" class="rounded-circle img-fluid" alt="Placeholder image">
                        </div>

                        <div class="col-lg-8"> 
                            <h6>Nombre: ${nombre}</h6>
                            <h6>Cedula: ${cedulaEst}</h6>
                            <h6>Correo: ${correo}</h6>
                            <h6>Tel: ${telefono}</h6>
                        </div>
                    </div>

                </div>

            </div>
        </div>

        <br>           
        <br> 
        <br> 
        <br>
        <div class="container">

            <h2>Cursos Matriculados</h2>

            <table class="t">
                <tr>
                    <th>Nombre del Curso</th>
                    <th>Profesor</th>
                    <th>Horario</th>
                </tr>

                <%if (hist_est != null) {%>
                <% if (!(hist_est.isEmpty())) {%>
                <% for (HistorialEst h : hist_est) {%>
                <tr>
                    <td><%=h.getNombre_curso()%></td>
                    <td><%=h.getNombre_prof()%></td>
                    <td><%=h.getHorario()%></td>
                </tr>
                <%}%>
                <%}%>
                <%}%>



            </table>
        </div>
        <br>           
        <br> 
        <br> 
        <div class="container">
            <form action="/Proyecto_P4/Presentacion.Vistas/Imprimir",class="form-inline my-2 my-lg-0" , method="POST">
                <button type="submit" class="btn btn-primary btn-lg">Generar Constancia en PDF</button>
                <input type="hidden"  name="codCurso" value=<%="Novalue"%> />
            </form>

        </div>
        <br>           
        <br> 
        <br> 
    </body>
    <%} else {
            response.sendRedirect("error.jsp");
        }%>
    <%@ include file="footer.jsp" %>
</html>
