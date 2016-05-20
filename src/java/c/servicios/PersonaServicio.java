/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c.servicios;

import h.util.HUtil;
import java.util.List;
import m.pojos.Dificultades;
import m.pojos.Persona;
import m.pojos.Produccion;
import m.pojos.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ar Montalvo
 */
public class PersonaServicio {
    
    public static List<Persona> getPersonas() {
        SessionFactory sf = HUtil.getSessionFactory();
        Session ses = sf.openSession();
        return ses.createCriteria(Persona.class).list();
    }
boolean editPersona(int idpersona, String nombre, int edad, Boolean sexo, Double ingresosanuales, Integer lugardeventa, int zona, List<Usuario> usuarios, List<Produccion> produccions, List<Dificultades> dificultadeses){
       
    Persona p=new Persona(idpersona, nombre, edad);
    p.setSexo(sexo);
    
    
    p.setZona(ZonaServicio.getZonas(zona));
    p.setIngresosanuales(ingresosanuales);
    
    return true;
}
}
