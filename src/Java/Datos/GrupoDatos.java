/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.Curso;
import Logica.Grupo;
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
public class GrupoDatos {
Conexion cnx = new Conexion();
       Connection cn;
       PreparedStatement ps;
       ResultSet rs;
       CursoDatos cd = new CursoDatos();
       ProfesorDatos pf = new ProfesorDatos();
     
       
    
    public List listar() {
       ArrayList<Grupo>lista = new ArrayList<>();
       String sql = "select * from grupos";
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement)cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
             Grupo g = new Grupo();
             g.setId(rs.getInt("id"));
             g.setCurso(cd.consultarCurso(rs.getInt("codigo_curso")));
             g.setProfesor((Profesor) pf.consultar(rs.getInt("cedula_profesor")));
             g.setHora(rs.getString("horario"));
             lista.add(g);
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
    public Grupo consultar(int id) {
          Grupo g = new Grupo();
        //String sql = "SELECT * FROM cursos WHERE nombre ='" + nombre +"'";
        String sql = "SELECT * FROM grupos WHERE id="+id;
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
             g.setId(rs.getInt("id"));
             g.setCurso(cd.consultarCurso(rs.getInt("codigo_curso")));
             g.setProfesor((Profesor) pf.consultar(rs.getInt("cedula_profesor")));
             g.setHora(rs.getString("horario"));
            }
        } catch (SQLException e) {

        }
        return g;

    }
    public boolean agregar(Grupo g) {
        String sql = "insert into grupos(cedula_profesor,codigo_curso,horario)"
                + "values(" + g.getProfesor().getCedula() + "," + g.getCurso().getCodigo()+",'"+g.getHora()+"')"; 
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    
    public boolean editarGrupo(int id, Profesor p) {
        String sql = "update grupos set cedula_profesor ="+p.getCedula()+" where id="+id;
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
     return true;
    }

   
    public boolean eliminar(int id) {
        String sql = "delete from grupos where id="+id;
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
