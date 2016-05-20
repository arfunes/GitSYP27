/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v.weblistener;

import c.servicios.PersonaServicio;
import c.servicios.UsuarioServicio;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import m.pojos.Persona;

/**
 * Web application lifecycle listener.
 *
 * @author Ar Montalvo
 */
public class PersonaListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<Persona> lista = PersonaServicio.getPersona();
        
        //dejando la lista de usuarios en la nube
        sce.getServletContext().setAttribute("productores", lista);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}