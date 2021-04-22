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




import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

 

 

 

/*
public class Conexion {

 

 

 

    Connection getConexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}*/
public class Conexion {

 

    public Connection getConnection() {
        return con;
    }

 

    Connection con;
   public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprueba?allowPublicKeyRetrieval=true&useSSL=false", "root", "");
            
        }catch(Exception e){
            System.err.println("Error: " +e);
        }
    }
}



/*
public class Conexion {

    Connection getConexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
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
    
    
    
    
    
   Connection con;
   public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprueba?useSSL=false", "root", "");
            
        }catch(Exception e){
            System.err.println("Error: " +e);
        }
    }
      public static void main(String[] args) {
        Conexion cn = new Conexion();
        Statement st;
        ResultSet rs;
        try {
            st = cn.con.createStatement();
            rs = st.executeQuery("select * from cursos");
            while (rs.next()) {
                System.out.println(rs.getInt("codigo") + " " + rs.getString("nombre")
                        + " " + rs.getString("tematica") + " " + rs.getString("costo")
                        + " " + rs.getString("status") + " " + rs.getString("logo"));
            }
            cn.con.close();
        } catch (Exception e) {
        }
    }
}*/