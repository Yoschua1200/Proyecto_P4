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
       String sql = "select * from profesor";
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
           p.AgregarEspecialidad(rs.getString("especialiad1"));
           p.AgregarEspecialidad(rs.getString("especialiad2"));
           p.AgregarEspecialidad(rs.getString("especialiad3"));
           lista.add(p);
       }
       
    }catch(SQLException e){
        
    }
       return lista;
    }
    

    @Override
    public Persona consultar(int id) {
       
    Profesor p = new Profesor();
        String sql = "SELECT * FROM profesor WHERE cedula =" + id;
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
           p.setCedula(rs.getInt("cedula"));
           p.setCorreo(rs.getString("correo"));
           p.setNombre(rs.getString("nombre"));
           p.setTelefono(rs.getString("telefono"));
           p.AgregarEspecialidad(rs.getString("especialiad1"));
           p.AgregarEspecialidad(rs.getString("especialiad2"));
           p.AgregarEspecialidad(rs.getString("especialiad3"));
            }
        } catch (SQLException e) {

        }
        
        return p;

    }

    @Override
    public boolean agregar(Persona per) {
        Profesor p = (Profesor) per;

          String sql = "insert into profesores(cedula, nombre, correo electronico, telefono, especialidad1, especialidad2, especialidad3)"
                + "values('"+ p.getCedula()+ "','"+ p.getNombre() + "','" 
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
         String sql = "delete from profesor where cedula="+id;
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
