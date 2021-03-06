/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.Curso;
import Logica.Estudiante;
import Logica.Grupo;
import Logica.HistorialEst;
import Logica.Matricula;
import Logica.Profesor;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Boris Monge
 */
public class MatriculaDatos {

    Conexion cnx = new Conexion();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    GrupoDatos cd = new GrupoDatos();
    EstudianteDatos ed = new EstudianteDatos();

    public List listar() {
        ArrayList<Matricula> lista = new ArrayList<>();
        String sql = "select * from matriculas";
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Matricula m = new Matricula();
                m.setId(rs.getInt("id"));
                m.setGrupo(cd.consultar(rs.getInt("id_grupo")));
                m.setEstudiante((Estudiante) ed.consultar(rs.getInt("id_estudiante")));
                m.setNota(rs.getFloat("nota_estudiante"));
                lista.add(m);
            }
        } catch (SQLException e) {

        }
        return lista;
    }
    public List listarPorGrupo(int id) {
        ArrayList<Matricula> lista = new ArrayList<>();
        String sql = "select * from matriculas where id_grupo="+id;
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Matricula m = new Matricula();
                m.setId(rs.getInt("id"));
                m.setGrupo(cd.consultar(rs.getInt("id_grupo")));
                m.setEstudiante((Estudiante) ed.consultar(rs.getInt("id_estudiante")));
                m.setNota(rs.getInt("nota_estudiante"));
                lista.add(m);
            }
        } catch (SQLException e) {

        }
        return lista;
    }

    /*public static void main(String[] args) {
         CursosDatos k = new CursosDatos();
         
         //System.out.println(k.listar().toString());
         System.out.println(k.consultar("Virtual Box").toString());
     }*/
    public Matricula consultar(int id) {
        Matricula m = new Matricula();
        //String sql = "SELECT * FROM cursos WHERE nombre ='" + nombre +"'";
        String sql = "SELECT * FROM matriculas WHERE id=" + id;
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                m.setId(rs.getInt("id"));
                m.setGrupo(cd.consultar(rs.getInt("id_grupo")));
                m.setEstudiante((Estudiante) ed.consultar(rs.getInt("id_estudiante")));
                m.setNota(rs.getFloat("nota_estudiante"));
            }
        } catch (SQLException e) {

        }
        return m;

    }
    public boolean editarNotas(int nota, int id) {
       String sql = "update matriculas set nota_estudiante ="+nota+" where id ="+id;

      try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
     return true;
    }

    public boolean agregar(Matricula m) {
        String sql = "insert into matriculas(id,id_grupo,id_estudiante,nota_estudiante)"
                + "values('" + m.getId() + "','" + m.getGrupo().getId() + "','" + m.getEstudiante().getCedula() + "','" + m.getNota() + "')";
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.executeUpdate();
            //this.actualizarHistorial();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean editar(Curso cur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean eliminar(int id) {
        String sql = "delete from matriculas where cedula=" + id;
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public List listar_hist_est(int id) {
        ArrayList<HistorialEst> lista = new ArrayList<>();
        String sql = "SELECT * FROM historial_est WHERE ced_est=" + id;
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HistorialEst h = new HistorialEst();
                h.setCed_est(rs.getInt("ced_est"));
                h.setHorario(rs.getString("horario"));
                h.setNombre_curso(rs.getString("nombre_curso"));
                h.setNombre_prof(rs.getString("nombre_prof"));

                lista.add(h);
            }
        } catch (SQLException e) {

        }
        return lista;
    }

    public Matricula consultar_mat_repetida(int id_est, int id_grupo) {
        Matricula m = new Matricula();
        String sql = "SELECT * FROM matriculas WHERE id_estudiante=" + id_est + "and id_grupo=" + id_grupo;
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                m.setId(rs.getInt("id"));
                m.setGrupo(cd.consultar(rs.getInt("id_grupo")));
                m.setEstudiante((Estudiante) ed.consultar(rs.getInt("id_estudiante")));
                m.setNota(rs.getFloat("nota_estudiante"));
            }
        } catch (SQLException e) {

        }
        return m;

    }

    public void actualizarHistorial() {

        String sql = "CREATE or REPLACE VIEW historial_est as SELECT e.cedula ced_est,c.nombre nombre_curso ,p.nombre nombre_prof,g.horario \n"
                + "from estudiantes e,cursos c, profesores p , grupos g ,matriculas m \n"
                + "where g.cedula_profesor=p.cedula and \n"
                + "g.codigo_curso = c.codigo and \n"
                + "m.id_estudiante = e.cedula and m.id_grupo=g.id ;";
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            rs = ps.executeQuery();

        } catch (SQLException e) {

        }

    }

}
