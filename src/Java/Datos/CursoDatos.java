/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.Curso;
import Logica.Estudiante;
import Logica.Persona;
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

public class CursoDatos {
Conexion cnx = new Conexion();
       Connection cn;
       PreparedStatement ps;
       ResultSet rs;
       
       
    
    public List listar() {
        
       ArrayList<Curso>lista = new ArrayList<>();
       String sql = "select * from cursos";
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement)cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Curso c = new Curso();
                c.setCodigo(rs.getInt("codigo"));
                c.setNombre(rs.getString("nombre"));
                c.setTematica(rs.getString("tematica"));
                c.setCosto(rs.getString("costo"));
                c.setStatus(rs.getString("status"));
                c.setLogo(rs.getString("logo"));
                lista.add(c);
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
    public List consultar(String nombre) {
        ArrayList<Curso> lista = new ArrayList<>();
        String sql = "SELECT * FROM cursos WHERE nombre LIKE'" + nombre + "%'" + "or tematica LIKE'" + nombre + "%'";
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Curso c = new Curso();
                c.setCodigo(rs.getInt("codigo"));
                c.setNombre(rs.getString("nombre"));
                c.setTematica(rs.getString("tematica"));
                c.setCosto(rs.getString("costo"));
                c.setStatus(rs.getString("status"));
                c.setLogo(rs.getString("logo"));
                lista.add(c);
            }
        } catch (SQLException e) {

        }
        return lista;

    }
    
     public Curso consultarCurso(int codigo) {
         Curso cur = new Curso();
        //String sql = "SELECT * FROM cursos WHERE nombre ='" + nombre +"'";
        String sql = "SELECT * FROM cursos WHERE codigo=" + codigo;
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cur.setCodigo(rs.getInt("codigo"));
                cur.setNombre(rs.getString("nombre"));
                cur.setTematica(rs.getString("tematica"));
                cur.setCosto(rs.getString("costo"));
                cur.setStatus(rs.getString("status"));
                cur.setLogo(rs.getString("logo"));
               
            }
        } catch (SQLException e) {
          
        }
        return cur;

    }
        public List ofertaCurso() {
        ArrayList<Curso> lista = new ArrayList<>();
        String sql = "SELECT * FROM cursos WHERE status='Oferta'";
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Curso c = new Curso();
                c.setCodigo(rs.getInt("codigo"));
                c.setNombre(rs.getString("nombre"));
                c.setTematica(rs.getString("tematica"));
                c.setCosto(rs.getString("costo"));
                c.setStatus(rs.getString("status"));
                c.setLogo(rs.getString("logo"));
                lista.add(c);
                
            }
        } catch (SQLException e) {

        }
        return lista;

    }
    
    public boolean agregar(Curso cur) {
        String sql = "insert into cursos(nombre, tematica, costo, status, logo)"
                    + "values('" + cur.getNombre() + "','" 
                    + cur.getTematica() + "','" + cur.getCosto()
                    + "','" + cur.getStatus() + "','" + cur.getLogo() +"')";
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

   
    public boolean eliminar(int cod) {
        String sql = "delete from cursos where codigo="+cod;
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
