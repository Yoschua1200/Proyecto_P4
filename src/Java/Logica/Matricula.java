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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
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

    public Matricula(int id, Grupo grupo, Estudiante estudiante, float nota) {
        this.id = id;
        this.grupo = grupo;
        this.estudiante = estudiante;
        this.nota = nota;
    }
     public Matricula() {
         this.id = 0;
        this.grupo = null;
        this.estudiante = null;
        this.nota = 0;
    }
    private int id;
    private Grupo grupo;
    private Estudiante estudiante;
    private float nota;
}
