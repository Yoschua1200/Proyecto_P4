/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.Curso;
import Logica.Estudiante;
import Logica.Grupo;
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
       CursoDatos cd = new CursoDatos();
       EstudianteDatos ed = new EstudianteDatos();
     
       
    
    public List listar() {
       ArrayList<Matricula>lista = new ArrayList<>();
       String sql = "select * from matricula";
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement)cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
             Matricula m = new Matricula();
             m.setCurso(cd.consultarCurso(rs.getString("id_curso")));
             m.setEstudiante((Estudiante) ed.consultar(rs.getInt("id_estudiante")));
             m.setNota(rs.getFloat("nota_estudiante"));
             lista.add(m);
            }
    }catch(SQLException e){
        
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
        String sql = "SELECT * FROM matricula WHERE id="+id;
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
             m.setCurso(cd.consultarCurso(rs.getString("id_curso")));
             m.setEstudiante((Estudiante) ed.consultar(rs.getInt("estudiante")));
             m.setNota(rs.getFloat("nota_estudiante"));
            }
        } catch (SQLException e) {

        }
        return m;

    }
    public boolean agregar(Matricula m) {
        String sql = "insert into grupos(id_curso,id_estudiante,nota_estudiante)"
                + "values('"+ m.getCurso().getCodigo() + "','" + m.getEstudiante().getCedula()+ "','" + m.getNota()+"')";
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    
    public boolean editar(Curso cur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public boolean eliminar(int id) {
        String sql = "delete from matricula where cedula="+id;
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
}
