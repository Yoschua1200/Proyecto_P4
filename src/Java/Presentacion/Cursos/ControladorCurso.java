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
                urlPatterns = {"/RegistroCurso", "/EditarCurso", "/BuscarCurso",
                                "/VerCurso", "/EliminarCurso", "/ConsultarCurso", "/Matricular", "/Index"})
public class ControladorCurso extends HttpServlet {

    Curso curso = new Curso();
    CursoDatos cursosdatos = new CursoDatos();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String flag = "";
        if ("/RegistroCurso".equals(request.getServletPath())) {
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
            
            curso.setNombre(nombre);
            curso.setTematica(tematica);
            curso.setCosto(costo);
            curso.setStatus(status);
            curso.setLogo(logo);
            cursosdatos.agregar(curso);
            
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }else if ("/VerCurso".equals(request.getServletPath())) {
            flag = "ver";
            request.setAttribute("flag", flag);
            request.getRequestDispatcher("Pruebas.jsp").forward(request, response);
        }else if("/BuscarCurso".equals(request.getServletPath())) {
            flag = "consulta";
            request.setAttribute("flag", flag);
            String nombre = request.getParameter("nombre");
            request.setAttribute("nombre", nombre);
            //cursosdatos.consultar(nombre);
            request.getRequestDispatcher("busqueda.jsp").forward(request, response);
        }else if("/Index".equals(request.getServletPath())) {
            flag = "index";
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else if("/EliminarCurso".equals(request.getServletPath())) {
           // cursosdatos.eliminar((int) request.getAttribute("codigoElim"));
            cursosdatos.eliminar(Integer.parseInt(request.getParameter("codigoElim")));
               request.getRequestDispatcher("admin.jsp").forward(request, response);   
        }
         else if("/ConsultarCurso".equals(request.getServletPath())){
             String CodCurso = request.getParameter("codigoConsul");
             request.setAttribute("Consulta", CodCurso);
             request.getRequestDispatcher("admin.jsp").forward(request, response); 
              
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
