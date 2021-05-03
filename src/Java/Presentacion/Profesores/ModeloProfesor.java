/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Profesores;

import Datos.ProfesorDatos;
import Datos.UsuarioDatos;
import Logica.Profesor;
import Logica.Usuario;

/**
 *
 * @author Boris Monge
 */
public class ModeloProfesor {

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   private Usuario usuario;
           

    public UsuarioDatos getUsuariod() {
        return usuariod;
    }

    public void setUsuariod(UsuarioDatos usuariod) {
        this.usuariod = usuariod;
    }
    
  
    private Profesor profesor;
    private ProfesorDatos profd;
    private UsuarioDatos usuariod;
    
    public ProfesorDatos getProfd() {
        return profd;
    }

    public void setProfd(ProfesorDatos profd) {
        this.profd = profd;
    }
     
    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

 
    public ModeloProfesor() {
        this.profesor = new Profesor();
        this.profd = new ProfesorDatos();
        this.usuariod = new UsuarioDatos();
        this.usuario = new Usuario();
        
    }
   
    
}
