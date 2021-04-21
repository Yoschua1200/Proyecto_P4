/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.Persona;
import java.util.List;

/**
 *
 * @author Boris Monge
 */
public interface CRUD {
    public List listar();
    public Persona consultar(int id);
    public boolean agregar(Persona per);
    public boolean editar(Persona per);
    public boolean eliminar(Persona per);
}
