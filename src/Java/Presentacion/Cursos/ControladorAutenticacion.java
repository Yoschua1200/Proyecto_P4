/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Cursos;

import Datos.AdministradorDatos;
import Datos.EstudianteDatos;
import Datos.ProfesorDatos;
import Datos.UsuarioDatos;
import Logica.Administrador;
import Logica.Estudiante;
import Logica.Profesor;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Danny
 */
@WebServlet(name = "ControladorAutenticacion", 
            urlPatterns = {"/RegistroEstudiante", "/Log", "/Logout"})
public class ControladorAutenticacion extends HttpServlet {
    Usuario usuario = new Usuario();
    UsuarioDatos usuarioDatos = new UsuarioDatos();
    Estudiante estudiante = new Estudiante();
    EstudianteDatos estudianteDatos = new EstudianteDatos();
    Profesor profesor = new Profesor();
    ProfesorDatos profesorDatos = new ProfesorDatos();
    Administrador administrador = new Administrador();
    AdministradorDatos administradorDatos = new AdministradorDatos();
    
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
            
            usuario.setCedula(Integer.parseInt(cedula));
            usuario.setClave("1234");
            usuario.setTipo(1);
            usuarioDatos.agregar(usuario);
            
            estudiante.setCedula(Integer.parseInt(cedula));
            estudiante.setNombre(nombre);
            estudiante.setCorreo(correo);
            estudiante.setTelefono(telefono);
            estudianteDatos.agregar(estudiante);
            
            request.setAttribute("flagE", "si");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            
        }else if("/Log".equals(request.getServletPath())){
            
            String cedula = request.getParameter("cedula");
            request.setAttribute("cedula", cedula);
            String contrasena = request.getParameter("contrasena");
            request.setAttribute("contrasena", contrasena);
            
            usuario = usuarioDatos.validar(Integer.parseInt(cedula),contrasena);
            
            if (usuario!=null) {
                
                if(usuario.getTipo() == 3){
                    administrador = administradorDatos.consultarAdministrador(Integer.parseInt(cedula));
                    String banderaLogin = "1";
                    request.getSession().setAttribute("banderaLogin", banderaLogin);
                    String banderaLoginDos = "true";
                    request.setAttribute("banderaLoginDos", banderaLoginDos);
                    String tipo = "3";
                    request.getSession().setAttribute("tipo", tipo);
                    int cedulaAdmin = administrador.getCedula();
                    request.getSession().setAttribute("cedulaAdmin", cedulaAdmin);
                    String nombre = administrador.getNombre();
                    request.getSession().setAttribute("nombre", nombre);
                    String correo = administrador.getCorreo();
                    request.getSession().setAttribute("correo", correo);
                    String telefono = administrador.getTelefono();
                    request.getSession().setAttribute("telefono", telefono);
                    
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                }else if (usuario.getTipo() == 1) {
                    //SE CREA EL ESTUDIANTE CON BASE UNA CONSULTA POR ID YA VALIDADA
                    estudiante = estudianteDatos.consultarEstudiante(Integer.parseInt(cedula));
                    String banderaLogin = "1";
                    request.getSession().setAttribute("banderaLogin", banderaLogin);
                    String banderaLoginDos = "true";
                    request.setAttribute("banderaLoginDos", banderaLoginDos);
                    String tipo = "1";
                    request.getSession().setAttribute("tipo", tipo);
                    int cedulaEst = estudiante.getCedula();
                    request.getSession().setAttribute("cedulaEst", cedulaEst);
                    String nombre = estudiante.getNombre();
                    request.getSession().setAttribute("nombre", nombre);
                    String correo = estudiante.getCorreo();
                    request.getSession().setAttribute("correo", correo);
                    String telefono = estudiante.getTelefono();
                    request.getSession().setAttribute("telefono", telefono);
                    request.getRequestDispatcher("estudiante.jsp").forward(request, response);
                }else if(usuario.getTipo() == 2){
                    profesor = profesorDatos.consultarProfesor(Integer.parseInt(cedula));
                    String banderaLogin = "1";
                    request.getSession().setAttribute("banderaLogin", banderaLogin);
                    String banderaLoginDos = "true";
                    request.setAttribute("banderaLoginDos", banderaLoginDos);
                    String tipo = "2";
                    request.getSession().setAttribute("tipo", tipo);
                    
                    int cedulaPro = profesor.getCedula();
                    request.getSession().setAttribute("cedulaPro", cedulaPro);
                    String nombre = profesor.getNombre();
                    request.getSession().setAttribute("nombre", nombre);
                    String correo = profesor.getCorreo();
                    request.getSession().setAttribute("correo", correo);
                    String telefono = profesor.getTelefono();
                    request.getSession().setAttribute("telefono", telefono);
                    
                    String especialidad1 = profesor.getEspecialidad1();
                    request.getSession().setAttribute("especialidad1", especialidad1);
                    String especialidad2 = profesor.getEspecialidad2();
                    request.getSession().setAttribute("especialidad2", especialidad2);
                    String especialidad3 = profesor.getEspecialidad3();
                    request.getSession().setAttribute("especialidad3", especialidad3);
                    
                    request.getRequestDispatcher("profesor.jsp").forward(request, response);
                }else{
                    request.setAttribute("error", "si");
                     request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } else if ("/Logout".equals(request.getServletPath())) {
            HttpSession session = request.getSession(true);
            session.invalidate();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    
    public void login(HttpServletRequest request){
     
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
