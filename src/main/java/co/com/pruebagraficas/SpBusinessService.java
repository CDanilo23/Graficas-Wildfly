/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.pruebagraficas;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cristian.ordonez
 */
@Stateless
public class SpBusinessService implements SpBusinessServiceLocal {

    @PersistenceContext(unitName = "Infovalmer-PU")
    EntityManager em;

    @Override
    public List<SpValoresPuntos> listarValoresVelas() {
        List<SpValoresPuntos> li  = new ArrayList<SpValoresPuntos>();
        try {
            Query query = em.createQuery("select sp from SpValoresPuntos sp");
            li=query.getResultList();
            System.err.println(li.get(1).getOpen());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return li;
    }

}
