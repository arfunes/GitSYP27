/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c.servicios;


import java.util.List;
import m.pojos.Persona;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ar Montalvo
 */
public class PersonaServicio {
    
    //HIBERNATE CRUD

    
    Session ses = null;

    void getSession() {
        SessionFactory sf = HUtil.getSessionFactory();
        ses = sf.isClosed() ? sf.openSession() : sf.getCurrentSession();
    }

    void closeSession() {
        ses.close();
    }

    void savePersona(Persona persona) {
        getSession();
        Transaction tx = this.ses.beginTransaction();
        try {
            ses.save(persona);
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        }
    }

    boolean editPersona(Persona persona) {
        getSession();
        Transaction tx = this.ses.beginTransaction();
        try {
            if (ses.contains(persona)) {
                ses.saveOrUpdate(persona);
                return true;
            }
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deletePersona(Persona p) {
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

    public List<Persona> getPersonas() {
        Transaction tx = this.ses.beginTransaction();
        try {
            getSession();
            return ses.createCriteria(Persona.class).list();
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
            return null;
        }
    }

    public Persona getPersona(Persona pr) {
        Persona personaSelect = null;
        List<Persona> personas = getPersonas();
        for (Persona p : personas) {
            personaSelect = (p.getIdpersona() == pr.getIdpersona()) ? p : null;
        }
        return personaSelect;
    }

    public List<Persona> getPersona(String busq) {
        getSession();
        Transaction tx = this.ses.beginTransaction();
        try {
            return ses.createQuery("from Persona as persona where persona." + busq).list();
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
            return null;
        }
    }
}