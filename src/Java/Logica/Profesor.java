/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Boris Monge
 */
public class Profesor extends Persona{


    public List<String> getEspecialidades() {
        return especialidades;
    }

    public Profesor(String nombre, int cedula, String correo, String telefono, Usuario usuario) {
        super(nombre, cedula, correo, telefono, usuario);
    }
   private List<String> especialidades = new ArrayList<String>();

    public Profesor() {
     super("",0,"","",null);
    }
  

public void AgregarEspecialidad(String especialidad){
    especialidades.add(especialidad);
}
public boolean EliminarEspecialidad(String especialidad){
    for(int i = 0; i < especialidades.size(); i++)
        if(especialidades.get(i).equalsIgnoreCase(especialidad)){
            especialidades.remove(i);
            return true;
        }
    return false;
}



}