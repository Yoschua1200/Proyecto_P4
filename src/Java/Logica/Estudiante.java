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
public class Estudiante extends Persona {

    public Estudiante(String nombre, int cedula, String correo, String telefono, Usuario usuario) {
        super(nombre, cedula, correo, telefono, usuario);
    }

    public Estudiante() {
       super("",0,"","",null);
    }
    
}
