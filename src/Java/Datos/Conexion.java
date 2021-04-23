/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    public Connection getConnection() {
        return con;
    }
    Connection con;
   public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprueba?allowPublicKeyRetrieval=true&useSSL=false", "root", "");
            
        }catch(ClassNotFoundException | SQLException e){
            System.err.println("Error: " +e);
        }
    }
}
