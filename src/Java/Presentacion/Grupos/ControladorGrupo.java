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
@WebServlet(name = "ControladorGrupo", urlPatterns = {"/RegistroGrupo", "/EliminarGrupo", "/ConsultarGrupo"})
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
              if ("/RegistroGrupo".equals(request.getServletPath())) {
            String codigoCurso = request.getParameter("curso");
            request.setAttribute("curso", codigoCurso);
            String cedProfe = request.getParameter("profesor");
            request.setAttribute("profesor", cedProfe);
            String horario = request.getParameter("horario");
            request.setAttribute("horario", horario);
            mg.getGrupo().setCurso(mg.getCurd().consultarCurso(Integer.parseInt(codigoCurso)));
            mg.getGrupo().setProfesor((Profesor) mg.getProfd().consultar(Integer.parseInt(cedProfe)));
            mg.getGrupo().setHora(horario);
            mg.getGrupd().agregar(mg.getGrupo());
            request.getRequestDispatcher("admin.jsp").forward(request, response);
          }
          else if ("/EliminarGrupo".equals(request.getServletPath())) {    
                   request.getRequestDispatcher("admin.jsp").forward(request, response);
              }
          else if ("/ConsultarGrupo".equals(request.getServletPath())) {    
              String CodCurso = request.getParameter("codigoConsul");
             request.setAttribute("Consulta", CodCurso);
             request.getRequestDispatcher("admin.jsp").forward(request, response); 
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
