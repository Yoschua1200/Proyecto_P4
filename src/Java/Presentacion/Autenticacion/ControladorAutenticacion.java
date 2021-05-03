/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Autenticacion;


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
            urlPatterns = {"/Presentacion.Vistas/RegistroEstudiante", 
                           "/Presentacion.Vistas/Log", 
                           "/Presentacion.Vistas/Logout"})
public class ControladorAutenticacion extends HttpServlet {
    ModeloAutenticacion ma = new ModeloAutenticacion();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if("/Presentacion.Vistas/RegistroEstudiante".equals(request.getServletPath())){
            String cedula = request.getParameter("cedula");
            request.setAttribute("cedula", cedula);
            String nombre = request.getParameter("nombre");
            request.setAttribute("nombre", nombre);
            String telefono = request.getParameter("telefono");
            request.setAttribute("telefono", telefono);
            String correo = request.getParameter("correo");
            request.setAttribute("correo", correo);
            String clave = request.getParameter("clave");
            request.setAttribute("clave", clave);
            
            ma.getUsuario().setCedula(Integer.parseInt(cedula));
            ma.getUsuario().setClave(clave);
            ma.getUsuario().setTipo(1);
            ma.getUsuarioDatos().agregar(ma.getUsuario());
            
            ma.getEstudiante().setCedula(Integer.parseInt(cedula));
            ma.getEstudiante().setNombre(nombre);
            ma.getEstudiante().setCorreo(correo);
            ma.getEstudiante().setTelefono(telefono);
            ma.getEstudianteDatos().agregar(ma.getEstudiante());
            
            request.setAttribute("flagE", "si");
            request.getRequestDispatcher("/Presentacion.Vistas/login.jsp").forward(request, response);
            
        }else if("/Presentacion.Vistas/Log".equals(request.getServletPath())){
            
            String cedula = request.getParameter("cedula");
            request.setAttribute("cedula", cedula);
            String contrasena = request.getParameter("contrasena");
            request.setAttribute("contrasena", contrasena);
            
            ma.setUsuario(ma.getUsuarioDatos().validar(Integer.parseInt(cedula),contrasena));
            
            if (ma.getUsuario()!=null) {
                
                if(ma.getUsuario().getTipo() == 3){
                    ma.setAdministrador(ma.getAdministradorDatos().consultarAdministrador(Integer.parseInt(cedula)));
                    String banderaLogin = "1";
                    request.getSession().setAttribute("banderaLogin", banderaLogin);
                    String banderaLoginDos = "true";
                    request.setAttribute("banderaLoginDos", banderaLoginDos);
                    String tipo = "3";
                    request.getSession().setAttribute("tipo", tipo);
                    int cedulaAdmin = ma.getAdministrador().getCedula();
                    request.getSession().setAttribute("cedulaAdmin", cedulaAdmin);
                    String nombre = ma.getAdministrador().getNombre();
                    request.getSession().setAttribute("nombre", nombre);
                    String correo = ma.getAdministrador().getCorreo();
                    request.getSession().setAttribute("correo", correo);
                    String telefono =ma.getAdministrador().getTelefono();
                    request.getSession().setAttribute("telefono", telefono);
                    
                    request.getRequestDispatcher("/Presentacion.Vistas/admin.jsp").forward(request, response);
                }else if (ma.getUsuario().getTipo() == 1) {
                    //SE CREA EL ESTUDIANTE CON BASE UNA CONSULTA POR ID YA VALIDADA
                    ma.setEstudiante(ma.getEstudianteDatos().consultarEstudiante(Integer.parseInt(cedula)));
                    String banderaLogin = "1";
                    request.getSession().setAttribute("banderaLogin", banderaLogin);
                    String banderaLoginDos = "true";
                    request.setAttribute("banderaLoginDos", banderaLoginDos);
                    String tipo = "1";
                    request.getSession().setAttribute("tipo", tipo);
                    int cedulaEst = ma.getEstudiante().getCedula();
                    request.getSession().setAttribute("cedulaEst", cedulaEst);
                    String cedulaString = String.valueOf(ma.getEstudiante().getCedula());
                     request.getSession().setAttribute("cedulaString", cedulaString);
                    String nombre = ma.getEstudiante().getNombre();
                    request.getSession().setAttribute("nombre", nombre);
                    String correo = ma.getEstudiante().getCorreo();
                    request.getSession().setAttribute("correo", correo);
                    String telefono = ma.getEstudiante().getTelefono();
                    request.getSession().setAttribute("telefono", telefono);
                    request.getRequestDispatcher("/Presentacion.Vistas/estudiante.jsp").forward(request, response);
                }else if(ma.getUsuario().getTipo() == 2){
                    ma.setProfesor(ma.getProfesorDatos().consultarProfesor(Integer.parseInt(cedula)));
                    String banderaLogin = "1";
                    request.getSession().setAttribute("banderaLogin", banderaLogin);
                    String banderaLoginDos = "true";
                    request.setAttribute("banderaLoginDos", banderaLoginDos);
                    String tipo = "2";
                    request.getSession().setAttribute("tipo", tipo);
                    
                    int cedulaPro = ma.getProfesor().getCedula();
                    request.getSession().setAttribute("cedulaPro", cedulaPro);
                    String nombre = ma.getProfesor().getNombre();
                    request.getSession().setAttribute("nombre", nombre);
                    String correo = ma.getProfesor().getCorreo();
                    request.getSession().setAttribute("correo", correo);
                    String telefono = ma.getProfesor().getTelefono();
                    request.getSession().setAttribute("telefono", telefono);
                    
                    String especialidad1 = ma.getProfesor().getEspecialidad1();
                    request.getSession().setAttribute("especialidad1", especialidad1);
                    String especialidad2 = ma.getProfesor().getEspecialidad2();
                    request.getSession().setAttribute("especialidad2", especialidad2);
                    String especialidad3 = ma.getProfesor().getEspecialidad3();
                    request.getSession().setAttribute("especialidad3", especialidad3);
                    
                    request.getRequestDispatcher("/Presentacion.Vistas/profesor.jsp").forward(request, response);
                }else{
                    request.setAttribute("error", "si");
                     request.getRequestDispatcher("/Presentacion.Vistas/login.jsp").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("/Presentacion.Vistas/login.jsp").forward(request, response);
            }

        } else if ("/Presentacion.Vistas/Logout".equals(request.getServletPath())) {
            HttpSession session = request.getSession(true);
            session.invalidate();
            request.getRequestDispatcher("/Presentacion.Vistas/index.jsp").forward(request, response);
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
