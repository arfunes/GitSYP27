/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c.servicios;

import java.util.List;
import m.pojos.Producto;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ar Montalvo
 */
public class ProductoServicio {

    Session ses = null;

    void getSession() {
        SessionFactory sf = HUtil.getSessionFactory();
        ses = sf.isClosed() ? sf.openSession() : sf.getCurrentSession();
    }

    void closeSession() {
        ses.close();
    }

    void saveProducto(Producto producto) {
        getSession();
        Transaction tx = this.ses.beginTransaction();
        try {
            ses.save(producto);
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        }
    }

    boolean editProducto(Producto producto) {
        getSession();
        Transaction tx = this.ses.beginTransaction();
        try {
            if (ses.contains(producto)) {
                ses.saveOrUpdate(producto);
                return true;
            }
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteProducto(Producto p) {
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

    public List<Producto> getProductos() {
        Transaction tx = this.ses.beginTransaction();
        try {
            getSession();
            return ses.createCriteria(Producto.class).list();
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
            return null;
        }
    }

    public Producto getProducto(Producto pr) {
        Producto prodSelect = null;
        List<Producto> productos = getProductos();
        for (Producto p : productos) {
            prodSelect = (p.getIdproducto() == pr.getIdproducto()) ? p : null;
        }
        return prodSelect;
    }

    public List<Producto> getProducto(String busq) {
        getSession();
        Transaction tx = this.ses.beginTransaction();
        try {
            return ses.createQuery("from Producto as producto where producto." + busq).list();
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
            return null;
        }
    }
}
