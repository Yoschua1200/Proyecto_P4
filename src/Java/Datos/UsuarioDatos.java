/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.Curso;
import Logica.Usuario;
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
public class UsuarioDatos {
Conexion cnx = new Conexion();
       Connection cn;
       PreparedStatement ps;
       ResultSet rs;
      
       
    
    public List listar() {
        
       ArrayList<Usuario>lista = new ArrayList<>();
       String sql = "select * from usuarios";
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement)cn.prepareStatement(sql);
            rs = ps.executeQuery();
            Usuario u = new Usuario();
            while (rs.next()) {
                u.setCedula(rs.getInt("cedula"));
                u.setClave(rs.getString("clave"));
                u.setTipo(rs.getInt("tipo"));
                lista.add(u);
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
    public Usuario consultar(int id) {
        Usuario u = new Usuario();
        //String sql = "SELECT * FROM cursos WHERE nombre ='" + nombre +"'";
        String sql = "SELECT * FROM usuarios WHERE id ="+ id;
        try {
            
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setCedula(rs.getInt("id"));
                u.setClave(rs.getString("clave"));
                u.setTipo(rs.getInt("tipo"));
              
            }
        } catch (SQLException e) {

        }
        return u;

    }
    public boolean agregar(Usuario u) {
        String sql = "insert into usuarios(cedula, contrasena, tipo)"
                    + "values('" + u.getCedula() 
                    + "','" 
                    + u.getClave()
                    + "','" + u.getTipo() 
                    +"')";
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
        String sql = "delete from usuarios where id="+id;
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
    public Usuario validar(int ced, String pass){
        String sql = "select * from usuarios where cedula=? and contrasena=?";

        try {
            Usuario usuario = new Usuario();
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.setInt(1, ced);
            ps.setString(2, "1234");
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario.setCedula(rs.getInt("cedula"));
                usuario.setClave(rs.getString("contrasena"));
                usuario.setTipo(rs.getInt("tipo"));

            }
            return usuario;
        } catch (SQLException e) {
           
        }
        return null;
    }
    
}
