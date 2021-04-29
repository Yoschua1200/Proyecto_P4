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

   

    @Override
    public List listar() {
        
       ArrayList<Persona>lista = new ArrayList<>();
       String sql = "select * from profesores";
       try{
       cn = cnx.getConnection();
       ps = (PreparedStatement) cn.prepareStatement(sql);
       rs = ps.executeQuery();
       while(rs.next()){
           Profesor p = new Profesor();
           p.setCedula(rs.getInt("cedula"));
           p.setCorreo(rs.getString("correo"));
           p.setNombre(rs.getString("nombre"));
           p.setTelefono(rs.getString("telefono"));
           p.setEspecialidad1(rs.getString("especialiad1"));
           p.setEspecialidad2(rs.getString("especialiad2"));
           p.setEspecialidad3(rs.getString("especialiad3"));
           lista.add(p);
       }
       
    }catch(SQLException e){
        
    }
       return lista;
    }
    

    @Override
    public Persona consultar(int id) {
       
    Profesor p = new Profesor();
        String sql = "SELECT * FROM profesores WHERE cedula=" + id;
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
           p.setCedula(rs.getInt("cedula"));
           p.setCorreo(rs.getString("correo"));
           p.setNombre(rs.getString("nombre"));
           p.setTelefono(rs.getString("telefono"));
           p.setEspecialidad1(rs.getString("especialiad1"));
           p.setEspecialidad2(rs.getString("especialiad2"));
           p.setEspecialidad3(rs.getString("especialiad3"));
            }
        } catch (SQLException e) {

        }
        
        return p;

    }

    @Override
    public boolean agregar(Persona per) {
        Profesor p = (Profesor) per;

          String sql = "insert into profesores(cedula, nombre, correo, telefono, especialidad1, especialidad2, especialidad3)"
                + "values("+ p.getCedula()+ ",'"+ p.getNombre() + "','" 
                + p.getCorreo()+ "','" + p.getTelefono()
                + "','" + p.getEspecialidad1()+"','" + p.getEspecialidad2()+"','" + p.getEspecialidad3()+"')";
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
         String sql = "delete from profesores where cedula="+id;
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
