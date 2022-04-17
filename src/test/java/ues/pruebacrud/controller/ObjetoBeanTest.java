/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.pruebacrud.controller;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import ues.pruebacrud.entities.Objeto;

/**
 *
 * @author Sara
 */
public class ObjetoBeanTest {
    
    public ObjetoBeanTest() {
    }
    
     @org.junit.jupiter.api.Test
    public void testgetEntityManager() throws Exception {
        ObjetoBean cut = new ObjetoBean();
        cut.getEntityManager();
    }
    

    /**
     * Test of findByIdTipoObjeto method, of class ObjetoBean.
     */
    @org.junit.jupiter.api.Test
    public void testFindByIdTipoObjeto() throws Exception {
        System.out.println("findByIdTipoObjeto");
        Integer idTipoObjeto = null;
        int first = 0;
        int pageSize = 1;
        
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        Query mockQ = Mockito.mock(Query.class);
        ObjetoBean cut = new ObjetoBean();
        List esperado = new ArrayList();
        
        Mockito.when(mockEM.createNamedQuery("Objeto.findByTipoObjeto")).thenReturn(mockQ);
        Mockito.when(mockQ.setParameter("idTipoObjeto", idTipoObjeto)).thenReturn(mockTQ);
        Mockito.when(mockTQ.getResultList()).thenReturn(esperado);
   
        try {
            Mockito.when(mockTQ.getResultList()).thenReturn(esperado);
            cut.em = mockEM;
            List resultado = cut.findByIdTipoObjeto(idTipoObjeto, first, pageSize);
        } catch (Exception e) {
        }
        try {
            Mockito.when(mockTQ.getResultList()).thenReturn(null);
            cut.em = mockEM;
            List resultado = cut.findByIdTipoObjeto(idTipoObjeto, first, pageSize);
        } catch (Exception e) {
        }
        
        try {
            cut.em = mockEM;
            List resultado = cut.findByIdTipoObjeto(1, first, pageSize);
        } catch (Exception e) {
        }
        
    }

    /**
     * Test of countByIdTipoObjeto method, of class ObjetoBean.
     */
    @org.junit.jupiter.api.Test
    public void testCountByIdTipoObjeto() throws Exception {
        System.out.println("countByIdTipoObjeto");
        Integer idTipoObjeto = null;
        
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        Query mockQ = Mockito.mock(Query.class);
        ObjetoBean cut = new ObjetoBean();
        try {
            Integer esperado = 0;
            
            Mockito.when(mockEM.createNamedQuery("Objeto.countByTipoObjeto")).thenReturn(mockQ);
            Mockito.when(mockQ.setParameter("idTipoObjeto", idTipoObjeto)).thenReturn(mockTQ);
            Mockito.when(((Long) mockTQ.getSingleResult()).intValue()).thenReturn(esperado);
   
            try {
                Mockito.when(((Long) mockTQ.getSingleResult()).intValue()).thenReturn(esperado);
                cut.em = mockEM;
                int resultado = cut.countByIdTipoObjeto(idTipoObjeto);
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
        
        try {
            Mockito.when(((Long) mockTQ.getSingleResult()).intValue()).thenReturn(null);
            cut.em = mockEM;
            int resultado = cut.countByIdTipoObjeto(idTipoObjeto);
        } catch (Exception e) {
        }
        
        try {
            cut.em = mockEM;
            Integer resultado = cut.countByIdTipoObjeto(1);
        } catch (Exception e) {
        }
        try {
            cut.em = null;
            cut.countByIdTipoObjeto(idTipoObjeto);
        } catch (Exception e) {
        }
    }
    
}
