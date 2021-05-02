/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Grupos;

import Logica.Curso;
import Logica.Profesor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Boris Monge
 */
@WebServlet(name = "ControladorGrupo", urlPatterns = {"/Presentacion.Vistas/RegistroGrupo", 
    "/Presentacion.Vistas/EliminarGrupo", "/Presentacion.Vistas/ConsultarGrupo", "/Presentacion.Vistas/EditarGrupo"})
public class ControladorGrupo extends HttpServlet {
ModeloGrupo mg = new ModeloGrupo();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
            /* TODO output your page here. You may use following sample code. */
              if ("/Presentacion.Vistas/RegistroGrupo".equals(request.getServletPath())) {
            String codigoCurso = request.getParameter("curso");
            request.setAttribute("curso", codigoCurso);
            String cedProfe = request.getParameter("profesor");
            request.setAttribute("profesor", cedProfe);
            String horario = request.getParameter("horario");
            request.setAttribute("horario", horario);
            mg.getGrupo().setCurso(mg.getCurd().consultarCurso(Integer.parseInt(codigoCurso)));
            mg.getGrupo().setProfesor((Profesor) mg.getProfd().consultar(Integer.parseInt(cedProfe)));
            mg.getGrupo().setHora(horario);
            boolean x = mg.getGrupd().agregar(mg.getGrupo());
            
             if(x==true){ request.setAttribute("flagA", "si");}
            else{request.setAttribute("flagA", "no");}
            request.getRequestDispatcher("/Presentacion.Vistas/admin.jsp").forward(request, response);
          }
          else if ("/Presentacion.Vistas/EliminarGrupo".equals(request.getServletPath())) { 
              boolean x = mg.getGrupd().eliminar(Integer.parseInt(request.getParameter("IdElim")));
               if(x==true){ request.setAttribute("flagE", "si");}
            else{request.setAttribute("flagE", "no");}
            request.getRequestDispatcher("/Presentacion.Vistas/admin.jsp").forward(request, response);
              }
          else if ("/Presentacion.Vistas/ConsultarGrupo".equals(request.getServletPath())) {    
              String CodCurso = request.getParameter("codigoConsul");
             request.setAttribute("ConsultaGrupo", CodCurso);
             request.getRequestDispatcher("/Presentacion.Vistas/admin.jsp").forward(request, response); 
            }
          else if ("/Presentacion.Vistas/EditarGrupo".equals(request.getServletPath())) {    
            String cedProf = request.getParameter("EditGrupo");
             String CodGrupo = request.getParameter("IdGrupo");
             Profesor p = (Profesor) mg.getProfd().consultar(Integer.parseInt(cedProf));
             boolean x = mg.getGrupd().editarGrupo(Integer.parseInt(CodGrupo), p);
              if(x==true){ request.setAttribute("flagEd", "si");}
              else{request.setAttribute("flagEd", "no");}
             request.getRequestDispatcher("/Presentacion.Vistas/admin.jsp").forward(request, response); 
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
