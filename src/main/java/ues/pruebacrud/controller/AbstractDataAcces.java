/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.pruebacrud.controller;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Sara
 */
public abstract class AbstractDataAcces<T> implements Serializable{
    
    protected final Class clase;

    public AbstractDataAcces(Class clase) {
        this.clase = clase;
    }
    
    public abstract EntityManager getEntityManager();
    
    public void crear(T nuevo) throws IllegalArgumentException, IllegalStateException{
        
        if(nuevo!=null){
            EntityManager em = null;
            try{
                em = this.getEntityManager();
            }catch(Exception e){
            }
            if(em!=null){
                em.persist(nuevo);
                return;
            }else{
                throw new IllegalStateException("El registro no se pudo almacenar");
            }
        }
        throw new IllegalArgumentException();      
    }
    
    public void modificar(T registro) throws IllegalArgumentException, IllegalStateException{
        
        if(registro!=null){
            EntityManager em = null;
            try{
                em = this.getEntityManager();
            }catch(Exception e){
            }
            if(em!=null){
                em.merge(registro);
                return;
            }else{
                throw new IllegalStateException("El registro no se pudo modificar");
            }
        }
        throw new IllegalArgumentException();
        
    }
    
    public void eliminar(T registro) throws IllegalArgumentException, IllegalStateException{
        
        if(registro!=null){
            EntityManager em = null;
            try{
                em = this.getEntityManager();
            }catch(Exception e){
            }
            if(em!=null){
                em.remove(em.merge(registro));
                return;
            }else{
                throw new IllegalStateException("El registro no se pudo eliminar");
            }
        }
        throw new IllegalArgumentException();
        
    }
    
    public T findById(final Object id) throws IllegalArgumentException, IllegalStateException{
        if(id!=null){
            EntityManager em = null;
            try{
                em = this.getEntityManager();
            }catch(Exception e){
            }
            if(em!=null){
                return (T) em.find(clase, id);
            }
            throw new IllegalStateException("No se puede obtener persistencia");
        }
        throw new IllegalArgumentException();
    }
    
    public List<T> findAll() throws IllegalStateException{
        EntityManager em = null;
        try{
            em = this.getEntityManager();
        }catch(Exception e){
        }
        if(em!=null){
            TypedQuery consulta = this.generarConsulta(em);
            List salida = consulta.getResultList();
            if(salida!=null){
                return salida;
            }
            return Collections.EMPTY_LIST;
        }
        throw new IllegalStateException("No se puede obtener persistencia");
    }
    
    public List<T> findRange(int first, int pageSize) throws IllegalStateException{
        EntityManager em = null;
        try{
            em = this.getEntityManager();
        }catch(Exception e){
        }
        if(em!=null){
            TypedQuery consulta = this.generarConsulta(em);
            consulta.setFirstResult(first);
            consulta.setMaxResults(pageSize);
            List salida = consulta.getResultList();
            if(salida!=null){
                return salida;
            }
            return Collections.EMPTY_LIST;
        }
        throw new IllegalStateException("No se puede obtener persistencia");
    }
    
    
    protected TypedQuery generarConsulta(EntityManager em){
        if(em!=null){
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(clase);
            Root<T> raiz = cq.from(clase);
            cq.select(raiz);
            return em.createQuery(cq);
        }
        throw new IllegalArgumentException();
    }
    
    public Long contar() throws IllegalStateException{
        EntityManager em = null;
        try{
            em = this.getEntityManager();
        }catch(Exception e){
        }
        if(em!=null){
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Long> cq = cb.createQuery(Long.class);
            cq.select(cb.count(cq.from(clase)));
            return em.createQuery(cq).getSingleResult();
        }
        throw new IllegalStateException("No se puede obtener persistencia");
    }
}
