/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Grupos;

import Datos.CursoDatos;
import Datos.GrupoDatos;
import Datos.ProfesorDatos;
import Logica.Grupo;

/**
 *
 * @author Boris Monge
 */


public class ModeloGrupo {
    
     private Grupo grupo;
 private GrupoDatos grupd;
 private CursoDatos curd;
 private ProfesorDatos profd;


    public CursoDatos getCurd() {
        return curd;
    }

    public void setCurd(CursoDatos curd) {
        this.curd = curd;
    }

    public ProfesorDatos getProfd() {
        return profd;
    }

    public void setProfd(ProfesorDatos profd) {
        this.profd = profd;
    }

    public GrupoDatos getGrupd() {
        return grupd;
    }

    public void setGrupd(GrupoDatos grupd) {
        this.grupd = grupd;
    }
   
    public ModeloGrupo() {
        this.grupo = new Grupo();
        this.grupd = new GrupoDatos();
        this.curd = new CursoDatos();
        this.profd = new ProfesorDatos();
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    
}
