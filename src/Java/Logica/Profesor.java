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
public class Profesor extends Persona{

    public String getEspecialidad1() {
        return especialidad1;
    }

    public void setEspecialidad1(String especialidad1) {
        this.especialidad1 = especialidad1;
    }

    public String getEspecialidad2() {
        return especialidad2;
    }

    public void setEspecialidad2(String especialidad2) {
        this.especialidad2 = especialidad2;
    }

    public String getEspecialidad3() {
        return especialidad3;
    }

    public void setEspecialidad3(String especialidad3) {
        this.especialidad3 = especialidad3;
    }
private String especialidad1;
private String especialidad2;
private String especialidad3;

    public Profesor(String nombre, int cedula, String correo, String telefono, Usuario usuario) {
        super(nombre, cedula, correo, telefono, usuario);
    }
  

    public Profesor() {
     super("",0,"","",null);
     this.especialidad1 = "";
     this.especialidad2 = "";
     this.especialidad3 = "";
    }
  



}