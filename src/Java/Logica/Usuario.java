/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Boris Monge
 */
public class Usuario  implements java.io.Serializable {

     private int id;
     private String clave;
     private int tipo;
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Usuario() {
        this.id = 0;
        this.clave = "";
        this.tipo = 0;
    }
    
    public Usuario(int id, String clave, int tipo) {
       this.id = id;
       this.clave = clave;
       this.tipo = tipo;
    }
   
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    public int getTipo() {
        return this.tipo;
    }
    
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}