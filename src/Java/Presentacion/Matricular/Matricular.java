/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Matricular;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Datos.*;
import Logica.*;

/**
 *
 * @author yosch
 */
@WebServlet(name = "Matricular", urlPatterns = {"/Presentacion.Vistas/Matricular","/Presentacion.Vistas/MatricularGrupo"})

public class Matricular extends HttpServlet {

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

        switch (request.getServletPath()) {
            case "/Presentacion.Vistas/Matricular":
                int cod = Integer.parseInt(request.getParameter("codCurso"));
                request.setAttribute("codCurso", cod);
                request.getRequestDispatcher("/Presentacion.Vistas/Matricula.jsp").forward(request, response);
                break;
            case "/Presentacion.Vistas/MatricularGrupo":
                int cod2 = Integer.parseInt(request.getParameter("codGrupo"));
                request.setAttribute("codGrupo", cod2);
                request.getRequestDispatcher("/Presentacion.Vistas/historial.jsp").forward(request, response);
                break;

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
