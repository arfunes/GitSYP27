/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c.servicios;

import java.util.List;
import m.pojos.Categoria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ar Montalvo
 */
public class CategoriaServicio {

    public List<Categoria> getCategorias() {
        Transaction tx = this.ses.beginTransaction();
        try {
            getSession();
            return ses.createCriteria(Categoria.class).list();
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
            return null;
        }
    }

    Session ses = null;

    void getSession() {
        SessionFactory sf = HUtil.getSessionFactory();
        ses = sf.isClosed() ? sf.openSession() : sf.getCurrentSession();
    }

    void closeSession() {
        ses.close();
    }

    void saveCategoria(Categoria categoria) {
        getSession();
        Transaction tx = this.ses.beginTransaction();
        try {
            ses.save(categoria);
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        }
    }

    boolean editCategoria(Categoria categoria) {
        getSession();
        Transaction tx = this.ses.beginTransaction();
        try {
            if (ses.contains(categoria)) {
                ses.saveOrUpdate(categoria);
                return true;
            }
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteCategoria(Categoria p) {
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
    /*
    public List<Categoria> getCategorias() {
    
    }*/

    public Categoria getCategoria(Categoria pr) {
        Categoria catSelect = null;
        List<Categoria> categorias = getCategorias();
        for (Categoria p : categorias) {
            catSelect = (p.getIdcategoria() == pr.getIdcategoria()) ? p : null;
        }
        return catSelect;
    }

    public List<Categoria> getCategoria(String busq) {
        getSession();
        Transaction tx = this.ses.beginTransaction();
        try {
            return ses.createQuery("from Categoria as categoria where categoria." + busq).list();
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
            return null;
        }
    }
}
