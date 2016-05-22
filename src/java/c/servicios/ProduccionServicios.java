/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c.servicios;

import java.util.List;
import m.pojos.Produccion;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ar Montalvo
 */
public class ProduccionServicios {
    
    Session ses = null;

    void getSession() {
        SessionFactory sf = HUtil.getSessionFactory();
        ses = sf.isClosed() ? sf.openSession() : sf.getCurrentSession();
    }

    void closeSession() {
        ses.close();
    }

    void saveProduccion(Produccion produccion) {
        getSession();
        Transaction tx = this.ses.beginTransaction();
        try {
            ses.save(produccion);
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        }
    }

    boolean editProduccion(Produccion produccion) {
        getSession();
        Transaction tx = this.ses.beginTransaction();
        try {
            if (ses.contains(produccion)) {
                ses.saveOrUpdate(produccion);
                return true;
            }
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteProduccion(Produccion p) {
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

    public List<Produccion> getProduccions() {
        Transaction tx = this.ses.beginTransaction();
        try {
            getSession();
            return ses.createCriteria(Produccion.class).list();
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
            return null;
        }
    }

    public Produccion getProduccion(Produccion pr) {
        Produccion prodSelect = null;
        List<Produccion> produccions = getProduccions();
        for (Produccion p : produccions) {
            prodSelect = (p.getIdproduccion() == pr.getIdproduccion()) ? p : null;
        }
        return prodSelect;
    }

    public List<Produccion> getProduccion(String busq) {
        getSession();
        Transaction tx = this.ses.beginTransaction();
        try {
            return ses.createQuery("from Produccion as produccion where produccion." + busq).list();
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
            return null;
        }
    }
}