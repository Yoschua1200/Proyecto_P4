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


     private String cedula;
     private String clave;
     private int tipo;


    public Usuario() {
    }

	
    public Usuario(String cedula) {
        this.cedula = cedula;
    }
    public Usuario(String cedula, String clave, int tipo) {
       this.cedula = cedula;
       this.clave = clave;
       this.tipo = tipo;
    }
   
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
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