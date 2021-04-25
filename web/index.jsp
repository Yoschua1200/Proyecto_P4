<%-- 
    Document   : index
    Created on : 18 abr. 2021, 5:20:42
    Author     : Danny
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Logica.Curso"%>
<%@page import="java.util.List"%>
<%@page import="Datos.CursoDatos"%>
<%
    String oferta = (String) request.getAttribute("oferta");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CursosLibres.com</title>
        <link href="css/bootstrap-4.4.1.css" rel="stylesheet" type="text/css">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <link rel="shortcut icon" href="images/logo.ico" type="">

    </head>

    <body style="padding-top: 70px; padding-bottom: 70px;">
        <br>
        <%@ include file="header.jsp" %>

        <div class="container">
            <div id="carouselExampleIndicators1" class="carousel slide" data-ride="carousel" style="background-color: grey">
                <div class="carousel-inner" role="listbox">

                    <%
                        if (1 != 2) {
                            CursoDatos curso = new CursoDatos();
                            List<Curso> list = curso.ofertaCurso();
                            Iterator<Curso> iter = list.iterator();
                            Curso c = null;
                            while (iter.hasNext()) {

                                c = iter.next();
                    %>
                    <div class="carousel-item active"> 
                        <img class="d-block mx-auto" src="images/<%= c.getLogo()%>" alt="First slide">
                        <div class="carousel-caption">
                            <h5><%= c.getNombre()%></h5>
                        </div>
                    </div>
                    <%}
                    }%>

                </div>
            </div>

        </div>
        <br>
        <div class="container-fluid">
            <div class="row texto-centrado">
                <div class="col-lg-2">

                </div>
                <div class="col-lg-8">
                    <img src="images/index.jpg" width="100%"" height="100%" alt=""/>
                </div>
                <div class="col-lg-2">

                </div>
            </div>
        </div>


    </div>



<!--
<div class="row texto-centrado">
    <div class="col-lg-2">

    </div>
    <div class="col-lg-8">

        <form action="VerCurso" method="POST">
            <h3> Wachar </h3> 
            <input type="submit" value="Consultar">
        </form>

    </div>
    <div class="col-lg-2">

    </div>
</div>

<div class="row texto-centrado">
    <div class="col-lg-2">

    </div>
    <div class="col-lg-8">

        <form action="Consultar" method="POST">
            <h3> Wachar </h3> 
            <input type="text" name="nombre" placeholder="Nombre">
            <input type="submit" value="Consultar">
        </form>

    </div>
    <div class="col-lg-2">

    </div>
</div>-->
</div>
</body>
<%@ include file="footer.jsp" %>
</html>
