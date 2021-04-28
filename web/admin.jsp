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
        <div class="container"> 
            <div class="row">
                <div class="col-lg-5">

                    <div class="row">
                        <div class="col-lg-4"> 
                            <img src="images/pururin.jpg" class="rounded-circle img-fluid" alt="Placeholder image">
                        </div>

                        <div class="col-lg-8"> 
                            <h6>Nombre: Qwerty</h6>
                            <h6>Correo: qwerty@protonmail.com</h6>
                            <h6>Tel: 3773244</h6>
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
                                <div class="card-body">CURSOS</div>
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
                                <div class="card-body">CURSOS</div>
                            </div>
                        </div>
                    </div>


                </div>
                <div class="col-lg-6">
                    <div id="accordion4" role="tablist">
                        <div class="card">
                            <div class="card-header" role="tab" id="tituloCuatro">
                                <h5 class="mb-0"> 
                                    <a class="collapsed" data-toggle="collapse" href="#colapsarAcordionCuatro" role="button" aria-expanded="false" aria-controls="colapsarAcordionCuatro">Editar curso </a> 
                                </h5>
                            </div>
                            <div id="colapsarAcordionCuatro" class="collapse" role="tabpanel" aria-labelledby="tituloCuatro" data-parent="#accordion4">
                                <div class="card-body">CURSOS</div>
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
                                    <a class="collapsed" data-toggle="collapse" href="#colapsarAcordionUnoGrupo" role="button" aria-expanded="false" aria-controls="colapsarAcordionUnoGrupo"> Insertar curso </a> 
                                </h5>
                            </div>
                            <div id="colapsarAcordionUnoGrupo" class="collapse" role="tabpanel" aria-labelledby="tituloUnoGrupo" data-parent="#accordion1Grupo">
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
                                <div class="card-body">CURSOS</div>
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
                                <div class="card-body">CURSOS</div>
                            </div>
                        </div>
                    </div>


                </div>
                <div class="col-lg-6">
                    <div id="accordion4" role="tablist">
                        <div class="card">
                            <div class="card-header" role="tab" id="tituloCuatro">
                                <h5 class="mb-0"> 
                                    <a class="collapsed" data-toggle="collapse" href="#colapsarAcordionCuatro" role="button" aria-expanded="false" aria-controls="colapsarAcordionCuatro">Editar curso </a> 
                                </h5>
                            </div>
                            <div id="colapsarAcordionCuatro" class="collapse" role="tabpanel" aria-labelledby="tituloCuatro" data-parent="#accordion4">
                                <div class="card-body">CURSOS</div>
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
                                <div class="card-body">CURSOS</div>
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
                                <div class="card-body">CURSOS</div>
                            </div>
                        </div>
                    </div>


                </div>
                <div class="col-lg-6">
                    <div id="accordion4" role="tablist">
                        <div class="card">
                            <div class="card-header" role="tab" id="tituloCuatro">
                                <h5 class="mb-0"> 
                                    <a class="collapsed" data-toggle="collapse" href="#colapsarAcordionCuatro" role="button" aria-expanded="false" aria-controls="colapsarAcordionCuatro">Editar curso </a> 
                                </h5>
                            </div>
                            <div id="colapsarAcordionCuatro" class="collapse" role="tabpanel" aria-labelledby="tituloCuatro" data-parent="#accordion4">
                                <div class="card-body">CURSOS</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
    <%@ include file="footer.jsp" %>
</html>
