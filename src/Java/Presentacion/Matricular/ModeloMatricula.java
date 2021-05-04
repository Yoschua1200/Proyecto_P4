/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package Presentacion.Matricular;

import Datos.MatriculaDatos;

/**
 *
 * @author yosch
 */
public class ModeloMatricula {

    public MatriculaDatos getMd() {
        return md;
    }

    public void setMd(MatriculaDatos md) {
        this.md = md;
    }
    private MatriculaDatos md;

    public ModeloMatricula() {
        this.md = new MatriculaDatos();
    }
}
