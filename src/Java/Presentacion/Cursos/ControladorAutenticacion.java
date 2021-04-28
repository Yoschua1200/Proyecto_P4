/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Cursos;

import Datos.EstudianteDatos;
import Logica.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Danny
 */
@WebServlet(name = "ControladorAutenticacion", 
            urlPatterns = {"/RegistroEstudiante", "/Log"})
public class ControladorAutenticacion extends HttpServlet {
    
    Estudiante estudiante = new Estudiante();
    EstudianteDatos estudianteDatos = new EstudianteDatos();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if("/RegistroEstudiante".equals(request.getServletPath())){
            String cedula = request.getParameter("cedula");
            request.setAttribute("cedula", cedula);
            String nombre = request.getParameter("nombre");
            request.setAttribute("nombre", nombre);
            String telefono = request.getParameter("telefono");
            request.setAttribute("telefono", telefono);
            String correo = request.getParameter("correo");
            request.setAttribute("correo", correo);
            
            estudiante.setCedula(Integer.parseInt(cedula));
            estudiante.setNombre(nombre);
            estudiante.setCorreo(correo);
            estudiante.setTelefono(telefono);
            estudianteDatos.agregar(estudiante);
            
            request.getRequestDispatcher("login.jsp").forward(request, response);
            
        }else if("/Login".equals(request.getServletPath())){
            
            //if(request.getParameter("correo")==)
            out.println("Error");
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
