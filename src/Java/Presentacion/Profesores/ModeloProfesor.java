/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Profesores;

import Datos.ProfesorDatos;
import Logica.Profesor;

/**
 *
 * @author Boris Monge
 */
public class ModeloProfesor {
    private Profesor profesor;
    private ProfesorDatos profd;
    
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
    }
   
    
}
