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
public class Grupo {

    public Grupo() {
        this.profesor = null;
        this.curso = null;
        this.hora = null;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Grupo(Curso curso, Profesor profesor, String hora) {
        this.curso = curso;
        this.profesor = profesor;
        this.hora = hora;
    }
    private Curso curso;
    private Profesor profesor;
    private String hora;
}
