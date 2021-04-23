/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.Persona;
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
public class ProfesorDatos implements CRUD {
Conexion cnx = new Conexion();
       Connection cn;
       PreparedStatement ps;
       ResultSet rs;
       Profesor p = new Profesor();
       
    @Override
    public List listar() {
        
       ArrayList<Persona>lista = new ArrayList<>();
       String sql = "select * from profesores";
       try{
       cn = cnx.getConnection();
       ps = (PreparedStatement) cn.prepareStatement(sql);
       rs = ps.executeQuery();
       while(rs.next()){
           p.setCedula(rs.getInt("id"));
           p.setCorreo(rs.getString("correo electronico"));
           p.setNombre(rs.getString("nombre"));
           p.setTelefono(rs.getString("telefono"));
           p.AgregarEspecialidad(rs.getString("especialiad 1"));
           p.AgregarEspecialidad(rs.getString("especialiad 2"));
           p.AgregarEspecialidad(rs.getString("especialiad 3"));
       }
       
    }catch(SQLException e){
        
    }
       return lista;
    }
    

    @Override
    public Persona consultar(int id) {
       
   
        String sql = "SELECT * FROM profesores WHERE id LIKE'" + id;
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
           p.setCedula(rs.getInt("id"));
           p.setCorreo(rs.getString("correo electronico"));
           p.setNombre(rs.getString("nombre"));
           p.setTelefono(rs.getString("telefono"));
           p.AgregarEspecialidad(rs.getString("especialiad 1"));
           p.AgregarEspecialidad(rs.getString("especialiad 2"));
           p.AgregarEspecialidad(rs.getString("especialiad 3"));
            }
        } catch (SQLException e) {

        }
        return p;

    }

    @Override
    public boolean agregar(Persona per) {
        Profesor p = (Profesor) per;

          String sql = "insert into profesores(nombre, correo electronico, telefono, especialidad 1, especialidad 2, especialidad 3)"
                + "values('" + p.getNombre() + "','" 
                + p.getCorreo()+ "','" + p.getTelefono()
                + "','" + p.getTelefono()+"','" + p.getEspecialidades().get(0) + p.getEspecialidades().get(1) + p.getEspecialidades().get(2)+"')";
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
         String sql = "delete from profesores where id="+id;
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
