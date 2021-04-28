/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

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

public class EstudianteDatos implements CRUD {
Conexion cnx = new Conexion();
       Connection cn;
       PreparedStatement ps;
       ResultSet rs;
      
       
    @Override
    public List listar() {
        
       ArrayList<Persona>lista = new ArrayList<>();
       String sql = "select * from estudiantes";
       try{
       cn = cnx.getConnection();
       ps = (PreparedStatement) cn.prepareStatement(sql);
       rs = ps.executeQuery();
       while(rs.next()){
            Persona p = new Estudiante();
           p.setCedula(rs.getInt("cedula"));
           p.setCorreo(rs.getString("correo"));
           p.setNombre(rs.getString("nombre"));
           p.setTelefono(rs.getString("telefono"));
           lista.add(p);
       }
       
    }catch(SQLException e){
        
    }
       return lista;
    }
    

    @Override
    public Persona consultar(int id) {
       
        Persona p = new Estudiante();
        String sql = "SELECT * FROM estudiante WHERE cedula =" + id;
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) { 
           p.setCedula(rs.getInt("cedula"));
           p.setCorreo(rs.getString("correo"));
           p.setNombre(rs.getString("nombre"));
           p.setTelefono(rs.getString("telefono"));
        
            }
        } catch (SQLException e) {

        }
        return p;

    }

    @Override
    public boolean agregar(Persona per) {
          String sql = "insert into estudiante(cedula, nombre, correo, telefono)"
                        + "values('"+ per.getCedula()+ "','" 
                        + per.getNombre() + "','" 
                        + per.getCorreo()+ "','" 
                        + per.getTelefono()+"')";
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean editar(Persona per) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
         String sql = "delete from estudiantes where cedula="+id;
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
