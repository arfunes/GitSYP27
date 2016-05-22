/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c.control;

import c.servicios.*;
import java.util.List;
import m.pojos.Persona;
import m.pojos.Usuario;

/**
 *
 * @author Ar Montalvo
 */
public class Control {

    //crud usuario
    public Usuario getUser(String nombre, String pasword) {
        return UsuarioServicio.isUser(new Usuario(0, nombre, pasword));
    }
    //crud Persona
    public List<Persona> getPersonas(){
        return getPersonas();
    }
    public Persona thisPersona(int idPersona){
        Persona p=new Persona();
        p.setIdpersona(idPersona);
        PersonaServicio ps=new PersonaServicio();
        return ps.getPersona(p);
    }
    //crud dificultades
    //crud zona
    //crud producto
    //crud categoria
    //crud produccion
}
