/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Profesores;

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
@WebServlet(name = "ControladorProfesor", urlPatterns = {"/RegistroProfesor"})
public class ControladorProfesor extends HttpServlet {
ModeloProfesor mp = new ModeloProfesor();
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
            String cedula = request.getParameter("cedula");
            request.setAttribute("cedula", cedula);
            String nombre = request.getParameter("nombre");
            request.setAttribute("nombre", nombre);
            String correo = request.getParameter("correo");
            request.setAttribute("correo", correo);
            String telefono = request.getParameter("telefono");
            request.setAttribute("telefono", telefono);
            String especialidad1 = request.getParameter("especialidad1");
            request.setAttribute("especialidad1", especialidad1);
            String especialidad2 = request.getParameter("especialidad2");
            request.setAttribute("especialidad2", especialidad2);
            String especialidad3 = request.getParameter("especialidad3");
            request.setAttribute("especialidad3", especialidad3);
            mp.getProfesor().setCedula(Integer.parseInt(cedula));
            mp.getProfesor().setNombre(nombre);
            mp.getProfesor().setCorreo(correo);
            mp.getProfesor().setTelefono(telefono);
            mp.getProfesor().setEspecialidad1(especialidad1);
            mp.getProfesor().setEspecialidad2(especialidad2);
            mp.getProfesor().setEspecialidad3(especialidad3);
            mp.getProfd().agregar(mp.getProfesor());
            request.getRequestDispatcher("admin.jsp").forward(request, response);
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