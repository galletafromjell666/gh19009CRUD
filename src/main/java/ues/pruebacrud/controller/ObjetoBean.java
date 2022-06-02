/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.pruebacrud.controller;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ues.pruebacrud.entities.Objeto;

/**
 *
 * @author Sara
 */
@Stateless
@LocalBean
public class ObjetoBean extends AbstractDataAcces<Objeto> implements Serializable{
    @PersistenceContext(unitName="bachePU")
    EntityManager em;
    
    @Override
    public EntityManager getEntityManager(){
        return em;
    }
    
    public ObjetoBean(){
        super(Objeto.class);
    }
    
    public List<Objeto> findByIdTipoObjeto(final Integer idTipoObjeto, int first, int pageSize){
        if(this.em != null && idTipoObjeto != null){
            Query q = em.createNamedQuery("Objeto.findByTipoObjeto");
            q.setParameter("idTipoObjeto", idTipoObjeto);
            q.setFirstResult(first);
            q.setMaxResults(pageSize);
            return q.getResultList();
            
        }
        return Collections.EMPTY_LIST;
    }
    
    public int countByIdTipoObjeto(final Integer idTipoObjeto){
        if(this.em != null && idTipoObjeto != null){
            
            Query q = em.createNamedQuery("Objeto.countByTipoObjeto");
            q.setParameter("idTipoObjeto", idTipoObjeto);
            return ((Long) q.getSingleResult()).intValue();
        }
        return 0;
    }   
}
