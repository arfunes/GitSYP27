/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c.servicios;


import java.util.List;
import m.pojos.Zona;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ar Montalvo
 */
//por el momento no usaremos mas que estas dos partes Zona
public class ZonaServicio {
    public static List<Zona> getZonas() {
        SessionFactory sf = HUtil.getSessionFactory();
        Session ses = sf.openSession();
        return ses.createCriteria(Zona.class).list();
    }
    public static Zona getZonas(int idZona) {
        SessionFactory sf = HUtil.getSessionFactory();
        Session ses = sf.openSession();
        return (Zona) ses.createCriteria(Zona.class, "idzona="+idZona+"");
    }
    
}
