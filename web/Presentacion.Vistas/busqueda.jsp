<%-- 
    Document   : busqueda
    Created on : 18 abr. 2021, 21:19:05
    Author     : Danny
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Logica.Curso"%>
<%@page import="java.util.List"%>
<%@page import="Datos.CursoDatos"%>

<%
    String nombre = (String) request.getAttribute("nombre");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@ include file="header.jsp" %>
    <body style="padding-top: 70px;">
        <div class="container">
            <h3 class="resultado">Resultado de la búsqueda: "<%=nombre%>"</h3>


            <%
                if (nombre != "") {
                    CursoDatos curso = new CursoDatos();
                    List<Curso> list = curso.consultar(nombre);
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
                            <div class="col-lg-6">


                                <img src="../images/<%= c.getLogo()%>"  class="rounded img-fluid" alt="Placeholder image"> 
                            </div>
                            <div class="col-lg-6">
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
                                            <h5>Logo: <%= c.getLogo()%></h5>
                                        </tr>
                                        <tr>
                                           <form action="/Proyecto_P4/Presentacion.Vistas/Matricular",",class="form-inline my-2 my-lg-0" , method="POST">
                                                <button type="submit" class="btn btn-primary btn-lg">Ver Grupos Disponibles</button>
                                                <input  name="codCurso" value=<%=c.getCodigo()%> />
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
            <%}
                  }%>
        </div>

    </body>
    <br>
    <%@ include file="footer.jsp" %>
</html>
