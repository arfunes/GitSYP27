/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c.servicios;

//Hibernate
import java.util.ArrayList;
import java.util.List;
import m.pojos.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//SQL

/**
 *
 * @author Ar Montalvo
 */
public class UsuarioServicio {

     static SessionFactory sf = HUtil.getSessionFactory();
     static Session ses = sf.openSession();
static void closeSession(){
        ses.close();
    }
    public static List<Usuario> getUsuarios() {
        List<Usuario> list = new ArrayList<Usuario>();
        list = ses.createCriteria(Usuario.class).list();
        return list;
    }

    public static Usuario isUser(Usuario usuario) {
        List<Usuario> list = getUsuarios();
        Usuario uV = null;
        if (list.isEmpty()) {
            list.add(new Usuario(0, "def", "def", true, null));
        }
        for (Usuario us : list) {
            if (usuario.getNombreusuario().equalsIgnoreCase(us.getNombreusuario())) {
                if (us.getPasword().equals(usuario.getPasword())) {
                    return us;
                }
            }
        }
        return uV;
    }

    /*    public Usuario setUsuario (int idusuario, String nombreusuario, String pasword, Boolean privilegio, List personas){
    return null;
    }*/
    public static List<Usuario> getUsuariosSql() {

        return null;
    }
}
