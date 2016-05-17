/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c.sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import m.pojos.Produccion;

/**
 *
 * @author Ar Montalvo
 */
@Stateless
public class ProduccionFacade extends AbstractFacade<Produccion> {

    @PersistenceContext(unitName = "SIP27PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduccionFacade() {
        super(Produccion.class);
    }
    
}
