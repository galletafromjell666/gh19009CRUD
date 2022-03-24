/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.pruebacrud.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.text.DefaultEditorKit;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import ues.pruebacrud.entities.Estado;

/**
 *
 * @author Sara
 */
public class ControllerEstadoTest {
    
    public ControllerEstadoTest() {
    }
    
    /**
     * Test of crear method, of class ControllerEstado.
     */
    @org.junit.jupiter.api.Test
    public void testCrear() throws Exception {
        System.out.println("crear");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        Date fecha = new Date();
        
        Estado esperado = new Estado(1,"nuevo",fecha,"ninguna");
        ControllerEstado cut = new ControllerEstado();
        assertThrows(IllegalArgumentException.class, () ->{
            cut.crear(null);
        });
        assertThrows(IllegalStateException.class, () ->{
            cut.crear(esperado);
        });

        cut.em = mockEM;
        cut.crear(esperado);
        
        ControllerEstado espia = Mockito.spy(ControllerEstado.class);
        espia.em = mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.crear(esperado);
        } catch (Exception e) {
        }
        Mockito.verify(espia,Mockito.times(1)).getEntityManager();

    }

    /**
     * Test of modificar method, of class ControllerEstado.
     */
    
    @org.junit.jupiter.api.Test
    public void testModificar() throws Exception {
        System.out.println("modificar");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        Date fecha = new Date();
        
        Estado esperado = new Estado(1,"nuevo",fecha,"ninguna");
        ControllerEstado cut = new ControllerEstado();
        assertThrows(IllegalArgumentException.class, () ->{
            cut.modificar(null);
        });
        assertThrows(IllegalStateException.class, () ->{
            cut.modificar(esperado);
        });

        cut.em = mockEM;
        cut.modificar(esperado);
        
        ControllerEstado espia = Mockito.spy(ControllerEstado.class);
        espia.em = mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.modificar(esperado);
        } catch (Exception e) {
        }
        Mockito.verify(espia,Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of eliminar method, of class ControllerEstado.
     */
    @org.junit.jupiter.api.Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        Date fecha = new Date();
        
        Estado esperado = new Estado(1,"nuevo",fecha,"ninguna");
        ControllerEstado cut = new ControllerEstado();
        assertThrows(IllegalArgumentException.class, () ->{
            cut.eliminar(null);
        });
        assertThrows(IllegalStateException.class, () ->{
            cut.eliminar(esperado);
        });

        cut.em = mockEM;
        cut.eliminar(esperado);
        
        ControllerEstado espia = Mockito.spy(ControllerEstado.class);
        espia.em = mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.eliminar(esperado);
        } catch (Exception e) {
        }
        Mockito.verify(espia,Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of findById method, of class ControllerEstado.
     */
    @org.junit.jupiter.api.Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Integer id = 1;
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        
        ControllerEstado cut = new ControllerEstado();
        Estado esperado = new Estado();
        Mockito.when(mockEM.find(Estado.class, id)).thenReturn(esperado);
        assertThrows(IllegalArgumentException.class, ()->{
            cut.findById(null);
        });
        assertThrows(IllegalStateException.class, ()->{
            cut.findById(id);
        });
        cut.em = mockEM;
        Estado encontrado = cut.findById(id);
        assertNotNull(encontrado);
        assertEquals(esperado, encontrado);
        
        ControllerEstado espia = Mockito.spy(ControllerEstado.class);
        espia.em = mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.findById(id);
        } catch (Exception e) {
        }
        Mockito.verify(espia,Mockito.times(1)).getEntityManager();
        
        
    }

    /**
     * Test of findAll method, of class ControllerEstado.
     */
    @org.junit.jupiter.api.Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);
        CriteriaBuilder mockCB = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery mockCQ = Mockito.mock(CriteriaQuery.class);
        ControllerEstado cut = new ControllerEstado();
        List esperado = new ArrayList();
        
        Mockito.when(mockEM.getCriteriaBuilder()).thenReturn(mockCB);
        Mockito.when(mockCB.createQuery(Estado.class)).thenReturn(mockCQ);
        Mockito.when(mockEM.createQuery(mockCQ)).thenReturn(mockTQ);
        Mockito.when(mockTQ.getSingleResult()).thenReturn(esperado);
        
        
        try {
            Mockito.when(mockTQ.getResultList()).thenReturn(esperado);
            cut.em = mockEM;
            List resultado = cut.findAll();
        } catch (Exception e) {
        }
        try {
            Mockito.when(mockTQ.getResultList()).thenReturn(null);
            cut.em = mockEM;
            List resultado = cut.findAll();
        } catch (Exception e) {
        }
        
        try {
            cut.em = mockEM;
            List obtenido = cut.findAll();
        } catch (Exception e) {
        }

        ControllerEstado espia = Mockito.spy(ControllerEstado.class);
        espia.em = mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.findAll();
        } catch (Exception e) {
        }
        Mockito.verify(espia,Mockito.times(1)).getEntityManager();
    }
    
    /**
     * Test of generarConsulta method, of class ControllerEstado.
     */
    @org.junit.jupiter.api.Test
    public void testgenerarConsulta() throws Exception {
        System.out.println("generarConsulta");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        CriteriaBuilder mockCB = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery mockCQ = Mockito.mock(CriteriaQuery.class);
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);
        Root<Estado> mockR = Mockito.mock(Root.class);
        ControllerEstado cut = new ControllerEstado();
        
        Mockito.when(mockEM.getCriteriaBuilder()).thenReturn(mockCB);
        Mockito.when(mockCB.createQuery(Estado.class)).thenReturn(mockCQ);
        Mockito.when(mockCQ.from(Estado.class)).thenReturn(mockR);
        Mockito.when(mockEM.createQuery(mockCQ)).thenReturn(mockTQ);
        
        try {
            cut.em = mockEM;
            TypedQuery resultado = cut.generarConsulta(mockEM);
        } catch (Exception e) {
        }
               
        assertThrows(IllegalArgumentException.class, () ->{
            cut.generarConsulta(null);
        });
       
        ControllerEstado espia = Mockito.spy(ControllerEstado.class);
        espia.em = mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.contar();
        } catch (Exception e) {
        }
        Mockito.verify(espia,Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of findRange method, of class ControllerEstado.
     */
    @org.junit.jupiter.api.Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int first = 0;
        int pageSize = 1;
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);
        CriteriaBuilder mockCB = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery mockCQ = Mockito.mock(CriteriaQuery.class);
        ControllerEstado cut = new ControllerEstado();
        List esperado = new ArrayList();
        
        Mockito.when(mockEM.getCriteriaBuilder()).thenReturn(mockCB);
        Mockito.when(mockCB.createQuery(Estado.class)).thenReturn(mockCQ);
        Mockito.when(mockEM.createQuery(mockCQ)).thenReturn(mockTQ);
        Mockito.when(mockTQ.getSingleResult()).thenReturn(esperado);
   
        try {
            Mockito.when(mockTQ.getResultList()).thenReturn(esperado);
            cut.em = mockEM;
            List resultado = cut.findRange(first, pageSize);
        } catch (Exception e) {
        }
        try {
            Mockito.when(mockTQ.getResultList()).thenReturn(null);
            cut.em = mockEM;
            List resultado = cut.findRange(first, pageSize);
        } catch (Exception e) {
        }
        
        try {
            cut.em = mockEM;
            List resultado = cut.findRange(first, pageSize);
        } catch (Exception e) {
        }
        
        ControllerEstado espia = Mockito.spy(ControllerEstado.class);
        espia.em = mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.findRange(first, pageSize);
        } catch (Exception e) {
        }
        Mockito.verify(espia,Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of contar method, of class ControllerEstado.
     */
    @org.junit.jupiter.api.Test
    public void testContar() throws Exception {
        System.out.println("contar");
        Long esperado = Long.valueOf(1);
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        CriteriaBuilder mockCB = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery mockCQ = Mockito.mock(CriteriaQuery.class);
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);
        
        Mockito.when(mockEM.getCriteriaBuilder()).thenReturn(mockCB);
        Mockito.when(mockCB.createQuery(Long.class)).thenReturn(mockCQ);
        Mockito.when(mockEM.createQuery(mockCQ)).thenReturn(mockTQ);
        Mockito.when(mockTQ.getSingleResult()).thenReturn(esperado);
        ControllerEstado cut = new ControllerEstado();
        
        assertThrows(IllegalStateException.class, ()->{
            cut.contar();
        });
        
        cut.em = mockEM;
        Long resultado = cut.contar();
        assertNotNull(resultado);
        assertEquals(esperado, resultado);
        
        try {
            cut.em = null;
            cut.contar();
            fail("EntityManager es nulo");
        } catch (Exception e) {
        }
        
        ControllerEstado espia = Mockito.spy(ControllerEstado.class);
        espia.em = mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.contar();
        } catch (Exception e) {
        }
        Mockito.verify(espia,Mockito.times(1)).getEntityManager();
    }
    
    
}
