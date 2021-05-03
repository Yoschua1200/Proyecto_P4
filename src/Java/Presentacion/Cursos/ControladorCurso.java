/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Cursos;

import Datos.CursoDatos;
import Logica.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Danny
 */
//CONTROLADOR log
@WebServlet(name = "ServletRegistroCurso", 
                urlPatterns = {"/Presentacion.Vistas/RegistroCurso", 
                                "/Presentacion.Vistas/EditarCurso", 
                                "/Presentacion.Vistas/BuscarCurso", 
                                "/Presentacion.Vistas/EliminarCurso", 
                                "/Presentacion.Vistas/ConsultarCurso",  
                                "/Presentacion.Vistas/Index"})
public class ControladorCurso extends HttpServlet {

    ModeloCursos md = new ModeloCursos();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String flag = "";
        if ("/Presentacion.Vistas/RegistroCurso".equals(request.getServletPath())) {
            flag = "registrar";
            request.setAttribute("flag", flag);
            String codigo = request.getParameter("codigo");
            request.setAttribute("codigo", codigo);
            String nombre = request.getParameter("nombre");
            request.setAttribute("nombre", nombre);
            String tematica = request.getParameter("tematica");
            request.setAttribute("tematica", tematica);
            String costo = request.getParameter("costo");
            request.setAttribute("costo", costo);
            String status = request.getParameter("status");
            request.setAttribute("status", status);
            String logo = request.getParameter("logo");
            request.setAttribute("logo", logo);
            
            md.getCurso().setNombre(nombre);
            md.getCurso().setTematica(tematica);
            md.getCurso().setCosto(costo);
            md.getCurso().setStatus(status);
            md.getCurso().setLogo(logo);
            boolean x = md.getCursosdatos().agregar(md.getCurso());
             if(x==true){ request.setAttribute("flagA", "si");}
            else{request.setAttribute("flagA", "no");}
            request.getRequestDispatcher("/Presentacion.Vistas/admin.jsp").forward(request, response);
        }else if("/Presentacion.Vistas/BuscarCurso".equals(request.getServletPath())) {
            flag = "consulta";
            request.setAttribute("flag", flag);
            String nombre = request.getParameter("nombre");
            request.setAttribute("nombre", nombre);
            //cursosdatos.consultar(nombre);
            request.getRequestDispatcher("/Presentacion.Vistas/busqueda.jsp").forward(request, response);
        }else if("/Presentacion.Vistas/Index".equals(request.getServletPath())) {
            flag = "index";
            request.getRequestDispatcher("/Presentacion.Vistas/index.jsp").forward(request, response);
        }
        else if("/Presentacion.Vistas/EliminarCurso".equals(request.getServletPath())) {
           // cursosdatos.eliminar((int) request.getAttribute("codigoElim"));
           boolean x = md.getCursosdatos().eliminar(Integer.parseInt(request.getParameter("codigoElim")));
             if(x==true){ request.setAttribute("flagE", "si");}
            else{request.setAttribute("flagE", "no");}
               request.getRequestDispatcher("/Presentacion.Vistas/admin.jsp").forward(request, response);   
        }
         else if("/Presentacion.Vistas/ConsultarCurso".equals(request.getServletPath())){
             String CodCurso = request.getParameter("codigoConsul");
             request.setAttribute("ConsultaCurso", CodCurso);
             request.getRequestDispatcher("/Presentacion.Vistas/admin.jsp").forward(request, response); 
              
         }
         else if("/Presentacion.Vistas/EditarCurso".equals(request.getServletPath())){
             boolean flag2;
             String CodCurso = request.getParameter("codigoActualizar");
             Curso c = md.getCursosdatos().consultarCurso(Integer.parseInt(CodCurso));
             if(c.getStatus().equals("Oferta")){
                 flag2 = true;
             }
             else{
                 flag2 = false;
             }
             boolean x = md.getCursosdatos().editarStatus(Integer.parseInt(CodCurso),flag2);
              if(x==true){ request.setAttribute("flagEd", "si");}
              else{request.setAttribute("flagEd", "no");}
             request.getRequestDispatcher("/Presentacion.Vistas/admin.jsp").forward(request, response); 
              
         }
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
  
}
