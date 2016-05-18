/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c.weblistener;

import c.servicios.UsuarioServicio;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import m.pojos.Usuario;

/**
 * Web application lifecycle listener.
 *
 * @author Ar Montalvo
 */
public class ObjListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<Usuario> listaUsuarios = UsuarioServicio.getUsuario();
        
        //dejando la lista de usuarios en la nube
        sce.getServletContext().setAttribute("usuarios", listaUsuarios);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
