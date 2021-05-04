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
//PDF
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author yosch
 */
@WebServlet(name = "Matricular", urlPatterns = {"/Presentacion.Vistas/Matricular", 
        "/Presentacion.Vistas/MatricularGrupo", 
        "/Presentacion.Vistas/Imprimir", "/Presentacion.Vistas/MeterCifra"})

public class Matricular extends HttpServlet {

    ModeloMatricula mm = new ModeloMatricula();
    
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
        int cod = 0;
        switch (request.getServletPath()) {

            case "/Presentacion.Vistas/Matricular":
                cod = Integer.parseInt(request.getParameter("codCurso"));
                request.setAttribute("codCurso", cod);
                request.getRequestDispatcher("/Presentacion.Vistas/Matricula.jsp").forward(request, response);
                break;
            case "/Presentacion.Vistas/MatricularGrupo":
                String cod2 = (String) request.getParameter("codGrupo");
                String ced_estu = (String) request.getSession().getAttribute("cedulaString");
                request.setAttribute("cedula", ced_estu);

                boolean matriculado = this.matricularEst(Integer.parseInt(cod2), Integer.parseInt(ced_estu));

                if (!matriculado) {
                    request.setAttribute("curso_repetido", "si");
                    request.getRequestDispatcher("/Presentacion.Vistas/Matricula.jsp").forward(request, response);
                } else {
                    request.setAttribute("curso_repetido", "no");
                    request.setAttribute("codGrupo", cod2);
                    request.getRequestDispatcher("/Presentacion.Vistas/estudiante.jsp").forward(request, response);
                }
                break;

            case "/Presentacion.Vistas/Imprimir":
                String ced_estu2 = (String) request.getSession().getAttribute("cedulaString");
                int cedula = Integer.parseInt(ced_estu2);
                System.out.println("Id que llega");
                System.out.println(cedula);
                String viewUrl = this.print(request, response, cedula);
                if (viewUrl != null) {
                    request.getRequestDispatcher(viewUrl).forward(request, response);
                }
                break;
            case "/Presentacion.Vistas/MeterCifra":
                String nota = request.getParameter("notaEst");
                String id = request.getParameter("idMatricula");
                request.setAttribute("banderaNota", "si");
                mm.getMd().editarNotas(Integer.parseInt(nota), Integer.parseInt(id));
                request.getRequestDispatcher("/Presentacion.Vistas/profesor.jsp").forward(request, response);
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

    private boolean matricularEst(int codGrupo, int id_estudiante) {
        Matricula m1 = new Matricula();
        GrupoDatos g1 = new GrupoDatos();
        Grupo g_asociado = g1.consultar(codGrupo);
        EstudianteDatos ed = new EstudianteDatos();
        Estudiante e1 = ed.consultarEstudiante(id_estudiante);

        m1.setEstudiante(e1);
        m1.setGrupo(g_asociado);

        MatriculaDatos md = new MatriculaDatos();
        return md.agregar(m1);
    }

    private boolean grupo_curso_agregado(int id_est, int id_grupo) {
        MatriculaDatos m1 = new MatriculaDatos();
        Matricula m2 = m1.consultar_mat_repetida(id_est, id_grupo);
        if (m2.getGrupo() == null || m2.getEstudiante() == null) {
            return true;
        } else {
            return false;
        }
    }

    private String print(HttpServletRequest request, HttpServletResponse response, int id) throws IOException {
        MatriculaDatos m1 = new MatriculaDatos();
        EstudianteDatos e1 = new EstudianteDatos();
        Estudiante p =e1.consultarEstudiante(id);
       
        List<HistorialEst> historial = m1.listar_hist_est(id);
        try {

            PdfDocument pdf = new PdfDocument(new PdfWriter(response.getOutputStream()));
            Document doc = new Document(pdf, PageSize.A4.rotate());
            PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
            for (HistorialEst h : historial) {
                doc.add(new Paragraph("*Historial Academico del Estudiante*"));
                doc.add(new Paragraph(""));
                doc.add(new Paragraph("Id estudiante: " + p.getCedula()));
                doc.add(new Paragraph(""));
                doc.add(new Paragraph("Estudiante: " + p.getNombre()));
                doc.add(new Paragraph(""));
                doc.add(new Paragraph("CURSO: " + h.getNombre_curso()));
                doc.add(new Paragraph(""));
                doc.add(new Paragraph("Profesor a Cargo: " + h.getNombre_prof()));
                doc.add(new Paragraph(""));
                doc.add(new Paragraph("Horario del Curso: " + h.getHorario()));
                doc.add(new Paragraph(""));
            }
            doc.close();
            response.setContentType("application/pdf");
            response.addHeader("Content-disposition", "inline");
            return null;
        } catch (Exception ex) {
            return "/Presentacion.Vistas/error.jsp";
        }
    }

}
