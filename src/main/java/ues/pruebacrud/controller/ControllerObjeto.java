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
import ues.pruebacrud.exception.DataNotFoundException;

/**
 *
 * @author Sara
 */
@Stateless
@LocalBean
public class ControllerObjeto extends AbstractDataAcces<Objeto> implements Serializable{
    
        @PersistenceContext(unitName = "bachePU")
        EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    public ControllerObjeto(){
        super(Objeto.class);
    }
    
    public List<Objeto> findByName (final String name){
        Query q = em.createNamedQuery("Objeto.findByNombre");
            q.setParameter("nombre", name);
            return q.getResultList();
    }
    
    public List<Objeto> findByIdTipoObjeto(final Integer idTipoObjeto, int first, int pageSize){
        if(this.em != null && idTipoObjeto != null){
            Query q = em.createNamedQuery("Objeto.findByTipoObjeto");
            q.setParameter("idTipoObjeto", idTipoObjeto);
            q.setFirstResult(first);
            q.setMaxResults(pageSize);
            if(q.getResultList().size()==0){
                throw new DataNotFoundException("Entity Tipo Objeto with id "+idTipoObjeto+" not found");
            }
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
