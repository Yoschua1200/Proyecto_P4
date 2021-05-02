/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Cursos;

import Datos.CursoDatos;
import Logica.Curso;

/**
 *
 * @author Boris Monge
 */
public class ModeloCursos {

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public CursoDatos getCursosdatos() {
        return cursosdatos;
    }

    public void setCursosdatos(CursoDatos cursosdatos) {
        this.cursosdatos = cursosdatos;
    }
    private Curso curso = new Curso();
    private CursoDatos cursosdatos = new CursoDatos();
}
