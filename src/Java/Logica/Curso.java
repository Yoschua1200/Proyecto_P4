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
public class Curso {

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + "nombre=" + nombre + ", tematica=" + tematica + ", logo=" + logo + ", costo=" + costo + ", status=" + status + '}';
    }
    
    public Curso(int codigo, String nombre, String tematica, String costo, String status, String logo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tematica = tematica;
        this.logo = logo;
        this.costo = costo;
        this.status = status;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    private int codigo;
    private String nombre;
    private String tematica;
    private String logo;
    private String costo;
    private String status;

    public Curso() {
        this.codigo = 0;
        this.nombre = "";
        this.tematica = "";
        this.logo = "";
        this.costo = "";
        this.status = "";
    }
}
