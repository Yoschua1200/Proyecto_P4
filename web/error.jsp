<%-- 
    Document   : error
    Created on : 28 abr. 2021, 18:38:01
    Author     : Danny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<div class="alert alert-danger" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
    <h4 class="alert-heading">¡Buen intento!</h4>
    <p>No puedes ingresar sin iniciar sesión. </p>
    <hr>
</div>
<body style="padding-top: 70px; padding-bottom: 70px;">
    <br>
    <%@ include file="header.jsp" %>
    <>
    <div class="container"> 
        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-7">
                <img src="images/dino.gif" alt="Dinochrome">
            </div>
            <div class="col-lg-2"></div>
        </div>
    </div>

</body>
<%@ include file="footer.jsp" %>
</html>

