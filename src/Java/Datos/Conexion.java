/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
public class Conexion {

    Connection getConexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}*/
public class Conexion {
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USER = "root";
    //private static String PASSWORD = "contrasql";
    private static String PASSWORD = "";
    private static String URL = "jdbc:mysql://localhost:3306/dbprueba?useSSL=false";
  
   
    static{
        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"ERROR EN EL DRIVER"+e);
        }
    }
    public Connection getConnection(){
        
        Connection con = null;
        try{
            con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
            JOptionPane.showMessageDialog(null,"Conexion exitosa");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR en la conexion"+e);
        }
        return con;
    }

}