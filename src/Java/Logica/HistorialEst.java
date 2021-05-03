/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author yosch
 */
public class HistorialEst {

    public int getCed_est() {
        return ced_est;
    }

    public void setCed_est(int ced_est) {
        this.ced_est = ced_est;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public String getNombre_prof() {
        return nombre_prof;
    }

    public void setNombre_prof(String nombre_prof) {
        this.nombre_prof = nombre_prof;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public HistorialEst() {
    }

    public HistorialEst(int ced_est, String nombre_curso, String nombre_prof, String horario) {
        this.ced_est = ced_est;
        this.nombre_curso = nombre_curso;
        this.nombre_prof = nombre_prof;
        this.horario = horario;
    }
    private int ced_est;
    private String nombre_curso;
    private String nombre_prof;
    private String horario;
    
}
