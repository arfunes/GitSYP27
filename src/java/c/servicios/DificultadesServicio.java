/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c.servicios;

import java.util.List;
import m.pojos.Dificultades;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ar Montalvo
 */
class DificultadesServicio {

    public static List<Dificultades> getDificultades(int idpersona) {
    SessionFactory sf = HUtil.getSessionFactory();
        Session ses = sf.openSession();
        return ses.createCriteria(Dificultades.class, ""+idpersona+"").list();
    }
    
    Session ses = null;

    void getSession() {
        SessionFactory sf = HUtil.getSessionFactory();
        ses = sf.isClosed() ? sf.openSession() : sf.getCurrentSession();
    }

    void closeSession() {
        ses.close();
    }

    void saveDificultades(Dificultades dif) {
        getSession();
        Transaction tx = this.ses.beginTransaction();
        try {
            ses.save(dif);
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        }
    }

    boolean editDificultades(Dificultades dif) {
        getSession();
        Transaction tx = this.ses.beginTransaction();
        try {
            if (ses.contains(dif)) {
                ses.saveOrUpdate(dif);
                return true;
            }
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteDificultades(Dificultades p) {
        getSession();
        Transaction tx = this.ses.beginTransaction();
        try {
            if (ses.contains(p)) {
                ses.delete(p);
                return true;
            }
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        }
        return false;
    }

    public List<Dificultades> getDificultadess() {
        Transaction tx = this.ses.beginTransaction();
        try {
            getSession();
            return ses.createCriteria(Dificultades.class).list();
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
            return null;
        }
    }

    public Dificultades getDificultades(Dificultades pr) {
        Dificultades difSelect = null;
        List<Dificultades> difs = getDificultadess();
        for (Dificultades p : difs) {
            difSelect = (p.getIddificultad()== pr.getIddificultad()) ? p : null;
        }
        return difSelect;
    }

    public List<Dificultades> getDificultades(String busq) {
        getSession();
        Transaction tx = this.ses.beginTransaction();
        try {
            return ses.createQuery("from Dificultades as dif where dif." + busq).list();
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
            return null;
        }
    }
}

