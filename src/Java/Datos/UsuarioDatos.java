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
       Usuario u = new Usuario();
       
    
    public List listar() {
        
       ArrayList<Usuario>lista = new ArrayList<>();
       String sql = "select * from usuarios";
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement)cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt("id"));
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
    public List consultar(int id) {
        ArrayList<Usuario> lista = new ArrayList<>();
        //String sql = "SELECT * FROM cursos WHERE nombre ='" + nombre +"'";
        String sql = "SELECT * FROM usuarios WHERE id LIKE'" + id +"%'";
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setClave(rs.getString("clave"));
                u.setTipo(rs.getInt("tipo"));
                lista.add(u);
            }
        } catch (SQLException e) {

        }
        return lista;

    }
    public boolean agregar(Usuario u) {
        String sql = "insert into usuarios(id, clave, tipo)"
                + "values('" + u.getId() + "','" 
                + u.getClave()+ "','" + u.getTipo() +"')";
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
    
}
