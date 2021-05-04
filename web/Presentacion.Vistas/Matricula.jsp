<%-- 
    Document   : Matricula
    Created on : 01/05/2021, 01:41:04 PM
    Author     : yosch
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logica.*"%>
<%@page import="java.util.List"%>
<%@page import="Datos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   
    ArrayList<Grupo> grupos = null;
    String cod_curso = (String) request.getParameter("codCurso");
    if (cod_curso != null) {
        int cod = Integer.parseInt(request.getParameter("codCurso"));

        GrupoDatos g1 = new GrupoDatos();
        grupos = g1.listar_por_curso_asociado(cod);
    }
    //List<Grupo> grupos = g1.listar();
%>
<!-- Page Content -->

<!DOCTYPE html>
<html>
    <head>
        <!-- Bootstrap core CSS -->
        <link href="../css/specific.css" rel="stylesheet" type="text/css"/>
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="../images/logo.ico" type="">
        <style>
            body{
                background-color: #1c1d1f;
            }   
            td { text-align: center; }

        </style> 
    </head>
    <body>
        <br>
        <br>
        <br>
        <%@ include file="header.jsp" %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <%if (tipoUsuario != "1") {%>
        <div class="alert alert-danger" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <h4 class="alert-heading">¡Buen intento!</h4>
            <p class="palert">No puedes ingresar sin iniciar sesión o no Tiene Permiso Para realizar la accion!!.</p>
            <hr>
        </div>
        <%}%>
        
        <div class="container">
            <h2>Grupos Disponibles</h2>

            <table class="t">
                <tr>
                    <th>Nombre del Curso</th>
                    <th>Profesor</th>
                    <th>Horario</th>
                    <th>
                        <h2 class="c2">Matricular</h2>
                        <img src="../images/cheque.png" alt=""/>
                    </th>

                </tr>
                <%if (grupos != null) {%>
                <% if (!(grupos.isEmpty())) {%>
                <% for (Grupo g : grupos) {%>
                <tr>
                    <td><%=g.getCurso().getNombre()%></td>
                    <td><%=g.getProfesor().getNombre()%></td>
                    <td><%=g.getHora()%></td>

                    <% if (tipoUsuario == "1") {%>
                <form action="/Proyecto_P4/Presentacion.Vistas/MatricularGrupo" method="POST">
                    <td><button type="submit" class="btn btn-primary btn-lg">Matricular</button></td>
                    <input type = "hidden" name="codGrupo" class="form-control" value="<%= g.getId()%>" placeholder="Eliminar">
                </form>
                </tr>
                <%} else { %>
                <td>NO DISPONIBLE</td>


                <%}%>
                <%}%>
                <%}%>

                <%if (grupos.isEmpty()) {%>
                <td>NO DISPONIBLE</td>
                <td>NO DISPONIBLE</td>
                <td>NO DISPONIBLE</td>
                <td>NO DISPONIBLE</td>
                <%}%>
                <%}%>

                <%if (grupos == null) {%>
                <td>NO DISPONIBLE</td>
                <td>NO DISPONIBLE</td>
                <td>NO DISPONIBLE</td>
                <td>NO DISPONIBLE</td>
                <%}%>
            </table>




        </div>

       
        <br>
        <br>
        <br>
        <br>
        <br>
    </body>

    <%@ include file="footer.jsp" %>
</html>

<!-- /.container -->