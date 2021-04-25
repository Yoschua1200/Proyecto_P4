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
public class Matricula {

    public String get;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Matricula(Curso curso, Estudiante estudiante, float nota) {
        this.curso = curso;
        this.estudiante = estudiante;
        this.nota = nota;
    }
     public Matricula() {
        this.curso = null;
        this.estudiante = null;
        this.nota = 0;
    }
    private Curso curso;
    private Estudiante estudiante;
    private float nota;
}
