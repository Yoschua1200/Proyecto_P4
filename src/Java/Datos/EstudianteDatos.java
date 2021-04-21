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
       Persona per = new Estudiante();
       
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
           p.setCedula(rs.getInt("id"));
           p.setCorreo(rs.getString("correo electronico"));
           p.setNombre(rs.getString("nombre"));
           p.setTelefono(rs.getString("telefono"));
       }
       
    }catch(SQLException e){
        
    }
       return lista;
    }
    

    @Override
    public Persona consultar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar(Persona per) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Persona per) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Persona per) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
