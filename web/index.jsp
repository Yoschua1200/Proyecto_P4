<%-- 
    Document   : index
    Created on : 18 abr. 2021, 5:20:42
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
<link href="css/bootstrap-4.4.1.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>

<body style="padding-top: 70px; padding-bottom: 70px;">
    
<%@ include file="header.jsp" %>
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

<div class="row texto-centrado">
    <div class="col-lg-2">

    </div>
    <div class="col-lg-8">

        <form action="RegistroCurso" method="POST">
            <h3> Registrar curso </h3> 
            <input type="text" name="codigo" placeholder="Código">
            <input type="text" name="nombre" placeholder="Nombre">
            <input type="text" name="tematica" placeholder="Temática">
            <input type="text" name="costo" placeholder="Costo">
            <input type="text" name="status" placeholder="Status">
            <input type="text" name="logo" placeholder="Logo">

            <input type="submit" value="Consultar">
        </form>

        <!-- <form action="RegistroCurso" method="POST">
            registrar curso <input type="text" name="placa">
            <input type="submit" value="Consultar">
        </form>*
        -->
    </div>
    <div class="col-lg-2">

    </div>
</div>
</div>




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
</div>
</body>
<%@ include file="footer.jsp" %>
</html>
