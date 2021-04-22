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

public class CursosDatos {
Conexion cnx = new Conexion();
       Connection cn;
       PreparedStatement ps;
       ResultSet rs;
       Curso cur = new Curso();
       
    
    public List listar() {
        
       ArrayList<Curso>lista = new ArrayList<>();
       String sql = "select * from cursos";
        try {
            cn = cnx.getConnection();
            ps = (PreparedStatement)cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Curso c = new Curso();
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
         
         System.out.println(k.listar().toString());
     }*/
    public Persona consultar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean agregar(Curso cur) {
        String sql = "insert into cursos(nombre, costo, tematica, status)values('"+cur.getNombre()+"','"+cur.getCosto()+"','"+cur.getTematica()+"','"+cur.getStatus()+"')";
        try{
        cn = cnx.getConnection();
       ps = (PreparedStatement) cn.prepareStatement(sql);
       ps.executeUpdate();
        }catch(SQLException e){
          return false;  
        }
        return true;
    }

    
    public boolean editar(Curso cur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public boolean eliminar(Curso cur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}