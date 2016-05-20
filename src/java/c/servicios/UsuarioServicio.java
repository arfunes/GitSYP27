/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c.servicios;

import h.util.HUtil;
import java.util.ArrayList;
import java.util.List;
import m.pojos.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ar Montalvo
 */
public class UsuarioServicio {

    public static Usuario isUser(String nombre, String pasword) {
        SessionFactory sf = HUtil.getSessionFactory();
        Session ses = sf.openSession();

        Usuario uV;

        List<Usuario> list = new ArrayList<Usuario>();
        list = ses.createCriteria(Usuario.class).list();
        if (list.isEmpty()) {
            list.add(new Usuario(0, "def", "def",true, null));
        }
        for (Usuario us : list) {
            if (us.getNombreusuario().equalsIgnoreCase(nombre) && us.getPasword().equalsIgnoreCase(pasword)) {
                return us;
            }
        }

        return null;
    }
    public Usuario setUsuario (int idusuario, String nombreusuario, String pasword, Boolean privilegio, List personas){
        return null;
    }
}
