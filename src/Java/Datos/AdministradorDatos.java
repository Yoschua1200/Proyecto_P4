/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.Administrador;
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
public class AdministradorDatos implements CRUD {
Conexion cnx = new Conexion();
       Connection cn;
       PreparedStatement ps;
       ResultSet rs;
       Persona a = new Administrador();
       
    @Override
    public List listar() {
        
       ArrayList<Persona>lista = new ArrayList<>();
       String sql = "select * from administradores";
       try{
       cn = cnx.getConnection();
       ps = (PreparedStatement) cn.prepareStatement(sql);
       rs = ps.executeQuery();
       while(rs.next()){
           a.setCedula(rs.getInt("id"));
           a.setCorreo(rs.getString("correo electronico"));
           a.setNombre(rs.getString("nombre"));
           a.setTelefono(rs.getString("telefono"));
       }
       
    }catch(SQLException e){
        
    }
       return lista;
    }
    

    @Override
    public Persona consultar(int id) {
       
   
        String sql = "SELECT * FROM administradores WHERE id LIKE'" + id;
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement) cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
           a.setCedula(rs.getInt("id"));
           a.setCorreo(rs.getString("correo electronico"));
           a.setNombre(rs.getString("nombre"));
           a.setTelefono(rs.getString("telefono"));
        
            }
        } catch (SQLException e) {

        }
        return a;

    }

    @Override
    public boolean agregar(Persona per) {
          String sql = "insert into administradores(nombre, correo electronico, telefono)"
                + "values('" + per.getNombre() + "','" 
                + per.getCorreo()+ "','" + per.getTelefono()
                + "','" + per.getTelefono()+"')";
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
         String sql = "delete from administradores where id="+id;
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
