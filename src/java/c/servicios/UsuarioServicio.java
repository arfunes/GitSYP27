/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c.servicios;

import h.util.HUtil;
import java.util.List;
import m.pojos.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ar Montalvo
 */
public class UsuarioServicio {

    public static List<Usuario> getUsuarios() {
        SessionFactory sf = HUtil.getSessionFactory();
        Session ses = sf.openSession();
        return ses.createCriteria(Usuario.class).list();
    }

}
