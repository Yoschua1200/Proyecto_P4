/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

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
        urlPatterns = {"/RegistroCurso", "/EditarCurso", "/VerCurso", "/Eliminar", "/Consulta"})
public class ServletRegistroCurso extends HttpServlet {

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
        /*String placa = request.getParameter("placa");
        String restriccion = this.getRestriccion(placa);
        request.setAttribute("dia", restriccion);
        
        request.getRequestDispatcher("Pruebas.jsp").forward(request, response);
        */
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
            request.getRequestDispatcher("Pruebas.jsp").forward(request, response);
        }else if ("/VerCurso".equals(request.getServletPath())) {
            flag = "ver";
            request.setAttribute("flag", flag);
            request.getRequestDispatcher("Pruebas.jsp").forward(request, response);
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
    
    /*private String getRestriccion(String placa){
        
        switch(placa.charAt(placa.length()-1)){
            case '1': case '2': return "Lunes xD";
            case '3': case '4': return "Martes xD";
            default: return "Sin restriccion";
        }
    }*/
}
