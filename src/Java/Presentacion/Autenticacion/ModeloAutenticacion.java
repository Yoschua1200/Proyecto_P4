/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Autenticacion;

import Datos.AdministradorDatos;
import Datos.EstudianteDatos;
import Datos.ProfesorDatos;
import Datos.UsuarioDatos;
import Logica.Administrador;
import Logica.Estudiante;
import Logica.Profesor;
import Logica.Usuario;

/**
 *
 * @author Boris Monge
 */
public class ModeloAutenticacion {

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDatos getUsuarioDatos() {
        return usuarioDatos;
    }

    public void setUsuarioDatos(UsuarioDatos usuarioDatos) {
        this.usuarioDatos = usuarioDatos;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public EstudianteDatos getEstudianteDatos() {
        return estudianteDatos;
    }

    public void setEstudianteDatos(EstudianteDatos estudianteDatos) {
        this.estudianteDatos = estudianteDatos;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public ProfesorDatos getProfesorDatos() {
        return profesorDatos;
    }

    public void setProfesorDatos(ProfesorDatos profesorDatos) {
        this.profesorDatos = profesorDatos;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public AdministradorDatos getAdministradorDatos() {
        return administradorDatos;
    }

    public void setAdministradorDatos(AdministradorDatos administradorDatos) {
        this.administradorDatos = administradorDatos;
    }
    private Usuario usuario = new Usuario();
    private UsuarioDatos usuarioDatos = new UsuarioDatos();
    private Estudiante estudiante = new Estudiante();
    private EstudianteDatos estudianteDatos = new EstudianteDatos();
    private Profesor profesor = new Profesor();
    private ProfesorDatos profesorDatos = new ProfesorDatos();
    private Administrador administrador = new Administrador();
    private AdministradorDatos administradorDatos = new AdministradorDatos();
}
